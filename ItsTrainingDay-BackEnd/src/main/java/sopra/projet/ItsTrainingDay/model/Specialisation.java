package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;

@Entity
public @Data class Specialisation {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String speName;
	private String speDescription;
	
	@ManyToOne
	private Sport sport; 
	
	@ManyToMany
	@JoinTable(name="Specialisation_level",
	joinColumns = {@JoinColumn(name="Specialisation_id")},
	inverseJoinColumns = @JoinColumn(name="level_id"))
	private List<Level> levelss = new ArrayList<Level>(); 
	
	@OneToMany(mappedBy = "specialisation")
	private List<Program> programss = new ArrayList<Program>(); 
	
	public Specialisation() {
		super();
	}
	
	public Specialisation(String speName, String speDescription) {
		super();
		this.speName = speName;
		this.speDescription = speDescription;
	}
	
	

}
