package sopra.projet.ItsTrainingDay.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.projet.ItsTrainingDay.exception.NotFoundException;
import sopra.projet.ItsTrainingDay.model.Session;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.SessionRepository;

@RestController
@RequestMapping("/session")
@CrossOrigin("*")
public class SessionRestController {

	@Autowired
	private SessionRepository sessionRepo;

	@GetMapping("")
	@JsonView(Views.ViewSession.class)
	public List<Session> list() {
		List<Session> sessions = sessionRepo.findAll();

		return sessions;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSession.class)
	public Session find(@PathVariable Long id) {
		Optional<Session> opt = sessionRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewSession.class)
	public Session create(@RequestBody Session session) {
		session = sessionRepo.save(session);

		return session;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSession.class)
	public Session update(@RequestBody Session session, @PathVariable Long id) {
		session = sessionRepo.save(session);

		return session;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		sessionRepo.deleteById(id);
	}

}
