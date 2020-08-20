package member.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer custId;
	private String id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private java.util.Date birth;
	private String sex;
	private Blob headPic;
	private Integer levels;

	public MemberBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberBean(Integer custId, String id, String email, String password, String name, String phone, Date birth,
			String sex, Blob headPic, Integer levels) {
		super();
		this.custId = custId;
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.sex = sex;
		this.headPic = headPic;
		this.levels = levels;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.util.Date getBirth() {
		return birth;
	}

	public void setBirth(java.util.Date birth) {
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

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [custId=");
		builder.append(custId);
		builder.append(", id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", headPic=");
		builder.append(headPic);
		builder.append(", levels=");
		builder.append(levels);
		builder.append("]");
		return builder.toString();
	}

}
