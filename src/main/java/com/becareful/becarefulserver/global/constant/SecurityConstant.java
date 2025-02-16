package com.becareful.becarefulserver.global.constant;

import java.util.List;

public class SecurityConstant {

    public static List<String> passFilterStaticUrl = List.of(
            "/caregiver/signup", "/caregiver/upload-profile-img"
    );

    public static List<String> passFilterDynamicUrl = List.of(
            "/sms",
            "/auth",
            "/swagger-ui",
            "/v3/api-docs"
    );
}
