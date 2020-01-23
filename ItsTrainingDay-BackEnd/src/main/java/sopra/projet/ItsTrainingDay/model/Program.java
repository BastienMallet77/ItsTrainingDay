package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
public @Data class Program {

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
		private String description;
		@JsonView(Views.ViewCommon.class)
		private int duration;
		@JsonView(Views.ViewCommon.class)
		private int nbValidation;
		@JsonView(Views.ViewProgram.class)
		private Date creationDate;
		@JsonView(Views.ViewProgram.class)
		private boolean isValidated;
		@JsonView(Views.ViewProgram.class)
		private boolean isDone;
		@JsonView(Views.ViewProgram.class)
		private Float rate; 
		@JsonView(Views.ViewProgram.class)
		private Integer nbRate = null; 
		@JsonView(Views.ViewProgram.class)
		private Long creatorId = null; 
		
		@ManyToMany(mappedBy = "programs")
		@JsonView(Views.ViewProgramDetail.class)
		private List<User> users = new ArrayList<User>(); 
		
		@OneToMany(mappedBy = "program")
		@JsonView(Views.ViewProgramDetail.class)
		private List<Session> sessions = new ArrayList<Session>(); 
		
		@ManyToOne
		@JsonView(Views.ViewProgram.class)
		private Sport sport; 
		
		@ManyToOne
		@JsonView(Views.ViewProgram.class)
		private Level level; 
		
		@ManyToOne
		@JoinColumn(name = "spe_id")
		@JsonView(Views.ViewProgram.class)
		private Specialisation specialisation;

		@JsonView(Views.ViewProgram.class)
		@OneToMany(mappedBy = "program")
		private List<InProgress> inProgresses = new ArrayList<InProgress>();
		
		
		public Program() {
			super();
		}
		
		public Program(String name, String description, int duration, int nbValidation, Date creationDate,
				boolean isValidated, boolean isDone) {
			super();
			this.name = name;
			this.description = description;
			this.duration = duration;
			this.nbValidation = nbValidation;
			this.creationDate = creationDate;
			this.isValidated = isValidated;
		}
		
		public Program(String name, String description, int duration, int nbValidation, Date creationDate,
				boolean isValidated, boolean isDone, long creatorId) {
			super();
			this.name = name;
			this.description = description;
			this.duration = duration;
			this.nbValidation = nbValidation;
			this.creationDate = creationDate;
			this.isValidated = isValidated;
			this.isDone = isDone;
			this.creatorId = creatorId;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public int getNbValidation() {
			return nbValidation;
		}

		public void setNbValidation(int nbValidation) {
			this.nbValidation = nbValidation;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public boolean isValidated() {
			return isValidated;
		}

		public void setValidated(boolean isValidated) {
			this.isValidated = isValidated;
		}

		public boolean isDone() {
			return isDone;
		}

		public void setDone(boolean isDone) {
			this.isDone = isDone;
		}

		public void setRate(Float rate) {
			this.rate = rate;
		}

		public Integer getNbRate() {
			return nbRate;
		}

		public void setNbRate(Integer nbRate) {
			this.nbRate = nbRate;
		}


		public Float getRate() {
			return rate;
		}

		public Long getCreatorId() {
			return creatorId;
		}

		public void setCreatorId(Long creatorId) {
			this.creatorId = creatorId;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		public List<Session> getSessions() {
			return sessions;
		}

		public void setSessions(List<Session> sessions) {
			this.sessions = sessions;
		}

		public Sport getSport() {
			return sport;
		}

		public void setSport(Sport sport) {
			this.sport = sport;
		}

		public Level getLevel() {
			return level;
		}

		public void setLevel(Level level) {
			this.level = level;
		}

		public Specialisation getSpecialisation() {
			return specialisation;
		}

		public void setSpecialisation(Specialisation specialisation) {
			this.specialisation = specialisation;
		}

		public List<InProgress> getInProgresses() {
			return inProgresses;
		}

		public void setInProgresses(List<InProgress> inProgresses) {
			this.inProgresses = inProgresses;
		}	
}
