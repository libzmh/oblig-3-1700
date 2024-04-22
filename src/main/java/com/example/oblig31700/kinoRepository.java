package com.example.oblig31700;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class kinoRepository  {
    @Autowired
    private JdbcTemplate db;
    public void lagrebilett(kino innticket){
        String sql= "INSERT INTO kino (movie,firstname,surname,email,telephone,tickets) VALUES (?,?,?,?,?,?)";
        db.update(sql,innticket.getMovie(),innticket.getFirstname(),innticket.getSurname(),innticket.getEmail()
                                            ,innticket.getTelephone(),innticket.getTickets());
    }
    public ArrayList<kino>hentalle(){
        String sql="SELECT * FROM kino ORDER BY surname DESC";
        ArrayList<kino> allefilmer= (ArrayList<kino>) db.query(sql, new BeanPropertyRowMapper<>(kino.class));
        return allefilmer;
    }
    public void slettalle(){
        String sql="DELETE FROM kino";
        db.update(sql);
    }
}
