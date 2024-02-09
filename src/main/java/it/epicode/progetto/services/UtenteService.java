package it.epicode.progetto.services;

import it.epicode.progetto.entities.Utente;
import it.epicode.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(int id){
        return utenteRepository.findById(id).get();
    }

    public Utente salvaUtente(Utente utente){
        return utenteRepository.save(utente);
    }

    public void cancellaUtente(int id){
        utenteRepository.deleteById(id);
    }
}
