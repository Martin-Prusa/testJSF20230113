package cz.martin.beans;

import cz.martin.models.Hero;
import cz.martin.services.SuperheroService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SuperheroBean implements Serializable {
    @Inject
    private SuperheroService superheroService;

    private String[] order = {"pseudonym", "fullname", "gender", "race", "alignment"};

    private int publisher = -1;

    private String orderBy = "";

    private boolean asc = true;

    public List<Hero> getHeroes() {
        return superheroService.getHeroes(publisher, orderBy, asc);
    }

    public void sp(int p) {
        System.out.println(p);
        setPublisher(p);
    }

    public void so(String o) {
        this.orderBy = o;
    }

    public void sa(boolean s) {
        asc = s;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public String[] getOrder() {
        return order;
    }

    public boolean isAsc() {
        return asc;
    }

    public String getOrderBy() {
        return orderBy;
    }
}
