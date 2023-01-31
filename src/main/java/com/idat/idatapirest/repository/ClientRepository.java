package com.idat.idatapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.idatapirest.model.Clients;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Integer> {

}
