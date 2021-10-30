package controller;

import model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produto>> getAllProdutos () {
        List<Produto> produtos = produtoService.findAllProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Produto> getProdutoById (@PathVariable("id") Long id) {
        Produto produto = produtoService.findProdutoById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }


    @GetMapping("/produtoByNome/{nome}")
    public ResponseEntity<List<Produto>> getProdutoByNome(@PathVariable("nome") String nome) {
        List<Produto> produtos = produtoService.getProdutoByNome(nome);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        Produto updateProduto = produtoService.updateProduto(produto);
        return new ResponseEntity<>(updateProduto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable("id") Long id) {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
