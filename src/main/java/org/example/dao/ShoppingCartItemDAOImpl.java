package org.example.dao;

import org.example.model.ShoppingCartItem;

import java.util.List;
import java.util.Optional;

public class ShoppingCartItemDAOImpl extends AbstractDAO implements ShoppingCartItemDAO{
    @Override
    public ShoppingCartItem save(ShoppingCartItem cartItem) {
        return null;
    }

    @Override
    public Optional<ShoppingCartItem> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCartItem> findAll() {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findByCartId(int cartId) {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findByProductId(int productId) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
