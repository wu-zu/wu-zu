package com.wuzu.web.ui.board.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

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
    private String nickname;
    
    @Column(nullable = false, length = 100)
    private String password;
    
    @Column(nullable = false, length = 30)
    private String title;
    
    @Lob
    @Column(nullable = false)
    private String content;
    
	@Column(nullable = false)
    private LocalDateTime addDate;
    
    @OneToMany(mappedBy="article")
    private List<Comment> comments;
}