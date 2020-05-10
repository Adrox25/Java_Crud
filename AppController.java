package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private SamochodUsluga usluga;

    @RequestMapping("/")
    public String stronaGlowna(Model model){
        List<Samochod> listaSamochodow = usluga.wyswietl_wszystko();
        model.addAttribute("listaSamochodow", listaSamochodow);
        return "index";
    }

    @RequestMapping("/nowy")
    public String wyswietlStroneNowySamochod(Model model){
        Samochod samochod = new Samochod();
        model.addAttribute("samochod", samochod);
        return "nowy_samochod";
    }
    @RequestMapping(value="/zapisz", method= RequestMethod.POST)
    public String zapiszSamochod(@ModelAttribute("samochod") Samochod samochod) {
        usluga.zapisz(samochod);

            return "redirect:/";
    }

    @RequestMapping("/edytuj/{id}")
    public ModelAndView pokazStroneDoEdycji(@PathVariable(name = "id") int id) {
        ModelAndView widok = new ModelAndView("edytuj_samochod");
        Samochod samochod = usluga.znajdz(id);
        widok.addObject("samochod", samochod);
        return widok;
    }

    @RequestMapping("/usun/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        usluga.usun(id);
        return "redirect:/";

    }

}
