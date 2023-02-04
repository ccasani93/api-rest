package com.idat.idatapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.ItemRequestDTO;
import com.idat.idatapirest.dto.ItemResponseDTO;
import com.idat.idatapirest.model.Items;
import com.idat.idatapirest.repository.ItemRepository;

@Service

public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;
	
	@Override
	public void guardarItem(ItemRequestDTO i) {
		// TODO Auto-generated method stub
		
		Items items = new Items();
		
		items.setIdItem(i.getIditem());
		items.setItem(i.getNombreitem());
		items.setCantidad(i.getCantidaditem());
		items.setTotal(i.getTotalitem());
		repository.save(items);
		
	}

	@Override
	public void editarItem(ItemRequestDTO i) {
		// TODO Auto-generated method stub
		
		Items items = new Items();
		
		items.setIdItem(i.getIditem());
		items.setItem(i.getNombreitem());
		items.setCantidad(i.getCantidaditem());
		items.setTotal(i.getTotalitem());
		repository.saveAndFlush(items);
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ItemResponseDTO> listarItem() {
		// TODO Auto-generated method stub
		
		List<Items> items = repository.findAll();
		List<ItemResponseDTO> dto = new ArrayList<ItemResponseDTO>();
		ItemResponseDTO itemDTO = null;
		
		for(Items item: items) {
			itemDTO = new ItemResponseDTO();
			itemDTO.setIditem(item.getIdItem());
			itemDTO.setNombreitem(item.getItem());
			itemDTO.setCantidaditem(item.getCantidad());
			itemDTO.setTotalitem(item.getTotal());
			dto.add(itemDTO);
		}
		
		return dto;
	}

	@Override
	public ItemResponseDTO itemById(Integer id) {
		// TODO Auto-generated method stub
		
		Items items = repository.findById(id).orElse(null);
		ItemResponseDTO itemDTO = null;
		
		itemDTO = new ItemResponseDTO();
		
		itemDTO = new ItemResponseDTO();
		itemDTO.setIditem(items.getIdItem());
		itemDTO.setNombreitem(items.getItem());
		itemDTO.setCantidaditem(items.getCantidad());
		itemDTO.setTotalitem(items.getTotal());
		return itemDTO;
	}

}
