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
import sopra.projet.ItsTrainingDay.model.Exercice;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.ExerciceRepository;

@RestController
@RequestMapping("/exercice")
@CrossOrigin("*")
public class ExerciceRestController {

	@Autowired
	private ExerciceRepository exerciceRepo;

	@GetMapping("")
	@JsonView(Views.ViewExercice.class)
	public List<Exercice> list()
	{
		List<Exercice> exercices = exerciceRepo.findAll();
		return exercices;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewExercice.class)
	public Exercice find(@PathVariable Long id)
	{
		Optional<Exercice> opt = exerciceRepo.findById(id);
		
		if(opt.isPresent()) 
		{
			return opt.get();
		}else 
		{
			throw new NotFoundException();
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewExercice.class)
	public Exercice create(@RequestBody Exercice exercice) 
	{
		exercice = exerciceRepo.save(exercice);
		return exercice;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewExercice.class)
	public Exercice update(@RequestBody Exercice exercice, @PathVariable Long id) 
	{
		exercice = exerciceRepo.save(exercice);
		
		return exercice;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) 
	{
		exerciceRepo.deleteById(id);
	}

}
