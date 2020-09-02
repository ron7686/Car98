package commodity.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

// 本類別封裝單筆商品資料
public class BidBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer bidId;//商品ID
	private Integer memId;//會員ID
	private String bidItemName;//品名
	private String bidDetail;//種類描述
	private Integer bidPrice;//價格
	private Integer bidSelled;//數量
	private Date bidTime;//上架時間
	private Integer bidScore;//買家評價
	private Blob bidPic;//商品照片
	private String fileName;//照片名稱
	
	public BidBean(Integer bidId, Integer memId, String bidItemName,String bidDetail ,Integer bidPrice,
			Date bidTime, Integer bidSelled, Integer bidScore, Blob bidPic,String fileName) {
		this.bidId = bidId;
		this.memId = memId;
		this.bidItemName = bidItemName;
		this.bidDetail = bidDetail;
		this.bidPrice = bidPrice;
		this.bidTime = bidTime;
		this.bidSelled = bidSelled;
		this.bidScore = bidScore;
		this.bidPic = bidPic;
		this.fileName = fileName;
	}

	public BidBean() {
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public Integer getMemId() {
		return memId;
	}
	
	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getBidItemName() {
		return bidItemName;
	}

	public void setBidItemName(String bidItemName) {
		this.bidItemName = bidItemName;
	}

	public String getBidDetail() {
		return bidDetail;
	}

	public void setBidDetail(String bidDetail) {
		this.bidDetail = bidDetail;
	}

	public Integer getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(Integer bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Integer getBidSelled() {
		return bidSelled;
	}

	public void setBidSelled(Integer bidSelled) {
		this.bidSelled = bidSelled;
	}

	public Date getBidTime() {
		return bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	public Integer getBidScore() {
		return bidScore;
	}

	public void setBidScore(Integer bidScore) {
		this.bidScore = bidScore;
	}

	public Blob getBidPic() {
		return bidPic;
	}

	public void setBidPic(Blob bidPic) {
		this.bidPic = bidPic;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "BidBean [bidId=" + bidId + ", memId=" + memId + ", bidItemName=" + bidItemName + ", bidDetail="
				+ bidDetail + ", bidPrice=" + bidPrice + ", bidSelled=" + bidSelled + ", bidTime=" + bidTime
				+ ", bidScore=" + bidScore + ", bidPic=" + bidPic + ", fileName=" + fileName + "]";
	}
	
	
}
	

