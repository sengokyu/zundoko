/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.inject.Inject;
import static org.hamcrest.Matchers.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author y-okumura
 */
@RunWith(Arquillian.class)
public class ZunDokoProducerTest {

    @Deployment
    public static Archive<?> createDeployment() {
        final WebArchive war = ShrinkWrap.create(WebArchive.class,
                ZunDokoProducerTest.class.getSimpleName() + ".war")
                .addClass(ZunDokoProducer.class)
                .addClass(ZunDokoFactory.class)
                .addClass(ZunDoko.class);
        return war;
    }

    @Inject
    @ZunDokoQualifier
    ZunDoko instance;

    /**
     * Test of produceZunDoko method, of class ZunDokoProducer.
     */
    @Test
    public void testProduceZunDoko() {
        System.out.println("===>>> produceZunDoko");

        assertThat(instance, is(instanceOf(ZunDoko.class)));
        assertThat(instance.getZunDoko(), either(is(ZunDokoEnum.zun)).or(is(ZunDokoEnum.doko)));
    }
}
