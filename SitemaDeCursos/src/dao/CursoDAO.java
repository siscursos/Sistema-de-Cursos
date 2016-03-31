package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionBDFactory;
import to.CursoTO;

public class CursoDAO
{
	public boolean cadastrar(CursoTO to)
	{
		boolean sucesso = false;
		String sql = "INSERT INTO curso (idCurso, nome, dataInicio, dataTermino, hora, vagas, valor) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionBDFactory.obtemConexao(); PreparedStatement st = conn.prepareStatement(sql);)
		{
			st.setInt(1, to.getIdCurso());
			st.setString(2, to.getNome());
			st.setString(3, to.getDataInicio());
			st.setString(4, to.getDataTermino());
			st.setString(5, to.getHora());
			st.setInt(6, to.getVagas());
			st.setDouble(7, to.getValor());

			st.execute();

			sucesso = true;
		} catch (Exception e)
		{

			e.printStackTrace();
		}

		return sucesso;
	}

	public CursoTO consultar(int id)
	{
		CursoTO to = new CursoTO();

		String sqlSelect = "SELECT * FROM curso WHERE idCurso = ?";

		try (Connection conn = ConnectionBDFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);)
		{
			st.setInt(1, id);

			try (ResultSet rs = st.executeQuery();)
			{
				if (rs.next())
				{
					to.setIdCurso(rs.getInt("idcurso"));
					to.setNome(rs.getString("nome"));
					to.setDataInicio(rs.getString("datainicio"));
					to.setDataTermino(rs.getString("dataterminar"));
					to.setHora(rs.getString("hora"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("valor"));
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

	public boolean excluir(int id)
	{
		boolean sucesso = false;
		String sqlDelete = "DELETE FROM curso WHERE idCurso = ?";
		
		try (Connection conn = ConnectionBDFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
			
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sucesso;
	}

	public boolean alterar(CursoTO to)
	{
		boolean sucesso = false;
		String sqlUpdate = "UPDATE aluno SET nome = ?, endereco = ?, telefone = ?, email = ?, rg = ?, cpf = ? WHERE cpf = ?";
		try (Connection conn = ConnectionBDFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);)
		{
			st.setInt(1, to.getIdCurso());
			st.setString(2, to.getNome());
			st.setString(3, to.getDataInicio());
			st.setString(4, to.getDataTermino());
			st.setString(5, to.getHora());
			st.setInt(6, to.getVagas());
			st.setDouble(7, to.getValor());
			st.execute();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return sucesso;
	}
}
