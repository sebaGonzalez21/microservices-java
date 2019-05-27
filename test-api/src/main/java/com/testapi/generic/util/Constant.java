package com.testapi.generic.util;

/**
 * Sebastian Gonzalez
 */

public class Constant {

    private Constant(){
    //not called
    }

    /**
     *
     * Call Rest Url
     *
     */

    public static  final String URLTESTDAL = "/user/login";

    public static final String ASTERISK = "*";
    public static final boolean STATE_TRUE = true;
    public static final boolean STATE_FALSE= false;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int PROFILE_ADMIN = 1;
    public static final int PROFILE_VISUALIZER = 2;
    public static final int SEVEN = 7;
    public static final int ACTIVE = 1;
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";
    public static final String URL = "URL :";

    public static final String ERROR_GET_USER = "ERROR IN THE SYSTEM WHEN GET THE USER";
    public static final String ERROR_CLIENT_USER = "ERROR VALIDATE USER EXCEPTION";
    public static final String ERROR_TRANSFORM_MODEL_USER = "ERROR TRANSFORM FROM MODEL TO DTO";
}
