package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import negocio.Artes;
import negocio.Curso;
import negocio.Informatica;
import to.CursoTO;

public class CursoDAO {
	private boolean consulta = false;
	private ResourceBundle bn = null;

	public CursoDAO(ResourceBundle bun) {
		bn = bun;
	}

	public CursoDAO() {
	}

	// gets
	public boolean getConsulta() {
		return consulta;
	}

	public boolean incluir(CursoTO to) {
		boolean sucesso = false;
		String sqlInsert = "INSERT INTO Curso (codigo, area, nome, data_inicio, data_termino, horario, n_vagas, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getCodigo());
			stm.setString(2, to.getArea());
			stm.setString(3, to.getNome());
			stm.setDate(4, to.getDataInicio());
			stm.setDate(5, to.getDataTermino());
			stm.setString(6, to.getHorario());
			stm.setInt(7, to.getNVagas());
			stm.setDouble(8, to.getValor());

			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;

	}

	public boolean incluirInfo(CursoTO to) {
		String sqlInsert = "INSERT INTO Informatica(Curso_codigo_informatica, n_laboratorio, reg_softwares) VALUES (?, ?, ?)";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getCodigo());
			stm.setInt(2, to.getNLaboratorio());
			stm.setString(3, to.getRegSoftware());

			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean incluirAt(CursoTO to) {
		String sqlInsert = "INSERT INTO Artes(Curso_codigo_artes, descricao_material) VALUES (?, ?)";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getCodigo());
			stm.setString(2, to.getDescricaoMaterial());

			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	/*
	 * public boolean consultaSimples(int cod) { boolean existe = false;
	 * 
	 * try { ResultSet rs; String sql = "SELECT * FROM curso WHERE codigo = ?";
	 * st = conn.prepareStatement(sql); st.setInt(1, cod); rs =
	 * st.executeQuery(); if (rs.next()) { existe = true; } else { existe =
	 * false; } st.close(); } catch (Exception e) {
	 * JOptionPane.showMessageDialog(null,
	 * "Erro ao verificar existência, favor contatar o suporte técnico");
	 * e.printStackTrace(); }
	 * 
	 * return existe; }
	 */

	public CursoTO consultar(int area, int codigo) {
		CursoTO to = new CursoTO();

		if (area == 1) {
			to = selectInfo(codigo);
		} else if (area == 2) {
			to = selectArtes(codigo);
		}

		return to;
	}

	public CursoTO selectInfo(int codigo) {
		CursoTO to = new CursoTO();
		String sqlSelect = "SELECT * FROM curso cur "
				+ "INNER JOIN Informatica info ON cur.codigo = info.Curso_codigo_informatica where codigo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setCodigo(rs.getInt("codigo"));
					to.setArea(rs.getString("area"));
					to.setNome(rs.getString("nome"));
					to.setValor(rs.getDouble("valor"));
					to.setDataInicio(rs.getDate("data_inicio"));
					to.setDataTermino(rs.getDate("data_termino"));
					to.setHorario(rs.getString("horario"));
					to.setNVagas(rs.getInt("n_vagas"));
					to.setNLaboratorio(rs.getInt("n_laboratorio"));
					to.setRegSoftware(rs.getString("reg_softwares"));
					consulta = true;

				} else {
					JOptionPane.showMessageDialog(null, "Curso não encontrado");
					consulta = false;
					return null;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao realizar consulta, favor entrar em contato com o suporte técnico");
			e.printStackTrace();
		}
		return to;
	}

	public CursoTO selectArtes(int codigo) {
		CursoTO to = new CursoTO();
		String sqlSelect = "SELECT * FROM curso cur INNER JOIN Artes art ON cur.codigo = art.Curso_codigo_artes where codigo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setCodigo(rs.getInt("codigo"));
					to.setNome(rs.getString("nome"));
					to.setArea("Artes");
					to.setDataInicio(rs.getDate("data_inicio"));
					to.setDataTermino(rs.getDate("data_termino"));
					to.setHorario(rs.getString("horario"));

					to.setNVagas(rs.getInt("n_vagas"));
					to.setValor(rs.getDouble("valor"));
					to.setDescricaoMaterial(rs.getString("descricao_material"));
					consulta = true;

				} else {
					JOptionPane.showMessageDialog(null, "Curso não encontrado");
					consulta = false;
					return null;

				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao realizar consulta, favor entrar em contato com o suporte técnico");
			e.printStackTrace();
		}
		return to;
	}

	public boolean editar(CursoTO to, int cod) {
		boolean sucesso = false;
		if (cod == 1) {
			if (editarInfo(to)) {
				sucesso = true;
			}
		}
		if (cod == 2) {
			if (editarArtes(to)) {
				sucesso = true;
			}
		}
		return sucesso;
	}

	public boolean editarInfo(CursoTO to) {
		String sqlUpdate = "UPDATE curso cur inner join Informatica info on cur.codigo = info.Curso_codigo_informatica SET nome = ?,"
				+ "data_inicio = ?, data_termino = ?, horario = ?, n_vagas = ?, valor = ?, n_laboratorio = ?, reg_softwares = ? WHERE codigo = ?";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setDate(2, to.getDataInicio());
			stm.setDate(3, to.getDataTermino());
			stm.setString(4, to.getHorario());
			stm.setInt(5, to.getNVagas());
			stm.setDouble(6, to.getValor());
			stm.setInt(7, to.getNLaboratorio());
			stm.setString(8, to.getRegSoftware());
			stm.setInt(9, to.getCodigo());
			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar dados, favor entrar em contato com o suporte técnico");
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean editarArtes(CursoTO to) {
		String sqlUpdate = "UPDATE curso cur inner join Artes a on cur.codigo = a.Curso_codigo_artes SET nome = ?,"
				+ "data_inicio = ?, data_termino = ?, horario = ?, n_vagas = ?, valor = ?, descricao_material = ? WHERE codigo = ?";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setDate(2, to.getDataInicio());
			stm.setDate(3, to.getDataTermino());
			stm.setString(4, to.getHorario());
			stm.setInt(5, to.getNVagas());
			stm.setDouble(6, to.getValor());
			stm.setString(7, to.getDescricaoMaterial());
			stm.setInt(8, to.getCodigo());
			stm.execute();

			sucesso = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar dados, favor entrar em contato com o suporte técnico");
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean preencheVaga(int cod, int area) {
		CursoTO to = consultar(area, cod);
		int nvagas = to.getNVagas() - 1;
		String sqlUpdate = "UPDATE curso SET n_vagas = ? WHERE codigo = ?";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, nvagas);
			stm.setInt(2, cod);
			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher vaga, favor entrar em contato com o suporte técnico");
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean liberaVaga(int cod, int area) {
		CursoTO to = consultar(area, cod);
		int nvagas = to.getNVagas() + 1;
		String sqlUpdate = "UPDATE curso SET n_vagas = ? WHERE codigo = ?";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, nvagas);
			stm.setInt(2, cod);
			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher vaga, favor entrar em contato com o suporte técnico");
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean excluir(CursoTO to) {
		boolean sucesso = false;
		String sqlDelete = "DELETE FROM curso WHERE codigo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
			sucesso = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir dados, favor entrar em contato com o suporte técnico");
			e.printStackTrace();
		}
		return sucesso;
	}

	public int[] consultaCursosPorArea(String area) {
		String sqlSelect = "SELECT codigo, n_vagas FROM curso where area = ?";
		ArrayList<Integer> codigo = new ArrayList<Integer>();
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, area);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					int cod = rs.getInt("codigo");
					int numvagas = rs.getInt("n_vagas");
					if (numvagas > 0) {
						codigo.add(cod);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		int[] vetor = new int[codigo.size()];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = codigo.get(i).intValue();
		}
		return vetor;

	}

	public int consultaCursosPorNome(String nome) {
		int codigo = 0000;
		String sqlSelect = "SELECT codigo FROM curso where nome = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, nome);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					codigo = rs.getInt("codigo");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return codigo;
	}

	/*
	 * public String[] consultaCursosInfo() { ArrayList<String> nomes = new
	 * ArrayList<String>(); String[] cursos; try { String cur = "Informatica";
	 * ResultSet rs; String sql =
	 * "SELECT nome, n_vagas FROM curso WHERE area = ?"; st =
	 * conn.prepareStatement(sql); st.setString(1, cur); rs = st.executeQuery();
	 * while (rs.next()) { String name = rs.getString("nome"); int numvagas =
	 * rs.getInt("n_vagas"); if (numvagas > 0) { nomes.add(name); } }
	 * st.close(); } catch (Exception e) { e.printStackTrace();
	 * 
	 * } cursos = nomes.toArray(new String[nomes.size()]); return cursos;
	 * 
	 * }
	 * 
	 * public String[] consultaCursosArtes() { ArrayList<String> nomes = new
	 * ArrayList<String>(); String[] cursos; try { String cur = "Artes";
	 * ResultSet rs; String sql =
	 * "SELECT nome, n_vagas FROM curso WHERE area = ?"; st =
	 * conn.prepareStatement(sql); st.setString(1, cur); rs = st.executeQuery();
	 * while (rs.next()) { String name = rs.getString("nome"); int numvagas =
	 * rs.getInt("n_vagas"); if (numvagas > 0) { nomes.add(name); } }
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * 
	 * } cursos = nomes.toArray(new String[nomes.size()]); return cursos;
	 * 
	 * }
	 */

	public String consultaNome(int cod) {
		String nome = "";
		String sqlSelect = "SELECT * FROM curso WHERE codigo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cod);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					nome = rs.getString("nome");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nome;
	}

}
