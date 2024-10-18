package br.com.database_account.application.usecase;

import br.com.database_account.application.domain.model.AccountDomain;
import br.com.database_account.application.port.in.ICreateAccountUseCase;
import br.com.database_account.application.port.out.ICreateAccountService;
import br.com.database_account.infrastructure.usecase.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final ICreateAccountService iCreateAccountService;

    @Override
    public void execute(AccountDomain domain) {
        iCreateAccountService.execute(domain);
    }
}
