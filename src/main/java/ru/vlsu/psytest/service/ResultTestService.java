package ru.vlsu.psytest.service;

import ru.vlsu.psytest.domain.ResultTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ResultTest}.
 */
public interface ResultTestService {

    /**
     * Save a resultTest.
     *
     * @param resultTest the entity to save.
     * @return the persisted entity.
     */
    ResultTest save(ResultTest resultTest);

    /**
     * Get all the resultTests.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ResultTest> findAll(Pageable pageable);


    /**
     * Get the "id" resultTest.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ResultTest> findOne(Long id);

    /**
     * Delete the "id" resultTest.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
