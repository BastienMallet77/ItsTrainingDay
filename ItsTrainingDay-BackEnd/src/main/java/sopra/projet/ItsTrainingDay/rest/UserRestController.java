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
import sopra.projet.ItsTrainingDay.model.Erole;
import sopra.projet.ItsTrainingDay.model.User;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/{userName}/{password}")
	@JsonView(Views.ViewUser.class)
	public User findLogin(@PathVariable String userName, @PathVariable String password) 
	{
		User user = userRepo.findByUserNameAndPassword(userName, password);
		return user; 
	}

	@GetMapping("")
	@JsonView(Views.ViewUser.class)
	public List<User> list() {
		List<User> users = userRepo.findAll();
		return users;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewUser.class)
	public User find(@PathVariable Long id) {
		Optional<User> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewUser.class)
	public User create (@RequestBody User user) {
		user = userRepo.save(user);
		return user; 
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewUser.class)
	public User update(@RequestBody User user, @PathVariable Long id) {
		user = userRepo.save(user); 
		return user; 
	}	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userRepo.deleteById(id);
	}
	
	@GetMapping("/roles")
	public  Erole[] roles(){
		return Erole.values();
		
	}
}
