package kr.sample.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Member")
@Getter
@ToString
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;


    @Builder
    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
