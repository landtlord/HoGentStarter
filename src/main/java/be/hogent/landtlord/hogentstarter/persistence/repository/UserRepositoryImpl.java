package be.hogent.landtlord.hogentstarter.persistence.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.UserRepository;

import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
