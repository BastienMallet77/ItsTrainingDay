package sopra.projet.ItsTrainingDay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.Data;

@Entity
public @Data class Degree {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private boolean certificate;
	
	@ManyToOne
	private User usercertified;
	
	@ManyToOne
	private Sport sport;
	
	public Degree() {
		super();
	}
	
	public Degree(boolean certificate) {
		super();
		this.certificate = certificate;
	}
	
	
}
