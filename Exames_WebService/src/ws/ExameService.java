package ws;

import java.sql.SQLException;

import bean.Exame;

public interface ExameService {
	
	public Exame getExame(Long id) throws SQLException;

}
