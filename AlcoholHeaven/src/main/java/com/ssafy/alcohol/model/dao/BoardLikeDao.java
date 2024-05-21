package com.ssafy.alcohol.model.dao;

import com.ssafy.alcohol.model.dto.boardLike;

public interface BoardLikeDao {
	//내가 좋아요 했는데 확인용
	boardLike select(boardLike boardLike);
	//좋아요
	int insert(boardLike boardLike);
	//좋아요 취소
	int delete(boardLike boardLike);
	//좋아요 개수
	int likeCnt(int type, int boardId);
	boardLike selectByType(int type);
}
