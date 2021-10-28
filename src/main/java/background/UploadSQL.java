package background;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import tech.getarrays.produtomanager.model.Produto;



public class UploadSQL {
	
	LinkedList<Produto> fila = new  LinkedList<Produto>();
	//Conexion con = new Conexion();
	
	public UploadSQL(LinkedList<Produto> stock) {
		this.fila = stock;
		accion(stock);
	}
	

	public void accion(LinkedList<Produto> stock) {
		
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
