package com.mcnc.usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import com.mcnc.usermanagement.dao.DepartmentDAO;
import com.mcnc.usermanagement.dto.DepartmentDTO;
import com.mcnc.usermanagement.message.request.DepartmentQuery;
import com.mcnc.usermanagement.message.request.PageParam;
import com.mcnc.usermanagement.message.response.PageWrapper;
import com.mcnc.usermanagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	PlatformTransactionManager txManager;

	@Override
	public DepartmentDTO findDepartment(Integer id) {
		return departmentDAO.findDepartment(id);
	}

	@Override
	public DepartmentDTO findDepartmentForUser(Integer userId) {
		return departmentDAO.findDepartmentForUser(userId);
	}

	@Override
	public List<DepartmentDTO> findAllDepartments() {
		return departmentDAO.findAllDepartments();
	}

	@Override
	public void createDepartment(DepartmentDTO department) {
		departmentDAO.createDepartment(department);
	}

	@Override
	public void updateDepartment(DepartmentDTO department) {
		departmentDAO.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(Integer id) {
		departmentDAO.deleteDepartment(id);
	}

	@Override
	public PageWrapper<DepartmentDTO> searchDepartments(DepartmentQuery departmentQuery, PageParam pageParam) {
		Integer totalPages = 0;
		Integer totalRecords = countSearchDepartments(departmentQuery);

		if (totalRecords > 0 && pageParam.getSize() > 0) {
			totalPages = (int) Math.ceil((float) totalRecords / pageParam.getSize());
		}
		if (pageParam.getPage() > totalPages) {
			pageParam.setPage(totalPages);
		}
		List<DepartmentDTO> records = departmentDAO.searchDepartments(departmentQuery, pageParam);

		PageWrapper<DepartmentDTO> pageWrapper = new PageWrapper<DepartmentDTO>();
		pageWrapper.setPage(pageParam.getPage());
		pageWrapper.setSize(pageParam.getSize());
		pageWrapper.setTotalPages(totalPages);
		pageWrapper.setTotalRecords(totalRecords);
		pageWrapper.setRecords(records);
		return pageWrapper;
	}

	@Override
	public Integer countSearchDepartments(DepartmentQuery departmentQuery) {
		return departmentDAO.countSearchDepartments(departmentQuery);
	}

	@Override
	public void testTransaction() {
		
		// Method 1
		
//		 DefaultTransactionDefinition def = new
//		 DefaultTransactionDefinition();
//		 def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		 TransactionStatus status = txManager.getTransaction(def);
//		 try {
//		 DepartmentDTO department = new DepartmentDTO();
//		 department.setName("Test");
//		 createDepartment(department);
//		 int n = 2 / 0;
//		
//		 } catch (Exception e) {
//		 txManager.rollback(status);
//		 throw e;
//		 }
//		 txManager.commit(status);
//		
//		// Method 2
//
//		TransactionTemplate transactionTemplate = new TransactionTemplate(txManager);
//		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				 try {
//					 DepartmentDTO department = new DepartmentDTO();
//					 department.setName("Test");
//					 createDepartment(department);
//					 int n = 2 / 0;
//					 
//					 
//					 
//					 
//					
//				 } catch (Exception e) {	
//					 status.setRollbackOnly();
//				 }
//			}
//		});
	}
}
