package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Metodo para recuperar todos los productos de la bd
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
