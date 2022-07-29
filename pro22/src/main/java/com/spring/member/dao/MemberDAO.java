package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;


public interface MemberDAO {
	public List selectAllMembers() throws DataAccessException ; // 전체 멤버 보기
	public int addMember(MemberVO memberVO) throws DataAccessException ; // 삽입하기

}
