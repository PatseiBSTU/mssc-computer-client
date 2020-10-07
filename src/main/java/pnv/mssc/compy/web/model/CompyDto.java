package pnv.mssc.compy.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompyDto {

    private UUID id;
    private String compyName;
    private String compyStyle;
    private Long upc;


}
