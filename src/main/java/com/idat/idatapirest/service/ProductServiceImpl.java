package com.idat.idatapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.ProductRequestDTO;
import com.idat.idatapirest.dto.ProductResponseDTO;
import com.idat.idatapirest.model.Products;
import com.idat.idatapirest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository; 
	
	@Override
	public void guardarProducto(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		Products products = new Products();
		
		products.setNombreProducto(p.getNombreProducto());
		products.setDescripcion(p.getDescripcionProducto());
		products.setPrecio(p.getPrecioProducto());
		products.setStock(p.getStockProducto());
		products.setIdProducto(p.getIdRequest());
		repository.save(products);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarProducto(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		Products products = new Products();
		
		products.setNombreProducto(p.getNombreProducto());
		products.setDescripcion(p.getDescripcionProducto());
		products.setPrecio(p.getPrecioProducto());
		products.setStock(p.getStockProducto());
		products.setIdProducto(p.getIdRequest());
		repository.save(products);
	}	

	@Override
	public List<ProductResponseDTO> listarProductos() {
		// TODO Auto-generated method stub
		List<Products> products = repository.findAll();
		List<ProductResponseDTO> dto = new ArrayList<ProductResponseDTO>();
		ProductResponseDTO productDTO = null;
		
		for (Products product : products) {
			
				productDTO = new ProductResponseDTO();
				productDTO.setNombreProducto(product.getNombreProducto());
				productDTO.setDescripcionProducto(product.getDescripcion());
				productDTO.setPrecioProducto(product.getPrecio());
				productDTO.setStockProducto(product.getIdProducto());
				productDTO.setIdResponse(product.getIdProducto());	
				dto.add(productDTO);
		}
		return dto;
	}

	@Override
	public ProductResponseDTO productById(Integer id) {
		// TODO Auto-generated method stub
		
		Products product = repository.findById(id).orElse(null);		
		ProductResponseDTO productDTO = new ProductResponseDTO();
		
		
		productDTO = new ProductResponseDTO();		
		productDTO.setNombreProducto(product.getNombreProducto());
		productDTO.setDescripcionProducto(product.getDescripcion());
		productDTO.setPrecioProducto(product.getPrecio());
		productDTO.setStockProducto(product.getIdProducto());
		productDTO.setIdResponse(product.getIdProducto());			
	
		return productDTO;
	}

}
