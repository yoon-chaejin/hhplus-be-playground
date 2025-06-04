package dev.pinetree20s.learnspringcorebasic.order;

import dev.pinetree20s.learnspringcorebasic.AppConfig;
import dev.pinetree20s.learnspringcorebasic.member.Member;
import dev.pinetree20s.learnspringcorebasic.member.MemberGrade;
import dev.pinetree20s.learnspringcorebasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("주문 생성 - BASIC 회원은 0원 할인")
    void createOrderForMemberWithBasicGrade() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "홍길동", MemberGrade.BASIC);
        memberService.signUp(member);

        //when
        Order result = orderService.createOrder(memberId, "상품", 20_000);

        //then
        Assertions.assertThat(result.calculatePrice()).isEqualTo(20_000);
    }

    @Test
    @DisplayName("주문 생성 - VIP 회원은 1000원 할인")
    void createOrderForMemberWithVipGrade() {
        //given
        Long memberId = 2L;
        Member member = new Member(memberId, "홍길동", MemberGrade.VIP);
        memberService.signUp(member);

        //when
        Order result = orderService.createOrder(memberId, "상품", 20_000);

        //then
        Assertions.assertThat(result.calculatePrice()).isEqualTo(19_000);
    }

}