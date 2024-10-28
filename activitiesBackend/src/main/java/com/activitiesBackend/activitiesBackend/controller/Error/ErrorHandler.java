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
 */
@ControllerAdvice
public class ErrorHandler{

    Logger logger= LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalExce(HttpServletRequest request,Exception ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());
        return new ModelAndView("error").
                    addObject("msg", "AN UNEXPECTED ERROR OCCURRED");


    }

    @ExceptionHandler(PostNotFoundById.class)
    public ModelAndView handlePostNotThere(HttpServletRequest request,PostNotFoundById ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());
        return new ModelAndView("error").
                addObject("msg", ex.getMessage());


    }

    @ExceptionHandler(UserAlreadyThereException.class)
    public ModelAndView handleUserThere(HttpServletRequest request,UserAlreadyThereException ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());
        return new ModelAndView("error").
                addObject("msg", ex.getMessage());


    }

    @ExceptionHandler(StatusPostNotFound.class)
    public ModelAndView handleStatusNOT_FOUND(HttpServletRequest request, StatusPostNotFound ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());
        return new ModelAndView("error").
                addObject("msg", ex.getMessage());


    }

    @ExceptionHandler(StructureRecordNotFound.class)
    public ModelAndView handleStructureNOT_FOUND(HttpServletRequest request, StructureRecordNotFound ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());
        return new ModelAndView("error").
                addObject("msg", ex.getMessage());


    }

    @ExceptionHandler(EmailAddressException.class)
    public ModelAndView handleStructureNOT_FOUND(HttpServletRequest request, EmailAlreadyExists ex){
        System.err.println("Request:"+request.getRequestURL() + "raised" + ex);
        logger.error(ex.toString());
        return new ModelAndView("error").
                addObject("msg", ex.getMessage());


    }

//    @GetMapping("/error")
//    public ModelAndView getMethodName(HttpServletRequest request) {
//
//        Integer status=Integer.valueOf(
//                request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
//                        .toString()
//        );
//
//        if(status== HttpStatus.NOT_FOUND.value()){
//            return new
//                    ModelAndView("error").
//                    addObject("msg", "RESOURCE NOT FOUND");
//        }else if (status == HttpStatus.FORBIDDEN.value()) {
//            return new
//                    ModelAndView("error").
//                    addObject("msg", "FORBIDDEN ACCESS");
//        }else if(status == HttpStatus.INTERNAL_SERVER_ERROR.value()){
//            return new
//                    ModelAndView("error").
//                    addObject("msg", "SERVER ERROR");
//        }else{
//            return new
//                    ModelAndView("error").
//                    addObject("msg", "AN ERROR OCCURRED");
//        }
//    }

}
