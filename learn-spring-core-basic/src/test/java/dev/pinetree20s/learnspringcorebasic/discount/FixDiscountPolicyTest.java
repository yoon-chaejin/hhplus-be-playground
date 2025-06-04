package dev.pinetree20s.learnspringcorebasic.discount;

import dev.pinetree20s.learnspringcorebasic.member.Member;
import dev.pinetree20s.learnspringcorebasic.member.MemberGrade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixDiscountPolicyTest {

    FixDiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("BASIC 회원은 0원 할인")
    void basicDiscountPolicy() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "홍길동", MemberGrade.BASIC);

        //when
        int result = discountPolicy.discount(member, 20_000);

        //then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("VIP 회원은 1000원 할인")
    void vipDiscountPolicy() {
        //given
        Long memberId = 2L;
        Member member = new Member(memberId, "홍길동", MemberGrade.VIP);

        //when
        int result = discountPolicy.discount(member, 20_000);

        //then
        Assertions.assertThat(result).isEqualTo(1_000);
    }

}