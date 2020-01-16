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
import sopra.projet.ItsTrainingDay.model.Sport;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.SportRepository;

@RestController
@RequestMapping("/sport")
@CrossOrigin("*")
public class SportRestController {

	@Autowired
	private SportRepository sportRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewSport.class)
	public List<Sport> list(){
		List<Sport> sports = sportRepo.findAll();
		return sports;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewSport.class)
	public Sport find(@PathVariable Long id) {
		Optional<Sport> opt = sportRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewSport.class)
	public Sport create(@RequestBody Sport sport) {
		sport = sportRepo.save(sport);

		return sport;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSport.class)
	public Sport update(@RequestBody Sport sport, @PathVariable Long id) {
		sport = sportRepo.save(sport);

		return sport;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		sportRepo.deleteById(id);
	}

	

}
