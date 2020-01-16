package sopra.projet.ItsTrainingDay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import sopra.projet.ItsTrainingDay.model.Views.ViewExercice;




@Entity
public @Data class Exercice {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String exerciceName;
	@JsonView(Views.ViewCommon.class)
	private String exerciceText;
	
	@JsonView(ViewExercice.class)
	@ManyToOne
	private Session session;
	
	public Exercice() {
		super();
	}

	public Exercice(String exerciceName, String exerciceText) {
		super();
		this.exerciceName = exerciceName;
		this.exerciceText = exerciceText;
	}	
	
}
