/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dGreska;

import MVC.model.ProizvodListaUpit;
import MVC.kontroler.Proizvod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Zmaj9
 */
@ManagedBean(name = "ProizvodLista")
@SessionScoped

public class ProizvodLogika implements Serializable {

    private Proizvod proizvod = new Proizvod();
    ProizvodListaUpit query = new ProizvodListaUpit();
    private List<Proizvod> list = new ArrayList<Proizvod>();

    public List<Proizvod> getList() {
        list = query.listProizvod();
        return list;
    }

    public void setList(List<Proizvod> list) {
        this.list = list;
    }

    
    

}
