package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
public @Data class Sport {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String sportName;
	@JsonView(Views.ViewCommon.class)
	private String sportDescription;
	
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.ViewSport.class)
	private List<Program> programs = new ArrayList<Program>(); 
	
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.ViewSport.class)
	private List<Specialisation> specialisations = new ArrayList<Specialisation>(); 
	
	@ManyToMany
	@JoinTable(name="sport_level",
	joinColumns = @JoinColumn(name="sport_id"),
	inverseJoinColumns = @JoinColumn(name="level_id"))
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
	
	
}
