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

    
    



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getTaxa() {
		return taxa;
	}



	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getPreco() {
		return preco;
	}



	public void setPreco(String preco) {
		this.preco = preco;
	}



	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", taxa=" + taxa + ", descricao=" + descricao + ", preco="
				+ preco + "]";
	}
    

   
}
