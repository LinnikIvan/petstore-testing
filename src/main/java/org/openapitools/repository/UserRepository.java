package org.openapitools.repository;

import org.openapitools.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends HashMapRepository<User, String> {

    @Override
    <S extends User> String getEntityId(S user) {
        return user.getUsername();
    }

}
