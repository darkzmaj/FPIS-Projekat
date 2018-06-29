/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.model;

import MVC.kontroler.Porudzbenica;
import cBroker.Konekcija;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zmaj9
 */
public class PorudzbenicaListaUpit extends Konekcija implements Serializable {

    public List<Porudzbenica> listPorudzbenica() {
        List<Porudzbenica> list = new ArrayList<Porudzbenica>();

        try {
            ps = connect().prepareStatement("select * from porudzbenica order by porid");
            Porudzbenica p;
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Porudzbenica();
                p.setPorID(rs.getInt("porid"));
                p.setNazivPorucioca(rs.getString("naziv"));
                p.setMesto(rs.getString("mesto"));
                p.setDatumI(rs.getString("datumI"));
                p.setUslovI(rs.getString("uslovI"));
                p.setUslovP(rs.getString("uslovP"));
                list.add(p);
            }

            return list;
        } catch (Exception e) {
            return null;
        }

    }

}
