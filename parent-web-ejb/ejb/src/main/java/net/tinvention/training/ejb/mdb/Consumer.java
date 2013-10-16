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
package net.tinvention.training.ejb.mdb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/test")
public class Consumer implements MessageListener {

  @PreDestroy
  public void preDestroy() {
    System.out.println("preDestroy called");
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("postConstruct called");
  }

  @Override
  // @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void onMessage(Message message) {
    ValueObject vo;
    try {
      vo = message.getBody(ValueObject.class);
      System.out.println("Message found: " + vo);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

}
