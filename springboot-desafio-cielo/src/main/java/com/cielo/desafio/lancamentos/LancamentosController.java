package com.cielo.desafio.lancamentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("lancamentos")
public class LancamentosController {

    @Autowired
    private LancamentosServiceImpl lancamentos;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<String> obterLancamentos() {
        try {
            String json = lancamentos.obterLancamentos();
            return new ResponseEntity<>(json, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}