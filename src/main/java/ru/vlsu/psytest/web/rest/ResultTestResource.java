package ru.vlsu.psytest.web.rest;

import ru.vlsu.psytest.domain.ResultTest;
import ru.vlsu.psytest.service.ResultTestService;
import ru.vlsu.psytest.web.rest.errors.BadRequestAlertException;
import ru.vlsu.psytest.service.dto.ResultTestCriteria;
import ru.vlsu.psytest.service.ResultTestQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link ru.vlsu.psytest.domain.ResultTest}.
 */
@RestController
@RequestMapping("/api")
public class ResultTestResource {

    private final Logger log = LoggerFactory.getLogger(ResultTestResource.class);

    private static final String ENTITY_NAME = "resultTest";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResultTestService resultTestService;

    private final ResultTestQueryService resultTestQueryService;

    public ResultTestResource(ResultTestService resultTestService, ResultTestQueryService resultTestQueryService) {
        this.resultTestService = resultTestService;
        this.resultTestQueryService = resultTestQueryService;
    }

    /**
     * {@code POST  /result-tests} : Create a new resultTest.
     *
     * @param resultTest the resultTest to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resultTest, or with status {@code 400 (Bad Request)} if the resultTest has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/result-tests")
    public ResponseEntity<ResultTest> createResultTest(@RequestBody ResultTest resultTest) throws URISyntaxException {
        log.debug("REST request to save ResultTest : {}", resultTest);
        if (resultTest.getId() != null) {
            throw new BadRequestAlertException("A new resultTest cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResultTest result = resultTestService.save(resultTest);
        return ResponseEntity.created(new URI("/api/result-tests/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /result-tests} : Updates an existing resultTest.
     *
     * @param resultTest the resultTest to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resultTest,
     * or with status {@code 400 (Bad Request)} if the resultTest is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resultTest couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/result-tests")
    public ResponseEntity<ResultTest> updateResultTest(@RequestBody ResultTest resultTest) throws URISyntaxException {
        log.debug("REST request to update ResultTest : {}", resultTest);
        if (resultTest.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ResultTest result = resultTestService.save(resultTest);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resultTest.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /result-tests} : get all the resultTests.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resultTests in body.
     */
    @GetMapping("/result-tests")
    public ResponseEntity<List<ResultTest>> getAllResultTests(ResultTestCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ResultTests by criteria: {}", criteria);
        Page<ResultTest> page = resultTestQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /result-tests/count} : count all the resultTests.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/result-tests/count")
    public ResponseEntity<Long> countResultTests(ResultTestCriteria criteria) {
        log.debug("REST request to count ResultTests by criteria: {}", criteria);
        return ResponseEntity.ok().body(resultTestQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /result-tests/:id} : get the "id" resultTest.
     *
     * @param id the id of the resultTest to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resultTest, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/result-tests/{id}")
    public ResponseEntity<ResultTest> getResultTest(@PathVariable Long id) {
        log.debug("REST request to get ResultTest : {}", id);
        Optional<ResultTest> resultTest = resultTestService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resultTest);
    }

    /**
     * {@code DELETE  /result-tests/:id} : delete the "id" resultTest.
     *
     * @param id the id of the resultTest to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/result-tests/{id}")
    public ResponseEntity<Void> deleteResultTest(@PathVariable Long id) {
        log.debug("REST request to delete ResultTest : {}", id);
        resultTestService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
