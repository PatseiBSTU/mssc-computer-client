package pnv.mssc.compy.services.v2;

import pnv.mssc.compy.web.model.v2.CompyDtoV2;

import java.util.UUID;

public interface CompyServiceV2 {
    CompyDtoV2 getCompyById(UUID compyId) ;

    CompyDtoV2 savedCompy(CompyDtoV2 compyDto);

    void updateCompy(UUID compyId, CompyDtoV2 compyDto);

    void deleteById(UUID compyId);
}
