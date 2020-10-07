package pnv.mssc.compy.services;

import lombok.extern.slf4j.Slf4j;
import pnv.mssc.compy.web.model.CompyDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CompyServiceImpl implements CompyService {
    @Override
    public CompyDto getCompyById(UUID compyId) {
        return CompyDto.builder().id(UUID.randomUUID())
                .compyName("iCore5")
                .compyStyle("office")
                .build();
    }

    @Override
    public CompyDto savedCompy(CompyDto compyDto) {
        return CompyDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCompy(UUID compyId, CompyDto compyDto) {
        //todo impl - would add a real implamantation
    }

    @Override
    public void deleteById(UUID compyId) {
    log.debug("Delete a coputer...");
    }
}
