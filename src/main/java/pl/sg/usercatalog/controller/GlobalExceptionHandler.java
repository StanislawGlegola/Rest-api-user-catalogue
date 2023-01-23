package pl.sg.usercatalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    private void handleServerError(Exception e, HttpServletRequest req) {
            LOGGER.info("Error message: " +
                    e.getMessage()
                    + ", in request: " +
                    req.getServletPath()
                    + "." , e);
        }
}