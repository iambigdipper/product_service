package com.meru.ProductService.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.ProductService.Model.Product;
import com.meru.ProductService.Model.ProductList;
import com.meru.ProductService.Repository.ProductRepository;

@Service
public class ProductService {
    
	private final static String SUCCESS="success"; 
	private final static String FAILURE="fail"; 
	
	@Autowired
	private ProductRepository productRepository; 
	
	public String addProduct(Product product ) {
		Product productAdded=productRepository.save(product);
		if(productAdded.getProductid()==product.getProductid()) {
			return SUCCESS;
		}
		return FAILURE;
	}
	
	public String updateProduct(Product product) {
		Product productAdded=productRepository.save(product);
		if(productAdded.getProductid()==product.getProductid()) {
			return SUCCESS;
		}
		return FAILURE;
	}
	
	public void  deleteProduct(int productid){
		productRepository.deleteById(productid);
	}
	
	public Product searchProduct(int productid) {
		return productRepository.findById(productid).get();
	}
	
	/*
	 * public List<Product> searchProducts(){ List<Product> products=new
	 * ArrayList<Product>(); Iterator <Product>
	 * productIt=productRepository.findAll().iterator(); while(productIt.hasNext())
	 * { products.add(productIt.next()); } return products; }
	 */
	
	public ProductList searchProducts(){
		List<Product> products=new ArrayList<Product>(); 
		 Iterator <Product> productIt=productRepository.findAll().iterator();
		 while(productIt.hasNext()) {
			 products.add(productIt.next());
			}
		 ProductList productList=new ProductList();
		 productList.setProducts(products);
		 return productList;
	}
}
