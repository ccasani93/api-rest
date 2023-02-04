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

import com.idat.idatapirest.dto.SupplierRequestDTO;
import com.idat.idatapirest.dto.SupplierResponseDTO;
import com.idat.idatapirest.service.SupplierService;

@RestController
@RequestMapping("/proveedor/v1")
public class SupplierController {

	@Autowired
	private SupplierService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<SupplierResponseDTO>> listarProveedor(){
		
		return new ResponseEntity<List<SupplierResponseDTO>>(service.listarProveedor(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardarProveedor(@RequestBody SupplierRequestDTO supplier){
		
		service.guardarProveedor(supplier);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<SupplierResponseDTO> proveedorById(@PathVariable Integer id){
		
		SupplierResponseDTO supplier = service.proveedorByid(id);
		
		if(supplier != null) {
			return new ResponseEntity<SupplierResponseDTO>(HttpStatus.OK);
		}
		
		return new ResponseEntity<SupplierResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id){
		
		SupplierResponseDTO supplier = service.proveedorByid(id);
		
		if(supplier != null) {
			service.eliminarProveedor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/editar")
	public ResponseEntity<Void> editarProveedor(@RequestBody SupplierRequestDTO supplier){
		
		SupplierResponseDTO suppliers = service.proveedorByid(supplier.getIdproveedor());
		
		if(suppliers != null) {
			
			service.editarProveedor(supplier);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
