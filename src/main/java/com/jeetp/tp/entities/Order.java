package com.jeetp.tp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jeetp.tp.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;


    // JOIN ENTITY CUSTOMER
    @ManyToOne
    @JsonIgnore
    private Customer customer;

    // JOIN ENTITY DELIVERY
    @OneToMany(mappedBy = "order")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "orderDet")
    private List<OrderDetail> orderDetails;


}
