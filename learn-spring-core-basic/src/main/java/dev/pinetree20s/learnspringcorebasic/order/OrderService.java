package dev.pinetree20s.learnspringcorebasic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
