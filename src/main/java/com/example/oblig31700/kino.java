package com.example.oblig31700;

//import lombok.Getter;

//@Getter
public class kino {
    private String movie;
    private String firstname;
    private String surname;
    private String email;
    private int telephone;
    private int tickets;

    public kino() {
    }

    public kino(String movie, String firstname, String surname, String email, int telephone, int tickets) {
        this.movie = movie;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.tickets = tickets;
    }

    public String getMovie() {
        return movie;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public int getTickets() {
        return tickets;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
