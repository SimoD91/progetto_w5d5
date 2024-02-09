package it.epicode.progetto.repositories;
import it.epicode.progetto.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
}
