package com.masai.DAO;

import com.masai.Bean.Admin;
import com.masai.Exceptions.AdminException;

public interface AdminDAO {
	
	public Admin AdminLogin(String username, String password)throws AdminException;

}
