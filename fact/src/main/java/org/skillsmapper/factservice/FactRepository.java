package org.skillsmapper.factservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FactRepository extends CrudRepository<Fact, Long> {

    List<Fact> findByType(String type);

    Fact findById(long id);
}
