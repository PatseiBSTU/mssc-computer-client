package pnv.mssc.compy.services;

import pnv.mssc.compy.web.model.CompyDto;

import java.util.UUID;


public interface CompyService {
    CompyDto getCompyById(UUID compyId);

    CompyDto savedCompy(CompyDto compyDto);

    void updateCompy(UUID compyId, CompyDto compyDto);

    void deleteById(UUID compyId);
}
