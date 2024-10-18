package br.com.database_account.application.port.in;

import br.com.database_account.application.domain.model.AccountDomain;

public interface ICreateAccountUseCase {
    void execute(AccountDomain domain);
}
