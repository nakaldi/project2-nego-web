package codes.dirty.nego.negoweb.module.member.service;

import codes.dirty.nego.negoweb.module.member.model.Member;
import codes.dirty.nego.negoweb.module.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        memberRepository.save(member);
        return member.getId();
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById((id));
    }

    public Optional<Member> findMemberId(String memberId){
        return memberRepository.findByMemberId(memberId);
    }
}
