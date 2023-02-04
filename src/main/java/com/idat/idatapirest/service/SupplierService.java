package com.idat.idatapirest.service;

import java.util.List;

import com.idat.idatapirest.dto.SupplierRequestDTO;
import com.idat.idatapirest.dto.SupplierResponseDTO;

public interface SupplierService {

	public void guardarProveedor(SupplierRequestDTO s);
	public void editarProveedor(SupplierRequestDTO s);
	public void eliminarProveedor(Integer id);
	public List<SupplierResponseDTO> listarProveedor();
	public SupplierResponseDTO proveedorByid(Integer id);
}
