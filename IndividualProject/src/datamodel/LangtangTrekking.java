package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "LangtangTrekking")
public class LangtangTrekking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "descr", length = 1000)
	private String desc;
	
	public Integer getDay() {
		return id;
	}
	
	public LangtangTrekking(String desc) {
		super();
		this.desc = desc;
	}

	public void setDay(Integer day) {
		this.id = day;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public LangtangTrekking() {
		
	}
	
	public LangtangTrekking(Integer id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}
}
