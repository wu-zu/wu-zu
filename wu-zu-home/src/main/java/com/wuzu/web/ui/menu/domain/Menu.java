package com.wuzu.web.ui.menu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

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
    
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    
    @Column(nullable = false, length = 1)
    private String type;
    
    @Column(nullable = false)
    private int parentId;
    
//    private List<Menu> children;
    
    @Column(name = "is_opened", nullable = false)
    private boolean isOpened;
}