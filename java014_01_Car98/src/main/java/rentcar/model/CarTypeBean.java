package rentcar.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="CarType")	//車型
public class CarTypeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer typeId;				//建檔編號
	@Transient
	private Integer rentId;				//租車建檔編號
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "rentId")
	private RentCarBean rentCarBean;
	
	private String carBrand;			//車牌
	private String carType;				//車型
	private Integer weekdayHourly;		//平日時租
	private Integer holidayHourly;		//假日時租
	private Integer weekdayDaily;		//平日日租
	private Integer holidayDaily;		//假日日租

	public CarTypeBean() {
		super();
	}

	public CarTypeBean(
			Integer typeId, 
			Integer rentId, 
			String carBrand, 
			String carType,
			Integer weekdayHourly, 
			Integer holidayHourly, 
			Integer weekdayDaily,
			Integer holidayDaily
			) {
		super();
		this.typeId = typeId;
		this.rentId = rentId;
		this.carBrand = carBrand;
		this.carType = carType;
		this.weekdayHourly = weekdayHourly;
		this.holidayHourly = holidayHourly;
		this.weekdayDaily = weekdayDaily;
		this.holidayDaily = holidayDaily;
		
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

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public void setRentCarBean(RentCarBean rentCarBean) {
		this.rentCarBean = rentCarBean;
	}
	
	public RentCarBean getRentCarBean() {
		return rentCarBean;
	}
}
