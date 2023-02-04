package com.idat.idatapirest.service;

import java.util.List;

import com.idat.idatapirest.dto.ItemRequestDTO;
import com.idat.idatapirest.dto.ItemResponseDTO;

public interface ItemService {

	
	public void guardarItem(ItemRequestDTO i);
	public void editarItem(ItemRequestDTO i);
	public void eliminarItem (Integer id);
	public List<ItemResponseDTO> listarItem();
	public ItemResponseDTO itemById(Integer id);
}
