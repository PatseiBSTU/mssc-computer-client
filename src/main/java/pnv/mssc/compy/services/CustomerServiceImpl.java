package pnv.mssc.compy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pnv.mssc.compy.web.model.CustomerDto;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Ksenia Petrova")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
       //totdo impl
    }

    @Override
    public void deletById(UUID customerId) {
        //todo impl
        log.debug("Deleting .....");
    }
}
