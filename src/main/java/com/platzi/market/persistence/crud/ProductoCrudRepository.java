package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

//Lo que tenemos que definir en CrudRepository, es la Clase Entity<Producto>, y el tipo de dato de su clave primaria que es Integer
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
