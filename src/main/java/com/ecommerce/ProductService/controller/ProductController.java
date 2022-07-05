package com.ecommerce.ProductService.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.ProductService.VO.ResponseTemplateVO;
import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	

//	@PostMapping("/")
//	public Product saveProduct(@RequestBody Product product) {
//		return productService.createProduct(product);
//	}
	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		try {
			product = productService.createProduct(product);

			return new ResponseEntity<Product>(product, HttpStatus.CREATED);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	
	
	  @GetMapping("/{productId}") 
	  public ResponseTemplateVO getProductWithCategory(@PathVariable("productId") Integer productId) { 
		  return productService.getProductWithCategory(productId); }



	
	 

}
