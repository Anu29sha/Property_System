package com.company.prop.Management.Repository;

import com.company.prop.Management.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
