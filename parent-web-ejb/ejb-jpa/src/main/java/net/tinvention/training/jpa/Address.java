package net.tinvention.training.jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

  private static final long serialVersionUID = 883754296730144807L;

  private String city;
  private String country;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}
