package com.jeetp.tp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeetp.tp.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query(value = "SELECT * FROM Customer c (SELECT c.name, COUNT(Order.id)) AS 'TOTAL ORDERS' FROM Customer c INNER JOIN c.orders orders group by c order by 'TOTAL ORDERS' DESC LIMIT 5 ",nativeQuery = true)
     Page<Customer[]> getCustomerWithMaxOrders(Pageable pageable) ;

    @Query(value = "select id avg(price*qty) as avgTotalAmount from Orders orders_details Item where orders_details.id in (SELECT * FROM Customer INNER JOIN Orders ON Customer.id = Orders.customer_id  ) DESC LIMIT 5",nativeQuery = true)
    Page<Customer[]> getHighestSpendingCustomers(Pageable pageable) ;

    @Query(value = "select * from Orders orders_details Item where weight >10 and orders_details.id in (SELECT * FROM Customer INNER JOIN Orders ON Customer.id = Orders.customer_id  )",nativeQuery = true)
    Page<Customer[]> getCustomersWithMoreThan10kgOrders(Pageable pageable) ;
}