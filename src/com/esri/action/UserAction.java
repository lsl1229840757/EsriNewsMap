package com.esri.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.esri.entity.User;
import com.esri.service.UserService;
import com.esri.util.UserGet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")

@Repository
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	public UserAction() {
		super();
	}

	private HttpServletRequest req = ServletActionContext.getRequest();
	private Map<String,Object> session = ActionContext.getContext().getSession();
	
	
	public boolean checknull(String str) {
		if(str==null||"".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	
	private User user = new User();

	@Resource
	private UserService us;

	private String checkCode2 = CreateImageAction.checkCode;

	private String checkCode;
	private String password;

	static String primitive;

	private String age;

	private String password2;

	public String getPrimitive() {
		return primitive;
	}
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String enterLogin() {
		return super.SUCCESS;
	}
	public String login() {
		primitive = user.getPassword();
		System.out.println(primitive);
		user = us.findUserByUserName(user.getUsername());
		System.out.println(user);
		session.put("user", user);
		return super.SUCCESS;
	}

	public void validateLogin() {
		System.out.println(checkCode);
		System.out.println(checkCode2);

		if (checknull(user.getUsername())) {
			super.addFieldError("username", "用户名不能为空!");
		}
		if (checknull(user.getPassword())) {
			super.addFieldError("password", "密码不能为空!");
		}
		if (checknull(checkCode)) {
			super.addFieldError("checkCode", "验证码不能为空!");
		}
		if (!checkCode.toLowerCase().equals(checkCode2.toLowerCase())) {
			super.addFieldError("checkCode", "验证码输入错误!");
		}
		if (!us.findLogin(user)) {
			System.out.println(user);
			super.addFieldError("username", "用户名或密码错误!!");
		}
	}

	public void excuteAjax() {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html");
		String username = req.getParameter("username");
		System.out.println(username);
		Map<String, String> map = new HashMap<String, String>();

		if (us.findUserByUserName(username) != null) {
			map.put("username", "该用户名已经被使用!");
			map.put("error", "1");
		}else {
			map.put("username", "该用户名未被使用!");
			map.put("error", "0");
		}
		JSONObject json = new JSONObject(map);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String enterRegist() {
		return super.SUCCESS;
	}
	public String regist() {
		user.setPassword(password);
		user.setAge(Integer.parseInt(this.age));
		us.add(user);
		session.put("user", user);
		session.put("msg", "注册成功!");
		return super.SUCCESS;
	}

	public void validateRegist() {
		System.out.println(checkCode);
		System.out.println(checkCode2);

		if (checknull(user.getUsername())) {
			super.addFieldError("username", "用户名不能为空!");
		}
		if (checknull(user.getName())) {
			super.addFieldError("name", "昵称不能为空!");
		}
		if (checknull(this.age)) {
			super.addFieldError("age", "年龄不能为空!");
		}
		try {
			int age = Integer.parseInt(this.age);
			if (age > 100 || age < 1) {
				super.addFieldError("age", "年龄必须在0~100之间!");
			}
		} catch (NumberFormatException e) {
			super.addFieldError("age", "输入格式不正确!");
		}

		System.out.println(password);
		System.out.println(password2);
		if (checknull(this.password)) {
			super.addFieldError("password", "密码不能为空!");
		}
		if (checknull(this.password2)) {
			super.addFieldError("password2", "密码不能为空!");
		}
		if (!password.equals(password2)) {
			super.addFieldError("password", "两次密码输入不一致!");
		}
		if (checknull(checkCode)) {
			super.addFieldError("checkCode", "验证码不能为空!");
		}
		if (!checkCode.toLowerCase().equals(checkCode2.toLowerCase())) {
			super.addFieldError("checkCode", "验证码输入错误!");
		}

	}

	public String userInfo() {
		return super.SUCCESS;
	}

	public String enterChange() {
		return super.SUCCESS;
	}

	public String changeInfo() {
		User userold = UserGet.getUser(session);
		if(userold!=null&&userold.getPassword()!=null&&userold.getUsername()!=null) {
			user.setAge(Integer.parseInt(this.age));
			user.setUsername(userold.getUsername());
			user.setPassword(userold.getPassword());
			us.update(user);
			session.put("user", user);
		}else {
			return super.ERROR;
		}
		return super.SUCCESS;
	}

	public void validateChangeInfo() {
		System.out.println(checkCode);
		System.out.println(checkCode2);

		if (checknull(user.getName())) {
			super.addFieldError("name", "昵称不能为空!");
		}
		if (checknull(this.age)) {
			super.addFieldError("age", "年龄不能为空!");
		}
		try {
			int age = Integer.parseInt(this.age);
			if (age > 100 || age < 1) {
				super.addFieldError("age", "年龄必须在0~100之间!");
			}
		} catch (NumberFormatException e) {
			super.addFieldError("age", "输入格式不正确!");
		}
		if (checknull(checkCode)) {
			super.addFieldError("checkCode", "验证码不能为空!");
		}
		if (!checkCode.toLowerCase().equals(checkCode2.toLowerCase())) {
			super.addFieldError("checkCode", "验证码输入错误!");
		}
	}
	
	public String entermap() {
		return SUCCESS;
	}
	
}
