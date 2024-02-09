package it.epicode.progetto.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "prenotazione")
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Prenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione, Edificio edificio) {
        this.utente = utente;
        this.postazione = postazione;
        this.dataPrenotazione = dataPrenotazione;
        this.edificio = edificio;
    }

    public static List<Postazione> cercaPostazioni(List<Postazione> postazioni, TipoPostazione tipo, String citta){
        List<Postazione> risultati = new ArrayList<>();
        for (Postazione postazione : postazioni) {
            if (postazione.getTipoPostazione().equals(tipo) && postazione.getEdificio().getCitta().equalsIgnoreCase(citta)){
                risultati.add(postazione);
            }
        }
        return risultati;
    }
    public static boolean prenotazioneEffettuata(List<Prenotazione> prenotazioni, Utente utente, LocalDate data){
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getUtente().equals(utente) && prenotazione.getDataPrenotazione().isEqual(data)){
                return true;
            }
        }
        return false;
    }
}
