package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public Long save(Order order) {
        em.persist(order);
        return order.getId();
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

//    TODO : 검색 기능 개발
//    public List<Order> findAll(OrderSearch orderSearch) {}
}
