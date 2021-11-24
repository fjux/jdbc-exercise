package org.example.dao;

import org.example.model.Product;
import org.example.model.ShoppingCart;
import org.example.model.ShoppingCartItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public abstract class AbstractDAO {
    public void closeAll(AutoCloseable...closeables){
        if (closeables != null){
            for (AutoCloseable closeable : closeables){
                if (closeable != null){
                    try{
                        closeable.close();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DatabaseCredentials.getInstance().getUrl(), DatabaseCredentials.getInstance().getUser(), DatabaseCredentials.getInstance().getPassword());
    }

    public Product mapProduct(ResultSet resultSet) throws SQLException{
        return new Product(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price")
        );
    }

    public ShoppingCart mapShoppingCart(ResultSet resultSet) throws SQLException{
        return new ShoppingCart(
                resultSet.getInt("id"),
                resultSet.getObject("last_update", LocalDateTime.class),
                resultSet.getString("order_status"),
                resultSet.getString("delivery_address"),
                resultSet.getString("customer_reference"),
                resultSet.getBoolean("payment_approved")
                );
    }

    public ShoppingCartItem mapShoppingCartItem(ResultSet resultSet) throws SQLException{
        return new ShoppingCartItem(
                resultSet.getInt("id"),
                resultSet.getInt("amount"),
                resultSet.getDouble("total_price"),
                resultSet.getObject("product_id", Product.class),
                resultSet.getObject("shopping_cart_id", ShoppingCart.class)
                );
    }
}


