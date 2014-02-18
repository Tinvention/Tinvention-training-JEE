/**
 * Copyright Tinvention -Ingegneria Informatica- http://tinvention.net/ Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.tinvention.training.rs.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ProductRSClient {

  private final static String RES_PROD_URL = "http://localhost:8080/rs/api/products";

  public static void main(String[] args) {

    // Call get list

    {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(RES_PROD_URL);
      Invocation invocation = target.request(MediaType.APPLICATION_XML).buildGet();
      Response response = invocation.invoke();

      System.out.println(response);
      System.out.println(response.readEntity(String.class));
      System.out.println();
    }
    {

      Response response = ClientBuilder.newClient().target(RES_PROD_URL).request(MediaType.APPLICATION_XML).get();
      // -> APPLICATION_JSON not out of box and not standard for the moment...
      // you need to add a Jersey specific provider to have a JSON MessageBodyReader and
      // MessageBodyWriter.
      List<ClientProduct> retrived = response.readEntity(new GenericType<List<ClientProduct>>() {
      });

      System.out.println(response);
      System.out.println(retrived);
      System.out.println();
    }
    {

      Response response = ClientBuilder.newClient().target(RES_PROD_URL).path("12").request(MediaType.APPLICATION_XML).get();
      ClientProduct retrived = response.readEntity(ClientProduct.class);

      System.out.println(response);
      System.out.println(retrived);
      System.out.println();
    }

    {
      ClientProduct newProduct = new ClientProduct();
      newProduct.setName("A new product ... ");

      Response response = ClientBuilder.newClient().target(RES_PROD_URL).request().post(Entity.entity(newProduct, MediaType.APPLICATION_XML));

      System.out.println(response);
      System.out.println(response.getLocation());
    }

  }
}
