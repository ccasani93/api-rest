package com.idat.idatapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.SupplierRequestDTO;
import com.idat.idatapirest.dto.SupplierResponseDTO;
import com.idat.idatapirest.model.Suppliers;
import com.idat.idatapirest.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierRepository repository;
	
	@Override
	public void guardarProveedor(SupplierRequestDTO s) {
		// TODO Auto-generated method stub
		Suppliers suppliers = new Suppliers();
		
		suppliers.setIdProveedor(s.getIdproveedor());
		suppliers.setProveedor(s.getNombreproveedor());
		suppliers.setDireccion(s.getDireccionproveedor());
		repository.save(suppliers);
	}

	@Override
	public void editarProveedor(SupplierRequestDTO s) {
		// TODO Auto-generated method stub
		Suppliers suppliers = new Suppliers();
		
		suppliers.setIdProveedor(s.getIdproveedor());
		suppliers.setProveedor(s.getNombreproveedor());
		suppliers.setDireccion(s.getDireccionproveedor());
		repository.saveAndFlush(suppliers);
	}

	@Override
	public void eliminarProveedor(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<SupplierResponseDTO> listarProveedor() {
		// TODO Auto-generated method stub
		List<Suppliers> suppliers = repository.findAll();
		List<SupplierResponseDTO> dto = new ArrayList<SupplierResponseDTO>();
		SupplierResponseDTO supplierDTO = null;
		
		for(Suppliers supplier : suppliers) {
			supplierDTO = new SupplierResponseDTO();
			supplierDTO.setIdproveedor(supplier.getIdProveedor());
			supplierDTO.setNombreproveedor(supplier.getDireccion());
			supplierDTO.setDireccionproveedor(supplier.getDireccion());
			dto.add(supplierDTO);
		}
		
		
		return dto;
	}

	@Override
	public SupplierResponseDTO proveedorByid(Integer id) {
		// TODO Auto-generated method stub
				
		Suppliers suppliers = repository.findById(id).orElse(null);
		
		SupplierResponseDTO supplierDTO = new SupplierResponseDTO();
		
		supplierDTO.setIdproveedor(suppliers.getIdProveedor());
		supplierDTO.setNombreproveedor(suppliers.getDireccion());
		supplierDTO.setDireccionproveedor(suppliers.getDireccion());
				
		return supplierDTO;
	}

}
