/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

/**
 * ズンドコCDIプロデューサ
 * <p>
 * ZunDokoをインジェクションします。
 *
 * @author sengoku
 */
@RequestScoped
public class ZunDokoProducer {

    /**
     * ZunDokoをインジェクションします。
     *
     * @return
     */
    @Produces
    @ZunDokoQualifier
    public ZunDoko produceZunDoko() {
        return ZunDokoFactory.createZunDoko();
    }
}
