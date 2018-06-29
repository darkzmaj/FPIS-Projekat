/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dGreska;

import MVC.model.PorudzbenicaListaUpit;
import MVC.kontroler.Porudzbenica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Zmaj9
 */
@ManagedBean(name = "PorudzbenicaLista")
@SessionScoped

public class PorudzbenicaLogika implements Serializable {

    private Porudzbenica porudzbenica = new Porudzbenica();
   PorudzbenicaListaUpit query = new PorudzbenicaListaUpit();
    private List<Porudzbenica> list = new ArrayList<Porudzbenica>();

    public List<Porudzbenica> getList() {
        list = query.listPorudzbenica();
        return list;
    }

    public void setList(List<Porudzbenica> list) {
        this.list = list;
    }

    
    

}
