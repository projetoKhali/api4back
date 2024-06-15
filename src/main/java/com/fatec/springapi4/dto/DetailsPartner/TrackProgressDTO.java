package com.fatec.springapi4.dto.DetailsPartner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrackProgressDTO {
    private String trackName;
    private Long expertisesTrack;
    private Long progressExpertises;
    private Long finalizedExpertises;

}
