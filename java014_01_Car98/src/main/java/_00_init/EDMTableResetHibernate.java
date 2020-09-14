package _00_init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _00_init.util.HibernateUtils;
//import _00_init.util.GlobalService;
import rentcar.model.CarTypeBean;
import rentcar.model.RentCarBean;


// 本程式建立範例程式所需要的表格與部分表格的初始資料
// 範例程式所需要的表格如下：
// 
public class EDMTableResetHibernate {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

	public static void main(String args[]) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		String line = "";
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
//			int count = 0;
			// 1. rentcar表格
			// 1-2 由"data/rentcarbean.dat"逐筆讀入rentcar表格內的初始資料，
			// 然後依序新增到rentcar表格中
			try (
					FileReader fr = new FileReader("data/rentcarbean.dat"); 
					BufferedReader br = new BufferedReader(fr);
			) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					String store = token[0];
					String city = token[1];
					String district = token[2];
					String street = token[3];
					RentCarBean rcb = new RentCarBean(null, store, city, district, street);
					session.save(rcb);
				}
				System.out.println("RentCar 資料新增成功");
			} catch (IOException e) {
				System.err.println("新建RentCar表格時發生IO例外: " + e.getMessage());
			}
			// 2. cartype表格
			File file = new File("data/cartypebean.dat");
			// 2-2 由"data/cartypebean.dat"逐筆讀入cartype表格內的初始資料，
			//然後依序新增到cartype表格中
			try (
					FileInputStream fis = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fis, "UTF8");
					BufferedReader br = new BufferedReader(isr);
			) {
				while ((line = br.readLine()) != null) {
					System.out.println("line=" + line);
					// 去除 UTF8_BOM: \uFEFF
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					CarTypeBean ctb = new CarTypeBean ();
					
//					ctb.setRentId(Integer.parseInt(token[0].trim()));
					int rentId = Integer.parseInt(token[0].trim());
					RentCarBean rcb = session.get(RentCarBean.class, rentId);
					ctb.setRentCarBean(rcb);
					
					ctb.setCarBrand(token[1]);
					ctb.setCarType(token[2]);
					ctb.setWeekdayHourly(Integer.parseInt(token[3].trim()));
					ctb.setHolidayHourly(Integer.parseInt(token[4].trim()));
					ctb.setWeekdayDaily(Integer.parseInt(token[5].trim()));
					ctb.setHolidayDaily(Integer.parseInt(token[6].trim()));
					
					session.save(ctb);
					System.out.println("新增一筆CarType紀錄成功");
				}
				// 印出資料新增成功的訊息
				System.out.println("CarType資料新增成功");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
//			// 3. Member表格
//			// 3-2 由"data/Input.txt"逐筆讀入Member表格內的初始資料，
//			// 然後依序新增到Member表格中
//			try (FileInputStream fis = new FileInputStream("data/Input.txt");
//					InputStreamReader isr0 = new InputStreamReader(fis, "UTF-8");
//					BufferedReader br = new BufferedReader(isr0);) {
//				while ((line = br.readLine()) != null) {
//					String[] sa = line.split("\\|");
//					MemberBean bean = new MemberBean();
//					bean.setMemberId(sa[0]);
//					bean.setName(sa[1]);
//					String pswd = GlobalService.getMD5Endocing(GlobalService.encryptString(sa[2]));
//					bean.setPassword(pswd);
//					bean.setAddress(sa[3]);
//					bean.setEmail(sa[4]);
//					bean.setTel(sa[5]);
//					bean.setUserType(sa[6]);
//					bean.setTotalAmt(Double.parseDouble(sa[7]));
//					bean.setTs(new java.sql.Timestamp(System.currentTimeMillis()));
//					// --------------處理Blob(圖片)欄位----------------
//					Blob sb = GlobalService.fileToBlob(sa[8]);
//					bean.setMemberImage(sb);
//					String imageFileName = sa[8].substring(sa[8].lastIndexOf("/") + 1);
//					bean.setFileName(imageFileName);
//					Clob clob = GlobalService.fileToClob(sa[9]);
//					bean.setComment(clob);
//					bean.setUnpaid_amount(0.0);
//					session.save(bean);
//					count++;
//					System.out.println("新增" + count + "筆記錄:" + sa[1]);
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
	}

}