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
package net.tinvention.training.ejb;

import javax.naming.InitialContext;

import net.tinvention.training.ejb.stateless.Echo;


public class MainClient  {
	
	 private final static String JNDI_ECHOBEAN_REMOTE_URI = "java:global/ear-web-ejb/ejb/EchoBean!" + Echo.class.getName();

	 public static void main(String args[]) {

	        try {

	            InitialContext ic = new InitialContext();
	            // Echo echo = (Echo) ic.lookup(Echo.class.getName()); //Same host, Glassfish default
	            Echo echo = (Echo) ic.lookup(JNDI_ECHOBEAN_REMOTE_URI); 
	            System.out.println("Echo bean says : " + echo.echoMsg("Test echo ...."));
	            
	            // For connecting to a different remote host you need to set
                // -Dorg.omg.CORBA.ORBInitialHost=xxx -Dorg.omg.CORBA.ORBInitialPort=xxxx
	            // ex. -Dorg.omg.CORBA.ORBInitialHost=yourdomain.your -Dorg.omg.CORBA.ORBInitialPort=3700

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	    }

}
