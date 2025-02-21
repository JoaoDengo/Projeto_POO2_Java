package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.ClienteDao;
import org.example.model.Cliente;

import java.util.List;

public class ClienteService {
    private ClienteDao clienteDao;

    public ClienteService(EntityManager em){
        this.clienteDao = new ClienteDao(em);
    }

    public void inserir(Cliente cliente){
        clienteDao.cadastrar(cliente);
    }

    public void alterar(Cliente cliente){
        clienteDao.atualizar(cliente);
    }

    public void excluir(Cliente cliente){
        clienteDao.excluir(cliente);
    }

    public Cliente buscarClientePorId(Long id){
        return clienteDao.buscarPorId(id);
    }

    public List<Cliente> buscarTodosCliente(){
        return clienteDao.buscarTodos();
    }
}
