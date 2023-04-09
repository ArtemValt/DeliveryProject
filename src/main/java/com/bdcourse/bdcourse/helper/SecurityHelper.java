package com.bdcourse.bdcourse.helper;

import com.bdcourse.bdcourse.security.jwtToken.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityHelper {
    private static JwtService jwtService;

    @Autowired(required = true)
    public void setJwtService(JwtService jwtService){
        SecurityHelper.jwtService=jwtService;
    }

    public static String getUserIdFromToken(String token) {
        String id = jwtService.getClaimsFromToken(token).get("id").toString();
        return StringUtils.isNotBlank(id) ? id : StringUtils.EMPTY;
    }

}
