package kr.co.soldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.soldesk.beans.UserBean;

@Mapper
public interface UserMapper {

	//회원가입
	@Insert("insert into test_user "
			+ "(user_id, user_pass, user_name, user_age, user_gender, user_job,"
			+ "user_address) values(#{user_id}, #{user_pass}, #{user_name}, "
			+ "#{user_age}, #{user_gender}, #{user_job}, #{user_address})")
	void insertUser(UserBean userBean);
	
	//전체 회원 조회
	@Select("select * from test_user")
	List<UserBean> getUsers();
	
	//개별 회원 조회
	@Select("select * from test_user where user_id = #{id}")
	UserBean getUser(String id);
	
	//로그인
	@Select("select * from test_user "
			+ "where user_id = #{user_id} and user_pass = #{user_pass}")
	UserBean getLoginUser(UserBean user);
	
	//회원확인
	@Select("SELECT user_id FROM test_user"
			+ " where user_id =#{id} and user_pass = #{pass}")
	String checkUser(@Param("id") String id, @Param("pass") String pass);
	
	//회원삭제
	@Delete("delete from test_user where user_id = #{id}")
	void deleteUser(@Param("id") String id);
}
