package com.ecommerce.ProductService.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.ProductService.VO.Category;
import com.ecommerce.ProductService.VO.ResponseTemplateVO;
import com.ecommerce.ProductService.controller.ProductController;
import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.service.ProductService;




@SpringBootTest(classes = { ProductControllerTest.class })
public class ProductControllerTest {
	
	@Mock
	
	ProductService productService;
	
	
	@InjectMocks
	ProductController productController;
	
	
	Product product;
	
	@Test
	@Order(1)
	public void test_saveUser() {

		Product product = new Product(8, "hp", "hhjjhj", 20, 900, 800, 2, "hghjhj", 675);

		when(productService.createProduct(product)).thenReturn(product);

		ResponseEntity<Product> res = productController.saveProduct(product);

		assertEquals(HttpStatus.CREATED, res.getStatusCode());

		assertEquals(product, res.getBody());

	}
	
	@Test
	@Order(2)
	public void test_getProductWithCategory() {
		
		Category category1 = new Category(7, "gfs");
		Product product1 = new Product();
		
		product1.setDescription("scac");
		product1.setDiscountedPrice(700);
		product1.setProductId(10);
		product1.setProductName("dxdw");
		product1.setProductRating(4);
		product1.setProductReview("qdd");
		product1.setQuantity(40);
		product1.setRegularPrice(500);


		 ResponseTemplateVO vo = new  ResponseTemplateVO();
		 vo.setProductId(product1.getProductId());
			vo.setProductName(product1.getProductName());
			vo.setDescription(product1.getDescription());
			vo.setDiscountedPrice(product1.getDiscountedPrice());
			vo.setRegularPrice(product1.getRegularPrice());
			vo.setQuantity(product1.getQuantity());
			vo.setProductRating(product1.getProductRating());
			vo.setProductReview(product1.getProductReview());
			vo.setCategory(category1);
			Integer productId = 10;
			
			when(productService.getProductWithCategory(productId)).thenReturn(vo);
			ResponseTemplateVO Vo = productController.getProductWithCategory(productId);
			assertEquals(productId, Vo.getProductId());
	}
}
