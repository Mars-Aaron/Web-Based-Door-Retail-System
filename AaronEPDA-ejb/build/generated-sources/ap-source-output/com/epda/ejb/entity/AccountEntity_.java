package com.epda.ejb.entity;

import com.epda.ejb.entity.ProfileEntity;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.AccountStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T13:19:22")
@StaticMetamodel(AccountEntity.class)
public class AccountEntity_ extends BaseEntity_ {

    public static volatile SingularAttribute<AccountEntity, AccountStatus> accountStatus;
    public static volatile SingularAttribute<AccountEntity, String> password;
    public static volatile SingularAttribute<AccountEntity, ProfileEntity> profile;
    public static volatile SingularAttribute<AccountEntity, Date> lastLoggedIn;
    public static volatile SingularAttribute<AccountEntity, AccountRole> accountRole;
    public static volatile SingularAttribute<AccountEntity, String> username;

}