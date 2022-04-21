package codes.dirty.nego.negoweb.module.member.repository;

import codes.dirty.nego.negoweb.module.member.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class MemoryMemberRepository implements MemberRepository {

    private HashMap<String, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getMemberId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        return Optional.ofNullable(store.get(memberId));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }



    public void clearStore() {
        store.clear();
    }




}
