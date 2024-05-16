package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dao.NoticeDao;
import com.ssafy.alcohol.model.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao nDao;	
	
	@Override
	public List<Notice> selectAll() {
		// TODO Auto-generated method stub
		return nDao.selectAll();
	}

	@Override
	public Notice detail(int id) {
		// TODO Auto-generated method stub
		return nDao.detail(id);
	}

	@Override
	public int write(Notice notice) {
		// TODO Auto-generated method stub
		return nDao.write(notice);
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return nDao.update(notice);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return nDao.delete(id);
	}

}
