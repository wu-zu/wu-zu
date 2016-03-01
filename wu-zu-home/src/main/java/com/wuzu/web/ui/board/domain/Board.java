package com.wuzu.web.ui.board.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    @OneToMany(mappedBy="board")
    private List<Article> articles;
}