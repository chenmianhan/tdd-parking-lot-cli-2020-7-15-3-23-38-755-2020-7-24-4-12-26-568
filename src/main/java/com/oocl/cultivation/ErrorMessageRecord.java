package com.oocl.cultivation;

public class ErrorMessageRecord implements MessageRecord {
    String errorMessageRecord;
    @Override
    public String getMessage() {
        return errorMessageRecord;
    }

    @Override
    public void setMessage(String message) {
        errorMessageRecord=message;
    }


}
