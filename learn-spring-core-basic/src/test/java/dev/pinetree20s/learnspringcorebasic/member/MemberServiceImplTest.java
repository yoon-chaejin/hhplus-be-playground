package dev.pinetree20s.learnspringcorebasic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {
    private MemberServiceImpl memberService = new MemberServiceImpl();

    @Test
    @DisplayName("회원가입 테스트")
    void signUp() {
        //given
        Member member = new Member(1L, "홍길동", MemberGrade.BASIC);

        //when
        memberService.signUp(member);

        //then
        Member result = memberService.findMemberById(member.getId());
        Assertions.assertThat(result).isEqualTo(member);
    }
}