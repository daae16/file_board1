package com.file.board.vo;

import lombok.Data;

@Data
public class PhotoBoardVO {

	int pbNum;
	
	String pbTitle;
	String pbContent;
	String pbPhotoName;
	String pbPhotoPath;
	String credat;
	String cretim;
	private PageVO page;
}
