package com.restaurant.faculty_modify.Helper;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTAuthValidate {
    private final JWTHelper jwtHelper;

    public  String extractAndCheckToken(String header) {
        if (header != null && !header.isEmpty() && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                if (jwtHelper.validateToken(token)) {
                    return jwtHelper.extractUsername(token); // Return the email if valid
                }
            }catch(ExpiredJwtException e){
                System.out.println("Token has expired: " + e.getMessage());
            }
            catch(SignatureException e){
                System.out.println("Invalid token signature:  " + e.getMessage());
            }
            catch(Exception e){
                System.out.println("Token validation error:" + e.getMessage());
            }

        }
        return null;
    }
}
