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
		
		@ManyToMany(mappedBy = "programs")
		@JsonView(Views.ViewProgram.class)
		private List<User> users = new ArrayList<User>(); 
		
		@OneToMany(mappedBy = "program")
		@JsonView(Views.ViewProgram.class)
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
		
		@ManyToOne
		@JsonView(Views.ViewProgram.class)
		private InProgress inProgress;
		
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
			this.isDone = isDone;
		}
}
