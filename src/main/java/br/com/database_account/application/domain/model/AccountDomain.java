package br.com.database_account.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDomain {
    private String id;
    private String name;
    private String email;
    private String cpf;
    private String password;
}
