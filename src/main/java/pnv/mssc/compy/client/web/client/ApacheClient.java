package pnv.mssc.compy.client.web.client;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pnv.mssc.compy.client.web.model.CompyDto;
import pnv.mssc.compy.client.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

    @Component
    @ConfigurationProperties(prefix = "spf.my.compy", ignoreUnknownFields = false)
    public class ApacheClient {

        public final String COMPY_PATH_V1 = "/api/v1/compy/";
        public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
        private String apihost;

        private final RestTemplate restTemplate;

        public ApacheClient(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder.build();
        }

        public CompyDto getCompyById(UUID uuid){
            return restTemplate.getForObject(apihost + COMPY_PATH_V1 + uuid.toString(), CompyDto.class);
        }

        public URI saveNewCompy(CompyDto compyDto){
            return restTemplate.postForLocation(apihost + COMPY_PATH_V1, compyDto);
        }

        public void updateCompy(UUID uuid, CompyDto compyDto){
            restTemplate.put(apihost + COMPY_PATH_V1  + uuid, compyDto);
        }

        public void deleteCompy(UUID uuid){
            restTemplate.delete(apihost + COMPY_PATH_V1 + uuid );
        }

        public void setApihost(String apihost) {
            this.apihost = apihost;
        }

        public CustomerDto getCustomerById(UUID customerId) {
            return restTemplate.getForObject(apihost+ CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
        }

        public URI saveNewCustomer(CustomerDto customerDto) {
            return  restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
        }

        public void updateCustomer(UUID customerId, CustomerDto customerDto) {
            restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId, customerDto);
        }

        public void deleteCustomer(UUID customerId) {
            restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
        }
    }

