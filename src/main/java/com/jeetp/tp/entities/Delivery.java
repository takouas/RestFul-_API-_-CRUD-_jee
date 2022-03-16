package com.jeetp.tp.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "t_delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deliveryMan;
    private Date shoppingDate;
    private Date deliveryDate;

    @ManyToOne
    private Order order;

}
