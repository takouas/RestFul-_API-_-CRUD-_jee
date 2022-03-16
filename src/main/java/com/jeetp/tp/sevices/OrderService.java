package com.jeetp.tp.sevices;

public interface OrderService {
    void calculateTotal( Long orderId) ;
    float calculateWeight(Long orderId ) ;

}
