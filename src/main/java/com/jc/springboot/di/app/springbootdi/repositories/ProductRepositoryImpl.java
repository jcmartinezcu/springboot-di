package com.jc.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.jc.springboot.di.app.springbootdi.models.Product;

@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {

        this.data = Arrays.asList(
            new Product(1L, "Memorai corsair 32", 300L),
            new Product(2L, "Cpu Inter Core I9", 850L),
            new Product(3L, "Teclado Razar Mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
       return  data.stream()
       .filter(p-> p.getId().equals(id))
       .findFirst()
       .orElseThrow();
    }

    

}
