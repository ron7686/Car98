package commodity.service.impl;


import java.util.List;

import commodity.dao.BidDao;
import commodity.dao.impl.BidDaoImpl_Jdbc;
import commodity.model.BidBean;
import commodity.service.BidService;

public class BidServiceImpl implements BidService {
	
    BidDao dao;
    
	public BidServiceImpl() {
		this.dao = new BidDaoImpl_Jdbc();
	}

	@Override
	public BidBean getBid(int bidId) {
		return dao.getBid(bidId);
	}

	@Override
	public List<BidBean> getSelectBid() {
		return dao.getSelectBid();
	}
	
	@Override
	public BidBean saveBid(BidBean bean) {
		return dao.saveBid(bean);
	}

	@Override
	public int deleteBid(String bidId) {
		return dao.deleteBid(bidId);
	}
	
	

}
