package rentcar.dao;

import java.util.Collection;

import rentcar.model.CarTypeBean;

public interface CarTypeDao {
	//1.查詢
	Collection<CarTypeBean> getCarTypeData();
}
