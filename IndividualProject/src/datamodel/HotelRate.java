package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "HotelRate")
public class HotelRate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "Rating", length = 1000)
	private String rating;

	@Column(name = "price")
	private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public HotelRate(Integer id, String rating, Integer price) {
		super();
		this.id = id;
		this.rating = rating;
		this.price = price;
	}

	public HotelRate(String rating, Integer price) {
		super();
		this.rating = rating;
		this.price = price;
	}

	public HotelRate() {
	}

}
