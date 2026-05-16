package tech.gtech.elifoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.gtech.elifoot.controller.request.CreateStadiumRequest;
import tech.gtech.elifoot.controller.response.StadiumResponse;
import tech.gtech.elifoot.entity.Stadium;
import tech.gtech.elifoot.mapper.StadiumMapper;
import tech.gtech.elifoot.repository.StadiumRepository;

@Service
@RequiredArgsConstructor
public class CreateStadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumResponse execute(CreateStadiumRequest stadium) {
        Stadium savedStadium = stadiumRepository.save(StadiumMapper.toStadium(stadium));
        return StadiumMapper.toResponse(savedStadium);
    }

}
