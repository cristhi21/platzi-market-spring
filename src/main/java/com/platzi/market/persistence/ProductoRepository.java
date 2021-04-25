package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    //Metodo para recuperar todos los productos de la bd
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int ProductId) {
        return productoCrudRepository.findById(ProductId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /**
     * Puedo eliminar un producto mandando el objeto completo o solo la PK
     */
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
