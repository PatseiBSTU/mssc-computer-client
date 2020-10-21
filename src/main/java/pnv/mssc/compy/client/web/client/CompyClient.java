package pnv.mssc.compy.client.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pnv.mssc.compy.client.web.model.CompyDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties (prefix = "spf.compy", ignoreUnknownFields = false)
public class CompyClient {

    public final String COMPY_PATH_V1 = "/api/v1/compy/";
    private String apihost;

    private final RestTemplate restTemplate;

    public CompyClient(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    public CompyDto getCompyById (UUID uuid){
        return restTemplate.getForObject(apihost+ COMPY_PATH_V1 + uuid.toString(), CompyDto.class);
    }

    public URI saveNewCompy (CompyDto compyDto){
      return  restTemplate.postForLocation(apihost + COMPY_PATH_V1, compyDto);
    }

    public void updateCompy (UUID uuid, CompyDto compyDto){
        restTemplate.put(apihost + COMPY_PATH_V1 + uuid.toString(), compyDto);
    }

    public void deleteCompy(UUID uuid){
        restTemplate.delete(apihost + COMPY_PATH_V1 + uuid.toString());
    }
    public void setApihost(String apihost){
        this.apihost = apihost;
    }
}
