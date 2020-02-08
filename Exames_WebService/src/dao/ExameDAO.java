package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Exame;
import connection.ConnectionFactory;


public class ExameDAO {

	Connection connection = new ConnectionFactory().getConnection();

	public Exame buscarExamePorId(Long id) throws SQLException {
		try {
			Exame exame = new Exame();

			String sql = "select * from exames where id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				exame.setId(Long.parseLong(rs.getString("id")));
				exame.setNome(rs.getString("nome"));
				exame.setEmail(rs.getString("email"));
				exame.setTelefone(rs.getString("telefone"));
				exame.setEndereco(rs.getString("endereco"));
				exame.setCpf(rs.getString("cpf"));
				exame.setTpExame(rs.getString("exame"));
				exame.setData(rs.getString("data"));
				exame.setSituacao(rs.getString("situacao"));
				exame.setRetorno(rs.getString("retorno"));
			}

			rs.close();
			connection.close();

			return exame;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
