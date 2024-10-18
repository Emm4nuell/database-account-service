package br.com.database_account.adapters.util;

import br.com.database_account.adapters.exception.JsonParsingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ParseStringJson<T> {

    private final ObjectMapper mapper;

    public T converter(String message, Class<T> type){
        try {
            JsonNode json = mapper.readTree(message);
            String domainjson = json.get("Message").asText();
            return mapper.readValue(domainjson, type);
        } catch (JsonProcessingException ex) {
            throw new JsonParsingException("Erro ao converter message em JSON." + ex.getMessage());
        }
    }
}
