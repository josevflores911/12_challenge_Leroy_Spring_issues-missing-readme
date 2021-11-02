package com.Leroy.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Classe que gera o modelo que sera enviado na tavela de dados
 *
 * aplicacao de anotacoes Lombok para a constroccao de getters e setters e
 * constructores com todos os argumentos e  sem argumentos assim como
 * builder para a instanciacao de novos objetos
 *
 * a interface Serializable permite a um objeto ser transformado,
 * em uma cadeia de bytes e desta forma pode ser manipulado de maneira mais fácil
 *
 * @author Jose Viera
 * @version 1.1
 *
 */
@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    /**
     *   declaraçao das variaveis que posee a base de dados
     *   se aplicaram anotacoes spring de autoincremento,id e no NULL para o id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String nome;
    private String taxa;
    private String descricao;
    private String preco;
}
