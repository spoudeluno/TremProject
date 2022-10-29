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
		super();
		this.desc = desc;
	}

	public EverestTreking(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "descr", length = 1000)
	private String desc;
	
	public Integer getDay() {
		return id;
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
	
	@Override
	public String toString() {
		return "EverestTreking [day=" + id + ", desc=" + desc + "]";
	}
	

}
