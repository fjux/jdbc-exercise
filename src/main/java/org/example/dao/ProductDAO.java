package org.example.dao;

import org.example.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductDAO {
Product save(Product product) throws SQLException;
Optional<Product> findById(int id);
List<Product> findAll() throws SQLException;
List<Product> findByName(String name);
List<Product> findByPriceBetween(double low, double high);
void delete(int id);
}
