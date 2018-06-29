/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.model;

import MVC.kontroler.Proizvod;
import cBroker.Konekcija;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zmaj9
 */
public class ProizvodListaUpit extends Konekcija implements Serializable {

    public List<Proizvod> listProizvod() {
        List<Proizvod> list = new ArrayList<Proizvod>();

        try {
            ps = connect().prepareStatement("select * from proizvod order by proizvodid");
            Proizvod p;
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Proizvod();
                p.setProizvodID(rs.getInt("proizvodid"));
                p.setNaziv(rs.getString("naziv"));
                p.setOpis(rs.getString("opis"));
                p.setCena(rs.getDouble("cena"));
                p.setJedMere(rs.getString("jedMere"));
                list.add(p);
            }

            return list;
        } catch (Exception e) {
            return null;
        }

    }

}
