package tech.getarrays.produtomanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nome;
    private String taxa;
    private String descricao;
    private String preco;


	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", taxa=" + taxa + ", descricao=" + descricao + ", preco="
				+ preco + "]";
	}
    

   
}
