/**
 * Copyright Tinvention -Ingegneria Informatica- http://tinvention.net/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.tinvention.training.rs;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * It use "HTTP Accept header param" for content negotiation, and Content-Type for input
 * 
 * http://localhost:8080/rs/api/products
 * http://localhost:8080/rs/api/application.wadl
 * http://localhost:8080/rs/api/products/1
 * 
 */
@Path("products")
public class ProductRS {
  
  @Context
  private UriInfo uriInfo;

  //@formatter:off
    /** 
        1. Respond to a GET request on the following web-service endpoint:
        /rsService/product/{id}
        where {id} is the numeric identifier for the product resource, matching the id field in the product
        data files
     * 
     * @return
     */
  //@formatter:on
  @GET
  @Path("{id}")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
  public Product load(@PathParam("id") String id) {
    // Stub code..

    Product p = new Product();
    p.setId(id);
    p.setMake("Acme Corporation ... ");
    p.setPurchaseDate(new Date());
    p.setName("Best product ...");

    return p;
  }

  //@formatter:off
    /** 
        2. Respond to a GET request on the following web-service endpoint:
        /rsService/products
        This request will respond with a collection of products.
        The collection request can be filtered and sorted using the following query-string request
        parameters:
        type = food | toy | furniture
        make = any string
        
     * 
     * @return
     */
  //@formatter:on
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Product> list() {
    // Stub code..
    List<Product> result = new ArrayList<>();

    for (int i = 0; i < 10; i++) {

      Product p = new Product();
      p.setId(Integer.toString(i));
      p.setMake("Acme Corporation ... ");
      p.setPurchaseDate(new Date());
      p.setName("Best product [" + i + "]");

      result.add(p);
    }// for

    return result;
  }

  @POST
  @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Response add(@Valid Product p) {
    // Stub code..
    // save and get the new ID
    
    Random r = new Random();
    String newId = Integer.toString(r.nextInt());
    
    //Example using uri api
    URI createdResourceUri = uriInfo.getAbsolutePathBuilder().path(newId).build();

    return Response.created(createdResourceUri).build();
  }

  
  @DELETE
  @Path("{id}")
  public Response remove(@PathParam("id") String id) {
     // Stub code..
    
    return Response.status(Response.Status.OK).build();
  }

}
