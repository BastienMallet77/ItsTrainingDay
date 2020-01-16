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
import sopra.projet.ItsTrainingDay.model.Specialisation;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.SpecialisationRepository;

@RestController
@RequestMapping("/specialisation")
@CrossOrigin("*")
public class SpecialisationRestController {

	@Autowired
	private SpecialisationRepository specialisationRepo;

	@GetMapping("")
	@JsonView(Views.ViewSpecialisation.class)
	public List<Specialisation> list() {
		List<Specialisation> specialisations = specialisationRepo.findAll();

		return specialisations;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSpecialisation.class)
	public Specialisation find(@PathVariable Long id) {
		Optional<Specialisation> opt = specialisationRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewSpecialisation.class)
	public Specialisation create(@RequestBody Specialisation specialisation) {
		specialisation = specialisationRepo.save(specialisation);

		return specialisation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSpecialisation.class)
	public Specialisation update(@RequestBody Specialisation specialisation, @PathVariable Long id) {
		specialisation = specialisationRepo.save(specialisation);

		return specialisation;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		specialisationRepo.deleteById(id);
	}

}
