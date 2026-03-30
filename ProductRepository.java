package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

      public void deleteById(int id);
      public void update(Product p , int id);
      public Product fingById(int id);
	

}
