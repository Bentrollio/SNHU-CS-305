
/**
 * MyErrorController.class
 * 
 * Adapted from:
 * https://www.baeldung.com/spring-boot-custom-error-page
 *
 */

package com.snhu.sslserver;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController{
    
    @RequestMapping(value = "/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        String errorMessage = "<p>UNEXPECTED ERROR</p>";

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorMessage += "<p>Error code: " + statusCode + "</p>" + 
                "<p>Error message: Page Not Found.</p>";
                
            }
            else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorMessage += "<p>Error code: " + statusCode + "</p>" + 
                "<p>Error message: Internal Server Error</p>";
            }
        }
        return errorMessage;
    }
}
