package _01_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mem")
public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memId;
	
	private String email;
	private String password;
	private String name;
	private String id;
	private String phone;
	private Date birth;
	private String sex;
	private Blob headPic;
	private String fileName;
	private Integer levels;
	private Date meCreate;
	private Timestamp loginTime;

	
	public MemberBean() {
		
	}
	
	public MemberBean(Integer memId, String email, String password, String name, String id, String phone, Date birth,
			String sex, Blob headPic, String fileName,Integer levels,Date meCreate,Timestamp loginTime) {
		super();
		this.memId = memId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.birth = birth;
		this.sex = sex;
		this.headPic = headPic;
		this.fileName = fileName;
		this.levels = levels;
		this.meCreate = meCreate;
		this.loginTime = loginTime;
	}
	
	public MemberBean(Integer memId, String email, String password, String name, String id, String phone, Date birth,
			String sex, Blob headPic, String fileName,Integer levels,Timestamp loginTime) {
		super();
		this.memId = memId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.birth = birth;
		this.sex = sex;
		this.headPic = headPic;
		this.fileName = fileName;
		this.levels = levels;
		this.loginTime = loginTime;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Blob getHeadPic() {
		return headPic;
	}

	public void setHeadPic(Blob headPic) {
		this.headPic = headPic;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public Date getMeCreate() {
		return meCreate;
	}

	public void setMeCreate(Date meCreate) {
		this.meCreate = meCreate;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [memId=");
		builder.append(memId);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", headPic=");
		builder.append(headPic);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", levels=");
		builder.append(levels);
		builder.append(", meCreate=");
		builder.append(meCreate);
		builder.append(", loginTime=");
		builder.append(loginTime);
		builder.append("]");
		return builder.toString();
	}
}
