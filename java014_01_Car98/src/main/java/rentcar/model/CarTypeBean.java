package rentcar.model;

import java.io.Serializable;

public class CarTypeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer typeId;
	private Integer rentId;
	private Integer weekdayHourly;
	private Integer weekdayDaily;
	private Integer holidayHourly;
	private Integer holidayDaily;
	private String carType;
	
	
	public CarTypeBean() {
		super();
	}
	
	public CarTypeBean(Integer typeId, Integer rentId, Integer weekdayHourly, Integer weekdayDaily,
			Integer holidayHourly, Integer holidayDaily, String carType) {
		super();
		this.typeId = typeId;
		this.rentId = rentId;
		this.weekdayHourly = weekdayHourly;
		this.weekdayDaily = weekdayDaily;
		this.holidayHourly = holidayHourly;
		this.holidayDaily = holidayDaily;
		this.carType = carType;
	}


	public Integer getTypeId() {
		return typeId;
	}


	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}


	public Integer getRentId() {
		return rentId;
	}


	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}


	public Integer getWeekdayHourly() {
		return weekdayHourly;
	}


	public void setWeekdayHourly(Integer weekdayHourly) {
		this.weekdayHourly = weekdayHourly;
	}


	public Integer getWeekdayDaily() {
		return weekdayDaily;
	}


	public void setWeekdayDaily(Integer weekdayDaily) {
		this.weekdayDaily = weekdayDaily;
	}


	public Integer getHolidayHourly() {
		return holidayHourly;
	}


	public void setHolidayHourly(Integer holidayHourly) {
		this.holidayHourly = holidayHourly;
	}


	public Integer getHolidayDaily() {
		return holidayDaily;
	}


	public void setHolidayDaily(Integer holidayDaily) {
		this.holidayDaily = holidayDaily;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}

}
