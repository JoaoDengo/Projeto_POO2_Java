package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.VeiculoDao;
import org.example.enums.CategoriaVeiculo;
import org.example.enums.StatusVeiculo;
import org.example.model.Veiculo;

import java.util.List;

public class VeiculoService {
    private VeiculoDao veiculoDao;

    public VeiculoService(EntityManager em) {
        this.veiculoDao = new VeiculoDao(em);
    }

    public void inserir(Veiculo veiculo) {
        veiculoDao.cadastrar(veiculo);
    }

    public void alterar(Veiculo veiculo) {
        veiculoDao.atualizar(veiculo);
    }

    public void excluir(Veiculo veiculo) {
        veiculoDao.excluir(veiculo);
    }

    public Veiculo buscarVeiculoPorID(Long id) {
        return veiculoDao.buscarPorId(id);
    }

    public List<Veiculo> buscarTodosVeiculos() {
        return veiculoDao.buscarTodos();
    }

    public List<Veiculo> buscarVeiculoPorNome(String nome){
        return veiculoDao.buscarPorNome(nome);
    }

    public List<Veiculo> buscaVeiculoPorCategoria(CategoriaVeiculo categoria){
        return  veiculoDao.buscarPorCategoria(categoria);
    }

    public List<Veiculo> buscaVeiculoPorStatus(StatusVeiculo status){
        return veiculoDao.buscarPorStatus(status);
    }
}
