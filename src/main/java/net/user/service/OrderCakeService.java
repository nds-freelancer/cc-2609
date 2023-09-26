package net.user.service;

import java.util.List;
import net.user.entity.OrderCa;

public interface OrderCakeService {
	
    List<OrderCa> getAllOrderCake(String phone);
//    
	public OrderCa updateOrderCake(OrderCa cake);
	
}
