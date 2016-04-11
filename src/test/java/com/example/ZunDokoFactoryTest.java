/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sengoku
 */
public class ZunDokoFactoryTest {

    /**
     * Test of createZunDoko method, of class ZunDokoFactory.
     */
    @Test
    public void testCreateZunDoko() {
        System.out.println("===>>> createZunDoko");

        int zunCount = 0;
        int dokoCount = 0;
        ZunDoko result = ZunDokoFactory.createZunDoko();
        
        assertThat(result.getZunDoko(), either(is(ZunDokoEnum.zun)).or(is(ZunDokoEnum.doko)));
        
        for (int i = 0; i < 10000; i++) {
            result = ZunDokoFactory.createZunDoko();

            switch (result.getZunDoko()) {
                case zun:
                    zunCount++;
                    break;
                case doko:
                    dokoCount++;
                    break;
                default:
                    fail("Something wrong!");
            }
        }

        assertThat("Zun appears " + zunCount, zunCount, is(greaterThan(1)));
        assertThat("Doko appears " + dokoCount, dokoCount, is(greaterThan(1)));
    }

}
