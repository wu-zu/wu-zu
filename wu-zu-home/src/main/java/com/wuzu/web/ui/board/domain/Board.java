package com.wuzu.web.ui.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Gahngha Ryu
 */
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(nullable = false, length = 30)
    private String name;
    
    @Column(nullable = false, length = 1)
    private String type;
    
    // Article
//    private List<Article> articles;
}