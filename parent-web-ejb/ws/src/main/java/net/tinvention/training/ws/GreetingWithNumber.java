package net.tinvention.training.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GreetingWithNumber {

	private String message;

	private String numberString;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNumberString() {
		return numberString;
	}

	public void setNumberString(String numberString) {
		this.numberString = numberString;
	}

}
