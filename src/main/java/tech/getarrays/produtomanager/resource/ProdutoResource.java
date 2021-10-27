package tech.getarrays.produtomanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.getarrays.produtomanager.model.Produto;
import tech.getarrays.produtomanager.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
    private final ProdutoService produtoService;

    public ProdutoResource(ProdutoService produtoService) {
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
