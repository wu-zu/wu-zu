package com.wuzu.home.vo;

import lombok.Data;

/**
 * @author Gahngha Ryu
 */
@Data
public class Menu {

    private int id;
    private String name;
    
    private boolean isOpened;
}