package codes.dirty.nego.negoweb.module.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Token {
    private String loginToken;

    private Long expirationTime;
    private String loginId;

    public Token(){
    }

    public Token(String loginToken) {
        this.loginToken = loginToken;
    }

    public Token(String loginToken, Long expirationTime, String loginId) {
        this.loginToken = loginToken;
        this.expirationTime = expirationTime;
        this.loginId = loginId;
    }
}
