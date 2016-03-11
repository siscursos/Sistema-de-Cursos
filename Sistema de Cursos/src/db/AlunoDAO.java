package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import to.AlunoTO;

public class AlunoDAO {
	private boolean consulta = false;
	private ResourceBundle bn = null;

	public AlunoDAO(ResourceBundle bun) {
		bn = bun;
	}

	public boolean getConsulta() {
		return consulta;
	}

	public boolean incluir(AlunoTO to) {
		boolean sucesso = false;
		String sqlInsert = "INSERT INTO aluno (cpf, nome, endereco, telefone, email, rg) VALUES (?, ?, ?, ?, ?, ?)";
		String sqlInsert2 = "INSERT INTO SisAcesso(Aluno_cpf, tipo_usuario, login, senha) VALUES (?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);
				PreparedStatement stm2 = conn.prepareStatement(sqlInsert2);) {
			stm.setString(1, to.getCPF());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getEndereco());
			stm.setString(4, to.getTelefone());
			stm.setString(5, to.getEmail());
			stm.setString(6, to.getRG());
			stm2.setString(1, to.getCPF());
			stm2.setInt(2, 1);
			stm2.setString(3, to.getLogin());
			stm2.setString(4, to.getSenha());
			stm.execute();
			stm2.execute();
			sucesso = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de inclusão, favor contatar o suporte técnico");
			e.printStackTrace();
		}
		return sucesso;

	}

	public boolean consultaExistAluno(AlunoTO to) {
		boolean existe = false;
		String sqlSelect = "SELECT * FROM aluno WHERE cpf = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, to.getCPF());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					existe = true;
				} else {
					existe = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	public boolean consultaExistLogin(AlunoTO to) {
		boolean existe = false;
		String sqlSelect = "SELECT * FROM SisAcesso WHERE login = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, to.getLogin());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					existe = true;
				} else {
					existe = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	public AlunoTO consultar(String cpf) {
		AlunoTO to = new AlunoTO();
		String sqlSelect = "SELECT * FROM aluno al INNER JOIN sisacesso sa ON al.cpf = sa.aluno_cpf where cpf = ?;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cpf);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setCPF(rs.getString("cpf"));
					to.setNome(rs.getString("nome"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRG(rs.getString("rg"));
					to.setLogin(rs.getString("login"));
					to.setSenha(rs.getString("senha"));
					consulta = true;

				} else {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado");
					consulta = false;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return to;
	}

	public boolean editar(AlunoTO to) {
		String sqlUpdate = "UPDATE aluno al inner join sisAcesso sa on al.cpf = sa.Aluno_cpf SET nome = ?,"
				+ "endereco = ?, telefone = ?, email = ?, rg = ?, login = ?, senha = ? WHERE cpf = ?";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRG());
			stm.setString(6, to.getLogin());
			stm.setString(7, to.getSenha());
			stm.setString(8, to.getCPF());
			stm.execute();
			sucesso = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM aluno WHERE cpf = ?";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, to.getCPF());
			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}
}
