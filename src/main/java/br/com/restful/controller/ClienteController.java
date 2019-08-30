package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

public class ClienteController {
	/**
	 * 
	 * Chama o metodo listarTodos da classe ClienteDAO
	 */
	public ArrayList<Cliente> listarTodos() {
		System.out.println("Controller: listarTodos ");
		return ClienteDAO.getInstance().listarTodos();

	}

	/**
	 * Chama o metodo getById da classe ClienteDAO
	 */
	public Cliente buscarPorId(long id) {
		System.out.println("Controller: buscarPorId - " + id);
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.getById(id);
		return cliente;
	}

	/**
	 * Chama o metodo inset da classe ClienteDAO
	 */
	public boolean gravarCliente(Cliente cliente) {
		System.out.println("Controller: gravarCliente " + cliente.getNome());
		return new ClienteDAO().insert(cliente);
	}

	/**
	 * Chama o metodo update na classe ClienteDAO
	 */
	public boolean atualizarCliente(long id, Cliente cliente) {
		System.out.println("Controller: atualizarCliente " + cliente.getNome());
		return ClienteDAO.getInstance().update(id, cliente);
	}

	/**
	 * Chama o metodo update na classe ClienteDAO
	 */
	public boolean atualizarClientePATCH(long id, Cliente cliente) {
		System.out.println("Controller: atualizarCliente " + cliente.getNome());
		return ClienteDAO.getInstance().updatePATCH(id, cliente);
	}
	
	
	/**
	 * Chama o metodo delete na classe ClienteDAO
	 */
	public boolean deletarCliente(long id) {
		System.out.println("Controller: deletarCliente " + id);
		return ClienteDAO.getInstance().delete(id);
	}

}
