package com.cvent.capstone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERID", nullable = false)
    private Long userId;

    @Column(name = "ORDER_TIME")
    private String orderTime;

    @Column(name = "PICKUP_TIME")
    private String pickupTime;

    @Column(name = "AREA")
    private String area;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "TAX")
    private Double tax;

    @Column(name = "TIP")
    private Double tip;

    @Column(name = "PAN")
    private String pan;

    @Column(name = "EXPIRY_MONTH")
    private Integer expiryMonth;

    @Column(name = "EXPIRY_YEAR")
    private Integer expiryYear;

    @Column(name = "STATUS", nullable = false)
    private String status;
}