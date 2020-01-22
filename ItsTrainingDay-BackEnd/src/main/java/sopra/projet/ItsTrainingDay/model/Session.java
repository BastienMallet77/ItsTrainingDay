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
	
	@JsonView(Views.ViewSession.class)
	private Boolean isDone = false; 
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getNbSession() {
		return nbSession;
	}
	public void setNbSession(Integer nbSession) {
		this.nbSession = nbSession;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	public List<Exercice> getExercices() {
		return exercices;
	}
	public void setExercices(List<Exercice> exercices) {
		this.exercices = exercices;
	} 
	
	
}
