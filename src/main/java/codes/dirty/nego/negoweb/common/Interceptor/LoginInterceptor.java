package codes.dirty.nego.negoweb.common.Interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.dirty.nego.negoweb.module.member.service.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final TokenService tokenService;

    public LoginInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login-token")){
                if (tokenService.checkToken(cookie.getValue())){
                    return true;
                }
            }
        }
        response.sendRedirect("/members/login");
        return true;
    }






}
