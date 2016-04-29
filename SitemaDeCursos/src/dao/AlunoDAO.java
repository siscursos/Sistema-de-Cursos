package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionBDFactory;
import to.AlunoTO;

public class AlunoDAO
{
	public void cadastrar(AlunoTO to)
	{
		String sql = "INSERT INTO Aluno(cpf, nome,endereco,telefone,email,rg) VALUES (?,?,?,?,?,?)";
		try (Connection conn = ConnectionBDFactory.obtemConexao(); PreparedStatement st = conn.prepareStatement(sql);)
		{
			st.setString(1, to.getcPF());
			st.setString(2, to.getNome());
			st.setString(3, to.getEndereco());
			st.setString(4, to.getTelefone());
			st.setString(5, to.getEmail());
			st.setString(6, to.getrG());
			
			st.execute();
			
			
			//cadastrarUsuario(to);
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setcPF(rs.getString("cpf"));
					}
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}
	
	/*public void cadastrarUsuario(AlunoTO to){
		String sql = "INSERT INTO SisAcesso(cpf, tipo_usuario, login, senha) VALUES (?,?,?,?)";
		try (Connection conn = ConnectionBDFactory.obtemConexao(); PreparedStatement st = conn.prepareStatement(sql);)
		{
			st.setString(1, to.getcPF());
			st.setInt(2, 2);
			st.setString(3, to.getUser());
			st.setString(4, to.getSenha());
			
			st.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	public AlunoTO consultar(String cpf)
	{
		AlunoTO to = new AlunoTO();

		String sqlSelect = "SELECT * FROM aluno WHERE cpf = ?";

		try (Connection conn = ConnectionBDFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);)
		{
			st.setString(1, cpf);
			try (ResultSet rs = st.executeQuery();)
			{
				if (rs.next())
				{
					to.setNome(rs.getString("nome"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setrG(rs.getString("rg"));
					to.setcPF(rs.getString("cpf"));
					to.setUser("teste");
					to.setSenha("teste2");
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		} catch (SQLException e1)
		{
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public boolean excluir(String cpf)
	{
		boolean sucesso = false;
		String sqlDelete = "DELETE FROM aluno WHERE cpf = ?";
		
		try (Connection conn = ConnectionBDFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, cpf);
			stm.execute();
			
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sucesso;
	}
	
	public boolean alterar(AlunoTO to)
	{
		boolean sucesso = false;
		String sqlUpdate = "UPDATE aluno SET nome = ?, endereco = ?, telefone = ?, email = ?, rg = ?, cpf = ?, user = ?, pass = ? WHERE cpf = ?";
		try (Connection conn = ConnectionBDFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getEndereco());
			st.setString(3, to.getTelefone());
			st.setString(4, to.getEmail());
			st.setString(5, to.getrG());
			st.setString(6, to.getcPF());
			//st.setString(7, to.getUser());
			//st.setString(8, to.getSenha());
			st.setString(9, to.getcPF());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sucesso;
	}
	
}
