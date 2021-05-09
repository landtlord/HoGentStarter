package be.hogent.landtlord.hogentstarter.domain.service.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T, U> {
    T toObject(U u);

    U toDTO(T t);

    default List<T> toObject(List<U> uList){
        return uList.stream()
                .map(u -> toObject(u))
                .collect(Collectors.toList());
    }

    default List<U> toDTO(List<T> oList){
        return oList.stream()
                .map(o -> toDTO(o))
                .collect(Collectors.toList());
    }
}
