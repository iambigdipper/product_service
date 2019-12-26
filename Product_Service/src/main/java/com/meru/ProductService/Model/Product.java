package com.meru.ProductService.Model;

import java.io.Serializable;
import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

@Entity
public class Product implements Serializable,IdentifierGenerator,Configurable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8297998516834266121L;
	
	public Product() {}
	public Product(Integer productid,String productName,float price,short isInStock) {
		this.productid=productid;
		this.productname=productName;
		this.price=price;
		this.isinstock=isInStock;
	}
	
	
	@Id
	@GenericGenerator(name = "prod_id", strategy = "com.meru.ProductService.Model.Product")
	@GeneratedValue(generator = "prod_id")  
	@Column(name="productid")
	private Integer productid;
	private String productname;
	private float price;
	@Column(name="isinstock")
	private short isinstock;
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public short getIsinstock() {
		return isinstock;
	}
	public void setIsinstock(short isinstock) {
		this.isinstock = isinstock;
	}
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return ((Product)object).getProductid();
	}
	
}
