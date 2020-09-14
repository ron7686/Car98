package rentcar.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RentCar")
public class RentCarBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rentId;			//建檔編號	
	private String store;			//租車商店
	private String city;			//城市
	private String district;		//區
	private String street;			//街道
	
	@OneToMany(mappedBy = "rentCarBean")
	private Set<CarTypeBean> cars = new LinkedHashSet<>();
	
	public RentCarBean() {
		super();
	}

	public RentCarBean(Integer rentId, String store, String city, String district, String street
			) {
		super();
		this.rentId = rentId;
		this.store = store;
		this.city = city;
		this.district = district;
		this.street = street;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Set<CarTypeBean> getCars() {
		return cars;
	}

	public void setCars(Set<CarTypeBean> cars) {
		this.cars = cars;
	}

	public Set<CarTypeBean> getCarTypeBean() {
		return cars;
	}
	
	public void setCarTypeBean(Set<CarTypeBean> cars) {
		this.cars = cars;
	}
}
