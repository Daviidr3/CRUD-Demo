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

    private String plateName;
    private int cookTime;
    private double price;

    public Food(String plateName, int cookTime, double price){

        this.plateName = plateName;
        this.cookTime = cookTime;
        this.price = price;
    }
}
