package com.example.springjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor      // 기본생성자를 만들어줌
@Getter     // 값을 저장할 때 쓰임
@Entity
public class Member {   //자바 클래스를 JPA를 사용해 Member라는 테이블을 만들기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member;
    @Column(nullable = false)
    private String memberName;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)  // 연관관계의 주인이 누구인지 중점적으로 생각하면 쉽게 만들 수 있다!
    public List<Orders> orders = new ArrayList<>();
    private String id;

    public Member(String memberName) {  // 단축키 alt + insert
        this.memberName = memberName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
