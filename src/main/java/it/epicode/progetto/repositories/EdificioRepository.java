package it.epicode.progetto.repositories;
import it.epicode.progetto.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
