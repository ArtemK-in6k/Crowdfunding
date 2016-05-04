package com.crowd.bean.donate;

public class DonationContributionBean {
    private int id;
    private double donate;

    public DonationContributionBean() {
    }

    public DonationContributionBean(int id, double donate) {
        this.id = id;
        this.donate = donate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDonate() {
        return donate;
    }

    public void setDonate(double donate) {
        this.donate = donate;
    }
}
