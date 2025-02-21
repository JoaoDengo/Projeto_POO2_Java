package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.enums.CategoriaVeiculo;
import org.example.enums.StatusVeiculo;
import org.example.exception.DataAccessException;
import org.example.model.Veiculo;

import java.util.List;

public class VeiculoDao extends GenericDao<Veiculo>{
    private EntityManager em;

    public VeiculoDao(EntityManager em) {
        super(em, Veiculo.class);
        this.em = em;
    }


    public List<Veiculo> buscarPorNome(String nomeModelo) {
        try {
            String jpql = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo";
            return em.createQuery(jpql, Veiculo.class)
                    .setParameter("modelo", nomeModelo)
                    .getResultList();
        }catch (Exception e) {
            throw new DataAccessException("Erro ao buscar veiculo por modelo:", e);
        }
    }

    public List<Veiculo> buscarPorCategoria(CategoriaVeiculo categoria) {
        try {
            String jpql = "SELECT v FROM Veiculo v WHERE v.categoria = :categoria";
            return em.createQuery(jpql, Veiculo.class)
                    .setParameter("categoria", categoria)
                    .getResultList();
        } catch (Exception e) {
            throw new DataAccessException("Erro ao buscar veículo por categoria:", e);
        }
    }

    public List<Veiculo> buscarPorStatus(StatusVeiculo status) {
        try{
            String jpql = "SELECT p FROM Veiculo p WHERE p.status = :status";
            return em.createQuery(jpql, Veiculo.class)
                    .setParameter("status", status)
                    .getResultList();
        }catch (Exception e){
            throw new DataAccessException("Erro ao buscar veículo por status:", e);
        }
    }



}
