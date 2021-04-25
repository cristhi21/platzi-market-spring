package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Podemos usar @Service o @Component
 * @Service Es mejor practica porque Agrega diferenciacion semantica de que es un servico en nuestra logica de negocios
 */

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    /**
     * Este servicio Inyecta ProductRepository
     * Podemos usar @Autowired porque a pesar de que ProductRepository no tiene anotaciones
     * ProductoRepository que es su implementacion si lo tiene, usamos @Repository
     */
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    //es un un intermediario y la capa del repository
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    /**
     * Aqui trabajamos en terminos del dominio
     * En donde ocurre la conversion es en ProductoRepository, y el servicio desconoce esa operacion
     * el servicio unicamente trabaja en terminos del dominio
     */
    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        //Buscamos un producto usando el metodo de arriba y usando el operador map del optional
        return getProduct(productId).map(prodcut -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);

        //Otra forma de hacerlo es asi
        /*if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }*/
    }

}
