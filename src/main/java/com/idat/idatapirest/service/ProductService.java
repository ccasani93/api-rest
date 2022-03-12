package com.idat.idatapirest.service;

import java.util.List;

import com.idat.idatapirest.dto.ProductRequestDTO;
import com.idat.idatapirest.model.Products;

public interface ProductService {

	public void guardarProducto(ProductRequestDTO p);
	public void eliminarProducto(Integer id);
	public void editarProducto(ProductRequestDTO p);
	public List<ProductRequestDTO> listarProductos();
	public Products productById(Integer id);
	
}
