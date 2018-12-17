package br.edu.ufcg.cccpharma.product;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.EntityListeners;

import br.edu.ufcg.cccpharma.category.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Product object models the real products of the CCCPharma system. Each
 * product will be unique identified by its code, being easily recognizable by
 * its name instead. Each Product has its base price, its stock amount and the
 * name of its producer as attributes. Also, a Product object has a flag to
 * indicate if it is available to be purchased by a client. The products are
 * described in one of our database tables.
 * 
 * @author Douglas Pereira de Lima
 * @author Fanny Batista Vieira
 * @author Mateus de Lima Oliveira
 * @author Matheus Alves dos Santos
 * 
 * @since 2018-11-12
 * @version 1.0
 * 
 */
@Entity
@Table(name = "tb_product")
@EntityListeners(ProductListener.class)
public class Product {

	@Id
	private String code;

	private String name;

	private double price;

	private int amount;

	private String producer;

	private boolean available;

	@ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.MERGE, optional = false)
    	@JoinColumn(name = "category_name", referencedColumnName = "name", nullable = false)
	private Category category;

	/**
	 * Creates a Product object with nulled attributes.
	 */
	public Product() {}

	/**
	 * Creates a Product object based on its identifier code, product name, base
	 * price, stock amount, producer name and product category.
	 * 
	 * @param code     The unique identifier of the Product.
	 * @param name     The name of the product.
	 * @param price    The base price of the product.
	 * @param amount   The stock amount of the product.
	 * @param producer The producer's name.
	 * @param category The category in which the product fits.
	 * 
	 */
	public Product(String code, String name, double price, int amount, String producer, Category category) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.producer = producer;
		this.category = category;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the sale price of the product. The sale price its defined by the base
	 * price of the product and the current discount given to the product category.
	 * 
	 * @return The sale price of the product.
	 * 
	 */
	public double getPrice() {
		return this.applyDiscount(this.getBasePrice(), this.getCategory().getDiscount());
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Generates a hash code for the Product object based on its identifier code.
	 * 
	 * @return The generated hash code for the Product object.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/**
	 * Verifies equality between the Product object and the Object given as
	 * parameter. This equality will only exists if the given Object is also an
	 * Product object and possesses the same code attribute value.
	 * 
	 * @param obj An object to be compared to the Product.
	 * 
	 * @return A boolean that represents the comparison result.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/**
	 * Generates a textual representation of the Product object based on its
	 * identifier code, product name, base price, stock amount, producer name and
	 * product category.
	 * 
	 * @return The textual representation of the Product.
	 * 
	 */
	@Override
	public String toString() {
		return "Product: " + this.getName() + " - Code: " + this.getCode() + " - Base Price: " + this.getBasePrice()
				+ " - Amount: " + this.getAmount() + " - Producer: " + this.getProducer() + " - Category: "
				+ this.getCategory().getName();
	}

	/**
	 * Returns the price attribute value of the Product. The base price does not
	 * apply the category discount.
	 * 
	 * @return The base price of the product.
	 * 
	 */
	@JsonIgnore
	public double getBasePrice() {
		return this.price;
	}

	/**
	 * Using the given discount and base price, calculates and returns the price
	 * with discount.
	 * 
	 * @param basePrice The base price to be used.
	 * @param discount  The discount to be applied.
	 * 
	 * @return The price with discount applied.
	 * 
	 */
	private double applyDiscount(double basePrice, double discount) {
		return ((1 - discount) * basePrice);
	}

}
