package com.example.springjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor      // 기본 생성자를 저장
@Getter     // 값을 저장할 때 쓰임
@Entity
public class Food {     //자바 클래스를 JPA를 사용해 Food라는 테이블을 만들기
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    // 음식의 이름 테이블 생성
    @Column (nullable = false)
    private String foodName;
    // 음식의 가격 테이블 생성
    @Column (nullable = false)
    private int price;

    @OneToMany(mappedBy = "food", fetch = FetchType.EAGER)      //OneToMany Food하나에 Order가 여러개가 될수 있기 때문에 사용함    //mappedBy 연관관계의 주인을 지정해 주는것
    private List<Orders> orders = new ArrayList<>();

   // 현재 Food 테이블과 orders테이블을 JoinColumn을 사용해서 Join이 되어 있는데 food_id의 주인이 Food라고 알려주는 것!

    public Food(String foodName, int price) {   // 단축키 alt + insert!
        this.foodName = foodName;
        this.price = price;
    }
}
