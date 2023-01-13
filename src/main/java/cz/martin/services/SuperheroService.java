package cz.martin.services;

import cz.martin.models.Hero;
import cz.martin.models.Publisher;
import cz.martin.repositories.SuperheroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class SuperheroService {
    @Inject
    private SuperheroRepository superheroRepository;

    public List<Publisher> getPublishers() {
        return superheroRepository.getPublishers();
    }

    public List<Hero> getHeroes(int publisher) {
        return superheroRepository.getHeroes(publisher);
    }
}
