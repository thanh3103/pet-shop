package com.website.springmvc.signup;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

import com.website.springmvc.DAO.MyUserAccountDAO;
import com.website.springmvc.entities.User;

public class MyConnectionSignUp implements ConnectionSignUp {

	private MyUserAccountDAO myUserAccountDAO;
	
	public MyConnectionSignUp(MyUserAccountDAO myUserAccountDAO) {
		this.myUserAccountDAO = myUserAccountDAO;
	}
	
	// Sau khi đăng nhập mạng xã hội xong.
	// Phương thức này sẽ được gọi để tạo ra một bản ghi User_Account tương ứng
	// nếu nó chưa tồn tại.
	@Override
	public String execute(Connection<?> connection) {
		User account = myUserAccountDAO.createUserAccount(connection);
		return String.valueOf(account.getId());
	}
	
}
