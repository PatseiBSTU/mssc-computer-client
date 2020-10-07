package pnv.mssc.compy.web.controller.v2;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pnv.mssc.compy.services.CompyService;
import pnv.mssc.compy.services.v2.CompyServiceV2;
import pnv.mssc.compy.web.model.CompyDto;
import pnv.mssc.compy.web.model.v2.CompyDtoV2;

import java.util.UUID;

@RequestMapping("/api/v2/compy")
@RestController
public class CompyControllerV2 {

    private final CompyServiceV2 compyServiceV2;

    public CompyControllerV2(CompyServiceV2 compyServiceV2) {
        this.compyServiceV2 = compyServiceV2;
    }

    @GetMapping({"/{compyId}"})
    public ResponseEntity<CompyDtoV2> getCompy(@PathVariable("compyId") UUID compyId){

        return new ResponseEntity<>(compyServiceV2.getCompyById(compyId), HttpStatus.OK);
    }

    @PostMapping // POST - create new
    public ResponseEntity handlePost (@RequestBody CompyDtoV2 compyDto){

        CompyDtoV2 savedDto =  compyServiceV2.savedCompy(compyDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/api/v1/compy/" + savedDto.getId().toString());
        return  new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping ("/{compyId}")
    public ResponseEntity handleUpdate (@PathVariable("compyId") UUID compyId, @RequestBody CompyDtoV2 compyDto){
        compyServiceV2.updateCompy(compyId, compyDto);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{/compyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteCompy(@PathVariable("compyId") UUID compyId){
        compyServiceV2.deleteById(compyId);

    }


}
