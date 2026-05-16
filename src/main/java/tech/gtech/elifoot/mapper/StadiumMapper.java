package tech.gtech.elifoot.mapper;

import tech.gtech.elifoot.controller.request.CreateStadiumRequest;
import tech.gtech.elifoot.controller.response.StadiumResponse;
import tech.gtech.elifoot.entity.Stadium;

public class StadiumMapper {
    public static StadiumResponse toResponse (Stadium stadium) {
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImg())
                .build();
    }

    public static Stadium toStadium (CreateStadiumRequest stadiumResponse) {
        return Stadium.builder()
                .name(stadiumResponse.getName())
                .city(stadiumResponse.getCity())
                .capacity(stadiumResponse.getCapacity())
                .urlImg(stadiumResponse.getUrlImg())
                .build();
    }
}
