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
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.model.InProgress;
import sopra.projet.ItsTrainingDay.repository.InProgressRepository;

@RestController
@RequestMapping("/inprogress")
@CrossOrigin("*")
public class InProgressRestController {

	@Autowired
	private InProgressRepository inProgressRepo;

	@GetMapping("")
	@JsonView(Views.ViewInProgress.class)
	public List<InProgress> list() {
		List<InProgress> inProgresses = inProgressRepo.findAll();
		return inProgresses;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewInProgress.class)
	public InProgress find(@PathVariable Long id) {
		Optional<InProgress> opt = inProgressRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewInProgress.class)
	public InProgress create(@RequestBody InProgress inProgress) {
		inProgress = inProgressRepo.save(inProgress);

		return inProgress;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewInProgress.class)
	public InProgress update(@RequestBody InProgress inProgress, @PathVariable Long id) {
		inProgress = inProgressRepo.save(inProgress);
		return inProgress;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		inProgressRepo.deleteById(id);
	}

}
