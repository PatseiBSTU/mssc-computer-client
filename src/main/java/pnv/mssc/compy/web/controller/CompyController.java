package pnv.mssc.compy.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import pnv.mssc.compy.services.CompyService;
import pnv.mssc.compy.web.model.CompyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


@RequestMapping("/api/v1/compy")
@RestController
public class CompyController {

    private final CompyService compyService;

    public CompyController(CompyService compyService) {

        this.compyService = compyService;
    }

    @GetMapping({"/{compyId}"})
    public ResponseEntity<CompyDto> getCompy(@PathVariable("compyId") UUID compyId){

        return new ResponseEntity<>(compyService.getCompyById(compyId), HttpStatus.OK);
    }

    @PostMapping // POST - create new
    public ResponseEntity handlePost (@RequestBody CompyDto compyDto){

        CompyDto savedDto =  compyService.savedCompy(compyDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/compy/" + savedDto.getId().toString());
        return  new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping ("/{compyId}")
    public ResponseEntity handleUpdate (@PathVariable("compyId") UUID compyId, @RequestBody CompyDto compyDto){
        compyService.updateCompy(compyId, compyDto);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{/compyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteCompy(@PathVariable("compyId") UUID compyId){
        compyService.deleteById(compyId);

    }

}
