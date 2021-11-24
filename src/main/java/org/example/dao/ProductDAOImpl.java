package org.example.dao;

import org.example.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    /*
        INSERT INTO table_name (column1, column2, column3, ...)
        VALUES (value1, value2, value3, ...);
     */

    @Override
    public Product save(Product product) {

        if (product == null) throw new IllegalArgumentException("Entity was null");

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("INSERT INTO product (id, name, price) VALUES (?, ?, ?)");
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeAll(statement, connection);
        }
        return product;

    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()){
                products.add(mapProduct(resultSet)
                );
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(resultSet, statement, connection);
        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByPriceBetween(double low, double high) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
