package com.btpn.persistence.transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, Integer> {
}
