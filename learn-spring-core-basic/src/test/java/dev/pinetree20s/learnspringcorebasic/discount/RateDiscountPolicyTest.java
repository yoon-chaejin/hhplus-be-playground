package dev.pinetree20s.learnspringcorebasic.discount;

import dev.pinetree20s.learnspringcorebasic.member.Member;
import dev.pinetree20s.learnspringcorebasic.member.MemberGrade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 회원은 10% 할인")
    void vipDiscountPolicy() {
        //given
        Member member = new Member(1L, "홍길동", MemberGrade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10_000);

        //then
        Assertions.assertThat(discount).isEqualTo(1_000);
    }

    @Test
    @DisplayName("BASIC 회원은 할인 없음")
    void basicDiscountPolicy() {
        //given
        Member member = new Member(2L, "홍길동", MemberGrade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10_000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}