package br.com.database_account.adapters.input.messaging;

import br.com.database_account.adapters.util.ParseStringJson;
import br.com.database_account.application.domain.model.AccountDomain;
import br.com.database_account.application.port.in.ICreateAccountUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SqsConsumerService {

    private final ICreateAccountUseCase iCreateAccountUseCase;
    @Value("${aws.queue-arn}")
    private String queue;

    private final ObjectMapper mapper;
    private final ParseStringJson<AccountDomain> parseStringJson;

    @SqsListener(queueNames = "${aws.queue-arn}")
    public void receiverMessage(@Payload String message){
        AccountDomain domain = parseStringJson.converter(message, AccountDomain.class);
        iCreateAccountUseCase.execute(domain);
    }

}
