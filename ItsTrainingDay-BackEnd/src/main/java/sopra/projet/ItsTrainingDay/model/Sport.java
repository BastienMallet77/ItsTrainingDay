package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
public @Data class Sport {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String sportName;
	@JsonView(Views.ViewCommon.class)
	private String sportDescription;
	@JsonView(Views.ViewCommon.class)
	private String img;
	
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.ViewSport.class)
	private List<Program> programs = new ArrayList<Program>(); 
	
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.ViewSport.class)
	private List<Specialisation> specialisations = new ArrayList<Specialisation>(); 
	
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.ViewSport.class)
	private List<Level> levels = new ArrayList<Level>();
	
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.ViewSport.class)
	private List<Degree> degreeSport = new ArrayList<Degree>();
	
	public Sport() {
		super();
	}
	public Sport(String sportName, String sportDescription) {
		super();
		this.sportName = sportName;
		this.sportDescription = sportDescription;
	}
	
	public Sport(String sportName, String sportDescription, String img) {
		super();
		this.sportName = sportName;
		this.sportDescription = sportDescription;
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
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public String getSportDescription() {
		return sportDescription;
	}
	public void setSportDescription(String sportDescription) {
		this.sportDescription = sportDescription;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
	public List<Specialisation> getSpecialisations() {
		return specialisations;
	}
	public void setSpecialisations(List<Specialisation> specialisations) {
		this.specialisations = specialisations;
	}
	public List<Level> getLevels() {
		return levels;
	}
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	public List<Degree> getDegreeSport() {
		return degreeSport;
	}
	public void setDegreeSport(List<Degree> degreeSport) {
		this.degreeSport = degreeSport;
	}
	
	
}
