package codes.dirty.nego.negoweb.module.member.service;

import codes.dirty.nego.negoweb.module.member.model.Token;
import codes.dirty.nego.negoweb.module.member.repository.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository){
        this.tokenRepository = tokenRepository;
    }

    public String create(String memberId){
        return tokenRepository.save(memberId);
    }

    public Token findToken(String token){
        return tokenRepository.findTokenByToken(token);
    }

    public boolean checkToken(String token){

        if (findToken(token) != null){
            if (findToken(token).getExpirationTime() > System.currentTimeMillis()){
                return true;
            }
        }
        tokenRepository.delete(token);
        return false;
    }

}
