package it.epicode.progetto;

import it.epicode.progetto.entities.*;
import it.epicode.progetto.services.EdificioService;
import it.epicode.progetto.services.PostazioneService;
import it.epicode.progetto.services.PrenotazioneService;
import it.epicode.progetto.services.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        utenteService.salvaUtente(new Utente("Pippo", "Paolo", "Bianchi", "pippo@hotmail.com"));
        utenteService.salvaUtente(new Utente("Xion", "Franco", "Rossi", "xion@hotmail.com"));
        utenteService.salvaUtente(new Utente("Zeb45", "Leonardo", "Gialli", "zeb45@hotmail.com"));
        utenteService.salvaUtente(new Utente("Yalloh", "Mattia", "Verdi", "yalloh@hotmail.com"));
        utenteService.salvaUtente(new Utente("Johnny", "Giovanni", "Neri", "johnny@hotmail.com"));

        edificioService.salvaEdificio(new Edificio("Edificio 1", "Via Tonni 4", "Milano"));
        edificioService.salvaEdificio(new Edificio("Edificio 2", "Via Mimmo 2", "Roma"));
        edificioService.salvaEdificio(new Edificio("Edificio 3", "Via Lessi 5", "Napoli"));
        edificioService.salvaEdificio(new Edificio("Edificio 4", "Via Dado 6", "Genova"));
        edificioService.salvaEdificio(new Edificio("Edificio 5", "Via Bobbio 1", "Cosenza"));

        edificioService.getAllEdifici().forEach(edificio -> {
            postazioneService.salvaPostazione(new Postazione("Descrizione 1", TipoPostazione.OPEN_SPACE, 10, edificio));
            postazioneService.salvaPostazione(new Postazione("Descrizione 2", TipoPostazione.PRIVATO, 15, edificio));
            postazioneService.salvaPostazione(new Postazione("Descrizione 3", TipoPostazione.SALA_RIUNIONI, 15, edificio));
            postazioneService.salvaPostazione(new Postazione("Descrizione 4", TipoPostazione.PRIVATO, 25, edificio));
            postazioneService.salvaPostazione(new Postazione("Descrizione 5", TipoPostazione.OPEN_SPACE, 20, edificio));
        });

        utenteService.getAllUtenti().forEach(utente -> {
            postazioneService.getAllPostazioni().forEach(postazione -> {
                prenotazioneService.salvaPrenotazione(new Prenotazione(utente, postazione, LocalDate.now(), postazione.getEdificio()));
            });
        });
    }
}

