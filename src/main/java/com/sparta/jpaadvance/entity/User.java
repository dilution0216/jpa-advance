package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Food> foodList = new ArrayList<>();
    // 실제로 이렇게는 불가, 관계를 표현하는방법. 데이터베이스에 실제로 이렇게 저장되진 않는다.

    public void addFoodList(Food food) {
        this.foodList.add(food);
        food.setUser(this);
        // 외래 키 설정
    }
}