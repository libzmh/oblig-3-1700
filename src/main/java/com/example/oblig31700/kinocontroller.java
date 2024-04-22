package com.example.oblig31700;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
//arraylist
@RestController
public class kinocontroller {
    @Autowired
    private kinoRepository rep;
    @PostMapping("/lagrefilm")
    public void lagrebilett(kino inticket){
       rep.lagrebilett(inticket);
    }
    @GetMapping("/hentfilm")
    public ArrayList<kino> hentalle(){
        return rep.hentalle();
    }
    @GetMapping("/slettalle")
    public void slettalle(){
        rep.slettalle();
    }
}
