package br.com.database_account.adapters.output.database.repository;

import br.com.database_account.adapters.output.database.entity.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<AccountEntity, String> {
}
