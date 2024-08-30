package com.hamitmizrak.error;

import com.hamitmizrak.assist.FrontendUrl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LOMBOK
@Log4j2
@RequiredArgsConstructor

// ErrorController
// ErrorAttributes
// WebRequest

// Spring Boot defaulttan gelen error'ı kendimize göre customise yapıyoruz.
@RestController
@CrossOrigin(origins = FrontendUrl.REACT_URL) //localhost:3000 portunu backentte kullanabiliriz.
public class CustomErrorHandleWebRequest implements ErrorController {

    // 1.YOL (Field Injection)
    // @Autowired
    // private ErrorAttributes errorAttributes;

    // 2.YOL (Constructor Injecftion)
    /*private ErrorAttributes errorAttributes;
    @Autowired
    public CustomErrorHandleWebRequest(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }*/

    // 3.YOL (Lombok Injection)
    private final ErrorAttributes errorAttributes;

    // Pırasa Vali MESC
    private ApiResult apiResult;
    private String path;
    private String message;
    private int status;
    private Map<String,String> validationErrors;

    // http://localhost:4444/error
    @RequestMapping("/error")
    public ApiResult handleErrorMethod(WebRequest webRequest){

        // Spring >=2.3
        Map<String,Object> attributes=errorAttributes.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions
                        .of(ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.BINDING_ERRORS)
        ); //end attributes

        // Spring'ten verileri almak
        status= (int) attributes.get("status");
        message= (String) attributes.get("message");
        path= (String) attributes.get("path");
        apiResult= new ApiResult(path,message,status);

        // attributes error varsa
        if(attributes.containsKey("errors")){
            List<FieldError> fieldErrorList= (List<FieldError>) attributes.get("errors");
            validationErrors=new HashMap<>();
            // for each dongu
            for(FieldError fieldError : fieldErrorList){
                validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            apiResult.setValidationErrors(validationErrors);
        }
        return apiResult;
    } //end handleErrorMethod
} // end CustomErrorHandleWebRequest
