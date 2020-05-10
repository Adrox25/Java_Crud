package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SamochodUsluga {

    @Autowired
    private SamochodRepository baza;
    public List<Samochod> wyswietl_wszystko() {
        return baza.findAll();
    }
    public void zapisz(Samochod samochod) {
        baza.save(samochod);
    }
    public Samochod znajdz(long id){
       return  baza.findById(id).get();
    }
    public void usun(long id){
        baza.deleteById(id);
    }
}
