package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
public @Data class Session {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String name;
	@JsonView(Views.ViewCommon.class)
	private String text;
	@JsonView(Views.ViewCommon.class)
	private Integer nbSession;
	
	@ManyToOne
	@JsonView(Views.ViewSession.class)
	private Program program; 
	
	@OneToMany (mappedBy = "session")
	@JsonView(Views.ViewSession.class)
	private List<Exercice> exercices = new ArrayList<Exercice>(); 
	
	public Session() {
		super();
	}
	public Session(String name, String text, Integer nbSession) {
		super();
		this.name = name;
		this.text = text;
		this.nbSession = nbSession;
	} 
	
	
}
