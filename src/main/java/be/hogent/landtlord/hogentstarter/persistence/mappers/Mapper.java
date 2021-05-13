package be.hogent.landtlord.hogentstarter.persistence.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T, U> {
    T toObject(U u);

    U toEntity(T t);

    default List<T> toObject(List<U> uList){
        return uList.stream()
                .map(this::toObject)
                .collect(Collectors.toList());
    }

    default List<U> toEntity(List<T> tList){
        return tList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
