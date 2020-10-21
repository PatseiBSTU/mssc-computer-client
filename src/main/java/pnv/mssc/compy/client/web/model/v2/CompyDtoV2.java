package pnv.mssc.compy.client.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompyDtoV2 {

    private UUID id;
    private String compyName;
    private CompyTypeEnum compyStyle;
    private Long upc;
}
