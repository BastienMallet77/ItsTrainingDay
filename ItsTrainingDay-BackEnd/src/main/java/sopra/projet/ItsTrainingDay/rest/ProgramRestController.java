package sopra.projet.ItsTrainingDay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sopra.projet.ItsTrainingDay.repository.ProgramRepository;

@RestController
@RequestMapping("/")
public class ProgramRestController {

	@Autowired
	private ProgramRepository programRepo;

	

}
