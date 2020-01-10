package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;

@Entity
public @Data class Level {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String levelName;
	private String levelDescription;
	
	@ManyToMany (mappedBy = "levels")
	private List<Sport> sports = new ArrayList<Sport>(); 
	
	@ManyToMany (mappedBy = "levelss")
	private List<Specialisation> specialisations = new ArrayList<Specialisation>(); 
	
	@OneToMany (mappedBy = "level")
	private List<Program> programs = new ArrayList<Program>(); 
	
	
	public Level() {
		super();
	}
	
	public Level(String levelName, String levelDescription) {
		super();
		this.levelName = levelName;
		this.levelDescription = levelDescription;
	}
	
	
}
