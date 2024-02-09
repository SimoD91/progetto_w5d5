package it.epicode.progetto.services;

import it.epicode.progetto.entities.Prenotazione;
import it.epicode.progetto.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazioneById(int id){
        return prenotazioneRepository.findById(id).get();
    }

    public Prenotazione salvaPrenotazione(Prenotazione prenotazione){
        return prenotazioneRepository.save(prenotazione);
    }

    public void cancellaPrenotazione(int id){
        prenotazioneRepository.deleteById(id);
    }

}
