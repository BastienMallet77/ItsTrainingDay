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

import lombok.Data;

@Entity
public @Data class Program {

		@Id
		@GeneratedValue
		private Long id;
		@Version
		private int version;
		private String name;
		private String description;
		private int duration;
		private int nbValidation;
		private Date creationDate;
		private boolean isValidated;
		private boolean isDone;
		
		@ManyToMany(mappedBy = "programs")
		private List<User> users = new ArrayList<User>(); 
		
		@OneToMany(mappedBy = "program")
		private List<Session> sessions = new ArrayList<Session>(); 
		
		@ManyToOne
		private Sport sport; 
		
		@ManyToOne
		private Level level; 
		
		@ManyToOne
		@JoinColumn(name = "spe_id")
		private Specialisation specialisation; 
		
		@ManyToOne
		private InProgress progressing;
		
		@ManyToOne
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
