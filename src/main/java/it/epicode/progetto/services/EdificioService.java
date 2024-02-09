package it.epicode.progetto.services;

import it.epicode.progetto.entities.Edificio;
import it.epicode.progetto.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public List<Edificio> getAllEdifici(){
        return edificioRepository.findAll();
    }

    public Edificio getEdificioById(int id){
        return edificioRepository.findById(id).get();
    }

    public Edificio salvaEdificio(Edificio edificio){
        return edificioRepository.save(edificio);
    }

    public void cancellaEdificio(int id){
        edificioRepository.deleteById(id);
    }
}
