package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;

@Entity
public @Data class Session {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String name;
	private String text;
	private Integer nbSession;
	
	@ManyToOne
	private Program program; 
	
	@OneToMany (mappedBy = "session")
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
