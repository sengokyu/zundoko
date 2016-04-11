/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 * ズンドコ
 * <p>
 * JSONになるクラスです。
 *
 * @author sengoku
 */
public class ZunDoko {

    private ZunDokoEnum zunDoko;

    /**
     * ここでは使っていないけれど、引数なしのコンストラクタも一応用意。
     */
    public ZunDoko() {
    }
    
    public ZunDoko(ZunDokoEnum zunDoko) {
        this.zunDoko = zunDoko;
    }
    
    public ZunDokoEnum getZunDoko() {
        return zunDoko;
    }

    public void setZunDoko(ZunDokoEnum zunDoko) {
        this.zunDoko = zunDoko;
    }
}
