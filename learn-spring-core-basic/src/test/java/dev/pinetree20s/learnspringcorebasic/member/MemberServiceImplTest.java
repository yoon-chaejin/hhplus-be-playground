package dev.pinetree20s.learnspringcorebasic.member;

import dev.pinetree20s.learnspringcorebasic.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {
    MemberService memberService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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