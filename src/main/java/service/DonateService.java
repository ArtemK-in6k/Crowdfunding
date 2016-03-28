package service;

import crowdfunding.Donate;
import dao.DonateDAO;
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
