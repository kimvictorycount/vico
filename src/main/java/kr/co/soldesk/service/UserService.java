package kr.co.soldesk.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.repository.UserRepository;

@Service
public class UserService {

	//test

	@Autowired
	private UserRepository userRepository;
	
	@Resource(name = "loginUser")
	private UserBean loginUser;
	
	//회원가입
	public void insertUser(UserBean userBean) {

		userRepository.insertUser(userBean);
	}
	//회원조회(전체)
	public List<UserBean> getUSers(){
		
		return userRepository.getUsers();
	}
	//회원조회(개별)
	public UserBean getUser(String id) {
		
		return userRepository.getUser(id);
	}
	
	//로그인
	public boolean getLoginUser(UserBean user) {
		
		UserBean tempUser =  userRepository.getLoginUser(user);
		
		loginUser.setUser_id(tempUser.getUser_id());
		loginUser.setUser_pass(tempUser.getUser_pass());
		loginUser.setUser_name(tempUser.getUser_name());
		loginUser.setUser_gender(tempUser.getUser_gender());
		loginUser.setUser_job(tempUser.getUser_job());
		loginUser.setUser_address(tempUser.getUser_address());
		loginUser.setLogin(true);
		
		return true;	
	}
	//로그아웃
	public void logout() {
		loginUser.setUser_id(null);
		loginUser.setLogin(false);
	}
	
	public boolean checkUser(String pass) {
		
		String id = loginUser.getUser_id();
		String checkId =  userRepository.checkUser(id,pass);
		
		if (checkId == null) {
			return false;
		}else {
			return true;
		}
	}
	
	//회원탈퇴
	public void deleteUser(String pass) {
		if (checkUser(pass)) {
			userRepository.deleteUser(loginUser.getUser_id());
			logout();
		}
	}
}
