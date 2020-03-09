package com.epda.ejb.entity;

import com.epda.ejb.entity.AccountEntity;
import com.epda.ejb.entity.OrderEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T13:19:22")
@StaticMetamodel(ProfileEntity.class)
public class ProfileEntity_ extends BaseEntity_ {

    public static volatile SingularAttribute<ProfileEntity, String> phoneNumber;
    public static volatile SingularAttribute<ProfileEntity, String> address;
    public static volatile SingularAttribute<ProfileEntity, String> fullName;
    public static volatile SingularAttribute<ProfileEntity, Date> dateOfBirth;
    public static volatile ListAttribute<ProfileEntity, OrderEntity> assignedJobs;
    public static volatile SingularAttribute<ProfileEntity, AccountEntity> account;

}