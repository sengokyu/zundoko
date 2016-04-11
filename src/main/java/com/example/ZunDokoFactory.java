/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Random;

/**
 * ズンドコファクトリー
 * <p>
 * ZunかDokoを生成します。
 *
 * @author sengoku
 */
public class ZunDokoFactory {

    private static final ZunDokoFactory SELF = new ZunDokoFactory();
    private final Random random = new Random();

    public static ZunDoko createZunDoko() {
        return SELF.create();
    }

    private ZunDoko create() {
        return new ZunDoko(ZunDokoEnum.valueOf(random.nextBoolean()));
    }
}
