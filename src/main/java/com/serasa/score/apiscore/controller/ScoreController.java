package com.serasa.score.apiscore.controller;

import com.serasa.score.apiscore.domain.dto.AfinidadeDTO;
import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.dto.ScoreDTO;
import com.serasa.score.apiscore.service.AfinidadeSevice;
import com.serasa.score.apiscore.service.PessoaService;
import com.serasa.score.apiscore.service.ScoreSevice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("serasa")
@Api(value = "API REST Cadastro Pessoa Score")
@CrossOrigin(origins = "*")
public class ScoreController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private AfinidadeSevice afinidadeSevice;

    @Autowired
    private ScoreSevice scoreSevice;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/pessoa")
    @ApiOperation(value = "Cadastra uma pessoa")
    @ApiModelProperty(example = "[{ 'nome':'Teste', 'telefone': '11111111111'}]")
    public void criarPessoa(@RequestBody PessoaDTO pessoaRequest){
        pessoaService.salvarPessoa(pessoaRequest);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/afinidade")
    @ApiOperation(value = "Cadastra uma afinidade por regiao")
    public void criarAfinidade(@RequestBody AfinidadeDTO afinidadeRequest){
        afinidadeSevice.salvarAfinidade(afinidadeRequest);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/score")
    @ApiOperation(value = "Cadatra um score")
    public void criarScore(@RequestBody ScoreDTO scoreRequest){
        scoreSevice.salvarScore(scoreRequest);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/pessoa/{id}")
    @ApiOperation(value = "Retonar uma pessoa unica")
    public PessoaDTO recuperarPessoaPorId(@PathVariable Integer id){
        return pessoaService.buscarPessoaPorId(id);

    }
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/pessoa")
    @ApiOperation(value = "Retonar uma lista de pessoas cadastradas")
    public List<PessoaDTO> recuperarPessoas(){
        return pessoaService.buscarPessoas();
    }
}
