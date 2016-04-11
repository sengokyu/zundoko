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
 * @author y-okumura
 */
public class ZunDokoTest {

    /**
     * Test of getZunDoko method, of class ZunDoko.
     */
    @Test
    public void testGetZunDoko() {
        System.out.println("===>>> getZunDoko");

        final ZunDoko instance = new ZunDoko(ZunDokoEnum.zun);

        assertThat(instance.getZunDoko(), is(ZunDokoEnum.zun));
    }

    /**
     * Test of setZunDoko method, of class ZunDoko.
     */
    @Test
    public void testSetZunDoko() {
        System.out.println("===>>> setZunDoko");

        final ZunDokoEnum zunDoko = ZunDokoEnum.doko;
        final ZunDoko instance = new ZunDoko();
        instance.setZunDoko(zunDoko);

        assertThat(instance.getZunDoko(), is(zunDoko));
    }

}
