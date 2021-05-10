package be.hogent.landtlord.hogentstarter.domain.bussines.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User save(User user);

    User update(User user);
}
