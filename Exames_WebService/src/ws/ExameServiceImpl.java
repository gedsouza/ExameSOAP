package ws;

import java.sql.SQLException;

import bean.Exame;
import dao.ExameDAO;

public class ExameServiceImpl implements ExameService{
	
	private ExameDAO exameDAO = new ExameDAO();
	
	@Override
	public Exame getExame(Long id) throws SQLException{
		return exameDAO.buscarExamePorId(id);
	}
}
