package MVC.kontroler;

import MVC.DBB.dbb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

@ManagedBean(name = "porudzbenicaBean")
@SessionScoped
public class Porudzbenica {

    private int porID;
    private String nazivPorucioca;
    private String mesto;
    private String datumI;
    private String uslovI;
    private String uslovP;

//liste za unos
    public ArrayList<Integer> pIdUnos = new ArrayList();
    public ArrayList<String> nPorUnos = new ArrayList();
    public ArrayList<String> mesUnos = new ArrayList();
    public ArrayList<String> dIUnos = new ArrayList();
    public ArrayList<String> uIUnos = new ArrayList();
    public ArrayList<String> uPUnos = new ArrayList();

//liste za izmenu
    public ArrayList<Integer> pIdIzmena = new ArrayList();
    public ArrayList<String> nPorIzmena = new ArrayList();
    public ArrayList<String> mesIzmena = new ArrayList();
    public ArrayList<String> dIIzmena = new ArrayList();
    public ArrayList<String> uIIzmena = new ArrayList();
    public ArrayList<String> uPIzmena = new ArrayList();

//lista za brisanje
    public ArrayList<Integer> pIdBrisanje = new ArrayList();
//
    public void dodajLista() {
        pIdUnos.add(porID);
        nPorUnos.add(nazivPorucioca);
        mesUnos.add(mesto);
        dIUnos.add(datumI);
        uIUnos.add(uslovI);
        uPUnos.add(uslovP);
    }

    //
    public void izmeniLista() {
        pIdIzmena.add(porID);
        nPorIzmena.add(nazivPorucioca);
        mesIzmena.add(mesto);
        dIIzmena.add(datumI);
        uIIzmena.add(uslovI);
        uPIzmena.add(uslovP);
    }
    /////////////////////

    public void obrisiLista() {
        pIdBrisanje.add(porID);
    }
    ////////////////////////

    public int getPorID() {
        return porID;
    }

    public void setPorID(int porID) {
        this.porID = porID;
    }

    public String getNazivPorucioca() {
        return nazivPorucioca;
    }

    public void setNazivPorucioca(String nazivPorucioca) {
        this.nazivPorucioca = nazivPorucioca;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getDatumI() {
        return datumI;
    }

    public void setDatumI(String datumI) {
        this.datumI = datumI;
    }

    public String getUslovI() {
        return uslovI;
    }

    public void setUslovI(String uslovI) {
        this.uslovI = uslovI;
    }

    public String getUslovP() {
        return uslovP;
    }

    public void setUslovP(String uslovP) {
        this.uslovP = uslovP;
    }

    public Porudzbenica() {
    }

    dbb dbb = new dbb();

    public void sacuvajStvarno() {

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Dodata je nova porudzbenica sa brojem: " + porID));

        dbb.sacuvajPorudzbenicuBazaIzListe(this);

    }

    public void izmeniStvarno() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Izmenjena je porudzbenica broj: " + porID));

        dbb.izmeniPorudzbenicuBazaIzListe(this);
    }

    public void obrisiStvarno() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Obrisana porudzbenica broj: " + porID));

        dbb.obrisiPorudzbenicuBazaIzListe(this);
    }

}
