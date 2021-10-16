package br.com.ifpb.series.modules.episode.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListEpisodeDTO {
    
    private Long id;

    private String name;

    private String time;

    private Boolean watched;
}
