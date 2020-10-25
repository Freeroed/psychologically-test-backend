package ru.vlsu.psytest.service.impl;

import ru.vlsu.psytest.service.QuestionTypeService;
import ru.vlsu.psytest.domain.QuestionType;
import ru.vlsu.psytest.repository.QuestionTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link QuestionType}.
 */
@Service
@Transactional
public class QuestionTypeServiceImpl implements QuestionTypeService {

    private final Logger log = LoggerFactory.getLogger(QuestionTypeServiceImpl.class);

    private final QuestionTypeRepository questionTypeRepository;

    public QuestionTypeServiceImpl(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public QuestionType save(QuestionType questionType) {
        log.debug("Request to save QuestionType : {}", questionType);
        return questionTypeRepository.save(questionType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionType> findAll() {
        log.debug("Request to get all QuestionTypes");
        return questionTypeRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<QuestionType> findOne(Long id) {
        log.debug("Request to get QuestionType : {}", id);
        return questionTypeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete QuestionType : {}", id);
        questionTypeRepository.deleteById(id);
    }
}
