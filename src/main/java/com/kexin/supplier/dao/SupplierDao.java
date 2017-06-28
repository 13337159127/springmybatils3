package com.kexin.supplier.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.kexin.supplier.entity.SupplierEntity;

/**
 * 定义接口 实现供货商方法的规范
 * 
 * @author caokexin
 *
 */
@Repository(value = "supplierDao")
public class SupplierDao extends SqlSessionDaoSupport {

	/**
	 * 查询供货商的信息
	 * 
	 * @return 返回供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List findSupplier() throws Exception {
		return this.getSqlSession().selectList("com.kexin.supplier.dao.SupplierDao.findSupplier");
	}

	/**
	 * 根据ID查询供货商的信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List getSupplierbyId(String supplierID) throws Exception {
		return this.getSqlSession().selectList("com.kexin.supplier.dao.SupplierDao.getSupplierbyId", supplierID);
	}

	/**
	 * 修改供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @return 返回修改供货商信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int updateSupplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone)
			throws Exception {
		SupplierEntity supplierEntity = new SupplierEntity();
		supplierEntity.setSupplierID(supplierID);
		supplierEntity.setSupplierName(supplierName);
		supplierEntity.setSupplierAddress(supplierAddress);
		supplierEntity.setSupplierPhone(supplierPhone);
		return this.getSqlSession().update("com.kexin.supplier.dao.SupplierDao.updateSupplier", supplierEntity);
	}

	/**
	 * 添加供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @return 返回添加供货商信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int addSupplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone)
			throws Exception {
		SupplierEntity supplierEntity = new SupplierEntity();
		supplierEntity.setSupplierID(supplierID);
		supplierEntity.setSupplierName(supplierName);
		supplierEntity.setSupplierAddress(supplierAddress);
		supplierEntity.setSupplierPhone(supplierPhone);
		return this.getSqlSession().insert("com.kexin.supplier.dao.SupplierDao.addSupplier", supplierEntity);
	}

	/**
	 * 删除供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @return 返回删除信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int deleteSupplier(String supplierID) throws Exception {
		return this.getSqlSession().delete("com.kexin.supplier.dao.SupplierDao.deleteSupplier", supplierID);
	}
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
