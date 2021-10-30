package controller;

import model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProdutoService;

import java.util.List;


/**
 *
 * classe controller encarregada de receber a url e o json (no caso do update) utilizando as propriedades
 * de spring con as anotacoes Restcontrolle, requestMapping, getMapping e path mapping para aplicar os
 * metodos da classe de servicos
 *
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    /**
     * instaciacao mediante constructo da classe servicos
     */
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * metodo do tipo rest controller get que chama todos o valores na tavela de dados
     * e retorna um estado indicando o resultado da pesquisa
     *
     * @return ResponseEntity
     */
    @GetMapping("/all")
    public ResponseEntity<List<Produto>> getAllProdutos () {
        List<Produto> produtos = produtoService.findAllProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    /**
     *
     * metodo do tipo rest controller get que chama todos o valores na tavela de dados contendo o id
     * indicado na url
     *
     * @param id
     *
     * @return ResponseEntity
     *
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Produto> getProdutoById (@PathVariable("id") Long id) {
        Produto produto = produtoService.findProdutoById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    /**
     *
     * metodo do tipo rest controller get que chama todos o valores na tavela de dados contendo o nome
     * exacto como foi registrado
     *
     * @param nome
     *
     * @return ResponseEntity
     */
    @GetMapping("/produtoByNome/{nome}")
    public ResponseEntity<List<Produto>> getProdutoByNome(@PathVariable("nome") String nome) {
        List<Produto> produtos = produtoService.getProdutoByNome(nome);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    /**
     * metodo do tipo rest controller put que chama todos o valores na tavela de dados contendo o id
     * e aplica o metodo updateProduto da classe service para poder alterar o valor e gerar a persistencia
     *
     * @param produto
     *
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        Produto updateProduto = produtoService.updateProduto(produto);
        return new ResponseEntity<>(updateProduto, HttpStatus.OK);
    }

    /**
     * metodo do tipo rest controller delete que chama todos o valores na tavela de dados contendo o id
     * e aplica o metodo delete dos services e retorna um estado depois de eliminar o valor
     *
     * @param id
     *
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable("id") Long id) {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
