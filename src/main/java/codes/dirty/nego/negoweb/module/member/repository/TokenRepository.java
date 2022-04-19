package codes.dirty.nego.negoweb.module.member.repository;


import codes.dirty.nego.negoweb.module.member.model.Token;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TokenRepository {
    private HashMap<String, Token> tokens = new HashMap<>();
    private static long sequence = 0L;

    public String save(String memberId) {
        String token = "token" + sequence;
        sequence++;
        tokens.put(token, new Token(token, System.currentTimeMillis()+10000, memberId));
        System.out.println(tokens);
        return token;
    }

    public Token findTokenByToken(String token) {
        return tokens.get(token);
    }

    public String delete(String token){
        tokens.remove(token);
        return token;
    }
}
