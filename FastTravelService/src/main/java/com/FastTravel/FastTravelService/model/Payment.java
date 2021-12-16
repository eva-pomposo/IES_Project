package com.FastTravel.FastTravelService.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Person client;

    @Column(name = "date", nullable = false)
    @CreationTimestamp
    private Date date;

    @OneToOne(mappedBy="payment")
    PaymentPassage passage;    

    public Payment() {}

    public Payment(Person client, Date date) {
        this.client = client;
        this.date = date;
    }

}