package com.jeetp.tp.servicesImpl;

import com.jeetp.tp.repository.DeliveryRepository;
import com.jeetp.tp.sevices.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository ;
    @Override
    public void displayDeliveryManAvgMinTime() {
        Page<Object[]> deliveryMans = deliveryRepository.getAvgTimeMin(PageRequest.of(0,1)) ;

        if(deliveryMans.getContent().size()>0) {
            Object[] deliveryMan = deliveryMans.getContent().get(0) ;
            System.out.println(" le livreur qui a une moyenne de temps de livraison la plus rapide et : \n" +
                    deliveryMan[1] );

        }
    }

    @Override
    public void displayDeliveryManAvgMaxTime() {
        Page<Object[]> deliveryMans = deliveryRepository.getAvgTimeMax(PageRequest.of(0,1)) ;

        if(deliveryMans.getContent().size()>0) {
            Object[] deliveryMan = deliveryMans.getContent().get(0) ;
            System.out.println(" le livreur qui a une moyenne de temps de livraison la plus lente et : \n" +
                     deliveryMan[1] );

        }
    }
}
