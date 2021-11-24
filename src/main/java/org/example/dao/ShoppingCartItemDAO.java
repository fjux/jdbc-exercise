package org.example.dao;

import org.example.model.ShoppingCartItem;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartItemDAO {
    ShoppingCartItem save(ShoppingCartItem cartItem);
    Optional<ShoppingCartItem> findById(int id);
    List<ShoppingCartItem> findAll();
    List<ShoppingCartItem> findByCartId(int cartId);
    List<ShoppingCartItem> findByProductId(int productId);
    void delete(int id);

}
