package ru.vlsu.psytest.service.impl;

import ru.vlsu.psytest.service.AnswerService;
import ru.vlsu.psytest.domain.Answer;
import ru.vlsu.psytest.repository.AnswerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Answer}.
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final Logger log = LoggerFactory.getLogger(AnswerServiceImpl.class);

    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer save(Answer answer) {
        log.debug("Request to save Answer : {}", answer);
        return answerRepository.save(answer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Answer> findAll() {
        log.debug("Request to get all Answers");
        return answerRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Answer> findOne(Long id) {
        log.debug("Request to get Answer : {}", id);
        return answerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Answer : {}", id);
        answerRepository.deleteById(id);
    }
}
