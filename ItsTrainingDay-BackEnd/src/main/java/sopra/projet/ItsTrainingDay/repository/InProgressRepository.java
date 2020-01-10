package sopra.projet.ItsTrainingDay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.ItsTrainingDay.model.InProgress;

public interface InProgressRepository extends JpaRepository<InProgress, Long> {

}
