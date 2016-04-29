package com.crowd.entity;

public enum Status {
        NOT_STARTED("Not started"),
        IN_PROGRESS("In progress"),
        FUNDED("Funded"),
        COMPLETED("Completed");

        private String status;

        Status(String status){
                this.status = status;
        }

        public String getStatus() {
                return this.status;
        }

}
