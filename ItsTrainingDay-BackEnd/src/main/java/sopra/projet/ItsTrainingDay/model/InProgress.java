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

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import sopra.projet.ItsTrainingDay.model.Views.ViewInProgress;

@Entity
@Table(name = "InProgress")
public @Data class InProgress {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private Date beginingDate;
	@JsonView(Views.ViewCommon.class)
	private Date endDate;
	@JsonView(Views.ViewCommon.class)
	private Integer progression;
	
	@JsonView(Views.ViewInProgress.class)
	@ManyToOne
	private User userProgressing;
	
	@JsonView(Views.ViewInProgress.class)
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
