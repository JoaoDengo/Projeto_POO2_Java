package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.RelatorioDao;
import org.example.vo.RelatorioAlugueisVo;
import org.example.vo.RelatorioFinanceiroVo;

import java.time.LocalDate;
import java.util.List;

public class RelatorioService {
    private RelatorioDao vendasDao;

    public RelatorioService(EntityManager em) {
        this.vendasDao = new RelatorioDao(em);
    }

    public Double relatorioValorTotalAlugadoPorPediodo(LocalDate dataInicial, LocalDate dataFinal) {
        return vendasDao.somaValorTotalAlugadoPorPediodo(dataInicial, dataFinal);
    }

    public Double relatorioValorTotalPorCliente(Long id){
        return vendasDao.somaValorTotalPorCliente(id);
    }

    public Long relatoriaTotalClienteAtendidoPorPediodo(LocalDate dataInicial, LocalDate dataFinal) {
        return  vendasDao.totalClientesAtentidosPorPeriodo(dataInicial, dataFinal);
    }

    public List<RelatorioAlugueisVo> retornarRelatorioAlugueis(){
        return this.vendasDao.relatorioAluguel();
    }

    public List<RelatorioFinanceiroVo> retornarRelatorioFinanceiro(){
        return this.vendasDao.relatorioFinanceiro();
    }
}
