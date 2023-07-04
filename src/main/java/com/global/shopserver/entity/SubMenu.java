package com.global.shopserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sub_menu")
public class SubMenu extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유한 id

    private String name; // 하위 메뉴 이름
    private String imageUrl; // 하위 메뉴 이미지 url
    private String introduction; // 하위 메뉴 설명
    private int price; // 하위 메뉴 가격
    private char deleted; // 논리 삭제 여부: 'Y'이면 삭제

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu; // 상위 메뉴
}
