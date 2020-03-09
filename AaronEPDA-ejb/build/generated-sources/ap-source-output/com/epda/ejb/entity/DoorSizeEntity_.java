package com.epda.ejb.entity;

import com.epda.ejb.entity.ProductEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T13:19:22")
@StaticMetamodel(DoorSizeEntity.class)
public class DoorSizeEntity_ extends BaseEntity_ {

    public static volatile SingularAttribute<DoorSizeEntity, Double> costMultiplier;
    public static volatile SingularAttribute<DoorSizeEntity, String> name;
    public static volatile ListAttribute<DoorSizeEntity, ProductEntity> products;

}