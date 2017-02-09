package com.genomichealth.online_emea.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.genomichealth.online_emea.domain.FormReport;
import com.genomichealth.online_emea.domain.User;
import com.genomichealth.online_emea.exception.GHIException;
import com.genomichealth.online_emea.repository.criteria.FormReportCriteria;
import com.genomichealth.online_emea.service.FormReportService;
import com.genomichealth.online_emea.service.util.UserLoggedService;
import com.genomichealth.online_emea.web.rest.dto.FormReportDTO;
import com.genomichealth.online_emea.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * REST controller for managing FormReport.
 */
@RestController
@RequestMapping("/api")
public class FormReportResource {

    private final Logger log = LoggerFactory.getLogger(FormReportResource.class);

    @Inject
    private UserLoggedService userLoggedService;

    @Inject
    private FormReportService formReportService;

    
    @RequestMapping(value = "/form-reports", // Noncompliant {{Unsecured Request Mapping, the request mapping should be associated with a @Secured annotation.}}
            method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE) 
    @Timed
    public ResponseEntity<FormReportDTO> createFormReport(@Valid @RequestBody FormReportDTO formReportDTO) throws URISyntaxException {

    }

    
    @RequestMapping(value = "/form-reports", // Noncompliant {{Unsecured Request Mapping, the request mapping should be associated with a @Secured annotation.}}
            method = RequestMethod.PUT,
            produces = APPLICATION_JSON_VALUE) 
    @Timed
    public ResponseEntity<FormReportDTO> updateFormReport(@Valid @RequestBody FormReportDTO formReportDTO) throws URISyntaxException {

    }

    
    @RequestMapping(value = "/form-reports",// Noncompliant {{Unsecured Request Mapping, the request mapping should be associated with a @Secured annotation.}}
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE) 
    @Timed
    public List<FormReportDTO> getAllFormReports(@ModelAttribute(value = "criteria") FormReportCriteria formReportCriteria) {
        return null;
    }

    
    @RequestMapping(value = "/form-reports/{id}", // Noncompliant {{Unsecured Request Mapping, the request mapping should be associated with a @Secured annotation.}}
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE) 
    @Timed
    public ResponseEntity<FormReportDTO> getFormReport(@PathVariable Long id) {
        return null;
    }

    
    @RequestMapping(value = "/form-reports/{id}.pdf",// Noncompliant {{Unsecured Request Mapping, the request mapping should be associated with a @Secured annotation.}}
            method = RequestMethod.GET,
            produces = "application/pdf") 
    @Timed
    public void getFormReportFile(@PathVariable Long id, HttpServletResponse httpServletResponse) throws IOException, GHIException {
    }

    
    @RequestMapping(value = "/form-reports/{id}", // Noncompliant {{Unsecured Request Mapping, the request mapping should be associated with a @Secured annotation.}}
            method = RequestMethod.DELETE,
            produces = APPLICATION_JSON_VALUE) 
    @Timed
    public ResponseEntity<Void> deleteFormReport(@PathVariable Long id) {
        return null;
    }


    
    @RequestMapping(value = "/users", 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE) 
    @Timed
    @Transactional(readOnly = true)
    @Secured(AuthoritiesConstants.ROLE_GHI_CS)
    public ResponseEntity<List<ManagedUserDTO>> getAllUsers(Pageable pageable, @ModelAttribute UserCriteria userCriteria)
            throws URISyntaxException {

        return null;
    }

}
