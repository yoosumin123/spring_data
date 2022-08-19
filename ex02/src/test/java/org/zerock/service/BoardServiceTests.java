package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//Java 설정을 사용하는 경우 
//@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	@Test
	public void testExist() {

		log.info(service);
		assertNotNull(service);
	}

	@Test
	public void testRegister() {

		BoardVO board = new BoardVO();
		board.setTitle("서비스가 작성");
		board.setContent("서비스가 작성한 내용");
		board.setWriter("myservice");

		service.register(board);

		log.info("생성된 게시물의 번호:" + board.getBno());
	}

	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testGet() {

		log.info(service.get(1L));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목 수정합니다");
		log.info("MODIFY RESULT:" + service.modify(board));
	}
	
	@Test
	public void testDelete() {
		
		// 게시물 번호의 존재 여부를 확인하고 테스트할 것
		log.info("REMOVE RESULT:" + service.remove(2L));
	}
}