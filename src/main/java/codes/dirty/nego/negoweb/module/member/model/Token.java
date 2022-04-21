package codes.dirty.nego.negoweb.module.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Token {
    private String tokenId;

    private Long expirationTime;
    private String loginId;

    public Token(){
    }

    public Token(String tokenId) {
        this.tokenId = tokenId;
    }

    public Token(String tokenId, Long expirationTime, String loginId) {
        this.tokenId = tokenId;
        this.expirationTime = expirationTime;
        this.loginId = loginId;
    }
}
