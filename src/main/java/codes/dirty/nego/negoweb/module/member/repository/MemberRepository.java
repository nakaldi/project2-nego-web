package codes.dirty.nego.negoweb.module.member.repository;

import codes.dirty.nego.negoweb.module.member.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByMemberId(String memberId);
    List<Member> findAll();
}
