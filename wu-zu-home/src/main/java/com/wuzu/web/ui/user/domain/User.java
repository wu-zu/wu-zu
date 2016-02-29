package com.wuzu.web.ui.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Gahngha Ryu
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
}