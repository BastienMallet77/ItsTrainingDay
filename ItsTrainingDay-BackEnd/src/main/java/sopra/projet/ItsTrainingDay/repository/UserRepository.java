package sopra.projet.ItsTrainingDay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.ItsTrainingDay.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserNameAndPassword(String userName, String password); 
	
}
