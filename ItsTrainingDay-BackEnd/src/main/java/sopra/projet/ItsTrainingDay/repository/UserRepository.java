package sopra.projet.ItsTrainingDay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.projet.ItsTrainingDay.model.Program;
import sopra.projet.ItsTrainingDay.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserNameAndPassword(String userName, String password); 
	
	@Query("select c from coach_program c where coach_id = :id")
	List<Program> findAllByCreator(@Param("id")Long id);
}
