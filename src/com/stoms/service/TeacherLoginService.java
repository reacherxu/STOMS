package com.stoms.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.stoms.dao.TeacherLoginDAO;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;

public class TeacherLoginService {

	private TeacherLoginDAO teacherLoginDAO;
	
	public boolean createNewTeacher(String teacherID, int userType) {
		
		
		List<TeacherLogin> tmpTeacherLoginList = teacherLoginDAO.findByTeacherId(teacherID);
		
		if(tmpTeacherLoginList != null && tmpTeacherLoginList.size() > 0) {
			return false;
		}
		
		TeacherLogin tmpTeacherLogin = new TeacherLogin();
		
		tmpTeacherLogin.setTeacherId(teacherID);
		tmpTeacherLogin.setIsActivate(1);
		tmpTeacherLogin.setUserType(userType);
		String tmpPassWord = encrypt(teacherID, "SHA-256");
		tmpTeacherLogin.setTpassword(tmpPassWord);
		
		teacherLoginDAO.save(tmpTeacherLogin);
		return true;
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
			
			TeacherLogin tempObject = (TeacherLogin) teacherLoginDAO.findByTeacherId(PK).get(0);
			if(tempObject != null) {
				teacherLoginDAO.delete(tempObject);
				result = true;
			}
		}
		
		return result;
	}
	/**
	 * 初始化所有教师登陆密码
	 * @return
	 */
	public boolean intializeAllPassword() {
		
		List<TeacherLogin> allTeacherList = teacherLoginDAO.findAll();
		
		if(allTeacherList == null || allTeacherList.size() == 0)
			return false;
		
		for(int i = 0; i < allTeacherList.size(); i++) {
			TeacherLogin tmpTeacherLogin = (TeacherLogin)allTeacherList.get(i);
			String tmpTeacherID = tmpTeacherLogin.getTeacherId();
			String newPassword = encrypt(tmpTeacherID, "SHA-256");
			tmpTeacherLogin.setTpassword(newPassword);
			teacherLoginDAO.attachDirty(tmpTeacherLogin);
		}
		
		return true;
	}
	
	public static String encrypt(String strSrc, String encName) {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || encName.equals("")) {
                encName = "SHA-256";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
	
	
	public TeacherLoginDAO getTeacherLoginDAO() {
		return teacherLoginDAO;
	}

	public void setTeacherLoginDAO(TeacherLoginDAO teacherLoginDAO) {
		this.teacherLoginDAO = teacherLoginDAO;
	}
}
