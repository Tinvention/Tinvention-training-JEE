package net.tinvention.training.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GreetingWithNumber implements Serializable {

	private static final long serialVersionUID = 1L;

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
