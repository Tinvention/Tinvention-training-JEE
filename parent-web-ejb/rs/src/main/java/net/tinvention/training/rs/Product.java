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
package net.tinvention.training.rs;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@formatter:off
/**
 * 
 <xs:element name="product">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="id" type="xs:string" minOccurs="1" maxOccurs="1"/>
                <xs:element name="name" type="xs:string" />
                <xs:element name="make" type="xs:string" />
                <xs:element name="type" type="xs:string"/>
                <xs:element name="purchaseDate" type="xs:date"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
 * 
 * 
 *
 */
//@formatter:on
@XmlRootElement
public class Product implements Serializable {

  private static final long serialVersionUID = 2670559828610853552L;
  
  private String id;

  @NotNull
  private String name;

  private String make;

  private String type;

  private Date purchaseDate;

  public String getId() {
    return id;
  }

  @XmlElement(required = true, nillable = false)
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

}
