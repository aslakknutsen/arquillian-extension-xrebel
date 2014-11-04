package org.arquillian.container.proxy;

import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CountryRepository {

    @PersistenceContext
    private EntityManager em;
    
    public Country createNew(String name) {
        Country country = new Country(UUID.randomUUID().toString(), name);
        em.persist(country);
        return country;
    }
}
