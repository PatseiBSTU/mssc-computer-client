package pnv.mssc.compy.client.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pnv.mssc.compy.client.web.model.CompyDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompyClientTest {

//    @Autowired
//    CompyClient client;

    @Autowired
    ApacheClient client;

    @Test
    void getCompyById() {
        CompyDto dto = client.getCompyById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewCompyTest(){
        CompyDto compyDto = CompyDto.builder().compyName("Lenovo").build();
        URI uri = client.saveNewCompy(compyDto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCompyTest(){
        //given
        CompyDto compyDto = CompyDto.builder().compyName("Lenovo 23/2").build();
        client.updateCompy(UUID.randomUUID(), compyDto);
    }
//    @Test
//    void deleteCoyTest(){
//        client.deleteCompy(UUID.randomUUID());
//    }
}