package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Esta es una clase que interactua directamente con la DB, es buena practica decorarla con la anotacion @Repository
 * Con esto indicamos a Spring que esta clase interactua con la DB ya que aca realizamos las operaciones que queremos aplicar en las tablas
 * Tambien se puede utilizar @Component - Esta es una generalizacion, le indicamos que es un componente de spring
 * es mejor usar @Repository porque indica que tipo de componenete en especifico es
 */
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Metodo para recuperar todos los productos de la bd
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    /**
     * Puedo eliminar un producto mandando el objeto completo o solo la PK
     */
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
