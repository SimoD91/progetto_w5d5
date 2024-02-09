package it.epicode.progetto.repositories;
import it.epicode.progetto.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}
