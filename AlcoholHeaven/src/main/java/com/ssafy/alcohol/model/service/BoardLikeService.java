package com.ssafy.alcohol.model.service;

import com.ssafy.alcohol.model.dto.boardLike;

public interface BoardLikeService {
	boardLike select(boardLike boardLike);
	
	// 좋아요
	int insert(boardLike boardLike);

	// 좋아요 취소
	int delete(boardLike boardLike);

	// 좋아요 개수
	int likeCnt(int type, int boardId);
}
