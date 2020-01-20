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
import sopra.projet.ItsTrainingDay.model.Level;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.LevelRepository;

@RestController
@RequestMapping("/level")
@CrossOrigin("*")
public class LevelRestController {

	@Autowired
	private LevelRepository levelRepo;

	@GetMapping("")
	@JsonView(Views.ViewLevel.class)
	public List<Level> list() {
		List<Level>  levels = levelRepo.findAll();
		return levels;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewLevel.class)
	public Level find(@PathVariable Long id) {
		Optional<Level> opt = levelRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	@GetMapping("/{id}/levels")
	@JsonView(Views.ViewSport.class)
	public List<Level> listLevels(@PathVariable Long id){
		List <Level> levels = levelRepo.findAllBySport(id);
		return levels;
	}
	
	@PostMapping("")
	@JsonView(Views.ViewLevel.class)
	public Level create (@RequestBody Level level) {
		level = levelRepo.save(level);
		return level; 
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewLevel.class)
	public Level update(@RequestBody Level level, @PathVariable Long id) {
		level = levelRepo.save(level); 
		return level; 
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		levelRepo.deleteById(id);
	}
	
}
