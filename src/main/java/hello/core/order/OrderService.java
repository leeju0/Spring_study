package hello.core.order;

public interface OrderService {
    //회원 id, 상품명 , 상품가격 정보를 받아서 -> 최종 주문결과를 반환할 것임
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
