package sopra.projet.ItsTrainingDay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.projet.ItsTrainingDay.model.Specialisation;

public interface SpecialisationRepository extends JpaRepository<Specialisation, Long> {

	@Query("select l from Specialisation l join l.sport s where s.id = :id")
	List<Specialisation> findAllBySport(@Param("id")Long id);
}
