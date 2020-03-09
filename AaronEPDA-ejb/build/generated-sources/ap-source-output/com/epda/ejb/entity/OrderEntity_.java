package com.epda.ejb.entity;

import com.epda.ejb.entity.CustomerDetailEntity;
import com.epda.ejb.entity.ProductEntity;
import com.epda.ejb.entity.ProfileEntity;
import com.sdsms.ejb.var.OrderStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T13:19:22")
@StaticMetamodel(OrderEntity.class)
public class OrderEntity_ extends BaseEntity_ {

    public static volatile SingularAttribute<OrderEntity, Date> completionTimestamp;
    public static volatile SingularAttribute<OrderEntity, ProfileEntity> installer;
    public static volatile SingularAttribute<OrderEntity, Date> installationDate;
    public static volatile SingularAttribute<OrderEntity, Date> orderTimestamp;
    public static volatile SingularAttribute<OrderEntity, OrderStatus> status;
    public static volatile ListAttribute<OrderEntity, ProductEntity> products;
    public static volatile SingularAttribute<OrderEntity, CustomerDetailEntity> customer;

}