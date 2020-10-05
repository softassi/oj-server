package com.softassi.oj.server.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.util.JWTUtils;
import com.softassi.oj.server.util.JsonUtils;
import com.softassi.oj.server.util.NeedLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    // 还没注册
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String token = httpServletRequest.getHeader("token");
        ResultBody resultBody = null;
        try {
            JWTUtils.verify(token);
            return true;
        }
        catch (SignatureVerificationException e) {
            e.printStackTrace();
            resultBody = ResultBody.error("签名错误");
        }
        catch (TokenExpiredException e) {
            e.printStackTrace();
            resultBody = ResultBody.error("token过期");
        }
        catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            resultBody = ResultBody.error("算法错误");

        }
        catch (Exception e) {
            e.printStackTrace();
            resultBody = ResultBody.error("错误");
        }
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JsonUtils.obj2JsonStr(resultBody));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}