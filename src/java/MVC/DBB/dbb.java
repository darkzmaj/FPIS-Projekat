/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.DBB;

import MVC.kontroler.Proizvod;
import MVC.kontroler.Porudzbenica;
import MVC.kontroler.Stavke;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Zmaj9
 */
public class dbb {

    Connection conn = null;
    PreparedStatement preparedStmt = null;
    String myUrl = "jdbc:mysql://localhost/fpis";
    String myDriver = "org.gjt.mm.mysql.Driver";

    public void pokreniDBTransakciju() {
        try {
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl, "root", "root");
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            System.err.println("Greska ucitavanje drajvera " + e);
        } catch (SQLException e) {
            System.err.println("greska sa konekcijom " + e);
        }
    }

    public void potvrdiDBTransakciju() {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Greska prilikom commit operacije... -> " + e);
        }
    }

    public void ponistiDBTransakciju() {
        try {
            conn.rollback();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Greska prilikom rollback operacije... -> " + e);
        }
    }

////////////////////////////////////////////////////////    
//pocetak koda za unos/izmenu/brisanje proizvoda iz baze
////////////////////////////////////////////////////////    
    public void obrisiProizvodBazaIzListe(Proizvod pr) {
        try {
            pokreniDBTransakciju();

            String query = " delete from proizvod where proizvodid = ?";

            for (int i = 0; i < pr.idBrisanje.size(); i++) {

                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, pr.idBrisanje.get(i));
                preparedStmt.executeUpdate();

            }
            potvrdiDBTransakciju();
            pr.idBrisanje.clear();
        } catch (Exception e) {
            ponistiDBTransakciju();
            pr.idBrisanje.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());
        }

    }

    public void izmeniProizvodBazaizListe(Proizvod pr) throws SQLException {
        try {

            pokreniDBTransakciju();

            String query = "update proizvod set naziv = ?, opis = ?, cena = ?, jedMere = ? where proizvodid = ?";

            for (int i = 0; i < pr.idIzmena.size(); i++) {

                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, pr.nazIzmena.get(i));
                preparedStmt.setString(2, pr.opIzmena.get(i));
                preparedStmt.setDouble(3, pr.ceIzmena.get(i));
                preparedStmt.setString(4, pr.jmIzmena.get(i));
                preparedStmt.setInt(5, pr.idIzmena.get(i));
                preparedStmt.execute();
                //

            }
            potvrdiDBTransakciju();
            pr.idIzmena.clear();
            pr.nazIzmena.clear();
            pr.opIzmena.clear();
            pr.ceIzmena.clear();
            pr.jmIzmena.clear();
        } catch (Exception e) {
            //
            ponistiDBTransakciju();
            pr.idIzmena.clear();
            pr.nazIzmena.clear();
            pr.opIzmena.clear();
            pr.ceIzmena.clear();
            pr.jmIzmena.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());
        }

    }

    public void sacuvajProizvodBazaIzListe(Proizvod pr) throws SQLException {
        try {

            pokreniDBTransakciju();
            String query = " insert into proizvod values (?, ?, ?, ?, ?)";

            for (int i = 0; i < pr.idUnos.size(); i++) {

                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, pr.idUnos.get(i));
                preparedStmt.setString(2, pr.nazUnos.get(i));
                preparedStmt.setString(3, pr.opUnos.get(i));
                preparedStmt.setDouble(4, pr.ceUnos.get(i));
                preparedStmt.setString(5, pr.jmUnos.get(i));

                preparedStmt.execute();

            }

            potvrdiDBTransakciju();
            pr.idUnos.clear();
            pr.nazUnos.clear();
            pr.opUnos.clear();
            pr.ceUnos.clear();
            pr.jmUnos.clear();
        } catch (Exception e) {
            conn.rollback();
            pr.idUnos.clear();
            pr.nazUnos.clear();
            pr.opUnos.clear();
            pr.ceUnos.clear();
            pr.jmUnos.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());

        }

    }
////////////////////////////////////////////////////////    
//kraj koda za unos/izmenu/brisanje proizvoda iz baze
////////////////////////////////////////////////////////   
    //no man's land
////////////////////////////////////////////////////////    
//pocetak koda za unos/izmenu/brisanje porudzbenice iz porudzbenice
////////////////////////////////////////////////////////   

    public void obrisiPorudzbenicuBazaIzListe(Porudzbenica por) {
        try {
            pokreniDBTransakciju();
            String query = " delete from porudzbenica where porid = ?";

            for (int i = 0; i < por.pIdBrisanje.size(); i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, por.pIdBrisanje.get(i));
                preparedStmt.execute();

            }

            potvrdiDBTransakciju();
            por.pIdBrisanje.clear();

        } catch (Exception e) {
            ponistiDBTransakciju();
            por.pIdBrisanje.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());
        }
    }

    public void izmeniPorudzbenicuBazaIzListe(Porudzbenica por) {
        try {
            pokreniDBTransakciju();

            String query = "update porudzbenica set naziv = ?, mesto = ?, datumI = ?, uslovI = ?, uslovP = ? where porID = ?";

            for (int i = 0; i < por.pIdIzmena.size(); i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(6, por.pIdIzmena.get(i));
                preparedStmt.setString(1, por.nPorIzmena.get(i));
                preparedStmt.setString(2, por.mesIzmena.get(i));
                preparedStmt.setString(3, por.dIIzmena.get(i));
                preparedStmt.setString(4, por.uIIzmena.get(i));
                preparedStmt.setString(5, por.uPIzmena.get(i));
                preparedStmt.execute();

            }

            potvrdiDBTransakciju();
            por.pIdIzmena.clear();
            por.nPorIzmena.clear();
            por.mesIzmena.clear();
            por.dIIzmena.clear();
            por.uIIzmena.clear();
            por.uPIzmena.clear();
        } catch (Exception e) {
            ponistiDBTransakciju();
            por.pIdIzmena.clear();
            por.nPorIzmena.clear();
            por.mesIzmena.clear();
            por.dIIzmena.clear();
            por.uIIzmena.clear();
            por.uPIzmena.clear();
            System.err.println("Greska");
            System.err.println(e.getMessage());
        }
    }

    public void sacuvajPorudzbenicuBazaIzListe(Porudzbenica por) {
        try {
            pokreniDBTransakciju();

            String query = " insert into porudzbenica values (?, ?, ?, ?, ?, ?)";
            for (int i = 0; i < por.pIdUnos.size(); i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, por.pIdUnos.get(i));
                preparedStmt.setString(2, por.nPorUnos.get(i));
                preparedStmt.setString(3, por.mesUnos.get(i));
                preparedStmt.setString(4, por.dIUnos.get(i));
                preparedStmt.setString(5, por.uIUnos.get(i));
                preparedStmt.setString(6, por.uPUnos.get(i));
                preparedStmt.execute();

            }
            potvrdiDBTransakciju();
            por.pIdUnos.clear();
            por.nPorUnos.clear();
            por.mesUnos.clear();
            por.dIUnos.clear();
            por.uIUnos.clear();
            por.uPUnos.clear();
        } catch (Exception e) {
            ponistiDBTransakciju();
            por.pIdUnos.clear();
            por.nPorUnos.clear();
            por.mesUnos.clear();
            por.dIUnos.clear();
            por.uIUnos.clear();
            por.uPUnos.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());
        }
    }

////////////////////////////////////////////////////////    
//kraj koda za unos/izmenu/brisanje porudzbenice iz baze
////////////////////////////////////////////////////////  
//
////////////////////////////////////////////////////////    
//pocetak koda za unos/izmenu/brisanje stavki iz baze
////////////////////////////////////////////////////////
    public void unesiStavkeBazaIzListe(Stavke sp) throws SQLException {
        try {
            pokreniDBTransakciju();

            String query = " insert into stavke (porid, proizvod, kolicina, datumIsporuke) values (?, ?, ?, ?)";
            for (int i = 0; i < sp.pIdUnos.size(); i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, sp.pIdUnos.get(i));
                preparedStmt.setString(2, sp.proizUnos.get(i));
                preparedStmt.setInt(3, sp.kolUnos.get(i));
                preparedStmt.setString(4, sp.datIspUnos.get(i));
                preparedStmt.execute();

            }
            potvrdiDBTransakciju();
            sp.pIdUnos.clear();
            sp.proizUnos.clear();
            sp.kolUnos.clear();
            sp.datIspUnos.clear();
        } catch (Exception e) {
            ponistiDBTransakciju();
            sp.pIdUnos.clear();
            sp.proizUnos.clear();
            sp.kolUnos.clear();
            sp.datIspUnos.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());
        }
    }

    public void izmeniStavkeBazaIzListe(Stavke sp) throws SQLException {
        try {
            pokreniDBTransakciju();

            String query = "update stavke set proizvod = ?, kolicina = ?, datumIsporuke = ? where porID = ? and redBr = ?";
            for (int i = 0; i < sp.pIdIzmena.size(); i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, sp.proizIzmena.get(i));
                preparedStmt.setInt(2, sp.kolIzmena.get(i));
                preparedStmt.setString(3, sp.datIspIzmena.get(i));
                preparedStmt.setInt(4, sp.pIdIzmena.get(i));
                preparedStmt.setInt(5, sp.rBrIzmena.get(i));
                preparedStmt.execute();

            }
            potvrdiDBTransakciju();
            sp.proizIzmena.clear();
            sp.kolIzmena.clear();
            sp.datIspIzmena.clear();
            sp.pIdIzmena.clear();
            sp.rBrIzmena.clear();

        } catch (Exception e) {
            ponistiDBTransakciju();
            sp.proizIzmena.clear();
            sp.kolIzmena.clear();
            sp.datIspIzmena.clear();
            sp.pIdIzmena.clear();
            sp.rBrIzmena.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());
        }
    }

    public void obrisiStavkeBazaIzListe(Stavke sp) throws SQLException {
        try {
            pokreniDBTransakciju();

            String query = " delete from stavke where porid = ? and redbr = ?";
            for (int i = 0; i < sp.rBrBrisanje.size(); i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, sp.pIdBrisanje.get(i));
                preparedStmt.setInt(2, sp.rBrBrisanje.get(i));
                preparedStmt.executeUpdate();

            }
            potvrdiDBTransakciju();
            sp.pIdBrisanje.clear();
            sp.rBrBrisanje.clear();
        } catch (Exception e) {
            ponistiDBTransakciju();
            sp.pIdBrisanje.clear();
            sp.rBrBrisanje.clear();
            System.err.println("Greska!");
            System.err.println(e.getMessage());
        }
    }

}
