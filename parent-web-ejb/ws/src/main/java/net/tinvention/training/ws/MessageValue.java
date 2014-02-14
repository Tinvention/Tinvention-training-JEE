package net.tinvention.training.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageValue {

	private String message;

	private Long number;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
