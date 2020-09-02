package commodity.service;

import java.util.List;

import commodity.model.BidBean;

public interface BidService {
	// 依bidId來查詢單筆記錄
		BidBean getBid(int bidId);
		
		// Select all
		List<BidBean> getSelectBid();
		
		
		// 新增一筆完整資料
		BidBean saveBid(BidBean bean);
		
		// 依bidId來刪除單筆記錄
		int deleteBid(String bidId);
		
		
}
