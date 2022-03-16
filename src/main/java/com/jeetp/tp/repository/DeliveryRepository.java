package com.jeetp.tp.repository;

import com.jeetp.tp.entities.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

    @Query(value = "select avg(delivery.deliveryDate - delivery.shoppingDate) as avgTime ,delivery.deliveryMan from Delivery delivery group by delivery.deliveryMan  order by avgTime ")
    Page<Object[]> getAvgTimeMin(Pageable pageable) ;

    @Query(value = "select avg(delivery.deliveryDate - delivery.shoppingDate) as avgTime ,delivery.deliveryMan from Delivery delivery group by delivery.deliveryMan order by avgTime Desc ")
    Page<Object[]> getAvgTimeMax(Pageable pageable) ;



}