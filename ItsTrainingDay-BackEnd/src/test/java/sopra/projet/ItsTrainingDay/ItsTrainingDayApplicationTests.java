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
		User user3 = new User("Bastien", "DRID", "Batou", "batou@training.com", "qwertyuiop", new Date(), Erole.USER, true, false); 
		User user4 = new User("Bastien", "MALLET", "Barbu", "bastien@training.com", "qwerty", new Date(), Erole.USER, true, false); 
		User user5 = new User("Berengère", "VALLIER", "Beren", "beren@training.com", "azertyuiop", new Date(), Erole.COACH, true, false); 
		
		Sport muscu = new Sport("Musculation", "Pour se contruire un corps d'Appolon"); 
		Sport judo = new Sport("Judo", "Sport préféré d'Appolon"); 
		
		Specialisation masse = new Specialisation("Masse", "Prise de muscle");
		Specialisation seche = new Specialisation("Sèche", "Perte de poids");
		Specialisation explo = new Specialisation("Explosivité", "Travail force/vitesse");
		
		Session session1 = new Session("Dos", "Entrainement du DOS", 1);
		Session session2 = new Session("Pec", "Entrainement des PECS", 2);
		Session session3 = new Session("Jambe", "Entrainement des JAMBES", 3);
		Session session4 = new Session("Epaule", "Entrainement des EPAULES", 4);
		
		Program prog1 = new Program("Muscu pour la sèche", "perdez du poids avant l'été", 12, 3, new Date(), true, true);
		Program prog2 = new Program("Muscu pour la prise de masse", "Musclez vous", 12, 3, new Date(), false, true);
		Program prog3 = new Program("Muscu pour l'explosivité", "Travaillez votre force et votre vitesse", 12, 3, new Date(), true, false);
		
		Level level1 = new Level("Niveau 1", "Pour les débutants");
		Level level2 = new Level("Niveau 2", "Pour les confirmés");
		Level level3 = new Level("Niveau 3", "Pour les experts"); 
		
		InProgress inprog1 = new InProgress(new Date(), new Date(), 24);
		InProgress inprog2 = new InProgress(new Date(), new Date(), 42);
		InProgress inprog3 = new InProgress(new Date(), new Date(), 68);
		
		Exercice exo1 = new Exercice("Traction", "attrapper la barre et se tracter"); 
		Exercice exo2 = new Exercice("Tirage", "Tirer la bare verticalement"); 
		Exercice exo3 = new Exercice("Rowing", "Buste penché, en tire l'haltère à soi"); 
		
		Degree deg1 = new Degree(true); 
		Degree deg2 = new Degree(false); 
		Degree deg3 = new Degree(true); 
		
		List<Program> programs = new ArrayList<Program>(); 
		programs.add(prog1);
		programs.add(prog2);
		programs.add(prog3);
		
		List<Degree> degrees = new ArrayList<Degree>(); 
		degrees.add(deg1);
		degrees.add(deg2);
		degrees.add(deg3);
		
		List<InProgress> inprogs = new ArrayList<InProgress>(); 
		inprogs.add(inprog1);
		inprogs.add(inprog2);
		inprogs.add(inprog3);
		
		List<Specialisation> specs = new ArrayList<Specialisation>(); 
		specs.add(explo);
		specs.add(masse);
		specs.add(seche);
		
		List<Level> levels = new ArrayList<Level>();
		levels.add(level1);
		levels.add(level2);
		levels.add(level3);
		
		List<Exercice> exos = new ArrayList<Exercice>();
		exos.add(exo1);
		exos.add(exo2);
		exos.add(exo3);
		
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(session1);
		sessions.add(session2);
		sessions.add(session3);
		sessions.add(session4);
		
		List<User> users = new ArrayList<User>(); 
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		List<Sport> sports = new ArrayList<Sport>(); 
		sports.add(muscu);
		sports.add(judo);
		
		user1.setPrograms(programs);
		user2.setPrograms(programs);
		user3.setPrograms(programs);
		user4.setPrograms(programs);
		user5.setPrograms(programs);
		
		prog1.setUsers(users);
		prog2.setUsers(users);
		prog3.setUsers(users);
		
		progRepo.save(prog1);
		progRepo.save(prog2);
		progRepo.save(prog3);
		
		userRepo.save(user1); 
		userRepo.save(user2); 
		userRepo.save(user3); 
		userRepo.save(user4); 
		userRepo.save(user5); 
	}

}
