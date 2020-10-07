package pnv.mssc.compy.services.v2;

import org.springframework.stereotype.Service;
import pnv.mssc.compy.web.model.v2.CompyDtoV2;

import java.util.UUID;
@Service
public class CompyServiceV2Impl implements CompyServiceV2 {
    @Override
    public CompyDtoV2 getCompyById(UUID compyId) {
        return null;
    }

    @Override
    public CompyDtoV2 savedCompy(CompyDtoV2 compyDto) {
        return null;
    }

    @Override
    public void updateCompy(UUID compyId, CompyDtoV2 compyDto) {

    }

    @Override
    public void deleteById(UUID compyId) {

    }
}
