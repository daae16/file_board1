package com.file.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.PhotoBoardDAO;
import com.file.board.vo.PhotoBoardVO;

public class PhotoBoardDAOImpl implements PhotoBoardDAO {

	@Autowired
	public SqlSessionFactory ssf;
	
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.insert("insertPhoto",pb);
		}
	}

	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectList("selectPhotoList",pb);
		}
	}

	@Override
	public int selectPhotoBoardCount(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectList("", pb);
		}
	}

}
