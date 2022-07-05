package com.ecommerce.ProductService.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.ProductService.VO.Category;
import com.ecommerce.ProductService.VO.ResponseTemplateVO;
import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.repository.ProductRepository;
import com.ecommerce.ProductService.service.ProductService;

@SpringBootTest(classes = { ProductServiceTest.class })
public class ProductServiceTest {
	@Mock
	ProductRepository productRepo;

	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	ProductService productService;

	List<Product> categories;



	@Test
	@Order(1)
	public void test_createProduct() {
		Product product = new Product(1, "Mobiles", null, null, null, null, null, null, null);

		when(productRepo.insert(product)).thenReturn(product);

		assertEquals(product, productService.createProduct(product));
	}
	@Test
	@Order(2)
	public void test_getProductWithCategory() {
		Category category1 = new Category(7, "gfs");

		Category category2 = new Category();
		category2.setCategoryId(category2.getCategoryId());
		category2.setCategoryName(category2.getCategoryName());

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
		
		Product product2 = new Product(8, "hp", "hhjjhj", 20, 900, 800, 2, "hghjhj", 675);

		when(restTemplate.getForObject("http://CATEGORY-SERVICE/categories/" +product1.getCategoryId(), Category.class))
		.thenReturn(category1);
		
		Integer productId = 10;
		when(productRepo.findByProductId(productId)).thenReturn(product1);
	}

}
