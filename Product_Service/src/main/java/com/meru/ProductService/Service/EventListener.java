package com.meru.ProductService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meru.ProductService.Model.Product;
import com.meru.ProductService.event.InventoryEvent;
import com.meru.ProductService.event.PriceEvent;

@Component
@EnableJms
public class EventListener {

	
	private Gson gson; 
	@Autowired
	private ProductService  productService;
	
	@JmsListener(destination = "stock.update")
	public void inventoryListener(String message){
        System.out.println("inventoryListener Message received {} "+ message);
        gson=new Gson();
        InventoryEvent inventoryEvent =gson.fromJson(message, InventoryEvent.class);
        int productid=inventoryEvent.getProductid();
        int stock=inventoryEvent.getStock();
        Product product=  productService.searchProduct(productid);
        if(stock==0)
        product.setIsinstock((short)0);
        else 
        product.setIsinstock((short)1);
        productService.updateProduct(product);
        System.out.println("Stock updated");
      
	}
	
	@JmsListener(destination ="price.update")
	public void priceListener(String message){
        System.out.println("priceListener Message received {} "+ message);
        gson=new Gson();
        PriceEvent priceEvent =gson.fromJson(message, PriceEvent.class);
        int productid=priceEvent.getProductid();
        float priceupdated=priceEvent.getPrice();
        Product product=  productService.searchProduct(productid);
        product.setPrice(priceupdated);
        productService.updateProduct(product);
        System.out.println("Product updated ! ");
      
	}
	
	
}
