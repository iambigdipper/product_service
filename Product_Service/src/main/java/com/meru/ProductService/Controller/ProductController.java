package com.meru.ProductService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meru.ProductService.Model.Product;
import com.meru.ProductService.Model.ProductList;
import com.meru.ProductService.Service.ProductService;

@RestController
public class ProductController {

	private final static String SUCCESS="success"; 
	private final static String FAILURE="fail"; 
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productdetails/{productid}")
	public Product getProductDetails(@PathVariable int productid ) {
		return productService.searchProduct(productid);
	}
	
	
	@RequestMapping("/productdetails") 
	/*
	 * public List<Product> getProductDetails() { return
	 * productService.searchProducts(); }
	 */
	public ProductList getProductDetails() {
		return productService.searchProducts();
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/addproduct")
	public String addProduct(@RequestBody Product product) {
		String status=productService.addProduct(product);
		if(status.equalsIgnoreCase(SUCCESS))
			 return SUCCESS;
		return FAILURE;
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/updateproduct")
	public String updateProduct(@RequestBody Product product) {
		String status=productService.updateProduct(product);
		if(status.equalsIgnoreCase(SUCCESS))
			 return SUCCESS;
		return FAILURE;
	}
	
	
}
