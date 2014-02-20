/**
 * Copyright Tinvention -Ingegneria Informatica- http://tinvention.net/ Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.tinvention.training.ws.client;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import net.tinvention.training.ws.GreetingWithNumber;
import net.tinvention.training.ws.HelloWS;
import net.tinvention.training.ws.HelloWSService;
import net.tinvention.training.ws.MessageValue;

public class HelloWSClient {

  public static void main(String[] args) {

    HelloWSService service = new HelloWSService();
    HelloWS port = service.getHelloWSPort();

    {

      String response = port.getGreeting("Stefano");
      System.out.println("Response is [" + response + "]");
    }

    {
      try {
        MessageValue msgData = new MessageValue();
        msgData.setMessage("Test WS with JAXB ...");
        msgData.setNumber(new Date().getTime());

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        msgData.setCreated(xmlDate);

        GreetingWithNumber response = port.getGreetingWitNumber(msgData);
        Date responseCreated = response.getCreated().toGregorianCalendar().getTime();
        System.out.println("Response is [" + response.getMessage() + ", " + response.getNumberString() + ", " + responseCreated +"]");

      } catch (DatatypeConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
