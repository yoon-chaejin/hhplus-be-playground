package dev.pinetree20s.learnspringcorebasic;

import dev.pinetree20s.learnspringcorebasic.discount.DiscountPolicy;
import dev.pinetree20s.learnspringcorebasic.discount.FixDiscountPolicy;
import dev.pinetree20s.learnspringcorebasic.discount.RateDiscountPolicy;
import dev.pinetree20s.learnspringcorebasic.member.MemberRepository;
import dev.pinetree20s.learnspringcorebasic.member.MemberService;
import dev.pinetree20s.learnspringcorebasic.member.MemberServiceImpl;
import dev.pinetree20s.learnspringcorebasic.member.MemoryMemberRepository;
import dev.pinetree20s.learnspringcorebasic.order.OrderService;
import dev.pinetree20s.learnspringcorebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
