package com.ssafy.alcohol.model.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.alcohol.model.dao.FoodDao;
import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class FoodServiceImpl implements FoodService {

	private FoodDao fDao;

	@Autowired
	public FoodServiceImpl(FoodDao fDao) {
		this.fDao = fDao;
	}

	@Override
	public List<Food> searchFood(SearchCondition condition) {
		return fDao.search(condition);
	}

	@Override
	public Food readFood(int id) {
		return fDao.selectOne(id);
	}

	@Override
	public boolean writeFood(Food food) {
		return fDao.insertFood(food) == 1;
	}

	@Override
	public boolean removeFood(int id) {
		return fDao.deleteFood(id) == 1;
	}

	@Override
	public boolean modifyFood(Food food) {
		return fDao.updateFood(food) == 1;
	}

	@Override
	public void updateFood(MultipartFile multipartFile, Food food) {
		if (multipartFile != null && multipartFile.getSize() > 0) {
			try {
				String fileName = multipartFile.getOriginalFilename();
				String fileId = UUID.randomUUID().toString();

				System.out.println("파일 이름: " + fileName);
				System.out.println("파일 크기: " + multipartFile.getSize());

				String[] arr = fileName.split("\\.");
				if (arr.length > 1) {
					food.setImg(fileId + "." + arr[arr.length - 1]);
				} else {
					food.setImg(fileId);
				}
				food.setOrgImg(fileName);

				String uploadDir = System.getProperty("user.dir") + "/uploads/food";
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

				fDao.updateFood(food);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Food> selectAll() {
		return fDao.selectAll();
	}

	@Override
	public boolean likeUp(int id) {
		return fDao.likeUp(id) == 1;
	}

	@Override
	public boolean likeDown(int id) {
		return fDao.likeDown(id) == 1;
	}

	@Override
	public void fileFood(MultipartFile multipartFile, Food food) {
		if (multipartFile != null && multipartFile.getSize() > 0) {
			try {
				String fileName = multipartFile.getOriginalFilename();
				String fileId = UUID.randomUUID().toString();

				System.out.println("파일 이름: " + fileName);
				System.out.println("파일 크기: " + multipartFile.getSize());

				String[] arr = fileName.split("\\.");
				System.out.println(Arrays.toString(arr));
				food.setImg(fileId + "." + arr[arr.length - 1]);
				food.setOrgImg(fileName);

//				Resource resource = resourceLoader.getResource("classpath:/static/img");
//				multipartFile.transferTo(new File(resource.getFile(), fileId));

				// 파일 저장 경로 설정 (시스템 경로)
				String uploadDir = System.getProperty("user.dir") + "/uploads" + "/food";
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

				fDao.insertFood(food);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
