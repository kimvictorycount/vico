package kr.co.soldesk.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.mapper.UserMapper;

@Repository
public class UserRepository {
	
	@Autowired
	private UserMapper userMapper;
	
	//회원가입
	public void insertUser(UserBean userBean) {
		
		userMapper.insertUser(userBean);
	}
	//회원조회(전체)
	public List<UserBean> getUsers(){
		
		return userMapper.getUsers();
	}
	//회원조회(개별)
	public UserBean getUser(String id) {
		return userMapper.getUser(id);
	}
	
	//로그인
	public UserBean getLoginUser(UserBean user) {
		return userMapper.getLoginUser(user);
	}
	
	//회원확인
	public String checkUser(String id, String pass) {
		
		return"userMapper.checkUser(id,pass)";
	}
	//회원삭제
	public void deleteUser(String id) {
		userMapper.deleteUser(id);

	}
}
