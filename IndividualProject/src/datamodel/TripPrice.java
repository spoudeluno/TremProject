package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "TripPrice")
public class TripPrice {

public TripPrice() {
		
	}

public TripPrice(Integer days, Integer price) {
		super();
		this.days = days;
		this.price = price;
	}

public TripPrice(Integer id, Integer days, Integer price) {
		super();
		this.id = id;
		this.days = days;
		this.price = price;
	}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private Integer id;

@Column(name = "days", length = 1000)
private Integer days;

@Column(name = "price")
private Integer price;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getDays() {
	return days;
}

public void setDays(Integer days) {
	this.days = days;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}

@Override
public String toString() {
	return "TripPrice [id=" + id + ", trip=" + days + ", price=" + price + "]";
}



}


