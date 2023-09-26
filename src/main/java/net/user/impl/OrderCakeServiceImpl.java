package net.user.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.user.entity.OrderCa;
import net.user.entity.OrderCaView;
import net.user.repository.OrderRepository;
import net.user.service.OrderCakeService;

@Service
@AllArgsConstructor
public class OrderCakeServiceImpl implements OrderCakeService {

    private OrderRepository orderRepository;

	@Override
	public OrderCa updateOrderCake(OrderCa orderCake) {

		OrderCa updatedOrderCake = orderRepository.saveAndFlush(orderCake);
        return updatedOrderCake;
	}

	@Override
	public List<OrderCa> getAllOrderCake(String phone) {
		
		List<OrderCa> lstOrderCake = orderRepository.findAllByPhone(phone);

		return lstOrderCake;
	}

}
