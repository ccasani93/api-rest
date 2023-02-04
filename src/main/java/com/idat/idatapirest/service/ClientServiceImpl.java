package com.idat.idatapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.ClientRequestDTO;
import com.idat.idatapirest.dto.ClientResponseDTO;
import com.idat.idatapirest.model.Clients;
import com.idat.idatapirest.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;

	@Override
	public void guardarCliente(ClientRequestDTO c) {
		// TODO Auto-generated method stub
		Clients clients = new Clients();
		clients.setIdCliente(c.getIdcliente());
		clients.setCliente(c.getNombrecliente());
		clients.setCelular(c.getCelularcliente());
		repository.save(clients);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarCliente(ClientRequestDTO c) {
		// TODO Auto-generated method stub
		Clients clients = new Clients();
		
		clients.setIdCliente(c.getIdcliente());
		clients.setCliente(c.getNombrecliente());
		clients.setCelular(c.getCelularcliente());
		repository.saveAndFlush(clients);
	}

	@Override
	public List<ClientResponseDTO> listarCliente() {
		// TODO Auto-generated method stub
		
		List<Clients> clients = repository.findAll();
		List<ClientResponseDTO> dto = new ArrayList<ClientResponseDTO>();
		ClientResponseDTO clienteDTO = null;
		
		for(Clients client : clients) {
			clienteDTO = new ClientResponseDTO();			
			clienteDTO.setIdcliente(client.getIdCliente());
			clienteDTO.setNombrecliente(client.getCliente());
			clienteDTO.setCelularcliente(client.getCelular());
			dto.add(clienteDTO);
		}
		
		return dto;
	}

	@Override
	public ClientResponseDTO clienteByid(Integer id) {
		// TODO Auto-generated method stub
		
		Clients clients = repository.findById(id).orElse(null);
		ClientResponseDTO clienteDTO = new ClientResponseDTO();
		
		clienteDTO = new ClientResponseDTO();
		clienteDTO.setIdcliente(clients.getIdCliente());
		clienteDTO.setNombrecliente(clients.getCliente());
		clienteDTO.setCelularcliente(clients.getCelular());
		
		return clienteDTO;
	}
	
	
}
