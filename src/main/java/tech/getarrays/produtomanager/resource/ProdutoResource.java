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
    public ResponseEntity<List<Produto>> getAllEmployees () {
        List<Produto> produtos = produtoService.findAllEmployees();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Produto> getEmployeeById (@PathVariable("id") Long id) {
        Produto produto = produtoService.findEmployeeById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    

    @PutMapping("/update")
    public ResponseEntity<Produto> updateEmployee(@RequestBody Produto produto) {
        Produto updateEmployee = produtoService.updateEmployee(produto);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        produtoService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
