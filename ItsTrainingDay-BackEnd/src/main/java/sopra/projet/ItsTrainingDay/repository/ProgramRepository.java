package sopra.projet.ItsTrainingDay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.projet.ItsTrainingDay.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
	@Query("select p from Program p left join fetch p.sessions s where p.id = :id")
	Program findByIdWithSessions(@Param("id") Long id);
	
	@Query("select p from Program p join p.level l where l.id = :id")
	List<Program> findAllByLevel(@Param("id")Long id);
	
}
