package rentcar.model;

import java.io.Serializable;

public class RentCarBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer rentId;
	private String store;
	private String area;
	private String address;
	
	public RentCarBean() {
		super();
	}
	
	public RentCarBean(Integer rentId, String store, String area, String address) {
		super();
		this.rentId = rentId;
		this.store = store;
		this.area = area;
		this.address = address;
	}

	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
