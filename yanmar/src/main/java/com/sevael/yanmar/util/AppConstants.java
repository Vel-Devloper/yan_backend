package com.sevael.yanmar.util;

public class AppConstants {
    // Roles
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_SECURITY = "SECURITY";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    // Status values
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_INACTIVE = 0;

    // Visitor types
    public static final int VISITOR_TYPE_VISITOR = 1;
    public static final int VISITOR_TYPE_CONSULTANT = 2;
    public static final int VISITOR_TYPE_INTERVIEW = 3;
    public static final int VISITOR_TYPE_TRAINEE = 4;
    public static final int VISITOR_TYPE_VENDOR = 5;
    public static final int VISITOR_TYPE_VIP = 6;
    

    // Visitor type names
    public static final String VISITOR_TYPE_MANUAL = "manual";
    public static final String VISITOR_TYPE_AUTOMATIC = "automatic";

    // Misc
    public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";
    public static final String SYSTEM_USER = "system";

    private AppConstants() {
        // Private constructor to prevent instantiation
    	throw new UnsupportedOperationException("Utility class");
    }
}
