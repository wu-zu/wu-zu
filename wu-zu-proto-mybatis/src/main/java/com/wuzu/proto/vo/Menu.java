package com.wuzu.proto.vo;

import java.util.List;

import lombok.Data;

/**
 * @author Gahngha Ryu
 */
@Data
public class Menu {

    private int id;
    private String name;
    
    private int parentId;
    private List<Menu> children;
    
    private boolean isOpened;
}