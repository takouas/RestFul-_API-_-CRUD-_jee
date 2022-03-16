package com.jeetp.tp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_orderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    private float tax;


    @ManyToOne
    private Order orderDet;

    @ManyToOne
    private Item item;
}
