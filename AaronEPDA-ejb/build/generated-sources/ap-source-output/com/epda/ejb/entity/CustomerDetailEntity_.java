package com.epda.ejb.entity;

import com.epda.ejb.entity.OrderEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T13:19:22")
@StaticMetamodel(CustomerDetailEntity.class)
public class CustomerDetailEntity_ extends BaseEntity_ {

    public static volatile SingularAttribute<CustomerDetailEntity, String> address;
    public static volatile SingularAttribute<CustomerDetailEntity, String> phoneNumber;
    public static volatile SingularAttribute<CustomerDetailEntity, String> name;
    public static volatile ListAttribute<CustomerDetailEntity, OrderEntity> orders;

}