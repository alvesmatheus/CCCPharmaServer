package br.edu.ufcg.cccpharma.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.edu.ufcg.cccpharma.category.Category;

@Entity
@Table(name = "tb_product")
public class Product {
	
	private String name;
	@Id
	private String code;
	
	private Double price;
	
	private int quantity;
	
	private String producer;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category", nullable = false)
	private Category category;

	public Product(String name, String code, Double price, int quantity, String producer,Category category) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.quantity = quantity;
		this.producer = producer;
		this.category = category;
	}
	
	public Product() {}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		double valueWithDiscount = this.valueWithDiscount(this.category.getDiscount());
		return this.valueWithDiscount(valueWithDiscount);
	}
	
	private Double getOriginalPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	private double valueWithDiscount(double discount) {
		double valueFinal = this.getOriginalPrice();
		if(discount != 0) {
			valueFinal = valueFinal - (discount * this.getOriginalPrice());
		}
		return valueFinal;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "Product [name=" + this.getName() + ", code=" + this.getCode() + ", price=" + this.getPrice() + ", quantity=" + this.getQuantity()
				+ ", producer=" + this.getProducer() + ", category=" + this.getCategory().getName() + "]";
	}
	
}
