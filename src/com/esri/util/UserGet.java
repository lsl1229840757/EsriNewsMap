package com.esri.util;

import java.util.Map;

import com.esri.entity.User;
/**
 * 
 * @author ¿ÓÀ…¡Æ
 *
 */
public class UserGet {

	public static User getUser(Map session) {
		Object obj = session.get("user");
		User user = null;
		if(obj!=null&&User.class.isInstance(obj)) {
			user = (User)obj;
		}
		return user;
	}
	
}
