package com.serasa.score.apiscore.controller;

import com.serasa.score.apiscore.domain.dto.AfinidadeDTO;
import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.dto.PessoaRequestDTO;
import com.serasa.score.apiscore.domain.dto.ScoreDTO;
import com.serasa.score.apiscore.service.AfinidadeSevice;
import com.serasa.score.apiscore.service.PessoaService;
import com.serasa.score.apiscore.service.ScoreSevice;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ApiModelProperty(value = "[{ 'nome':'Teste', 'telefone': '11111111111'}]")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso no cadastro"),
            @ApiResponse(code = 400, message = "Campos requeridos Faltante"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public void criarPessoa(@RequestBody @Valid PessoaRequestDTO pessoaRequest){
        pessoaService.salvarPessoa(pessoaRequest);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/afinidade")
    @ApiOperation(value = "Cadastra uma afinidade por regiao")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso no cadastro"),
            @ApiResponse(code = 400, message = "Campos requeridos Faltante"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public void criarAfinidade(@RequestBody @Valid AfinidadeDTO afinidadeRequest){
        afinidadeSevice.salvarAfinidade(afinidadeRequest);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/score")
    @ApiOperation(value = "Cadatra um score")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso no cadastro"),
            @ApiResponse(code = 400, message = "Campos requeridos Faltante"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public void criarScore(@RequestBody @Valid ScoreDTO scoreRequest){
        scoreSevice.salvarScore(scoreRequest);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/pessoa/{id}")
    @ApiOperation(value = "Retonar uma pessoa unica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
            @ApiResponse(code = 204, message = "Nenhum item encontrado no banco"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public PessoaDTO recuperarPessoaPorId(@PathVariable Integer id){
        return pessoaService.buscarPessoaPorId(id);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/pessoa")
    @ApiOperation(value = "Retonar uma lista de pessoas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
            @ApiResponse(code = 204, message = "Nenhum item encontrado no banco"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public List<PessoaDTO> recuperarPessoas(){
        return pessoaService.buscarPessoas();
    }
}
