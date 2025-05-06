package com.icinbank.service;

import java.util.List;

import com.icinbank.domain.Request;

public interface RequestService {
	Request createRequest(Request request);

    List<Request> findAll();

    Request findRequest(Long id);

    void confirmRequest(Long id);
}
