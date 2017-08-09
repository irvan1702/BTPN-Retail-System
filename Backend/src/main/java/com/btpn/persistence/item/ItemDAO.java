package com.btpn.persistence.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends CrudRepository<Item, Integer> {
}
