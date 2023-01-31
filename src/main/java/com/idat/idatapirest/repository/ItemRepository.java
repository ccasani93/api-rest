package com.idat.idatapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.idatapirest.model.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {

}
