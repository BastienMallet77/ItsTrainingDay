package sopra.projet.ItsTrainingDay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.projet.ItsTrainingDay.model.Degree;
import sopra.projet.ItsTrainingDay.model.Erole;
import sopra.projet.ItsTrainingDay.model.Exercice;
import sopra.projet.ItsTrainingDay.model.InProgress;
import sopra.projet.ItsTrainingDay.model.Level;
import sopra.projet.ItsTrainingDay.model.Program;
import sopra.projet.ItsTrainingDay.model.Session;
import sopra.projet.ItsTrainingDay.model.Specialisation;
import sopra.projet.ItsTrainingDay.model.Sport;
import sopra.projet.ItsTrainingDay.model.User;
import sopra.projet.ItsTrainingDay.repository.DegreeRepository;
import sopra.projet.ItsTrainingDay.repository.ExerciceRepository;
import sopra.projet.ItsTrainingDay.repository.InProgressRepository;
import sopra.projet.ItsTrainingDay.repository.LevelRepository;
import sopra.projet.ItsTrainingDay.repository.ProgramRepository;
import sopra.projet.ItsTrainingDay.repository.SessionRepository;
import sopra.projet.ItsTrainingDay.repository.SpecialisationRepository;
import sopra.projet.ItsTrainingDay.repository.SportRepository;
import sopra.projet.ItsTrainingDay.repository.UserRepository;

@SpringBootTest
class ItsTrainingDayApplicationTests {
	
	@Autowired
	private DegreeRepository degreeRepo; 
	@Autowired
	private ExerciceRepository exoRepo; 
	@Autowired
	private InProgressRepository inprogRepo; 
	@Autowired
	private LevelRepository levelRepo; 
	@Autowired
	private ProgramRepository progRepo; 
	@Autowired
	private SessionRepository sesRepo; 
	@Autowired
	private SpecialisationRepository speRepo; 
	@Autowired
	private SportRepository sportRepo; 
	@Autowired
	private UserRepository userRepo; 

	@Test
	void contextLoads() {
		User user1 = new User("Albert", "DER-ARSENIAN", "Cocorico", "albert@training.com", "azertyuiop", new Date(), Erole.COACH, true, false); 
		User user2 = new User("François", "MARION", "Francouz", "françois@training.com", "azerty", new Date(), Erole.ADMIN, false, true); 
		User user3 = new User("Bastien", "DRID", "Batou", "batou@training.com", "g", new Date(), Erole.USER, true, false); 
		User user4 = new User("Bastien", "MALLET", "Barbu", "bastien@training.com", "qwerty", new Date(), Erole.USER, true, false); 
		User user5 = new User("Berengère", "VALLIER", "Beren", "beren@training.com", "azertyuiop", new Date(), Erole.COACH, true, false);
		
		Sport muscu = new Sport("Musculation", "Pour se contruire un corps d'Apollon", "../assets/images/Muscu/Muscu.jpg"); 
		Sport judo = new Sport("Judo", "Sport préféré d'Apollon"); 
		
		Specialisation masse = new Specialisation("Masse", "Prise de muscle");
		Specialisation seche = new Specialisation("Sèche", "Perte de poids");
		Specialisation explo = new Specialisation("Explosivité", "Travail force/vitesse");
		Specialisation kata = new Specialisation("Kata", "Préparation kata");
		
		Session session1 = new Session("Dos", "Entrainement du DOS", 1);
		Session session2 = new Session("Pec", "Entrainement des PECS", 2);
		Session session3 = new Session("Jambe", "Entrainement des JAMBES", 3);
		Session session4 = new Session("Epaule", "Entrainement des EPAULES", 4);
		
		Program prog1 = new Program("Muscu pour la sèche", "perdez du poids avant l'été", 12, 3, new Date(), true, true, 3.5f);
		Program prog2 = new Program("Muscu pour la prise de masse", "Musclez vous", 12, 3, new Date(), false, true, 4.5f);
		Program prog3 = new Program("Muscu pour l'explosivité", "Travaillez votre force et votre vitesse", 12, 3, new Date(), true, false, 4.5f);
		
		Level level1m = new Level("Niveau 1", "Pour les débutants de la prise de masse","../assets/images/Muscu/Masse/0.jpg");
		Level level1s = new Level("Niveau 1", "Pour les débutants de la sèche");
		Level level1e = new Level("Niveau 1", "Pour les débutants de l'explosivité");
		Level level2m = new Level("Niveau 2", "Pour les confirmés de la prise de masse", "../assets/images/Muscu/Masse/1.jpg");
		Level level2s = new Level("Niveau 2", "Pour les confirmés de la sèche");
		Level level2e = new Level("Niveau 2", "Pour les confirmés de l'explosivité");
		Level level3m = new Level("Niveau 3", "Pour les experts de la prise de masse", "../assets/images/Muscu/Masse/2.jpeg"); 
		Level level3s = new Level("Niveau 3", "Pour les experts de la sèche"); 
		Level level3e = new Level("Niveau 3", "Pour les experts de l'explosivité"); 
		
		InProgress inprog1 = new InProgress(new Date(), 0);
		InProgress inprog2 = new InProgress(new Date(), 0);
		InProgress inprog3 = new InProgress(new Date(), 0);
		InProgress inprog4 = new InProgress(new Date(), 0);
		InProgress inprog5 = new InProgress(new Date(), 0);
		
		Exercice exo1 = new Exercice("Traction", "Attraper la barre et se tracter"); 
		Exercice exo2 = new Exercice("Tirage", "Tirer la barre verticalement"); 
		Exercice exo3 = new Exercice("Rowing", "Buste penché, on tire l'haltère à soi"); 
		
		Degree deg1 = new Degree(true); 
		Degree deg2 = new Degree(false); 
		Degree deg3 = new Degree(true); 
		
		List<Program> programs = new ArrayList<Program>(); 
		programs.add(prog1);
		programs.add(prog2);
		programs.add(prog3);
		
		List<User> users = new ArrayList<User>(); 
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);

		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		userRepo.save(user4);
		userRepo.save(user5);
		
		user1.setPrograms(programs);
		user2.setPrograms(programs);
		user3.setPrograms(programs);
		user4.setPrograms(programs);
		user5.setPrograms(programs);
		
		prog1.setUsers(users);
		prog2.setUsers(users);
		prog3.setUsers(users);
		
		sportRepo.save(muscu);
		sportRepo.save(judo);
		
		masse.setSport(muscu);
		explo.setSport(muscu);
		seche.setSport(muscu);
		kata.setSport(judo);
		
		speRepo.save(masse);
		speRepo.save(explo);
		speRepo.save(seche);
		speRepo.save(kata);
		
		level1e.setSpecialisation(explo);
		level2e.setSpecialisation(explo);
		level3e.setSpecialisation(explo);
		level1m.setSpecialisation(masse);
		level2m.setSpecialisation(masse);
		level3m.setSpecialisation(masse);
		level1s.setSpecialisation(seche);
		level2s.setSpecialisation(seche);
		level3s.setSpecialisation(seche);
		
		level1e.setSport(muscu);
		level2e.setSport(muscu);
		level3e.setSport(muscu);
		level1m.setSport(muscu);
		level2m.setSport(muscu);
		level3m.setSport(muscu);
		level1s.setSport(muscu);
		level2s.setSport(muscu);
		level3s.setSport(muscu);
		
		levelRepo.save(level1e);
		levelRepo.save(level2e);
		levelRepo.save(level3e);
		levelRepo.save(level1m);
		levelRepo.save(level2m);
		levelRepo.save(level3m);
		levelRepo.save(level1s);
		levelRepo.save(level2s);
		levelRepo.save(level3s);
		
		inprog1.setUserProgressing(user1);
		inprog2.setUserProgressing(user2);
		inprog3.setUserProgressing(user3);
		inprog4.setUserProgressing(user4);
		inprog5.setUserProgressing(user5);
		inprog3.setUserProgressing(user5);

		inprogRepo.save(inprog1);
		inprogRepo.save(inprog2);
		inprogRepo.save(inprog3);
		inprogRepo.save(inprog4);
		inprogRepo.save(inprog5);
			
		prog1.setLevel(level1m);
		prog2.setLevel(level2m);
		prog3.setLevel(level3m);
		
		prog1.setSpecialisation(seche);
		prog2.setSpecialisation(masse);
		prog3.setSpecialisation(explo);
		
		prog1.setSport(muscu);
		prog2.setSport(muscu);
		prog3.setSport(muscu);
		
		prog1.setUsers(users);
		prog2.setUsers(users);
		prog3.setUsers(users);
		
		prog1.setCreatorId(user1.getId());
		prog2.setCreatorId(user1.getId());
		prog3.setCreatorId(user5.getId());
		
		progRepo.save(prog1);
		progRepo.save(prog2);
		progRepo.save(prog3);
		
		inprog1.setProgram(prog1);
		inprog2.setProgram(prog2);
		inprog3.setProgram(prog3);
		inprog4.setProgram(prog2);
		inprog5.setProgram(prog1);
		
		inprogRepo.save(inprog1);
		inprogRepo.save(inprog2);
		inprogRepo.save(inprog3);
		inprogRepo.save(inprog4);
		inprogRepo.save(inprog5);
		
		user1.setPrograms(programs);
		user2.setPrograms(programs);
		user3.setPrograms(programs);
		user4.setPrograms(programs);
		user5.setPrograms(programs);
		
		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		userRepo.save(user4);
		userRepo.save(user5);
		
		session1.setProgram(prog2);
		session2.setProgram(prog2);
		session3.setProgram(prog1);
		session4.setProgram(prog3);
		
		sesRepo.save(session1);
		sesRepo.save(session2);
		sesRepo.save(session3);
		sesRepo.save(session4);
		
		exo1.setSession(session1);
		exo2.setSession(session2);
		exo3.setSession(session3);
		
		exoRepo.save(exo1);
		exoRepo.save(exo2);
		exoRepo.save(exo3);
		
		deg1.setSport(muscu);
		deg2.setSport(muscu);
		deg3.setSport(judo);
		
		deg1.setUsercertified(user5);
		deg2.setUsercertified(user3);
		deg3.setUsercertified(user4);
		
		degreeRepo.save(deg1);
		degreeRepo.save(deg2);
		degreeRepo.save(deg3);

	}
}
