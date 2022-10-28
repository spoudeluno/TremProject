package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EverestTreking")
public class EverestTreking {
	public EverestTreking() {
			
		}
	public EverestTreking(String desc) {
		this.desc = desc;
	}

	public EverestTreking(int day, String desc) {
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
		return "EverestTreking [day=" + day + ", desc=" + desc + "]";
	}
	

}
