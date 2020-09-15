package talk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comment")
public class CommentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ComID;
	
	@Column(name="PostID")
    private Integer PostID;
	@Column(name="MemID")
    private Integer MemID;
	@Column(name="Comtext")
    private String Comtext;
	@Column(name="ComTime")
    private Date ComTime;
	@Column(name="ComLike")
    private Integer ComLike;
	
	public CommentBean() {
		super();
	}
	public CommentBean(Integer PostID,String Comtext,Date ComTime,Integer ComLike) {				
		this.PostID = PostID;
		
		this.Comtext = Comtext;
		this.ComTime = ComTime;
		this.ComLike = ComLike;
	} 
	
    
	public Integer getComID() {
		return ComID;
	}
	public void setComID(Integer comID) {
		ComID = comID;
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
	public String getComtext() {
		return Comtext;
	}
	public void setComtext(String comtext) {
		Comtext = comtext;
	}
	public Date getComTime() {
		return ComTime;
	}
	public void setComTime(Date comTime) {
		ComTime = comTime;
	}
	public Integer getComLike() {
		return ComLike;
	}
	public void setComLike(Integer comLike) {
		ComLike = comLike;
	}	
	@Override
	public String toString() {
		return "CommentBean [ComID=" + ComID + ", PostID=" + PostID + ", MemID=" + MemID + ", Comtext=" + Comtext
				+ ", ComTime=" + ComTime + ", ComLike=" + ComLike +  "]";
	}
}
