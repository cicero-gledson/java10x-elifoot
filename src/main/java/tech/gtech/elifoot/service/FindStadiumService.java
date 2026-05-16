package tech.gtech.elifoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.gtech.elifoot.controller.response.StadiumResponse;
import tech.gtech.elifoot.entity.Stadium;
import tech.gtech.elifoot.mapper.StadiumMapper;
import tech.gtech.elifoot.repository.StadiumRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindStadiumService {
    private final StadiumRepository stadiumRepository;

    public Page<StadiumResponse> findAll(Pageable pageable) {
        return stadiumRepository.findAll(pageable)
                .map(StadiumMapper::toResponse);
    }
}
