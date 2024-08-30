package com.hamitmizrak.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Date;
import java.util.Map;

// LOMBOK
@Data
// spring Frameworkta gelen Error'ları kendimize göre yakalamak
// (Jackson: objeyi json'a çevirir)
// Eğer sistemde null değer varsa backentte gönderme
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    // Pırasa Vali MESC
    private String path;
    private String message;
    private String error;
    private int status;
    private Date createdDate=new Date(System.currentTimeMillis());
    private Map<String,String> validationErrors;

    // parametresiz constructor
    public ApiResult() {
    }

    // parametreli constructor
    public ApiResult(String path, String message,  int status) {
        this.path = path;
        this.message = message;
        this.status = status;
    }

    // parametreli constructor
    public ApiResult(String path, String message, String error, int status) {
        this.path = path;
        this.message = message;
        this.error = error;
        this.status = status;
    }
}
