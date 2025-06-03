package dev.pinetree20s.learnspringcorebasic.order;

import dev.pinetree20s.learnspringcorebasic.discount.DiscountPolicy;
import dev.pinetree20s.learnspringcorebasic.discount.FixDiscountPolicy;
import dev.pinetree20s.learnspringcorebasic.member.Member;
import dev.pinetree20s.learnspringcorebasic.member.MemberRepository;
import dev.pinetree20s.learnspringcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
