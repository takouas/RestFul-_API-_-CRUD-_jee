package com.jeetp.tp.servicesImpl;


import com.jeetp.tp.entities.Item;
import com.jeetp.tp.entities.Order;
import com.jeetp.tp.entities.OrderDetail;
import com.jeetp.tp.repository.OrderRepository;
import com.jeetp.tp.sevices.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;


    @Override
    public void calculateTotal(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        List<OrderDetail> orderDetails = order.get().getOrderDetails();
        float totalAmount = 0f;
        for (OrderDetail orderDetail : orderDetails) {
            Item item = orderDetail.getItem();
            totalAmount += (item.getPrice() * orderDetail.getQuantity()) + orderDetail.getTax();
        }
    }


    @Override
    public float calculateWeight(Long orderId) {

        Optional<Order> order = orderRepository.findById(orderId);
        List<OrderDetail> orderDetails = order.get().getOrderDetails();
        float totalWeight = 0f;
        for (OrderDetail orderDetail : orderDetails) {
            Item item = orderDetail.getItem();
            totalWeight += (item.getWeight() * orderDetail.getQuantity());
        }

        return totalWeight;

    }

}
