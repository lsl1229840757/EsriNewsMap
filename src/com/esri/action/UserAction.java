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
//配置多例
@Scope("prototype")

@Repository
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	public UserAction() {
		super();
	}

	private HttpServletRequest req = ServletActionContext.getRequest();
	private Map<String,Object> session = ActionContext.getContext().getSession();
	
	
	/**
	 * 李松廉修改：用一个类的方法来实现空值的校验,这里用得更多的话，可以考虑用工具类来实现
	 * @return 空就返回true，不空就返回false
	 */
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
	// 注册用
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
	/**
	 * 登陆界面
	 * 
	 * @return
	 */
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

		// 用户名不能为空
		if (checknull(user.getUsername())) {
			super.addFieldError("username", "用户名不能为空!");
		}
		// 密码不能为空
		if (checknull(user.getPassword())) {
			super.addFieldError("password", "密码不能为空!");
		}
		// 验证码不能为空
		if (checknull(checkCode)) {
			super.addFieldError("checkCode", "验证码不能为空!");
		}
		// 验证码输入是否正确
		if (!checkCode.equals(checkCode2)) {
			super.addFieldError("checkCode", "验证码输入错误!");
		}
		// 检验用户密码和用户名是否匹配
		if (!us.findLogin(user)) {
			System.out.println(user);
			super.addFieldError("username", "用户名或密码错误!!");
		}
	}

	
	/**
	 * 用户注册
	 * 
	 */
	public void excuteAjax() {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html");
		String username = req.getParameter("username");
		System.out.println(username);
		Map<String, String> map = new HashMap<String, String>();

		// 检验用户是否已被注册
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
		/**
		 * 李松廉修改：注册成功之后也要把用户存到session中。
		 */
		session.put("user", user);
		session.put("msg", "注册成功!");
		return super.SUCCESS;
	}

	public void validateRegist() {
		System.out.println(checkCode);
		System.out.println(checkCode2);

		// 用户名不能为空
		if (checknull(user.getUsername())) {
			super.addFieldError("username", "用户名不能为空!");
		}
		// 昵称不能为空
		if (checknull(user.getName())) {
			super.addFieldError("name", "昵称不能为空!");
		}
		// 年龄不能为空
		if (checknull(this.age)) {
			super.addFieldError("age", "年龄不能为空!");
		}
		// 年龄应该是数字(0~100)
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
		// 密码不能为空
		if (checknull(this.password)) {
			super.addFieldError("password", "密码不能为空!");
		}
		// 确认密码不能为空
		if (checknull(this.password2)) {
			super.addFieldError("password2", "密码不能为空!");
		}
		// 两次密码是否一致
		if (!password.equals(password2)) {
			super.addFieldError("password", "两次密码输入不一致!");
		}
		// 验证码不能为空
		if (checknull(checkCode)) {
			super.addFieldError("checkCode", "验证码不能为空!");
		}
		// 验证码输入是否正确
		if (!checkCode.equals(checkCode2)) {
			super.addFieldError("checkCode", "验证码输入错误!");
		}

	}

	/**
	 * 用户信息界面
	 * 
	 * @return
	 */
	public String userInfo() {
		return super.SUCCESS;
	}

	/**
	 * 进入修改信息界面
	 */
	public String enterChange() {
		return super.SUCCESS;
	}

	/**
	 * 修改信息
	 */
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

		// 昵称不能为空
		if (checknull(user.getName())) {
			super.addFieldError("name", "昵称不能为空!");
		}
		// 年龄不能为空
		if (checknull(this.age)) {
			super.addFieldError("age", "年龄不能为空!");
		}
		// 年龄应该是数字(0~100)
		try {
			int age = Integer.parseInt(this.age);
			if (age > 100 || age < 1) {
				super.addFieldError("age", "年龄必须在0~100之间!");
			}
		} catch (NumberFormatException e) {
			super.addFieldError("age", "输入格式不正确!");
		}
		// 验证码不能为空
		if (checknull(checkCode)) {
			super.addFieldError("checkCode", "验证码不能为空!");
		}
		// 验证码输入是否正确
		if (!checkCode.equals(checkCode2)) {
			super.addFieldError("checkCode", "验证码输入错误!");
		}
	}
	
	public String entermap() {
		return SUCCESS;
	}
	
}
