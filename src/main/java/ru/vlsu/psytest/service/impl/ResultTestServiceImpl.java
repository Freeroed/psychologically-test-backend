package ru.vlsu.psytest.service.impl;

import ru.vlsu.psytest.service.ResultTestService;
import ru.vlsu.psytest.domain.ResultTest;
import ru.vlsu.psytest.repository.ResultTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ResultTest}.
 */
@Service
@Transactional
public class ResultTestServiceImpl implements ResultTestService {

    private final Logger log = LoggerFactory.getLogger(ResultTestServiceImpl.class);

    private final ResultTestRepository resultTestRepository;

    public ResultTestServiceImpl(ResultTestRepository resultTestRepository) {
        this.resultTestRepository = resultTestRepository;
    }

    @Override
    public ResultTest save(ResultTest resultTest) {
        log.debug("Request to save ResultTest : {}", resultTest);
        return resultTestRepository.save(resultTest);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResultTest> findAll(Pageable pageable) {
        log.debug("Request to get all ResultTests");
        return resultTestRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ResultTest> findOne(Long id) {
        log.debug("Request to get ResultTest : {}", id);
        return resultTestRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ResultTest : {}", id);
        resultTestRepository.deleteById(id);
    }
}
