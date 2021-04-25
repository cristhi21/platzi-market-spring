package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //Nombre de metodos de culauqiere repositorio que tenga que trabajar con productos
    // Reglas que va a tener nuestro dominio al momento que cualquier repositorio quiera acceder a producto,
    // asi no acoplamos la soluciona a una base de datos sino al dominio
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProduct(int quantity);
    Optional<Product> getProduct(int ProductId);
    Product save(Product product);
    void delete(int productId);
}
