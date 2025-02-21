package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario> {
    private EntityManager em;

    public FuncionarioDao(EntityManager em) {
        super(em, Funcionario.class);
    }
}
