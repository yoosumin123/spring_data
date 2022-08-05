package com.myspring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.board.vo.ArticleVO;


public interface BoardDAO { // CRUD
	public List selectAllArticlesList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	//public void insertNewImage(Map articleMap) throws DataAccessException;
	
	public ArticleVO selectArticle(int articleNO) throws DataAccessException; //사람찾기
	public void updateArticle(Map articleMap) throws DataAccessException; //갱신
	public void deleteArticle(int articleNO) throws DataAccessException; //삭제
	public List selectImageFileList(int articleNO) throws DataAccessException;
	
}
