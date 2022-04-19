package codes.dirty.nego.negoweb.module.member.controller;

import codes.dirty.nego.negoweb.module.member.MemberForm;
import codes.dirty.nego.negoweb.module.member.model.Member;
import codes.dirty.nego.negoweb.module.member.service.MemberService;
import codes.dirty.nego.negoweb.module.member.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final TokenService tokenService;

    @Autowired
    public MemberController(MemberService memberService, TokenService tokenService) {
        this.tokenService = tokenService;
        this.memberService = memberService;
    }


    @GetMapping(value = "/members/new")
    public @ResponseBody
    String createForm() {


        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Sign Up</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/members/new\" method=\"post\">\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"memberId\">아이디</label>\n" +
                "            <input type=\"text\" id=\"memberId\" name=\"memberId\" placeholder=\"아이디을 입력하세요\">\n" +
                "            <label for=\"password\">비밀번호</label>\n" +
                "            <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"비밀번호를 입력하세요\">\n" +
                "        </div>\n" +
                "        <button type=\"submit\">등록</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    @PostMapping(value = "/members/new")
    public ResponseEntity create(MemberForm form) {
        if (!form.getMemberId().equals("") && !form.getPassword().equals("")){
            Member member = new Member(form.getMemberId(), form.getPassword());
            memberService.join(member);
            return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, "/").build();
        }
        return ResponseEntity.badRequest().build();



    }

    @GetMapping(value = "/members/list")
    public ResponseEntity<List> list() {
        List<Member> members = memberService.findMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping(value = "/members/login")
    public @ResponseBody
    String createFormLogin() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Sign Up</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/members/login\" method=\"post\">\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"memberId\">아이디</label>\n" +
                "            <input type=\"text\" id=\"memberId\" name=\"memberId\" placeholder=\"아이디을 입력하세요\">\n" +
                "            <label for=\"password\">비밀번호</label>\n" +
                "            <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"비밀번호를 입력하세요\">\n" +
                "        </div>\n" +
                "        <button type=\"submit\">로그인</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    @PostMapping(value = "/members/login")
    public ResponseEntity createLogin(MemberForm form) {
        if (memberService.findMemberId(form.getMemberId()).isPresent() != true){
            return ResponseEntity.badRequest().build();
        }
        Member member = memberService.findMemberId(form.getMemberId()).get();

        if (member.getPassword().equals(form.getPassword())) {
            return ResponseEntity.status(HttpStatus.FOUND)
                                 .header(HttpHeaders.SET_COOKIE,
                                         "login-token=" + tokenService.create(form.getMemberId()) + ";Path=/")
                                 .header(HttpHeaders.LOCATION, "/")
                                 .build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/members/check")
    public ResponseEntity checkLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login-token")){
                if (tokenService.checkToken(cookie.getValue())){
                    return ResponseEntity.ok(tokenService.findToken(cookie.getValue()).getLoginId() + "님 반갑습니다");
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }


}
