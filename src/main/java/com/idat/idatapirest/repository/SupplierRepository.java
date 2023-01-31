package com.idat.idatapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.idatapirest.model.Suppliers;

public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {

}
