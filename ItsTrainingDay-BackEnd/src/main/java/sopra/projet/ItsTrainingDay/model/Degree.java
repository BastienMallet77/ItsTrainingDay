package sopra.projet.ItsTrainingDay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
public @Data class Degree {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private boolean certificate;
	
	@JsonView(Views.ViewDegree.class)
	@ManyToOne
	private User usercertified;
	
	@JsonView(Views.ViewDegree.class)
	@ManyToOne
	private Sport sport;
	
	public Degree() {
		super();
	}
	
	public Degree(boolean certificate) {
		super();
		this.certificate = certificate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isCertificate() {
		return certificate;
	}

	public void setCertificate(boolean certificate) {
		this.certificate = certificate;
	}

	public User getUsercertified() {
		return usercertified;
	}

	public void setUsercertified(User usercertified) {
		this.usercertified = usercertified;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	
}
