package codes.dirty.nego.negoweb.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

    @GetMapping(value = "/")
    public @ResponseBody
    String Home() {

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Home</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/members/new\" method=\"get\">\n" +
                "        <button type=\"submit\">회원가입</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/members/login\" method=\"get\">\n" +
                "        <button type=\"submit\">로그인</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/members/check\" method=\"get\">\n" +
                "        <button type=\"submit\">로그인체크</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/product/list\" method=\"get\">\n" +
                "        <button type=\"submit\">상품보기</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}

