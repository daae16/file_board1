package com.file.board.controllder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PageVO;
import com.file.board.vo.PhotoBoardVO;

@Controller
public class PhotoCotroller {
	private PhotoBoardService pbService;

	@RequestMapping(value = "/photo/list", method = RequestMethod.GET)
	public String goList(@ModelAttribute PhotoBoardVO pb ,Model model) {
		if(pb.getPage()==null) {
			pb.setPage(new PageVO());
			pb.getPage().setPageNum(1);
		}
		model.addAttribute("pbList", pbService.selectPhotoBoardList(null));
		return "photo/list";
	}

	@RequestMapping(value = "/photo/write", method = RequestMethod.GET)
	public String goWrite() {
		return "photo/write";

	}

	@RequestMapping(value = "/photo/write", method = RequestMethod.POST)
	public String doWrite(@RequestParam("pbFile") MultipartFile file, @ModelAttribute PhotoBoardVO pb ) {
		pbService.insertPhotoBoard(file, pb);
		return "photo/write";
	}

}
