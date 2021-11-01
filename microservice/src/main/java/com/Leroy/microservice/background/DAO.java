package com.Leroy.microservice.background;

import com.Leroy.microservice.model.Produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * classe DAO (data access object) responsavel pela persistencia dos dados presentes no arquivo
 * de leitura  carregado na clase SheetLoad
 */
public class DAO {

    /**arreglo que contem todos os produtos almacenados no arquivo
     *
     */
    LinkedList<Produto> fila;
    //Conexion con = new Conexion();

    /**
     * constructor da clase DAO que chama o metodo upload responsavel pela persistencia
     */
    public DAO(LinkedList<Produto> stock) {
        this.fila = stock;
        upload(stock);
    }

    /**
     * metodo sem retorno, encarregado pela persistencia de dados toma um elemento statico
     * da classe conexion e inserta uma Query determinada pela propiedad do tipo string sql
     * faz um varrido no linkedlist com os produtos e asigna os getter na declaracao da query sql
     * finalmente fecha a conecao do tipo estatico
     *
     * @param stock
     */
    public void upload(LinkedList<Produto> stock) {

        int rs = 0;

        String sql ="INSERT INTO produto (id, descricao, nome, preco, taxa) VALUES (?, ?, ?, ?, ?)";

        for(Produto unidad: stock) {

            System.out.println(unidad.getNome()+"avarejo");

            //adiciona en la tabla

            try (PreparedStatement ps =Conexion.getConexion().prepareStatement(sql)){
                ps.setLong(1, unidad.getId());
                ps.setString(2, unidad.getDescricao());
                ps.setString(3, unidad.getNome());
                ps.setString(4, unidad.getPreco());
                ps.setString(5, unidad.getTaxa());

                rs=ps.executeUpdate();

            }catch(Exception e) {
                System.out.println("erro ao insertar valor");

            }
            finally{
                try {
                    Conexion.getConexion().close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }/*cerrar la conexion*/
            }
        }
    }
}


