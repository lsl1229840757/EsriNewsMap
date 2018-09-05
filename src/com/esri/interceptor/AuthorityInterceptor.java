package com.esri.interceptor;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.esri.entity.User;
import com.esri.util.UserGet;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登陆注册拦截器
 * 
 * @author 胡森
 *
 */
@Repository
@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得ActionContext示例
		ActionContext ctx = invocation.getInvocationContext();

		Map session = ctx.getSession();

		/**
		 *李松廉修改：考虑安全性问题,一般不要直接将类型强制转换
		 */
		/*User user = (User) session.get("user");*/
		
		User user = UserGet.getUser(session);
		if (user != null) {
			System.out.println("拦截器通过!");
			return invocation.invoke();
		}
		
		System.out.println("登陆拦截");
		// 放入数据
		ctx.put("tip", "请先登陆");
		return Action.LOGIN;
	}

}
