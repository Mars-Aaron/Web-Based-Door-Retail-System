package com.epda.ejb.entity;

import com.epda.ejb.entity.DoorEntity;
import com.epda.ejb.entity.DoorSizeEntity;
import com.epda.ejb.entity.OrderEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T13:19:22")
@StaticMetamodel(ProductEntity.class)
public class ProductEntity_ extends BaseEntity_ {

    public static volatile SingularAttribute<ProductEntity, DoorEntity> door;
    public static volatile SingularAttribute<ProductEntity, DoorSizeEntity> size;
    public static volatile SingularAttribute<ProductEntity, OrderEntity> order;

}