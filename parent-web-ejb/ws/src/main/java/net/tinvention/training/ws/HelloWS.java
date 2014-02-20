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
package net.tinvention.training.ws;

import javax.jws.WebService;

@WebService
public class HelloWS {

	public String getGreeting(String msg) {
		return "Hello: " + msg;
	}

	public GreetingWithNumber getGreetingWitNumber(MessageValue msg) {
		GreetingWithNumber response = new GreetingWithNumber();
		response.setNumberString(msg.getNumber().toString());
		response.setMessage("Hello: " + msg.getMessage());
		response.setCreated(msg.getCreated());
		return response;
	}

}
