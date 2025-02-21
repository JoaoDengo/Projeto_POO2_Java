package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.AluguelDao;
import org.example.model.Aluguel;

import java.time.LocalDate;
import java.util.List;

public class AluguelService {
    private AluguelDao aluguelDao;

    public AluguelService(EntityManager em) {
        this.aluguelDao = new AluguelDao(em);
    }

    public void inserir(Aluguel aluguel) {
        aluguelDao.cadastrar(aluguel);
    }

    public void alterar(Aluguel aluguel) {
        aluguelDao.atualizar(aluguel);
    }

    public void excluir(Aluguel aluguel) {
        aluguelDao.excluir(aluguel);
    }

    public Aluguel buscarAluguelPorId(Long id){
        return aluguelDao.buscarPorId(id);
    }

    public List<Aluguel> buscarTodosAluguel(){
        return aluguelDao.buscarTodos();
    }

    public List<Aluguel> buscarAlguelPorPeriodo(LocalDate dataIni, LocalDate dataFim){
        return aluguelDao.buscarPorPeriodo(dataIni, dataFim);
    }

    public List<Aluguel> buscarAluguelDeUmCliente(Long id) {
        return aluguelDao.buscarDeUmCliente(id);
    }

    public List<Aluguel> buscarAluguelDeUmFuncionario(Long id) {
        return aluguelDao.buscarDeUmFuncionario(id);
    }

    public List<Aluguel> buscarAluguelDeUmVeiculo(Long id) {
        return aluguelDao.buscarDeUmVeiculo(id);
    }
}
