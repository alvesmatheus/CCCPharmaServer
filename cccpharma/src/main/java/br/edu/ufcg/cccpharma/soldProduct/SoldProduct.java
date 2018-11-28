package br.edu.ufcg.cccpharma.soldProduct;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "tb_sold_product")
public class SoldProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String productCode;

	private int quantity;

	public SoldProduct(long id, String productCode, int quantity) {
		this.id = id;
		this.productCode = productCode;
		this.quantity = quantity;
	}

	public SoldProduct() { }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.productCode;
	}

	public void setCode(String code) {
		this.productCode = code;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		SoldProduct other = (SoldProduct) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product Code: " + this.getCode() + " - Quantity: " + this.getQuantity();
	}

}
