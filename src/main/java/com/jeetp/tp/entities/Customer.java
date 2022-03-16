package com.jeetp.tp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "t_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;
    private String name;
    private String deliveryAddress;
    private String contact;
    private boolean active = false;


    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


}
