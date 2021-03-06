package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Lo que tenemos que definir en CrudRepository, es la Clase Entity<Producto>, y el tipo de dato de su clave primaria que es Integer
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //Hay 2 formas de hacer las consultas

    // 1. Query Methods
    //Tener en cuenta que debemos respetar el CamelCase para esta busqueda por eso esta escrito asi: findByIdProducto
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //2. Query nativa
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByCategoriaNative(int idProducto);
    //NOTA: Es mejor practica usar los query methods que las query de manera nativa por la flexibilidad que nos dan

    //Los query methods tambien soportan los opertadores opcionales de las nuevas versiones de Java
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
