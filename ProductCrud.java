package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.Model.Product;
import com.example.Repository.ProductRepository;

@Service
public class ProductCrud {

	@Autowired
	private ProductRepository repo;
	
	@PostMapping("/save")
	public Product save(Product p)
	{
		Product p1 = new Product();
		p1.setProductId(1);
		p1.setProductName("p1");
		
		return repo.save(p1) ;
		
	}
	@DeleteMapping("/delete")
	public String delete(int id)
	{
		repo.deleteById(id);
		return "Product deleted";
	}
	
    @PutMapping("/put")
    public 	Product Update(Product p, int id) {
    	
    	Product existingProduct = repo.fingById(id);
    	existingProduct.setProductId(2);
    	existingProduct.setProductName("samsung");
    	
    	return repo.save(existingProduct);
    }
    @GetMapping("/showData")
    public void show()
    {
    	List<Product> product = repo.findAll();
    	for(Product p : product)
    	{
    		System.out.println(p.getProductId()+" "+p.getProductName());
    	}
    }
	
}
