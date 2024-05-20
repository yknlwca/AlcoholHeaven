package com.ssafy.alcohol.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.alcohol.model.dao.AlcoholDao;
import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class AlcoholServiceImpl implements AlcoholService {

	private final AlcoholDao alDao;

	@Autowired
	public AlcoholServiceImpl(AlcoholDao alDao) {
		this.alDao = alDao;
	}

	@Override
	public List<Alcohol> searchBoard(SearchCondition condition) {
		return alDao.search(condition);
	}

	@Override
	public Alcohol readAlcohol(int id) {
		return alDao.selectOne(id);
	}

	@Override
	public boolean writeAlcohol(Alcohol alcohol) {
		return alDao.insertAlcohol(alcohol) == 1;
	}

	@Override
	public boolean removeAlcohol(int id) {
		return alDao.deleteAlcohol(id) == 1;
	}

	@Override
	public List<Alcohol> selectAlcohol(String region) {
		// TODO Auto-generated method stub
		return alDao.selectAlcohol(region);
	}

	@Override
	public List<Alcohol> selectAll() {
		return alDao.selectAll();
	}

	@Override
	public boolean modifyAlcohol(Alcohol alcohol) {
		return alDao.updateAlcohol(alcohol) == 1;
	}

	@Override
	public boolean likeUp(int id) {
		return alDao.likeUp(id) == 1;
	}

	@Override
	public boolean likeDown(int id) {
		return alDao.likeDown(id) == 1;
	}

	@Override
	public void fileAlcohol(MultipartFile multipartFile, Alcohol alcohol) {
		if (multipartFile != null && multipartFile.getSize() > 0) {
			try {
				String fileName = multipartFile.getOriginalFilename();
				String fileId = UUID.randomUUID().toString();

				String[] arr = fileName.split("\\.");
				alcohol.setImg(fileId + "." + arr[arr.length - 1]);
				alcohol.setOrgImg(fileName);

				String uploadDir = System.getProperty("user.dir") + "/uploads" + "/alcohol";
				File uploadDirectory = new File(uploadDir);
				if (!uploadDirectory.exists()) {
					boolean dirCreated = uploadDirectory.mkdirs(); // 디렉토리가 존재하지 않으면 생성
					if (dirCreated) {
						System.out.println("업로드 디렉토리가 생성되었습니다: " + uploadDir);
					} else {
						System.err.println("업로드 디렉토리 생성에 실패했습니다: " + uploadDir);
					}
				}

				File file = new File(uploadDirectory, fileId + "." + arr[arr.length - 1]);
				multipartFile.transferTo(file);

				alDao.insertAlcohol(alcohol);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateAlcohol(MultipartFile multipartFile,Alcohol alcohol) {
		if (multipartFile != null && multipartFile.getSize() > 0) {
			try {
				String fileName = multipartFile.getOriginalFilename();
				String fileId = UUID.randomUUID().toString();

				System.out.println("파일 이름: " + fileName);
				System.out.println("파일 크기: " + multipartFile.getSize());

				String[] arr = fileName.split("\\.");
				if (arr.length > 1) {
					alcohol.setImg(fileId + "." + arr[arr.length - 1]);
				} else {
					alcohol.setImg(fileId);
				}
				alcohol.setOrgImg(fileName);

				String uploadDir = System.getProperty("user.dir") + "/uploads/alcohol";
				File uploadDirectory = new File(uploadDir);
				if (!uploadDirectory.exists()) {
					boolean dirCreated = uploadDirectory.mkdirs(); // 디렉토리가 존재하지 않으면 생성
					if (dirCreated) {
						System.out.println("업로드 디렉토리가 생성되었습니다: " + uploadDir);
					} else {
						System.err.println("업로드 디렉토리 생성에 실패했습니다: " + uploadDir);
					}
				}

				File file = new File(uploadDirectory, fileId + "." + arr[arr.length - 1]);
				multipartFile.transferTo(file);

				alDao.updateAlcohol(alcohol);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
