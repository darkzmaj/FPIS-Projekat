/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.kontroler;

import MVC.DBB.dbb;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

@ManagedBean(name = "proizvodBean")
@SessionScoped
public class Proizvod {

    private int proizvodID;
    private String naziv;
    private String opis;
    private double cena;
    private String jedMere;

    public Proizvod() {
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getJedMere() {
        return jedMere;
    }

    public void setJedMere(String jedMere) {
        this.jedMere = jedMere;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
//nizovi za unos podataka
    public ArrayList<Integer> idUnos = new ArrayList();
    public ArrayList<String> nazUnos = new ArrayList();
    public ArrayList<String> opUnos = new ArrayList();
    public ArrayList<Double> ceUnos = new ArrayList();
    public ArrayList<String> jmUnos = new ArrayList();

//nizovi za izmenu podataka
    public ArrayList<Integer> idIzmena = new ArrayList();
    public ArrayList<String> nazIzmena = new ArrayList();
    public ArrayList<String> opIzmena = new ArrayList();
    public ArrayList<Double> ceIzmena = new ArrayList();
    public ArrayList<String> jmIzmena = new ArrayList();
//niz za brisanje
    public ArrayList<Integer> idBrisanje = new ArrayList();

//dbb objekat
    dbb dbb = new dbb();

    //
    public void dodajProizvodUListu() {

        idUnos.add(proizvodID);
        nazUnos.add(naziv);
        opUnos.add(opis);
        ceUnos.add(cena);
        jmUnos.add(jedMere);
    }

    public void izmeniProizvodLista() {
        idIzmena.add(proizvodID);
        nazIzmena.add(naziv);
        opIzmena.add(opis);
        ceIzmena.add(cena);
        jmIzmena.add(jedMere);
    }

    public void obrisiProizvodLista() {
        idBrisanje.add(proizvodID);
    }

    public void sacuvajStvarno() throws ClassNotFoundException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sacuvano nov proizvod sa sifrom: " + proizvodID + " Naziv proizvoda: " + naziv));

        dbb.sacuvajProizvodBazaIzListe(this);

    }

    public void izmeniStvarno() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Izmenjen proizvod: " + proizvodID));

        dbb.izmeniProizvodBazaizListe(this);
    }

    public void obrisiStvarno() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Obrisan proizvod " + proizvodID));
        
        dbb.obrisiProizvodBazaIzListe(this);
    }
}
