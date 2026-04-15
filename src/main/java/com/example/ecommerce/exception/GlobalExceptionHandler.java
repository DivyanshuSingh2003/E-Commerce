package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model model) {
        model.addAttribute("error", "404 - Page Not Found");
        return "404";  // return the 404.html template
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handle500(Exception ex, Model model) {
        model.addAttribute("error", "500 - Internal Server Error");
        return "500";  // return the 500.html template
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
//    @ExceptionHandler({org.springframework.security.access.AccessDeniedException.class})
    public String handleAccessDeniedException(Model model) {
        model.addAttribute("error", "You do not have permission to access this page.");
        return "error/403";
    }
}