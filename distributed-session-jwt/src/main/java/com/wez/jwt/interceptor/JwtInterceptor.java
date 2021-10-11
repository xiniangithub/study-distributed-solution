package com.wez.jwt.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author wez
 * @Date 2021/10/11
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Algorithm algorithm = Algorithm.HMAC256("wez"); // 加密密钥
        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        // 通过捕获过期异常来处理token过期的问题
        String result = null;
        try {
            DecodedJWT jwt = verifier.verify(token);
            request.setAttribute("username", jwt.getClaim("login_name").asString());
            return true;
        } catch (TokenExpiredException tokenExpiredException) {
            throw new RuntimeException("token已过期");
        } catch (JWTDecodeException jwtDecodeException) {
            throw new RuntimeException("token解码失败");
        }
    }

}
