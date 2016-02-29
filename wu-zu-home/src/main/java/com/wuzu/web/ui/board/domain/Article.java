package com.wuzu.web.ui.board.domain;

import java.time.LocalDateTime;

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
public class Article {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(nullable = false, length = 30)
    private String title;
    
    @Column(nullable = false, length = 1500)
    private String content;
    
    private LocalDateTime writtenDateTime;
    
    // User
    private int userId;
    
    // Board
    private int boardId;
}