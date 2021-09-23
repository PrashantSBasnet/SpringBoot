package com.example.postman.Exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    /**
     * Message Source Instance
     */
    @Autowired
    protected CustomMessageSource customMessageSource;
    @Autowired
    protected ObjectMapper objectMapper;

    protected String moduleName;
    protected String permissionName;
    protected String permissionName1;
    protected String permissionName2;
    protected String permissionName3;

    protected String messageCode;

    /**
     * Function that sends successful API Response
     *
     * @param message
     * @param data
     * @return
     */
    protected GlobalApiResponse successResponse(String message, Object data) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(true);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(data);
        return globalApiResponse;
    }

    /**
     * Function that sends error API Response
     *
     * @param message
     * @param errors
     * @return
     */
    protected GlobalApiResponse errorResponse(String message, Object errors) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(false);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(errors);
        return globalApiResponse;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public String getPermissionName1() {
        return permissionName1;
    }

    public String getPermissionName2() {
        return permissionName2;
    }

    public String getPermissionName3() {
        return permissionName3;
    }
}

