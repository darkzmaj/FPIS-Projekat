package dGreska;

import MVC.model.StavkeListaUpit;
import MVC.kontroler.Stavke;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StavkeLista")
@SessionScoped
public class StavkeLogika implements Serializable {

    private Stavke stavke = new Stavke();
    StavkeListaUpit query = new StavkeListaUpit();
    private List<Stavke> list = new ArrayList<Stavke>();

    public List<Stavke> getList() {
        list = query.listStavke();
        return list;
    }

    public void setList(List<Stavke> list) {
        this.list = list;
    }
}
