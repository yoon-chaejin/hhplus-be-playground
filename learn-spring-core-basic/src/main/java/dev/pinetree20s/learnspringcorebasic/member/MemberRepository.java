package dev.pinetree20s.learnspringcorebasic.member;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long id);
}
