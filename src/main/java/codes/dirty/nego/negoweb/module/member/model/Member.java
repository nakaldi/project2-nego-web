package codes.dirty.nego.negoweb.module.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class Member {
    private Long id;
    private String memberId;
    private String password;

    public Member(){

    }

    public Member(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    public Member(Long id, String memberId, String password){
        this.id = id;
        this.memberId = memberId;
        this.password = password;
    }
}
