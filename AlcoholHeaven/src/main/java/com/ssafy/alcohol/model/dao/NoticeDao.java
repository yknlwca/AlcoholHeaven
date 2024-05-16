package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.Notice;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface NoticeDao {
	List<Notice> selectAll();
	Notice detail(int id);
	int write(Notice notice);
	int update(Notice notice);
	int delete(int id);
	List<Notice> search(SearchCondition condition);
}
