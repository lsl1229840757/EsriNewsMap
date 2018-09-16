package com.esri.interceptor;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.esri.entity.User;
import com.esri.util.UserGet;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Repository
@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();

		Map session = ctx.getSession();

		/*User user = (User) session.get("user");*/
		
		User user = UserGet.getUser(session);
		if (user != null) {
			return invocation.invoke();
		}
		
		ctx.put("tip", "还没有登陆...");
		return Action.LOGIN;
	}

}
