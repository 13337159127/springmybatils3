package com.kexin.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.kexin.user.entity.UserEntity;

@Repository(value="userDao")
public class UserDao extends SqlSessionDaoSupport {

	/**
	 * 查询用户名和密码（登录用户）
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 返回查询用户名和密码，返回判断登录成功，失败
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String, String>> findUserName(String username, String password) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		return this.getSqlSession().selectList("com.kexin.user.dao.UserDao.findUserName", map);
	}

	/**
	 * 根据用户名返回用户的ID （添加商品信息）
	 * 
	 * @param loginName
	 *            用户名
	 * @return 根据用户名查询用户的ID，返回用户的ID（添加商品信息使用）
	 * @throws Exception
	 *             抛出异常
	 */
	public String getUserId(String loginName) throws Exception {
		return this.getSqlSession().selectOne("com.kexin.user.dao.UserDao.getUserId", loginName);
	}

	/**
	 * 查询用户信息
	 * 
	 * @return 返回查询用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List findUser() throws Exception {
		return this.getSqlSession().selectList("com.kexin.user.dao.UserDao.findUser");
	}

	/**
	 * 添加用户信息
	 * 
	 * @param userId
	 *            用户名ID
	 * @param loginName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 返回添加用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int addUserName(String userId, String loginName, String passWord) throws Exception {
		UserEntity userEntity = new UserEntity();
		userEntity.setLoginName(loginName);
		userEntity.setPassWord(passWord);
		userEntity.setUserId(userId);
		return this.getSqlSession().insert("com.kexin.user.dao.UserDao.addUserName", userEntity);
	}

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return 返回根据ID查询的用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List getUserbyId(String userId) throws Exception {
		return this.getSqlSession().selectList("com.kexin.user.dao.UserDao.getUserbyId", userId);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @param loginName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 返回修改的用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int updateUserName(String userId, String loginName, String passWord) throws Exception {
		UserEntity userEntity = new UserEntity();
		userEntity.setLoginName(loginName);
		userEntity.setPassWord(passWord);
		userEntity.setUserId(userId);
		return this.getSqlSession().insert("com.kexin.user.dao.UserDao.updateUserName", userEntity);
	}

	/**
	 * 根据ID删除用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return 根据ID删除用户的信息，返回删除用户
	 * @throws Exception
	 *             抛出异常
	 */
	public int DeleteUserName(String userId) throws Exception {
		return this.getSqlSession().delete("com.kexin.user.dao.UserDao.DeleteUserName", userId);
	}
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
