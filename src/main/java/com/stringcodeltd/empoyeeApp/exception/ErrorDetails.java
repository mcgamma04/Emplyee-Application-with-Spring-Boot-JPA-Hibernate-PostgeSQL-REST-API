package com.stringcodeltd.empoyeeApp.exception;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private String detail;
    private Date timed;

    public ErrorDetails(String message, String detail, Date timed) {
        this.message = message;
        this.detail = detail;
        this.timed = timed;
    }
    public ErrorDetails(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getTimed() {
        return timed;
    }

    public void setTimed(Date timed) {
        this.timed = timed;
    }
}
