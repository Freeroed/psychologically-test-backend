package ru.vlsu.psytest.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.psytest.service.TestService;
import ru.vlsu.psytest.service.dto.AnswerDTO;
import ru.vlsu.psytest.service.dto.ResultTestDTO;

import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Override
    public ResultTestDTO solveTest(List<AnswerDTO> answers, String username) {
        return null;
    }
}
