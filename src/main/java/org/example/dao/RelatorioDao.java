package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.exception.DataAccessException;
import org.example.vo.RelatorioAlugueisVo;
import org.example.vo.RelatorioFinanceiroVo;

import java.time.LocalDate;
import java.util.List;

public class RelatorioDao {
    private EntityManager em;


    public RelatorioDao(EntityManager em) {
        this.em = em;
    }

    public Double somaValorTotalAlugadoPorPediodo(LocalDate dataInicial, LocalDate dataFinal) {
        try {
            String jpql = "SELECT sum(a.valorTotal) FROM Aluguel a WHERE a.dataInicio BETWEEN :dataInicial AND :dataFinal";
            Double total = em.createQuery(jpql, Double.class)
                    .setParameter("dataInicial", dataInicial)
                    .setParameter("dataFinal", dataFinal)
                    .getSingleResult();
            if (total == null) {
                return 0.0;
            }
            return total;
        }catch (Exception e) {
            throw new DataAccessException("Erro ao retornar Valor Total dos Alugueis por periodo", e);
        }
    }

    public Double somaValorTotalPorCliente(Long id){
        try{
            String jpql = "SELECT sum(a.valorTotal) FROM Aluguel a WHERE a.cliente.id = :id";
            Double total = em.createQuery(jpql, Double.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (total == null) {
                return 0.0;
            }
            return total;
        }catch (Exception e) {
            throw new DataAccessException("Erro ao retornar Valor Total por cliente", e);
        }
    }

    public Long totalClientesAtentidosPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        try{
            String jpql = "SELECT COUNT(DISTINCT a.cliente) FROM Aluguel a WHERE a.dataInicio BETWEEN :dataInicial AND :dataFinal";
            Long numCliente = em.createQuery(jpql, Long.class)
                    .setParameter("dataInicial", dataInicial)
                    .setParameter("dataFinal", dataFinal)
                    .getSingleResult();
            if(numCliente == null) {
                return Long.valueOf(0);
            }
            return numCliente;
        }catch (Exception e) {
            throw new DataAccessException("Erro ao retonar total de clientes atendidos por pedidos", e);
        }
    }


    public List<RelatorioAlugueisVo> relatorioAluguel() {
        String jpql = "SELECT new org.example.vo.RelatorioAlugueisVo("
                + "c.nome, "
                + "v.placa, "
                + "a.dataInicio, "
                + "a.dataFim, "
                + "(a.kmFinal - a.kmInicial), "
                + "f.nome) "
                + "FROM Aluguel a "
                + "JOIN a.cliente c "
                + "JOIN a.veiculo v "
                + "JOIN a.funcionario f "
                + "ORDER BY a.dataInicio DESC";

        return em.createQuery(jpql, RelatorioAlugueisVo.class)
                .getResultList();
    }

    public List<RelatorioFinanceiroVo> relatorioFinanceiro() {
        String jpql = "SELECT new org.example.vo.RelatorioFinanceiroVo("
                + "f.nome, "
                + "SUM(a.valorTotal)) "
                + "FROM Aluguel a "
                + "JOIN a.funcionario f "
                + "GROUP BY f.nome "
                + "ORDER BY SUM(a.valorTotal) DESC";

        return em.createQuery(jpql, RelatorioFinanceiroVo.class)
                .getResultList();
    }




}
