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
public @Data class Specialisation {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String speName;
	@JsonView(Views.ViewCommon.class)
	private String speDescription;
	@JsonView(Views.ViewCommon.class)
	private String img;
	
	@ManyToOne
	@JsonView(Views.ViewSpecialisation.class)
	private Sport sport; 
	
	@OneToMany (mappedBy = "specialisation")
	@JsonView(Views.ViewSpecialisation.class)
	private List<Level> levelss = new ArrayList<Level>();
	
	@OneToMany(mappedBy = "specialisation")
	@JsonView(Views.ViewSpecialisation.class)
	private List<Program> programss = new ArrayList<Program>(); 
	
	public Specialisation() {
		super();
	}
	
	public Specialisation(String speName, String speDescription) {
		super();
		this.speName = speName;
		this.speDescription = speDescription;
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

	public String getSpeName() {
		return speName;
	}

	public void setSpeName(String speName) {
		this.speName = speName;
	}

	public String getSpeDescription() {
		return speDescription;
	}

	public void setSpeDescription(String speDescription) {
		this.speDescription = speDescription;
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

	public List<Level> getLevelss() {
		return levelss;
	}

	public void setLevelss(List<Level> levelss) {
		this.levelss = levelss;
	}

	public List<Program> getProgramss() {
		return programss;
	}

	public void setProgramss(List<Program> programss) {
		this.programss = programss;
	}
	
	

}
