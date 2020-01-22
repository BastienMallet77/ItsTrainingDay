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

@SuppressWarnings("unused")
@Entity
@Table(name = "InProgress")
public @Data class InProgress {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
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
	
	@ManyToOne
	@JsonView(Views.ViewInProgress.class)
	private Program program;

	
	public InProgress() {
		super();
	}
	
	public InProgress(Date beginingDate, Integer progression) {
		super();
		this.beginingDate = beginingDate;
		this.progression = progression;
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

	public Date getBeginingDate() {
		return beginingDate;
	}

	public void setBeginingDate(Date beginingDate) {
		this.beginingDate = beginingDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getProgression() {
		return progression;
	}

	public void setProgression(Integer progression) {
		this.progression = progression;
	}

	public User getUserProgressing() {
		return userProgressing;
	}

	public void setUserProgressing(User userProgressing) {
		this.userProgressing = userProgressing;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
	
	
}
