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
import sopra.projet.ItsTrainingDay.model.Degree;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.DegreeRepository;

@RestController
@RequestMapping("/degree")
@CrossOrigin("*")
public class DegreeRestController {

	@Autowired
	private DegreeRepository degreeRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewDegree.class)
	public List<Degree> list()
	{
		List<Degree> degrees = degreeRepo.findAll();
		
		return degrees;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewDegree.class)
	public Degree find(@PathVariable Long id)
	{ 
		Optional<Degree> opt = degreeRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewDegree.class)
	public Degree create(@RequestBody Degree degree) 
	{
		degree = degreeRepo.save(degree);

		return degree;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewDegree.class)
	public Degree update(@RequestBody Degree degree, @PathVariable Long id) 
	{
		degree = degreeRepo.save(degree);
		
		return degree;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) 
	{
		degreeRepo.deleteById(id);
	}


	

}
