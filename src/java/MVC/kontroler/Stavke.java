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
import javax.faces.context.*;

@ManagedBean(name = "stavkeBean")
@SessionScoped
public class Stavke {

    private int porID;
    private int redBr;
    private String proizvod;
    private int kolicina;
    private String datumIsporuke;

    //liste za unos
    public ArrayList<Integer> pIdUnos = new ArrayList();
    public ArrayList<String> proizUnos = new ArrayList();
    public ArrayList<Integer> kolUnos = new ArrayList();
    public ArrayList<String> datIspUnos = new ArrayList();
    //liste za izmenu
    public ArrayList<Integer> pIdIzmena = new ArrayList();
    public ArrayList<Integer> rBrIzmena = new ArrayList();
    public ArrayList<String> proizIzmena = new ArrayList();
    public ArrayList<Integer> kolIzmena = new ArrayList();
    public ArrayList<String> datIspIzmena = new ArrayList();
    //liste za brisanje
    public ArrayList<Integer> pIdBrisanje = new ArrayList();
    public ArrayList<Integer> rBrBrisanje = new ArrayList();

    public void unosLista() {
        pIdUnos.add(porID);
        proizUnos.add(proizvod);
        kolUnos.add(kolicina);
        datIspUnos.add(datumIsporuke);

    }

    public void izmenaLista() {
        pIdIzmena.add(porID);
        rBrIzmena.add(redBr);
        proizIzmena.add(proizvod);
        kolIzmena.add(kolicina);
        datIspIzmena.add(datumIsporuke);
    }

    public void brisanjeLista() {
        pIdBrisanje.add(porID);
        rBrBrisanje.add(redBr);
    }

    public Stavke() {

    }

    public int getPorID() {
        return porID;
    }

    public void setPorID(int porID) {
        this.porID = porID;
    }

    public int getRedBr() {
        return redBr;
    }

    public void setRedBr(int redBr) {
        this.redBr = redBr;
    }

    public String getProizvod() {
        return proizvod;
    }

    public void setProizvod(String proizvod) {
        this.proizvod = proizvod;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getDatumIsporuke() {
        return datumIsporuke;
    }

    public void setDatumIsporuke(String datumIsporuke) {
        this.datumIsporuke = datumIsporuke;
    }
    dbb dbb = new dbb();

    public void sacuvajStvarno() throws SQLException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sacuvana nova stavka", "Redni broj: " + redBr + " Naziv: " + proizvod));

        dbb.unesiStavkeBazaIzListe(this);
    }

    public void izmeniStvarno() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Izmenjena stavka ", "Broj stavke: " + redBr + " Naziv proizvoda: " + proizvod));

        dbb.izmeniStavkeBazaIzListe(this);

    }

    public void obrisiStvarno() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Obrisana stavka sa porudzbenice" + porID, "Broj stavke: " + redBr));

        dbb.obrisiStavkeBazaIzListe(this);

    }
}
