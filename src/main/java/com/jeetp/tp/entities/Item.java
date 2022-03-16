package com.jeetp.tp.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "t_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float weight;
    private String description;
    private float price;
    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetail;


}
