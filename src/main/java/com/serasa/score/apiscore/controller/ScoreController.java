package com.serasa.score.apiscore.controller;

import com.serasa.score.apiscore.domain.dto.AfinidadeDTO;
import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.dto.ScoreDTO;
import com.serasa.score.apiscore.service.AfinidadeSevice;
import com.serasa.score.apiscore.service.PessoaService;
import com.serasa.score.apiscore.service.ScoreSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("serasa")
public class ScoreController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private AfinidadeSevice afinidadeSevice;

    @Autowired
    private ScoreSevice scoreSevice;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/pessoa")
    public void criarPessoa(@RequestBody PessoaDTO pessoaRequest){
        pessoaService.salvarPessoa(pessoaRequest);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/afinidade")
    public void criarAfinidade(@RequestBody AfinidadeDTO afinidadeRequest){
        afinidadeSevice.salvarAfinidade(afinidadeRequest);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/score")
    public void criarScore(@RequestBody ScoreDTO scoreRequest){
        scoreSevice.salvarScore(scoreRequest);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/pessoa/{id}")
    public PessoaDTO recuperarPessoa(@PathVariable Integer id){
        return pessoaService.buscarPessoaPorId(id);

    }
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/pessoa")
    public List<PessoaDTO> recuperarPessoas(){
        return pessoaService.buscarPessoas();
    }
}
