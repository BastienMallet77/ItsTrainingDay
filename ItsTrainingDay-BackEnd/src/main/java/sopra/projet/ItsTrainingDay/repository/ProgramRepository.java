package sopra.projet.ItsTrainingDay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.ItsTrainingDay.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {

}
