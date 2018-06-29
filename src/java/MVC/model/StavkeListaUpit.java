/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.model;

import MVC.kontroler.Stavke;
import cBroker.Konekcija;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zmaj9
 */
public class StavkeListaUpit extends Konekcija implements Serializable {

    public List<Stavke> listStavke() {
        List<Stavke> list = new ArrayList<Stavke>();

        try {
            ps = connect().prepareStatement("select * from Stavke order by porid, redbr");
            Stavke p;
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Stavke();
                p.setPorID(rs.getInt("porid"));
                p.setRedBr(rs.getInt("redbr"));
                p.setProizvod(rs.getString("proizvod"));
                p.setKolicina(rs.getInt("kolicina"));
                p.setDatumIsporuke(rs.getString("datumIsporuke"));
                list.add(p);
            }

            return list;
        } catch (Exception e) {
            return null;
        }

    }

}
