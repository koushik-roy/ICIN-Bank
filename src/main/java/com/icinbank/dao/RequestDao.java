package com.icinbank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.icinbank.domain.Request;

public interface RequestDao extends CrudRepository<Request, Long> {

    List<Request> findAll();

	Request findAllById(Long id);
}
