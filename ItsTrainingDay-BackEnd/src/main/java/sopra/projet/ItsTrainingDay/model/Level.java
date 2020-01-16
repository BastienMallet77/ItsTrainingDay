package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
public @Data class Level {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String levelName;
	@JsonView(Views.ViewCommon.class)
	private String levelDescription;
	
	@ManyToMany (mappedBy = "levels")
	@JsonView(Views.ViewLevel.class)
	private List<Sport> sports = new ArrayList<Sport>(); 
	
	@ManyToMany (mappedBy = "levelss")
	@JsonView(Views.ViewLevel.class)
	private List<Specialisation> specialisations = new ArrayList<Specialisation>(); 
	
	@OneToMany (mappedBy = "level")
	@JsonView(Views.ViewLevel.class)
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
