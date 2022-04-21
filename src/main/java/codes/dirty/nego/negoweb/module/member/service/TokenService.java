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

    public Token findTokenByTokenId(String tokenId){
        String[] splitToken = tokenId.split("-");
        return tokenRepository.findToken(splitToken[1]);
    }
    public void deleteTokenByTokenId(String tokenId){
        String[] splitToken = tokenId.split("-");
        tokenRepository.deleteToken(splitToken[1]);
    }
    public void deleteTokenByMemberId(String memberId) {
        tokenRepository.deleteToken(memberId);
    }

    public boolean checkToken(String tokenId){

        if (findTokenByTokenId(tokenId) != null){
            if (findTokenByTokenId(tokenId).getTokenId().equals(tokenId) &&
                    findTokenByTokenId(tokenId).getExpirationTime() > System.currentTimeMillis()){
                return true;
            }
        }
        deleteTokenByTokenId(tokenId);
        return false;
    }

}
