package Spring.Studey.Test.board.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import Spring.Studey.Test.board.VO.BoardVO;

public interface BoardDAO {

	List<Map<String, Object>> list()throws DataAccessException;

	BoardVO detail(int bno) throws DataAccessException;

}
