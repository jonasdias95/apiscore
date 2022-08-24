package com.serasa.score.apiscore.controller;

import com.serasa.score.apiscore.domain.dto.AfinidadeDTO;
import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.dto.ScoreDTO;
import com.serasa.score.apiscore.domain.model.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("serasa")
public class ScoreController {
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/pessoa")
    public void criarPessoa(@RequestBody PessoaDTO pessoaRequest){

    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/afinidade")
    public void criarAfinidade(@RequestBody AfinidadeDTO afinidadeRequest){

    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/score")
    public void criarScore(@RequestBody ScoreDTO scoreRequest){

    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping("/pessoa/{id}")
    public void recuperarPessoa(@PathVariable Integer id){

    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping("/pessoa/")
    public void recuperarPessoas(){

    }
}