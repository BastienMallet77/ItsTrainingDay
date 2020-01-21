package sopra.projet.ItsTrainingDay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.projet.ItsTrainingDay.model.Level;

public interface LevelRepository extends JpaRepository<Level, Long> {
	
	@Query("select l from Level l join l.specialisation s where s.id = :id")
	List<Level> findAllBySpec(@Param("id") Long id);
}
