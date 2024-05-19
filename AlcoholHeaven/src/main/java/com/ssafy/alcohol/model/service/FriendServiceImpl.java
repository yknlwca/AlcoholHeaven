package com.ssafy.alcohol.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.alcohol.model.dao.FriendDao;
import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class FriendServiceImpl implements FriendService {

	private FriendDao fDao;
	
	@Autowired
	public FriendServiceImpl(FriendDao fDao) {
		this.fDao = fDao;
	}

	@Override
	public List<Friend> searchFriend(SearchCondition condition) {
		return fDao.search(condition);
	}

	@Override
	public Friend readFriend(int id) {
		return fDao.selectOne(id);
	}

	@Override
	public boolean writeFriend(Friend friend) {
		return fDao.insertFriend(friend) == 1;
	}

	@Override
	public boolean removeFriend(int id) {
		return fDao.deleteFriend(id) == 1;
	}

	@Override
	public boolean modifyFriend(Friend friend) {
		return fDao.updateFriend(friend) == 1;
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
	public List<Friend> selectAll() {
		return fDao.selectAll();
	}

	@Override
	public void fileFriend(MultipartFile multipartFile, Friend friend) {
	    if (multipartFile != null && multipartFile.getSize() > 0) {
	        try {
	            String fileName = multipartFile.getOriginalFilename();
	            String fileId = UUID.randomUUID().toString();

	            System.out.println("파일 이름: " + fileName);
	            System.out.println("파일 크기: " + multipartFile.getSize());

	            String[] arr = fileName.split("\\.");
	            if (arr.length > 1) {
	                friend.setImg(fileId + "." + arr[arr.length - 1]);
	            } else {
	                friend.setImg(fileId);
	            }
	            friend.setOrgImg(fileName);

	            System.out.println("Original Image: " + friend.getOrgImg());
	            System.out.println("Generated Image: " + friend.getImg());

	            String uploadDir = System.getProperty("user.dir") + "/uploads" + "/friend";
	            File uploadDirectory = new File(uploadDir);
	            if (!uploadDirectory.exists()) {
	                boolean dirCreated = uploadDirectory.mkdirs();
	                if (dirCreated) {
	                    System.out.println("업로드 디렉토리가 생성되었습니다: " + uploadDir);
	                } else {
	                    System.err.println("업로드 디렉토리 생성에 실패했습니다: " + uploadDir);
	                }
	            }

	            File file = new File(uploadDirectory, fileId+ "." + arr[arr.length - 1]);
	            multipartFile.transferTo(file);

	            fDao.insertFriend(friend);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public void updateFriend(MultipartFile multipartFile, Friend friend) {
		if (multipartFile != null && multipartFile.getSize() > 0) {
			try {
				String fileName = multipartFile.getOriginalFilename();
				String fileId = UUID.randomUUID().toString();

				System.out.println("파일 이름: " + fileName);
				System.out.println("파일 크기: " + multipartFile.getSize());

				String[] arr = fileName.split("\\.");
				if (arr.length > 1) {
					friend.setImg(fileId + "." + arr[arr.length - 1]);
				} else {
					friend.setImg(fileId);
				}
				friend.setOrgImg(fileName);

				String uploadDir = System.getProperty("user.dir") + "/uploads/friend";
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

				fDao.updateFriend(friend);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}


}
