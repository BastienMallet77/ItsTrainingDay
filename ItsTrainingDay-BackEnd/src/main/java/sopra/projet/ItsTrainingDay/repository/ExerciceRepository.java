package sopra.projet.ItsTrainingDay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.projet.ItsTrainingDay.model.Exercice;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
	
	@Query("select e from Exercice e join e.session s where s.id = :id")
	List<Exercice> findAllBySession(@Param("id") Long id);
}
