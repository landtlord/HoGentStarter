package be.hogent.landtlord.hogentstarter.persistence.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.FundsRepository;

import java.util.List;

public class FundsRepositoryImpl implements FundsRepository {
    @Override
    public Funds save(Funds funds) {
        return null;
    }

    @Override
    public List<Funds> findFundsFor(Project project) {
        return null;
    }

    @Override
    public List<Funds> findFundsFor(User user) {
        return null;
    }
}
