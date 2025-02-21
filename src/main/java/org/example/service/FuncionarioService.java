package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.FuncionarioDao;
import org.example.model.Funcionario;

import java.util.List;

public class FuncionarioService {
    private FuncionarioDao funcionarioDao;

    public FuncionarioService(EntityManager em) {
        this.funcionarioDao = new FuncionarioDao(em);
    }

    public void inserir(Funcionario funcionario) {
        funcionarioDao.cadastrar(funcionario);
    }

    public void alterar(Funcionario funcionario) {
        funcionarioDao.atualizar(funcionario);
    }

    public void excluir(Funcionario funcionario) {
        funcionarioDao.excluir(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioDao.buscarPorId(id);
    }

    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarioDao.buscarTodos();
    }

}
