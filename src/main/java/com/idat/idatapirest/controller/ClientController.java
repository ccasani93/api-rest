package com.idat.idatapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatapirest.dto.ClientRequestDTO;
import com.idat.idatapirest.dto.ClientResponseDTO;
import com.idat.idatapirest.service.ClientService;

@RestController
@RequestMapping("/cliente/v1")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<ClientResponseDTO>> listarCliente(){
		
		return new ResponseEntity<List<ClientResponseDTO>>(service.listarCliente(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardarCliente(@RequestBody ClientRequestDTO clients){
		service.guardarCliente(clients);		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editarCliente(@RequestBody ClientRequestDTO clients){
		
		ClientResponseDTO client = service.clienteByid(clients.getIdcliente());
		
		if(client != null) {
			service.editarCliente(clients);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<ClientResponseDTO> clientById(@PathVariable Integer id){
		
		ClientResponseDTO client = service.clienteByid(id);
		
		if (client != null) {
			return new ResponseEntity<ClientResponseDTO>(client,HttpStatus.OK);
		}
		
		return new ResponseEntity<ClientResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id){
		
		ClientResponseDTO client = service.clienteByid(id);
		
		if (client != null) {
			service.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
