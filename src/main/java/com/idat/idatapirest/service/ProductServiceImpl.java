package com.idat.idatapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.ProductRequestDTO;
import com.idat.idatapirest.model.Products;
import com.idat.idatapirest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public void guardarProducto(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		repository.save(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarProducto(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(p);
	}

	@Override
	public List<ProductRequestDTO> listarProductos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Products productById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
