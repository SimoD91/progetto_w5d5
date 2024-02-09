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
@Table(name = "postazione")
@Data
public class Postazione {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "descrizione")
        private String descrizione;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_postazione")
        private TipoPostazione tipoPostazione;

        @Column(name = "numero_max_partecipanti")
        private int numeroMaxPartecipanti;

        @ManyToOne
        @JoinColumn(name = "edificio_id")
        private Edificio edificio;

        @OneToMany(mappedBy = "postazione")
        private List<Prenotazione> prenotazioni = new ArrayList<>();

        public Postazione(String descrizione, TipoPostazione tipoPostazione, int numeroMaxPartecipanti, Edificio edificio) {
                this.descrizione = descrizione;
                this.tipoPostazione = tipoPostazione;
                this.numeroMaxPartecipanti = numeroMaxPartecipanti;
                this.edificio = edificio;
                this.prenotazioni = prenotazioni;
        }

        public boolean disponibile(LocalDate data){
                for (Prenotazione prenotazione : prenotazioni){
                        if (prenotazione.getDataPrenotazione().isEqual(data)){
                                return false;
                        }
                }
                return true;
        }
}
