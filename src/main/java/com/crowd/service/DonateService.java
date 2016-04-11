package com.crowd.service;

import com.crowd.dao.DonateDAO;
import com.crowd.entity.Donate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonateService {

    @Autowired
    private DonateDAO donateDAO;

    public List<Donate> selectAll() {
        return donateDAO.selectAll();
    }

    public void insert(Donate donate){
        donateDAO.insert(donate);
    }

}
