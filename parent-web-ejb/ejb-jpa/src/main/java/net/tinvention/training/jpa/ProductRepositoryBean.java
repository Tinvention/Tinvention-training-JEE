//@formatter:off
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
//@formatter:on
package net.tinvention.training.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductRepositoryBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void store(ProductEntity toBeSaved) {
    entityManager.persist(toBeSaved);
  }

  public ProductEntity load(Long id) {
    return entityManager.find(ProductEntity.class, id);
  }
  
  public List<ProductEntity> list() {
    Query query = entityManager.createNamedQuery("products");
    
    @SuppressWarnings("unchecked")
    List<ProductEntity> list = query.getResultList();
    return list;
  }


}
