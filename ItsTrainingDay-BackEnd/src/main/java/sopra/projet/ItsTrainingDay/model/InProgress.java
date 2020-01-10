package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Table(name = "InProgress")
public @Data class InProgress {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private Date beginingDate;
	private Date endDate;
	private Integer progression;
	
	@ManyToOne
	private User userProgressing;
	
	@OneToMany(mappedBy = "inProgress")
	private List<Program> progInProgress = new ArrayList<Program>();
	
	public InProgress() {
		super();
	}
	
	public InProgress(Date beginingDate, Date endDate, Integer progression) {
		super();
		this.beginingDate = beginingDate;
		this.endDate = endDate;
		this.progression = progression;
	}
	
	
	
}
