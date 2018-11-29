package br.edu.ufcg.cccpharma.category;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category {
	
	@Id
	private String name;
	
	private double discount;
	
	public Category(String name, double discount) {
		this.name = name;
		this.discount = discount;
	}
	
	public Category() {}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getDiscount() {
		return this.discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category name: " + this.getName() + " - discount: " + this.getDiscount();
	}
}