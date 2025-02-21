package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Cliente;

public class ClienteDao extends GenericDao<Cliente> {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        super(em, Cliente.class);
    }
}
