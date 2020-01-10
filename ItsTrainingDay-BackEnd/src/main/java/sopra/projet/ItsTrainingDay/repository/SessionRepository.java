package sopra.projet.ItsTrainingDay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.ItsTrainingDay.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
