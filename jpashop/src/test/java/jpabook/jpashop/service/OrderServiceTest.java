package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import jpabook.jpashop.exception.NotEnoughStockException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class OrderServiceTest {
    @Autowired private OrderService sut;
    @Autowired private EntityManager em;

    @Test
    @DisplayName("상품 주문이 성공해야 한다")
    void testOrder() {
        //given
        Member member = createMember();
        em.persist(member);

        int itemPrice = 100;
        int itemStock = 5;
        Book book = createBook(itemPrice, itemStock);
        em.persist(book);

        int orderItemCount = 2;

        //when
        Long orderId = sut.order(member.getId(), book.getId(), orderItemCount);

        //then
        Order order = em.find(Order.class, orderId);
        Assertions.assertNotNull(orderId);
        assertEquals(OrderStatus.ORDER, order.getStatus());
        assertEquals(1, order.getOrderItems().size());
        assertEquals(itemPrice * orderItemCount, order.getTotalPrice());
        assertEquals(itemStock - orderItemCount, book.getStockQuantity());
    }

    @Test
    @DisplayName("상품을 주문할 때 재고 수량을 초과하면 안 된다")
    void testOrderMoreThanItemStock() {
        //given\
        Member member = createMember();
        em.persist(member);

        int itemPrice = 100;
        int itemStock = 5;
        Book book = createBook(itemPrice, itemStock);
        em.persist(book);

        int orderItemCount = 6;

        //when & then
        assertThrows(NotEnoughStockException.class, () -> sut.order(member.getId(), book.getId(), orderItemCount));
    }


    @Test
    @DisplayName("주문 취소가 성공해야 한다")
    void testOrderCancel() {
        //given
        Member member = createMember();
        em.persist(member);

        int itemPrice = 100;
        int itemStock = 5;
        Book book = createBook(itemPrice, itemStock);
        em.persist(book);

        int orderItemCount = 2;

        Long orderId = sut.order(member.getId(), book.getId(), orderItemCount);

        //when
        sut.cancelOrder(orderId);

        //then
        Order getOrder = em.find(Order.class, orderId);
        assertEquals(OrderStatus.CANCEL, getOrder.getStatus());
        assertEquals(itemStock, book.getStockQuantity());
    }

    private Book createBook(int itemPrice, int itemStock) {
        Book item = new Book();
        item.setName("도서명");
        item.setPrice(itemPrice);
        item.setStockQuantity(itemStock);
        return item;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("홍길동");
        member.setAddress(new Address("서울", "경기", "12345"));
        return member;
    }
}
