package tech.gtech.elifoot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.gtech.elifoot.controller.request.CreateStadiumRequest;
import tech.gtech.elifoot.controller.response.StadiumResponse;
import tech.gtech.elifoot.service.CreateStadiumService;
import tech.gtech.elifoot.service.FindStadiumService;

@RestController
@RequestMapping("/stadiums")
@RequiredArgsConstructor
public class StadiumController {

    private final FindStadiumService findStadiumService;
    private final CreateStadiumService createStadiumService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<StadiumResponse> getAllStadiums(
            @PageableDefault (page=0, size=10) Pageable pageable) {

        int safeSize = Math.max(1, Math.min(pageable.getPageSize(), 100)); // Limita o tamanho da página entre 1 e 100

        Pageable safePageable = PageRequest.of(
                pageable.getPageNumber(),
                safeSize,
                pageable.getSort()
        );

        return findStadiumService.findAll(safePageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse createStadium(@RequestBody CreateStadiumRequest stadiumRequest) {
        return createStadiumService.execute(stadiumRequest);
    }
}
