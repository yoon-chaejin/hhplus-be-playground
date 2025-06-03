package dev.pinetree20s.learnspringcorebasic.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member signUp(Member member) {
        return memberRepository.save(member);
    }
}
