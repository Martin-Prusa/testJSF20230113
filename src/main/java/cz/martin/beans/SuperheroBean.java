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

    private int publisher = -1;

    public List<Hero> getHeroes() {
        return superheroService.getHeroes(publisher);
    }

    public void sp(int p) {
        System.out.println(p);
        setPublisher(p);
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }
}
