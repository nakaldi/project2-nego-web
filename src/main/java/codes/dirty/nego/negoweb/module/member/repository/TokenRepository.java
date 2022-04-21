package codes.dirty.nego.negoweb.module.member.repository;


import codes.dirty.nego.negoweb.module.member.model.Token;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TokenRepository {
    private HashMap<String, Token> tokens = new HashMap<>();
    private static long sequence = 0L;

    public String save(String memberId) {
        String tokenId = "token" + sequence + "-" + memberId;
        sequence++;
        tokens.put(memberId, new Token(tokenId, System.currentTimeMillis()+1800000, memberId));
        System.out.println(tokens);
        return tokenId;
    }

    public Token findToken(String memberId) {
        return tokens.get(memberId);
    }

    public void deleteToken(String memberId){
        tokens.remove(memberId);
    }
}
