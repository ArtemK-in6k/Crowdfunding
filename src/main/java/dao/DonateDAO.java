package dao;

import crowdfunding.Donate;

import java.util.List;

public interface DonateDAO {

    void insert(Donate donate);

    List<Donate> selectAll();

    Donate findById(int id);

    void delete(Donate donate);

    void update(Donate donate);
}
