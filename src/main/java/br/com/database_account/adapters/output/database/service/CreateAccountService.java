package br.com.database_account.adapters.output.database.service;

import br.com.database_account.adapters.output.database.entity.AccountEntity;
import br.com.database_account.adapters.output.database.repository.AccountRepository;
import br.com.database_account.application.domain.model.AccountDomain;
import br.com.database_account.application.port.out.ICreateAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAccountService implements ICreateAccountService {

    private final AccountRepository accountRepository;
    private final ObjectMapper mapper;

    @Override
    public void execute(AccountDomain domain) {
        accountRepository.save(mapper.convertValue(domain, AccountEntity.class));
    }
}
