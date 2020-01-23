package sopra.projet.ItsTrainingDay.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Table(name = "athlete")
public @Data class User {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String firstName;
	@JsonView(Views.ViewCommon.class)
	private String lastName;
	@JsonView(Views.ViewCommon.class)
	private String userName;
	@JsonView(Views.ViewCommon.class)
	private String email;
	@JsonView(Views.ViewCommon.class)
	private String password;
	@JsonView(Views.ViewCommon.class)
	private Date birthDate;
	@Enumerated (EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Erole role;
	@JsonView(Views.ViewCommon.class)
	private boolean commercial;
	@JsonView(Views.ViewCommon.class)
	private boolean isDisactivated; 
	@JsonView(Views.ViewCommon.class)
	private Long sessionStop;
	@JsonView(Views.ViewCommon.class)
	private Long levelStop;
	@JsonView(Views.ViewCommon.class)
	private Long programStop;

	private String img;

	
	@ManyToMany
	@JoinTable(name="coach_program",
	joinColumns = {@JoinColumn(name="coach_id")},
	inverseJoinColumns = @JoinColumn(name="program_id"))
	@JsonView(Views.ViewUser.class)
	private List<Program> programs = new ArrayList<Program>(); 
	
	@OneToMany(mappedBy = "userProgressing")
	@JsonView(Views.ViewUser.class)
	private List<InProgress> inProgress = new ArrayList<InProgress>(); 
	
	@OneToMany(mappedBy = "usercertified")
	@JsonView(Views.ViewUser.class)
	private List<Degree> degreesCoach = new ArrayList<Degree>();
	
	@JsonView(Views.ViewUser.class)
	private Integer nbSessionFinished = 0;
	
	@JsonView(Views.ViewUser.class)
	private Integer nbProgramFinished = 0;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String userName, String email, String password, Date birthDate,
			Erole role, boolean commercial, boolean isDisactivated, String img) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.role = role;
		this.commercial = commercial;
		this.isDisactivated = isDisactivated;
		this.img = img;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Erole getRole() {
		return role;
	}

	public void setRole(Erole role) {
		this.role = role;
	}

	public boolean isCommercial() {
		return commercial;
	}

	public void setCommercial(boolean commercial) {
		this.commercial = commercial;
	}

	public boolean isDisactivated() {
		return isDisactivated;
	}

	public void setDisactivated(boolean isDisactivated) {
		this.isDisactivated = isDisactivated;
	}

	public List<InProgress> getInProgress() {
		return inProgress;
	}

	public void setInProgress(List<InProgress> inProgress) {
		this.inProgress = inProgress;
	}

	public List<Degree> getDegreesCoach() {
		return degreesCoach;
	}

	public void setDegreesCoach(List<Degree> degreesCoach) {
		this.degreesCoach = degreesCoach;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public Integer getNbSessionFinished() {
		return nbSessionFinished;
	}

	public void setNbSessionFinished(Integer nbSessionFinished) {
		this.nbSessionFinished = nbSessionFinished;
	}

	public Integer getNbProgramFinished() {
		return nbProgramFinished;
	}

	public void setNbProgramFinished(Integer nbProgramFinished) {
		this.nbProgramFinished = nbProgramFinished;
	}


	
	
	
	
	

}
