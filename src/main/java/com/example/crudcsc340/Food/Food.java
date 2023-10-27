package com.example.crudcsc340.Food;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "food")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int cookTime;
    private double price;

    public Food(String name, int cookTime, double price){

        this.name = name;
        this.cookTime = cookTime;
        this.price = price;
    }
}
