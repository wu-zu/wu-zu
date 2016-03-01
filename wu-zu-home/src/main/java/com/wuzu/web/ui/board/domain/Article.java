package com.wuzu.web.ui.board.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wuzu.web.ui.user.domain.User;

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
    
    @Lob
    @Column(nullable = false)
    private String content;
   
    private LocalDateTime writtenDateTime;
    
    // User
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
    
    // Board
    @ManyToOne
    @JoinColumn(name="BOARD_ID")
    private Board board;
}