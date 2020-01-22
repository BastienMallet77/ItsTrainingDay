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
import sopra.projet.ItsTrainingDay.model.Program;
import sopra.projet.ItsTrainingDay.model.Views;
import sopra.projet.ItsTrainingDay.repository.ProgramRepository;

@RestController
@RequestMapping("/program")
@CrossOrigin("*")
public class ProgramRestController {

	@Autowired
	private ProgramRepository programRepo;

	@GetMapping("")
	@JsonView(Views.ViewProgram.class)
	public List<Program> list() {
		List<Program> programs = programRepo.findAll();

		return programs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewProgram.class)
	public Program find(@PathVariable Long id) {
		Optional<Program> opt = programRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewProgramDetail.class)
	public Program findDetail(@PathVariable Long id) {
		Program program = programRepo.findByIdWithSessions(id);

		if (program != null) {
			return program;
		} else {
			throw new NotFoundException();
		}
	}
	
	@GetMapping("/{id}/programs")
	@JsonView(Views.ViewProgram.class)
	public List<Program> listPrograms(@PathVariable Long id){
		List<Program> programs = programRepo.findAllByLevel(id);
		return programs;
	}
	
	@GetMapping("/{id}/creator")
	@JsonView(Views.ViewProgram.class)
	public List<Program> programs(@PathVariable Long id){
		List<Program> programs = programRepo.findAllByCreator(id);
		return programs;
	}

	@PostMapping("")
	@JsonView(Views.ViewProgram.class)
	public Program create(@RequestBody Program program) {
		program = programRepo.save(program);

		return program;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewProgram.class)
	public Program update(@RequestBody Program program, @PathVariable Long id) {
		program = programRepo.save(program);

		return program;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		programRepo.deleteById(id);
	}

}
