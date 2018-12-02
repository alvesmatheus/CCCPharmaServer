package br.edu.ufcg.cccpharma.sale;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ufcg.cccpharma.soldProduct.SoldProduct;
import br.edu.ufcg.cccpharma.user.User;

@Entity
@Table(name = "tb_sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double cost;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "sold_product_id")
	private Set<SoldProduct> soldProducts;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
	private User user;
	
	public Sale() {}
	
	public Sale(User user, Set<SoldProduct> soldProducts) {
		this.user = user;
		this.soldProducts = soldProducts;
		this.cost = this.calculateCost(soldProducts);
	}

	private Double calculateCost(Set<SoldProduct> products) {
		Double toReturn = 0.0;
		for(SoldProduct soldProduct: products) {
			toReturn += (soldProduct.getQuantity() * soldProduct.getProduct().getPrice());
		}
		return toReturn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Set<SoldProduct> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(Set<SoldProduct> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
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
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale id: " + this.getId() + " - Cost: " + this.getCost();
	}
	
}
