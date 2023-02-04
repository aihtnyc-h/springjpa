package com.example.springjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor      // 기본 생성자 만들어줌
@Getter                 // 값을 저장할때
@Entity
public class Orders {    //자바 클래스를 JPA를 사용해 Order라는 테이블을 만들기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 넣으면 클래스 Order의 빨간 줄 사라짐!
    // Food의 Id와 Member의 Id를 받아와야하기 때문에 ManyToOne 사용!
    // JoinColum(name = "Food_id") 사용해서 Food의 Id로 Join 하기
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;               // Food 가져오기

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    // 현재 Food 테이블과 orders테이블을 JoinColumn을 사용해서 Join이 되어 있는데 food_id의 주인이 Food라고 알려주는 것!
    // 단축키 alt + insert!
    public Orders(Food food, Member member) {
        this.food = food;
        this.member = member;
    }
}

