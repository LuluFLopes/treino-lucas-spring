package br.com.twinsbakery.financeiro.controller;

import br.com.twinsbakery.financeiro.model.Produto;
import br.com.twinsbakery.financeiro.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    public final ProdutoService produtoService;


    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping("/salvar")
    public void salvarProduto(@RequestBody Produto produto) {
        produtoService.salvarProduto(produto);
    }

    @GetMapping("/listar")
    @ResponseBody
    public ResponseEntity<List<Produto>> listarProduto() {

        List<Produto> produtos = produtoService.listarProdutos();
        if (!produtos.isEmpty()) {
            return ResponseEntity.ok(produtos);
        }

        return ResponseEntity.notFound().build();
    }

}
