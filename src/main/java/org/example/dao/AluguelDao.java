package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.exception.DataAccessException;
import org.example.model.Aluguel;

import java.time.LocalDate;
import java.util.List;

public class AluguelDao extends GenericDao<Aluguel>{
    private EntityManager em;

    public AluguelDao(EntityManager em) {
        super(em, Aluguel.class);
        this.em = em;
    }

    public List<Aluguel> buscarPorPeriodo(LocalDate dataIni, LocalDate dataFim){
        try {
            String jpql = "SELECT a FROM Aluguel a WHERE a.dataInicio BETWEEN :dataIni AND :dataFim";
            return em.createQuery(jpql, Aluguel.class)
                    .setParameter("dataIni", dataIni)
                    .setParameter("dataFim", dataFim)
                    .getResultList();
        }catch (Exception e){
            throw new DataAccessException("Erro ao buscar aluguel por periodo", e);
        }
    }

    public List<Aluguel> buscarDeUmCliente(Long id) {
        try {
            String jpql = "SELECT a FROM Aluguel a JOIN FETCH a.cliente WHERE a.cliente.id = :id";
            return em.createQuery(jpql, Aluguel.class)
                    .setParameter("id", id)
                    .getResultList();
        }catch (Exception e){
            throw new DataAccessException("Erro ao buscar aluguels de um cliente", e);
        }
    }

    public List<Aluguel> buscarDeUmFuncionario(Long id) {
        try {
            String jpql = "SELECT a FROM Aluguel a JOIN FETCH a.funcionario WHERE a.funcionario.id = :id";
            return em.createQuery(jpql, Aluguel.class)
                    .setParameter("id", id)
                    .getResultList();
        }catch (Exception e){
            throw new DataAccessException("Erro ao buscar aluguels de um funcionario", e);
        }
    }

    public List<Aluguel> buscarDeUmVeiculo(Long id) {
        try {
            String jpql = "SELECT a FROM Aluguel a JOIN FETCH a.veiculo WHERE a.veiculo.id = :id";
            return em.createQuery(jpql, Aluguel.class)
                    .setParameter("id", id)
                    .getResultList();
        }catch (Exception e){
            throw new DataAccessException("Erro ao buscar aluguels de um veiculo", e);
        }
    }



}
