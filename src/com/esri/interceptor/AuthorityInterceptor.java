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
 * ��½ע��������
 * 
 * @author ��ɭ
 *
 */
@Repository
@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ȡ��ActionContextʾ��
		ActionContext ctx = invocation.getInvocationContext();

		Map session = ctx.getSession();

		/**
		 *�������޸ģ����ǰ�ȫ������,һ�㲻Ҫֱ�ӽ�����ǿ��ת��
		 */
		/*User user = (User) session.get("user");*/
		
		User user = UserGet.getUser(session);
		if (user != null) {
			System.out.println("������ͨ��!");
			return invocation.invoke();
		}
		
		System.out.println("��½����");
		// ��������
		ctx.put("tip", "���ȵ�½");
		return Action.LOGIN;
	}

}
