package dev.pinetree20s.learnspringcorebasic.member;

public interface MemberService {
    Member findMemberById(Long id);
    Member signUp(Member member);
}
