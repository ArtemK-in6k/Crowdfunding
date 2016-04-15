package com.crowd.dao;


import com.crowd.entity.Donate;

import java.util.List;

public interface DonateDAO {

    void insert(Donate donate);

    void saveUpdate(Donate donate);

    List<Donate> selectAll();

    Donate findById(int id);

    void delete(Donate donate);

    void update(Donate donate);

    List<Donate> findAllForProject(int projectId);

    void deleteById(int id);

    Donate findByDonatorAndProject(int donatorId, int projectId);
}
