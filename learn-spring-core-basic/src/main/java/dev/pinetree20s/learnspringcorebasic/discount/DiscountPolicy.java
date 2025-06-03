package dev.pinetree20s.learnspringcorebasic.discount;

import dev.pinetree20s.learnspringcorebasic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
