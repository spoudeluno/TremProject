package datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Itinary {
	
	public Itinary() {
		
	}
	
	public Itinary(String desc) {
		this.desc = desc;
	}

	public Itinary(int day, String desc) {
		this.day = day;
		this.desc = desc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "day")
	private int day;
	
	@Column(name = "desc")
	private String desc;
	
	public int getDay() {
		return day;
	}
	

	public void setDay(int day) {
		this.day = day;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Itinary [day=" + day + ", desc=" + desc + "]";
	}


}
