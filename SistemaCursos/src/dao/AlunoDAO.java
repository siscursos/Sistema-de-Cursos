package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.AlunoTO;

public class AlunoDAO {
	
	public void incluir(AlunoTO to) {
		String sqlInsert = "insert into aluno (nome, endereco, telefone, email, rg, cpf, user, pass) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEnd());
			stm.setString(3, to.getTel());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getCpf());
			stm.setString(7, to.getUser());
			stm.setString(8, to.getPass());
			stm.execute();
			/*String sqlSelect = "SELECT LAST_INSERT_ID() as id";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setId(rs.getInt("id"));
					}
			}*/
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE aluno SET nome=?, endereco=?, telefone=?, email=?, rg=?, cpf=?, user=?, pass=? WHERE cpf=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEnd());
			stm.setString(3, to.getTel());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getCpf());
			stm.setString(7, to.getUser());
			stm.setString(8, to.getPass());
			stm.setString(9, to.getCpf());
			stm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM aluno WHERE cpf = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, to.getCpf());
			stm.execute();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	public AlunoTO carregar(String cpf) {
		AlunoTO to = new AlunoTO();
		to.setCpf(cpf);
		String sqlSelect = "SELECT nome, endereco, telefone, email, rg, cpf, user, pass FROM aluno WHERE cpf = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cpf);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setEnd(rs.getString("endereco"));
					to.setEmail(rs.getString("email"));
					to.setTel(rs.getString("telefone"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
					to.setUser(rs.getString("user"));
					to.setPass(rs.getString("pass"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return to;
	}
}
