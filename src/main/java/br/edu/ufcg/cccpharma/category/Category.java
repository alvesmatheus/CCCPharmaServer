package br.edu.ufcg.cccpharma.category;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

/**
 * A Category object models the product categories of the CCCPharma system. A
 * category is unique identified by its name and has a discount attribute which
 * represents the discount that will be applied to every product of this
 * category. The categories are described in one of our database tables.
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
@Table(name = "tb_category")
public class Category {

	@Id
	private String name;

	private double discount;

	/**
	 * Creates a Category object with nulled attributes.
	 */
	public Category() {}

	/**
	 * Creates a Category object based on its name and on the percentage discount to
	 * be applied to its products.
	 * 
	 * @param name     The name of the category.
	 * @param discount The percentage discount to be applied to the products.
	 * 
	 */
	public Category(String name, double discount) {
		this.name = name;
		this.discount = discount;
	}

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

	/**
	 * Generates a hash code for the Category object based on its ID number.
	 * 
	 * @return The generated hash code for the Category object.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Verifies equality between the Category object and the Object given as
	 * parameter. This equality will only exists if the given Object is also an
	 * Category object and possesses the same name attribute value.
	 * 
	 * @param obj An object to be compared to the Category.
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
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Generates a textual representation of the Category object based on its name
	 * and its percentage discount.
	 * 
	 * @return The textual representation of the Category.
	 * 
	 */
	@Override
	public String toString() {
		return "Category: " + this.getName() + " - Discount: " + this.getDiscount();
	}

}