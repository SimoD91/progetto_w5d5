package it.epicode.progetto.services;

import it.epicode.progetto.entities.Postazione;
import it.epicode.progetto.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> getAllPostazioni(){
        return postazioneRepository.findAll();
    }

    public Postazione getPostazioneById(int id){
        return postazioneRepository.findById(id).get();
    }

    public Postazione salvaPostazione(Postazione postazione){
        return postazioneRepository.save(postazione);
    }

    public void cancellaPostazione(int id){
        postazioneRepository.deleteById(id);
    }


}