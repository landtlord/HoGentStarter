package be.hogent.landtlord.hogentstarter.domain.bussines.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;

import java.util.List;

public interface FundsRepository {
    Funds save(Funds funds);

    List<Funds> findFundsFor(Project project);

    List<Funds> findFundsFor(User user);
}
