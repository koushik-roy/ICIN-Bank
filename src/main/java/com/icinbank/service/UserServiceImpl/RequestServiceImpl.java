package com.icinbank.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.dao.RequestDao;
import com.icinbank.domain.Request;
import com.icinbank.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao requestDao;

    public Request createRequest(Request request) {
       return requestDao.save(request);
    }

    public List<Request> findAll() {
        return requestDao.findAll();
    }

    public Request findRequest(Long id) {
        return requestDao.findAllById(id);
    }

    public void confirmRequest(Long id) {
        Request request = findRequest(id);
        request.setConfirmed(true);
        requestDao.save(request);
    }
}
