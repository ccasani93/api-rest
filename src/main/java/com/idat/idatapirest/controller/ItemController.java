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

import com.idat.idatapirest.dto.ItemRequestDTO;
import com.idat.idatapirest.dto.ItemResponseDTO;
import com.idat.idatapirest.service.ItemService;

@RestController
@RequestMapping("/item/v1")
public class ItemController {

	
	@Autowired
	private ItemService service;
	
	@RequestMapping(method = RequestMethod.GET,path = "/listar")
	public ResponseEntity<List<ItemResponseDTO>> listarItem(){
		
		return new ResponseEntity<List<ItemResponseDTO>>(service.listarItem(),HttpStatus.OK);
	}
	
	@RequestMapping(method =RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<ItemResponseDTO> itemById(@PathVariable Integer id){
		
		ItemResponseDTO item = service.itemById(id);
		
		if(item != null) {			
			return new ResponseEntity<ItemResponseDTO>(item,HttpStatus.OK);
		}
		
		return new ResponseEntity<ItemResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardarItem(@RequestBody ItemRequestDTO item){
		
		service.guardarItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, params = "/editar")
	public ResponseEntity<Void> editarItem(@RequestBody ItemRequestDTO item){
		
		ItemResponseDTO items = service.itemById(item.getIditem());
		
		if(items != null) {
			service.editarItem(item);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				
	}
	
	@RequestMapping(method =RequestMethod.DELETE, path = "/eliminar" )
	public ResponseEntity<Void> eliminarItem(@PathVariable Integer id){
		
		ItemResponseDTO items = service.itemById(id);
		
		if(items != null) {
			service.eliminarItem(id);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
