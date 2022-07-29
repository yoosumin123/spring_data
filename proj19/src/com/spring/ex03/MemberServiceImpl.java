package com.spring.ex03;

public class MemberServiceImpl implements MemberService{

	// 주입되는 빈을 저장할 MemeberDAO 타입 속성 선언
	//      클래스를    변수로 선언
	private MemberDAO memberDAO;
	
	// 설정파일에서 memberDAO 빈을 생성한 후 set으로 속성 memberDAO에 주입
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMembers() {
	//  DAO 클래스에 있는 메소드 호출 (콘솔에 출력하는)
		memberDAO.listMembers();
		
	}	
}
