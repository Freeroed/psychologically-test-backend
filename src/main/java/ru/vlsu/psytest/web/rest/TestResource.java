package ru.vlsu.psytest.web.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.psytest.service.TestService;
import ru.vlsu.psytest.service.dto.AnswerDTO;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestResource {
    private final Logger log = LoggerFactory.getLogger(AnswerResource.class);


    private final TestService testService;

    public TestResource(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/test/solve")
    public ResponseEntity SolveTest(List<AnswerDTO> answers) {
        log.debug("REST request to solve test");
        return ResponseEntity.ok("Функция ещё не реализована");
    }
}
