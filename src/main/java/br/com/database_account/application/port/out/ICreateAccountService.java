package br.com.database_account.application.port.out;

import br.com.database_account.application.domain.model.AccountDomain;

public interface ICreateAccountService {
    void execute(AccountDomain domain);
}
