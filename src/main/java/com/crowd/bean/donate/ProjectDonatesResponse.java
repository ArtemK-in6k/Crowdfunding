package com.crowd.bean.donate;

import com.crowd.entity.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProjectDonatesResponse {
    private int id;
    private String name;
    private List<DonateBean> donates;

    public ProjectDonatesResponse(){}

    public ProjectDonatesResponse(Project project) {
        setId(project.getId());
        setName(project.getName());
        if (!Objects.isNull(project.getDonateList())){
            this.donates = project.getDonateList().stream().map(DonateBean::new).collect(Collectors.toList());
        }else {
            this.donates = new ArrayList<>();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DonateBean> getDonates() {
        return donates;
    }

    public void setDonates(List<DonateBean> donates) {
        this.donates = donates;
    }
}
