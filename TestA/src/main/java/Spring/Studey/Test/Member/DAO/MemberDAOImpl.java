package Spring.Studey.Test.Member.DAO;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import Spring.Studey.Test.Member.Controller.MemberController;
import Spring.Studey.Test.Member.VO.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	@Override
	public int insertMember(MemberVO memberVO)throws DataAccessException{
		int result = sqlSession.insert("mapper.member.insertMember",memberVO);
		return result;
	}
	
	//id 중복검사
	@Override
	public int idCheck(String id)throws DataAccessException{
		int result = sqlSession.selectOne("mapper.member.idCheck",id);
		return result;
	}
	
	//login
	@Override
	public MemberVO login(MemberVO memberVO)throws DataAccessException{
		MemberVO member = (MemberVO)sqlSession.selectOne("mapper.member.login",memberVO);
		return member;
	}
	
	//info
	@Override
	public MemberVO MemberInfo()throws DataAccessException{
		return sqlSession.selectOne("mapper.member.MemberInfo");
	}
	
	//modify
	@Override
	public void MemberModify_info(MemberVO memberVO)throws DataAccessException{
		sqlSession.update("mapper.member.MemberModify_info",memberVO);
	}
	
	//modify(비번)
	@Override
	public void MemberModify_info_pw(MemberVO memberVO)throws DataAccessException{
		sqlSession.update("mapper.member.MemberModify_info_pw",memberVO);
	}
}
