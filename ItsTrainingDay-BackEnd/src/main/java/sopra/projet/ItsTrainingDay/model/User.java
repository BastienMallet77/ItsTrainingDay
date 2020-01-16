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
	private Long id;
	@Version
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
	
	@ManyToMany
	@JoinTable(name="user_program",
	joinColumns = {@JoinColumn(name="user_id")},
	inverseJoinColumns = @JoinColumn(name="program_id"))
	@JsonView(Views.ViewUser.class)
	private List<Program> programs = new ArrayList<Program>(); 
	
	@OneToMany(mappedBy = "userProgressing")
	@JsonView(Views.ViewUser.class)
	private List<InProgress> inProgress = new ArrayList<InProgress>(); 
	
	@OneToMany(mappedBy = "usercertified")
	@JsonView(Views.ViewUser.class)
	private List<Degree> degreesCoach = new ArrayList<Degree>();;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String userName, String email, String password, Date birthDate,
			Erole role, boolean commercial, boolean isDisactivated) {
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
	}


	
	
	
	
	

}
