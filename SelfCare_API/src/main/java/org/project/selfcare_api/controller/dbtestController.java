package org.project.selfcare_api.controller;

import org.project.selfcare_api.service.dbtest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class dbtestController {

    private final dbtest dbtest;

    public dbtestController(dbtest dbtest) {
        this.dbtest = dbtest;
    }

    @GetMapping("/database")
    public String testDatabase() {
      return   dbtest.testConnection();
    }

}
