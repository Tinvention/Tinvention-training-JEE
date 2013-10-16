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
package net.tinvention.training.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tinvention.training.ejb.singleton.SingletonCounter;
import net.tinvention.training.ejb.stateful.Counter;

/**
 * 
 * http://localhost:8080/web/anotherCounter?dec=true
 * 
 * @author stefano
 *
 */
@SuppressWarnings("serial")
@WebServlet(name = "AnotherCounterServlet", urlPatterns = { "/anotherCounter" })
public class AnotherCounterServlet extends HttpServlet {

	@EJB
	private Counter counter;
	
	@EJB
	private SingletonCounter singletonCounter;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		if (req.getParameter("inc") != null) {
			counter.increment();
			singletonCounter.increment();
		}
		if (req.getParameter("dec") != null) {
			counter.decrement();
			singletonCounter.increment();
		}

		PrintWriter writer = res.getWriter();
		res.setContentType("text/plain");

		writer.write("\n StateFul Bean Counter value is : " + counter.getState());
		writer.write("\n SingletonCounter value is : " + singletonCounter.getState());

	}
}
