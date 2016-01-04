package com.stoms.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.transaction.annotation.Transactional;

import com.stoms.dao.DepartmentDAO;
import com.stoms.dao.TeacherDAO;
import com.stoms.dao.TeacherLoginDAO;
import com.stoms.dao.TeacherTitleDAO;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.model.ProjectType;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;
import com.stoms.model.TeacherTitle;
import com.stoms.utils.JSONTranslation;

public class TeacherService {

	private TeacherLoginDAO teacherLoginDAO;
	private TeacherDAO teacherDAO;
	private DepartmentDAO departmentDAO;
	private TeacherTitleDAO teacherTitleDAO;
	private String departmentName;
	private String indirectString;
	private String indirectId;
	private int IdCount;

	
	
	// 创建IndirectID
	@Transactional
	public String creatIndirectID(String departmentId) {
		indirectString = departmentId + "00112";
		List<Teacher> CreatItemList = teacherDAO.findByindirectString(indirectString);
		IdCount = 2;

		if (CreatItemList.size() == 0) {
			indirectId = indirectString + "002";
		}
		for (int i = 0; i < CreatItemList.size(); i++) {
			Teacher teacher = CreatItemList.get(i);
			if (Integer.parseInt(teacher.getIndirectId().substring(9)) == IdCount) {
				IdCount++;
			} else {
				indirectId = indirectString + IdCount / 100
						+ (IdCount % 100 / 10) + (IdCount % 10);
				List<Teacher> AlreadyItem = teacherDAO.findByIndirectId(indirectId);

				if (AlreadyItem.size() > 0) {
					IdCount++;
				} else {
					break;
				}
			}
		}
		indirectId = indirectString + IdCount / 100 + (IdCount % 100 / 10)
				+ (IdCount % 10);
		return indirectId;
	}
	
	/**
	 * 为工号为teacherID的教师创建一张间接经费卡，卡号为newIndirectedID
	 * @param teacherID
	 * @param newIndirectedID
	 * @return
	 */
	@Transactional
	public boolean createNewIndiretIDofTeacher(String teacherID, String newIndirectedID) {
		
		List<Teacher> tmpTeacherList1 = teacherDAO.findByIndirectId(newIndirectedID);
		if(tmpTeacherList1 != null && tmpTeacherList1.size() > 0) {
			//若表中已存在newIndirectedID卡号，则报错
			return false;
		}
		
		List<Teacher> tmpTeacherList = teacherDAO.findByTeacherId(teacherID);
		
		if(tmpTeacherList == null || tmpTeacherList.size() < 1) {
			return false;
		}
		Teacher tmpTeahcer = tmpTeacherList.get(0);
		tmpTeahcer.setIndirectId(newIndirectedID);
		teacherDAO.attachDirty(tmpTeahcer);
		
		return true;
	}
	/**
	 * 返回工号为teacherID的教师的间接经费卡号
	 * @param teacherID
	 * @return
	 */
	public String acquireIndirectIDbyTeacherID(String teacherID) {
		
		List<Teacher> tmpTeacherList = teacherDAO.findByTeacherId(teacherID);
		
		if(tmpTeacherList == null || tmpTeacherList.size() < 1) {
			return "";
		}
		
		Teacher tmpTeahcer = tmpTeacherList.get(0);
		
		return tmpTeahcer.getIndirectId();
	}
	
	/**
	 * 返回工号为teacherID的教师所在院系的编号
	 * @param teacherID
	 * @return
	 */
	public String acquireDepartmentIDOfTeacher(String teacherID) {
		
		List<Teacher> tmpTeacherList = teacherDAO.findByTeacherId(teacherID);
		
		if(tmpTeacherList == null || tmpTeacherList.size() < 1) {
			return "";
		}
		
		Teacher tmpTeahcer = tmpTeacherList.get(0);
		
		return tmpTeahcer.getDepartmentId();
	}
	
	/**
	 * 删除主键数组里面的教师
	 * @param 
	 * @return
	 */
	public boolean deleteSelectedTeacher(String[] PKArray) {
		
		boolean result = false;
		
		for (int i = 0; i < PKArray.length; i++) {
			
			String PK = PKArray[i];
			
			Teacher tempObject = (Teacher) teacherDAO.findByTeacherId(PK).get(0);
			if(tempObject != null) {
				teacherDAO.delete(tempObject);
				result = true;
			}
		}
		
		return result;
	}
	
	
	/**
	 * 增加老师
	 * 
	 * @return
	 */
	public boolean addNewTeacher(int titlePK, String teacherId, String teacherName, String titleName, 
							String departmentId, String departmentName, 
							String tel, String mobile,String  email){
		
		boolean result = false;
		
		Teacher tempTeacher = new Teacher();
		
		List<Teacher> tmpTeacherList = teacherDAO.findByTeacherId(teacherId);
		
		if(tmpTeacherList != null && tmpTeacherList.size() > 0) {
			return false;
		}

		tempTeacher = setTeacherValue(tempTeacher, titlePK, teacherId, teacherName, titleName, 
					departmentId, departmentName, 
					tel, mobile, email);
		
		teacherDAO.save(tempTeacher);
		
		result = true;
		
		return result;
	}
	
	/**
	 * 修改老师
	 * 
	 * @return
	 */
	public boolean modifyTeacher(long teacherPK, int titlePK, String teacherId, String teacherName, String titleName, 
							String departmentId, String departmentName, 
							String tel, String mobile,String  email){
		
		boolean result = false;
		
		Teacher tempTeacher = teacherDAO.findById(teacherPK);
		
		if( tempTeacher == null){
			 tempTeacher = new Teacher();
		}
		
		tempTeacher = setTeacherValue(tempTeacher, titlePK, teacherId, teacherName, titleName, 
				departmentId, departmentName, 
				tel, mobile, email);
	
	    teacherDAO.attachDirty(tempTeacher);
		
		result = true;
		return result;
	}
	
	
	/**
	 * 设置teacher的值
	 * 
	 * @return
	 */
	private Teacher setTeacherValue(Teacher tempTeacher,int titlePK, String teacherId, String teacherName, String titleName, 
								String departmentId, String departmentName, 
								String tel, String mobile,String  email){
		
		TeacherTitle tempteacherTitle = teacherTitleDAO.findById(titlePK);
		
		if(tempteacherTitle != null ){
			tempTeacher.setTeacherTitle(tempteacherTitle);
		}
		
		List tempDepartmentList = departmentDAO.findByDepartmentId(departmentId);
		
		if(tempDepartmentList.size() == 1){
			tempTeacher.setDepartment((Department)tempDepartmentList.get(0));
		}
		
		tempTeacher.setTeacherId(teacherId);
		tempTeacher.setTeacherName(teacherName);
		tempTeacher.setTitleName(titleName);
		tempTeacher.setDepartmentId(departmentId);
		tempTeacher.setDepartmentName(departmentName);
		tempTeacher.setTel(tel);
		tempTeacher.setMobile(mobile);
		tempTeacher.setEmail(email);
		
		return tempTeacher;
	}
	
	public Teacher acquireOneTeacherInfo(long teacherPK){
		
		Teacher teacherItem = teacherDAO.findById(teacherPK);
		return teacherItem;
	}
	
	//返回所有教师信息
	public List acquireAllTeacherInfo() {
			
		List<Teacher> allTeacherList = teacherDAO.findAll();
		List teacherids = teacherLoginDAO.findAdminAndSuperAdminUserList();
		List<Teacher> delList = new ArrayList<Teacher>();
		for (Teacher t : allTeacherList) {
//			List teacherLogins = teacherLoginDAO.findByTeacherId(t.getTeacherId());
//			TeacherLogin teacherLogin = null;
//			if (teacherLogins.size()>0) {
//				teacherLogin = (TeacherLogin) teacherLogins.get(0);
//			}
			
			if (teacherids.contains(t.getTeacherId())) {
				delList.add(t);
			}
		}
		allTeacherList.removeAll(delList);
		return allTeacherList;
	}
	
	//返回所有管理员信息
	public List acquireAllAdminInfo() {
			
		List<Teacher> allTeacherList = teacherDAO.findAll();
		List teacherids = teacherLoginDAO.findAdminUserList();
		List<Teacher> delList = new ArrayList<Teacher>();
		for (Teacher t : allTeacherList) {
			
			if (!teacherids.contains(t.getTeacherId())) {
				delList.add(t);
			}
		}
		allTeacherList.removeAll(delList);
		
		return allTeacherList;
	}
	
	//返回筛选条件（TeacherName和DepartmentPK）的教师信息
	//add by shi 20131008
	public List acquireTeacherInfo(String teacherName,int departmentPk) {
		
		if (departmentPk>=0) {
			Department tempDepartment = departmentDAO.findById(departmentPk);
			if (tempDepartment==null) {
				departmentName="";
			}else{
				departmentName=tempDepartment.getDepartmentName();
			}
		}else{
			departmentName="";
		}
				
		List teacherList = teacherDAO.findbyTeacherNameandDepartmentName(teacherName,departmentName);
		return teacherList;
	}
	
	//setters&getters
	
	
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherTitleDAO getTeacherTitleDAO() {
		return teacherTitleDAO;
	}

	public void setTeacherTitleDAO(TeacherTitleDAO teacherTitleDAO) {
		this.teacherTitleDAO = teacherTitleDAO;
	}


	public String getIndirectString() {
		return indirectString;
	}


	public void setIndirectString(String indirectString) {
		this.indirectString = indirectString;
	}


	public String getIndirectId() {
		return indirectId;
	}


	public void setIndirectId(String indirectId) {
		this.indirectId = indirectId;
	}


	public int getIdCount() {
		return IdCount;
	}


	public void setIdCount(int idCount) {
		IdCount = idCount;
	}

	public TeacherLoginDAO getTeacherLoginDAO() {
		return teacherLoginDAO;
	}

	public void setTeacherLoginDAO(TeacherLoginDAO teacherLoginDAO) {
		this.teacherLoginDAO = teacherLoginDAO;
	}
	
	
}

