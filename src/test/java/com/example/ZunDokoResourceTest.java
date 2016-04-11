/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.Matchers.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author y-okumura
 */
@RunWith(Arquillian.class)
public class ZunDokoResourceTest {

    @Deployment(testable = false)
    public static Archive<?> createDeployment() {
        final WebArchive war = ShrinkWrap.create(WebArchive.class,
                ZunDokoResourceTest.class.getSimpleName() + ".war")
                .addClass(ZunDokoResource.class)
                .addClass(ZunDokoProducer.class)
                .addClass(ZunDokoQualifier.class)
                .addClass(ZunDoko.class)
                .addClass(ZunDokoFactory.class)
                .addClass(ZunDokoEnum.class)
                .addClass(WebApiApplication.class);

        return war;
    }

    @ArquillianResource
    private URI base;

    private WebTarget target;

    @Before
    public void setUp() {
        final Client client = ClientBuilder.newClient();
        target = client.target(base)
                .path("webapi")
                .register(ZunDoko.class);
    }

    /**
     * Test of getZunDoko method, of class ZunDokoResource.
     */
    @Test
    public void testGetZunDoko() {
        System.out.println("===>>> getZunDoko");

        final Response response = target.path("zundoko")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get();

        assertThat(response.getStatus(), is(200));

        final ZunDoko result = response.readEntity(ZunDoko.class);

        assertThat(result, is(notNullValue()));
        assertThat(result.getZunDoko(),
                is(anyOf(equalTo(ZunDokoEnum.zun), equalTo(ZunDokoEnum.doko))));
    }
}
