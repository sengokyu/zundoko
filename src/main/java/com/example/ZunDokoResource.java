/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * ズンドコリソース
 * <p>
 * JAX-RSリソースです。
 *  * リクエストごとに異なるZunDokoを返すため、リクエストスコープにしてます。
 *
 * @author sengoku
 */
@Dependent
@Path("zundoko")
public class ZunDokoResource {

    /**
     * あえてディペンデンシーインジェクション！
     */
    @Inject
    @ZunDokoQualifier
    private ZunDoko zunDoko;

    /**
     * インジェクトされたZunDokoをJSONにして出力します。
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ZunDoko getZunDoko() {
        return zunDoko;
    }
}
