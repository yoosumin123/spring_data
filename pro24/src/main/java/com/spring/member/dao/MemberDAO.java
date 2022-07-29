package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.spring.member.vo.MemberVO;


public interface MemberDAO {
	// interface -> 능력(기능)을 알 수 있다.
	// 여기서 빼면 쓸 수 없다.   - interface를 부르는 거니까
	 public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 

}
