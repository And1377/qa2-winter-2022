package requesters;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import model.Reservation;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TicketsRequester {
    private final String URL = "http://qaguru.lv:8089/tickets/getReservations.php";

    public List<Reservation> getReservations() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForEntity(URL, String.class).getBody();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<Reservation>>() {});
    }
}
