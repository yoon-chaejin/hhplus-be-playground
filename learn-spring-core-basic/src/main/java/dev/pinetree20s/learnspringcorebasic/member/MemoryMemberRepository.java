package dev.pinetree20s.learnspringcorebasic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private final Map<Long, Member> members = new HashMap<>();

    @Override
    public Member save(Member member) {
        members.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return members.get(id);
    }
}
