package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Orders {

    @Id
    @GeneratedValue
    protected long id;
    protected LocalDateTime date;
    protected Long customerId;
    @ElementCollection
    @CollectionTable(name="orders_items", joinColumns = @JoinColumn(name ="order_id"))
    @Column(name = "items_id")
    protected List<Long> itemIdList;

    public Orders(Long customerId, List<Long> itemIdList) {
        this.date = LocalDateTime.now().withNano(0);
        this.customerId = customerId;
        this.itemIdList = itemIdList;
    }
}
