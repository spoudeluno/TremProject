package datamodel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "EverestTreking")
public class EverestTreking extends Itinary{

	public EverestTreking(String desc) {
		super(desc);
	}
	

}
