package com.spring.ex04;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader); // 섹션 활성화
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}

	public MemberVO selectMemberById(String id){
	      sqlMapper=getInstance();
	SqlSession session=sqlMapper.openSession();
	      MemberVO memberVO=session.selectOne("mapper.member.selectMemberById",id);
	      return memberVO;		
	   }

	public List<MemberVO> selectMemberByPwd(int pwd) {
	sqlMapper = getInstance();
	SqlSession session = sqlMapper.openSession();
	List<MemberVO> membersList = null;
	membersList= session.selectList("mapper.member.selectMemberByPwd", pwd);
	return membersList;
	}

	public int insertMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = 0;
		                       // 실행하고자 하는 SQL문의 ID   // SQL문으로 전달할 데이터 
	// SQL문으로 전달할 데이터 = <insert> 태그의 parameterType 속성의 데이터 타입인 MemberVO 클래스
		result = session.insert("mapper.member.insertMember", memberVO);
		session.commit();
		return result;
	}
	public int insertMember2(Map<String,String> memberMap){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        int result= result=session.insert("mapper.member.insertMember2",memberMap);
        session.commit();	
        return result;		
	}

	public int updateMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.update("mapper.member.updateMember", memberVO);
		session.commit();
		return result;
	}   

	
    public int deleteMember(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = 0;
		result = session.delete("mapper.member.deleteMember", id);
		session.commit();
		return result;
    } 
    
    public List<MemberVO>  searchMember(MemberVO  memberVO){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
                                      // member.xml과 연결됨 // memberVO -> 데이터가 1개
        List list=session.selectList("mapper.member.searchMember",memberVO);
        return list;		
    } 

    public List<MemberVO>  foreachSelect(List nameList){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        List list=session.selectList("mapper.member.foreachSelect",nameList);
        return list;		
    }
    
    public int  foreachInsert(List memList){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        int result = session.insert("mapper.member.foreachInsert",memList);
        session.commit();
        return result ;		
     }
    
    
    public List<MemberVO>  selectLike(String name){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        List list=session.selectList("mapper.member.selectLike",name);
        return list;		
    }


}
