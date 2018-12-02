package br.edu.ufcg.cccpharma.sale;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import br.edu.ufcg.cccpharma.user.User;
import br.edu.ufcg.cccpharma.soldProduct.SoldProduct;

@Entity
@Table(name = "tb_sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "sold_product_id")
	private Set<SoldProduct> soldProducts;

	private double cost;

	public Sale() {}

	public Sale(User user, Set<SoldProduct> soldProducts) {
		this.user = user;
		this.soldProducts = soldProducts;
		this.cost = this.calculateCost(soldProducts);
	}

	private double calculateCost(Set<SoldProduct> soldProducts) {
		double totalCost = 0.0;
		for (SoldProduct soldProduct : soldProducts) {
			totalCost += (soldProduct.getQuantity() * soldProduct.getProduct().getPrice());
		}

		return totalCost;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<SoldProduct> getSoldProducts() {
		return this.soldProducts;
	}

	public void setSoldProducts(Set<SoldProduct> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Sale other = (Sale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale ID: " + this.getId() + " - Cost: " + this.getCost();
	}

}
