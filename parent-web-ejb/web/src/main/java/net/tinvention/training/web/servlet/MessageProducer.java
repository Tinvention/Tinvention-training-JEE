/**
 * Copyright Tinvention -Ingegneria Informatica- http://tinvention.net/ Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.tinvention.training.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tinvention.training.ejb.mdb.ProducerBean;
import net.tinvention.training.ejb.mdb.ValueObject;

@WebServlet(urlPatterns = { "/mdbProduce" })
public class MessageProducer extends HttpServlet {

  private static final long serialVersionUID = -8821855061085119101L;

  @EJB
  private ProducerBean producerBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ValueObject vo = new ValueObject(Double.toString(Math.random()));

    producerBean.send(vo);

    resp.setContentType("text/html;charset=UTF-8");
    String data = "<!DOCTYPE html><html><body><p>Message: " + vo + " sent</p></body></html>";
    resp.getWriter().println(data);

  }

}
