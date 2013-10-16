/**
 * Copyright Tinvention -Ingegneria Informatica- http://tinvention.net/ Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.tinvention.training.ejb.mdb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class ProducerBean {

  @Resource(lookup = "jms/test")
  private Queue queue;

  @Inject
  private JMSContext jmsContext;

  public void send(ValueObject vo) {
    jmsContext.createProducer().send(queue, vo);
  }

}
