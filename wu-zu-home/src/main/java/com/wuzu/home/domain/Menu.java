package com.wuzu.home.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author HyungChae Kim
 */
@Entity
@Table(name="menu")
@Data
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",nullable = false,length = 30)
    private String name;

    @Column(name = "is_opened",nullable = false)
    private boolean isOpened;

}