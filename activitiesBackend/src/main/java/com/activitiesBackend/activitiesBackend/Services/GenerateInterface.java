package com.activitiesBackend.activitiesBackend.Services;

import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;

/**
 *  this should be implemented by both pdf and email
 * @author sumedh ahire
 *
 */
public interface GenerateInterface {
    /**
     * hash map coz how much varibles needed are not defined
     * @param hashMap
     * @return String
     */
    public String generate(HashMap<String,Object> hashMap);

    /**
     * hash map coz how much varibles needed are not defined
     * @param response
     * @param hashMap
     * @return Boolean
     */
    public Boolean sendEmail(HttpServletResponse response,HashMap<String,Object> hashMap);

}