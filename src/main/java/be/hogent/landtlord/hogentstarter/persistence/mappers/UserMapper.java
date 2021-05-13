package be.hogent.landtlord.hogentstarter.persistence.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;

public class UserMapper implements Mapper<User, UserEntity> {
    @Override
    public User toObject(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        user.setRole(userEntity.getRole());
        user.setApproved(userEntity.isApproved());

        return user;
    }

    @Override
    public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setApproved(user.isApproved());

        return userEntity;
    }
}
