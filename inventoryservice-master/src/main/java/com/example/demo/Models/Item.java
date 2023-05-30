package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {
    @Id
    @GeneratedValue
    protected long id;

    @NotEmpty(message = "name is mandatory")
    @Size(min = 3, max = 52, message = "product name must be between 3-52 characters long")
    protected String name;
    @Min(value = 0, message = "price cannot be below 0")
    protected long pris;

    public Item(String name, long pris) {
        this.name = name;
        this.pris = pris;
    }
}
