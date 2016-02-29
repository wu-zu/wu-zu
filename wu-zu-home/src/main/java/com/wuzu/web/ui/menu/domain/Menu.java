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
 * @author Hyungchae Kim
 * @author Gahngha Ryu
 */
@Data
@Entity
@Table
@NoArgsConstructor
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 1)
    private String type;
    
    @Column(nullable = false)
    private int parentId;
    
    /** Root에서 부터의 깊이, Root는 0 */
    @Column(nullable = false)
    private int depth;

    @Column(nullable = false)
    private int orderInDepth;
    
    @Column(nullable = false)
    private String uri;
    
//    private List<Menu> children;
    
    
    @Column(name = "IS_OPENED", nullable = false)
    private boolean isOpened;
    
    
    public class Type {
        
        public static final String ROOT = "R";
        public static final String BRANCH = "B";
        public static final String LEAF = "L";
    }
    
//    public enum Type {
//        
//        ROOT("R"), BRANCH("B"), LEAF("L");
//        
//        private String type;
//        
//        private Type(String type) {
//            
//            this.type = type;
//        }
//        
//        public String value() {
//
//            return type;
//        }
//    }
}