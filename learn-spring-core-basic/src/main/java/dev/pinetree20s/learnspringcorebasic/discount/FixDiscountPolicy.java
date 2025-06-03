package dev.pinetree20s.learnspringcorebasic.discount;

import dev.pinetree20s.learnspringcorebasic.member.Member;
import dev.pinetree20s.learnspringcorebasic.member.MemberGrade;

public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == MemberGrade.VIP)
            return 1000;
        else
            return 0;
    }
}
