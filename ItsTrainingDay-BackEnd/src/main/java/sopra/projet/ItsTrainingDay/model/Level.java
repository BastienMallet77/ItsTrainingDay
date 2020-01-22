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
public @Data class Level {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String levelName;
	@JsonView(Views.ViewCommon.class)
	private String levelDescription;
	@JsonView(Views.ViewCommon.class)
	private String img;
	
	@ManyToOne
	@JsonView(Views.ViewLevel.class)
	private Sport sport; 
	
	@ManyToOne
	@JsonView(Views.ViewLevel.class)
	private Specialisation specialisation; 
	
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
	
	public Level(String levelName, String levelDescription, String img) {
		super();
		this.levelName = levelName;
		this.levelDescription = levelDescription;
		this.img = img;
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

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelDescription() {
		return levelDescription;
	}

	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Specialisation getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
	
	
}
