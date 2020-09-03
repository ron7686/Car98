package talk.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "talk")
public class TalkBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer PostID;
	
	@Column(name="MemID")
	private Integer MemID;
	@Column(name="PostTitle")
	private String PostTitle;
	@Column(name="PostText")
	private String PostText;
	@Column(name="PostTime")
	private Date PostTime;
	@Column(name="PostLike")
	private Integer PostLike;
	@Column(name="PostHate")
	private Integer PostHate;
	@Column(name="PostCom")
	private Integer PostCom;
	public TalkBean() {
		super();
	}
	public TalkBean(Integer postID, String postTitle, String postText) {
		super();
		PostID = postID;
		PostTitle = postTitle;
		PostText = postText;
	}
	public Integer getPostID() {
		return PostID;
	}
	public void setPostID(Integer postID) {
		PostID = postID;
	}
	public Integer getMemID() {
		return MemID;
	}
	public void setMemID(Integer memID) {
		MemID = memID;
	}
	public String getPostTitle() {
		return PostTitle;
	}
	public void setPostTitle(String postTitle) {
		PostTitle = postTitle;
	}
	public String getPostText() {
		return PostText;
	}
	public void setPostText(String postText) {
		PostText = postText;
	}
	public Date getPostTime() {
		return PostTime;
	}
	public void setPostTime(Date postTime) {
		PostTime = postTime;
	}
	public Integer getPostLike() {
		return PostLike;
	}
	public void setPostLike(Integer postLike) {
		PostLike = postLike;
	}
	public Integer getPostHate() {
		return PostHate;
	}
	public void setPostHate(Integer postHate) {
		PostHate = postHate;
	}
	public Integer getPostCom() {
		return PostCom;
	}
	public void setPostCom(Integer postCom) {
		PostCom = postCom;
	}
	@Override
	public String toString() {
		return "TalkBean [PostID=" + PostID + ", MemID=" + MemID + ", PostTitle=" + PostTitle + ", PostText=" + PostText
				+ ", PostTime=" + PostTime + ", PostLike=" + PostLike + ", PostHate=" + PostHate + ", PostCom="
				+ PostCom + "]";
	}
	
	
	
}
