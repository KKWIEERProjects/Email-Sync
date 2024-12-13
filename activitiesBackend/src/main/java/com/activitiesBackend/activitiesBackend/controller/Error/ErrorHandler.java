package com.activitiesBackend.activitiesBackend.controller.Error;

import com.activitiesBackend.activitiesBackend.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * once we switch to react we will not use this
 * but until then... :)
 * with some changes we will use this
 */
@ControllerAdvice
public class ErrorHandler{

    Logger logger= LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalExce(HttpServletRequest request,Exception ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());

        String referer = request.getHeader("Referer");

        // Create ModelAndView with referer as the view name if available
        ModelAndView modelAndView;
        if (referer != null) {
            modelAndView = new ModelAndView("redirect:" + referer);
        } else {

            modelAndView = new ModelAndView("error");
        }
        return modelAndView
                .addObject("msg", "AN UNEXPECTED ERROR OCCURRED")
                .addObject("errorMessage","Error");

    }

    @ExceptionHandler(PostNotFoundById.class)
    public ModelAndView handlePostNotThere(HttpServletRequest request,PostNotFoundById ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());
        ModelAndView modelAndView;

        String referer = request.getHeader("Referer");
        if (referer != null) {
            modelAndView = new ModelAndView("redirect:" + referer);
        } else {

            modelAndView = new ModelAndView("error");
        }
        return modelAndView
                .addObject("msg", "AN UNEXPECTED ERROR OCCURRED")
                .addObject("errorMessage",ex.getMessage());

    }

    @ExceptionHandler(UserAlreadyThereException.class)
    public ModelAndView handleUserThere(HttpServletRequest request,UserAlreadyThereException ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());

        ModelAndView modelAndView;
        String referer = request.getHeader("Referer");
        if (referer != null) {
            modelAndView = new ModelAndView("redirect:" + referer);
        } else {

            modelAndView = new ModelAndView("error");
        }
        return modelAndView
                .addObject("msg", "AN UNEXPECTED ERROR OCCURRED")
                .addObject("errorMessage",ex.getMessage());

    }

    @ExceptionHandler(StatusPostNotFound.class)
    public ModelAndView handleStatusNOT_FOUND(HttpServletRequest request, StatusPostNotFound ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());

        ModelAndView modelAndView;
        String referer = request.getHeader("Referer");
        if (referer != null) {
            modelAndView = new ModelAndView("redirect:" + referer);
        } else {

            modelAndView = new ModelAndView("error");
        }
        return modelAndView
                .addObject("msg", "AN UNEXPECTED ERROR OCCURRED")
                .addObject("errorMessage",ex.getMessage());


    }

    @ExceptionHandler(StructureRecordNotFound.class)
    public ModelAndView handleStructureNOT_FOUND(HttpServletRequest request, StructureRecordNotFound ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());

        ModelAndView modelAndView;
        String referer = request.getHeader("Referer");
        if (referer != null) {
            modelAndView = new ModelAndView("redirect:" + referer);
        } else {

            modelAndView = new ModelAndView("error");
        }
        return modelAndView
                .addObject("msg", "AN UNEXPECTED ERROR OCCURRED")
                .addObject("errorMessage",ex.getMessage());

    }

    @ExceptionHandler(EmailAddressException.class)
    public ModelAndView handleStructureNOT_FOUND(HttpServletRequest request, EmailAlreadyExists ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());

        ModelAndView modelAndView;
        String referer = request.getHeader("Referer");
        if (referer != null) {
            modelAndView = new ModelAndView("redirect:" + referer);
        } else {

            modelAndView = new ModelAndView("error");
        }
        return modelAndView
                .addObject("msg", "AN UNEXPECTED ERROR OCCURRED")
                .addObject("errorMessage",ex.getMessage());


    }

    @ExceptionHandler(BlankSpaceException.class)
    public ModelAndView blank(HttpServletRequest request,BlankSpaceException ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());

        ModelAndView modelAndView;
        String referer = request.getHeader("Referer");
        if (referer != null) {
            modelAndView = new ModelAndView("redirect:" + referer);
        } else {

            modelAndView = new ModelAndView("error");
        }
        return modelAndView
                .addObject("msg", "AN UNEXPECTED ERROR OCCURRED")
                .addObject("errorMessage",ex.getMessage());


    }


}
