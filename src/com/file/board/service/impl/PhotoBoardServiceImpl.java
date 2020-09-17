package com.file.board.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.impl.PhotoBoardDAOImpl;
import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PageVO;
import com.file.board.vo.PhotoBoardVO;

public class PhotoBoardServiceImpl implements PhotoBoardService {
 
	private PhotoBoardDAOImpl pbdao;
	private final String uploadPath = "C:\\java_study\\eclipse\\photo_board\\WebContent\\resources";
	
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		String orgFileName = file.getOriginalFilename();
		String extName = orgFileName.substring(orgFileName.lastIndexOf("."));
		String fileName = System.nanoTime() + extName;
		pb.setPbPhotoName(orgFileName);
		pb.setPbPhotoPath(fileName);
		int cnt = pbdao.insertPhotoBoard(file,pb);
		if(cnt==1) {
			File f = new File(uploadPath + fileName);
			try {
				file.transferTo(f);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb,Model model) {
		PageVO page = pb.getPage();
		page.setPageNum(1);
		
		int startNum = (page.getPageNum()-1) * 10 + 1;
		int endNum = startNum + (10-1);
		
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		int totalCnt = pbdao.selectPhotoBoardCount(pb);
		pb.setPage(page);
		page.setTotalCnt(totalCnt);
		int totalPageSize = totalCnt/10;
		int startBlock = (page.getPageNum()-1) /10 * 10 + 1;
		int endBlock = startBlock + (10-1);
		if(endBlock>totalPageSize) {
			endBlock = totalPageSize;
		}
		
		model.addAttribute("pbList",pbdao.selectPhotoBoardList(pb));
		
		return null;
	}

}
