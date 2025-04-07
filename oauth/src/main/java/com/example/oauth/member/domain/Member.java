package com.example.oauth.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // 해당 클래스 내의 모든 변수에 대하여 생성자를 만들어줌
@NoArgsConstructor // 기본 생성자를 만들어줌
@Getter
@Entity
public class Member {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING) // 가독성 차원에서 문자열 그대로 저장하도록 하는 어노테이션
    @Builder.Default // 디폴트값을 user로 설정함
    private Role role = Role.USER; // Enum의 경우, 디폴트로는 인덱스 번호처럼 0, 1, ... 등 숫자로 들어감.

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;
}
