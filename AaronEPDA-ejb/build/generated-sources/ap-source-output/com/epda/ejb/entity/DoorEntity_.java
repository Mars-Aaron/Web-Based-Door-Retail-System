package com.epda.ejb.entity;

import com.epda.ejb.entity.ProductEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T13:19:22")
@StaticMetamodel(DoorEntity.class)
public class DoorEntity_ extends BaseEntity_ {

    public static volatile SingularAttribute<DoorEntity, String> typeName;
    public static volatile SingularAttribute<DoorEntity, Double> basicCost;
    public static volatile SingularAttribute<DoorEntity, String> categoryName;
    public static volatile ListAttribute<DoorEntity, ProductEntity> products;

}