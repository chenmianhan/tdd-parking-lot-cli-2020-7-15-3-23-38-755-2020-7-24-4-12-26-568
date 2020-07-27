package com.oocl.cultivation;

public enum ErrorMessage {
    WRONGTICKET("Unrecognized parking ticket."),
    NOTTICKET("Please provide your parking ticket."),
    NOTSPACE("Not enough position.");
    private String error;
    ErrorMessage(String error){
        this.error=error;
    }
    public String getError(){
        return error;
    }

}
