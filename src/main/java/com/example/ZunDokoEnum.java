/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 * ズンドコEnum
 * 
 * @author sengoku
 */
public enum ZunDokoEnum {
    zun,
    doko;
    
    public static ZunDokoEnum valueOf(boolean b) {
        return b ? ZunDokoEnum.zun : ZunDokoEnum.doko;
    }
}
