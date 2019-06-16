package com.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import com.model.*;


public class MySQL {
    private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/project";
	private final String user = "root";
	private final String password = "131413";
	
    /*private final String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_hitpsx";
	private final String user = "mxllm0zj55";
	private final String password = "z3im552ylhzxxkix3khyxiw5i125wlzk512ij4lm";
	*/
	private Connection con = null;
	private Statement stm = null;
	private ResultSet res = null;
	
	public MySQL() {
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int Number() {
		int p=0;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT count(*) number FROM user");
			res = stm.executeQuery(sql);
			if(res.next()) {
				p=res.getInt("number");
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	public String getType(String type) {
		String pt=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM invite WHERE invitateid= '%s';", type);
			res = stm.executeQuery(sql);
			if (res.next()) {
				pt=res.getString("type");
			}
			else {
				stm.close();
				return pt;
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pt;
	}
	public User userInfor(int userid) {
		User user = null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM user WHERE userid = %d;", userid);
			res = stm.executeQuery(sql);
			if (res.next()) {
				user = new User();
				user.setUsername(res.getString("Username"));
				user.setUserid(res.getInt("Userid"));
				user.setSex(res.getString("Sex"));
				user.setUnit(res.getString("Unit"));
				user.setEmail(res.getString("Email"));
				user.setPassword(res.getString("Password"));
				user.setType(res.getString("type"));
				user.setPicture(res.getString("Picture"));
				user.setIDcard(res.getString("IDcard"));
				user.setEntryTime(res.getString("EntryTime"));
				user.setPhone(res.getString("phone"));
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User Account(String username,String password) {
		User user = null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM user WHERE username = '%s' and password = '%s' ;", username,password);
			res = stm.executeQuery(sql);
			if (res.next()) {
				user = new User();
				user.setUsername(res.getString("Username"));
				user.setUserid(res.getInt("Userid"));
				user.setSex(res.getString("Sex"));
				user.setUnit(res.getString("Unit"));
				user.setEmail(res.getString("Email"));
				user.setPassword(res.getString("Password"));
				user.setType(res.getString("type"));
				user.setPicture(res.getString("Picture"));
			}
			else {
				stm.close();
				return user;
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public String userUnit(int userid) {
		String unit="";
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT unit FROM user where userid = %d",userid);
			res = stm.executeQuery(sql);
			if(res.next()) {
				unit=res.getString("Unit");
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unit;
	}
	public Vector<User> selectUser(String unit,int type) {
		Vector<User> ret=new Vector<User>();
		try {
			stm = con.createStatement();						
			String sql="";
			if(type==0) //部门管理员
				sql = String.format("select * from user where unit = '%s' and type ='0'",unit);
			else if (type==1) //超级管理员
				sql = String.format("select * from  user");
			res = stm.executeQuery(sql);
			while(res.next()) {
				
				User user = new User();
				user.setUsername(res.getString("Username"));
				user.setUserid(res.getInt("Userid"));
				user.setSex(res.getString("Sex"));
				user.setUnit(res.getString("Unit"));
				user.setEmail(res.getString("Email"));
				user.setPassword(res.getString("Password"));
				user.setType(res.getString("type"));
				user.setPicture(res.getString("Picture"));
				user.setIDcard(res.getString("IDcard"));
				user.setEntryTime(res.getString("EntryTime"));
				user.setPhone(res.getString("phone"));
			
				ret.add(user);
			}
			stm.close();
		  }catch (SQLException e) {
				e.printStackTrace();
			}
		return ret;
	}
	public void DeleteUser(int userid) {
		try {
			stm = con.createStatement();						
			String sql= String.format("delete from user where userid=%d",userid);
			stm.executeUpdate(sql);
		  }catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void insertUser(User user) {
		try {
			stm = con.createStatement();
			String sql = "INSERT INTO user (username, password, sex, unit, email, userid, Picture, type,EntryTime,IDcard,phone) VALUES " +
					String.format("(\"%s\", \"%s\",\"%s\", '%s',\"%s\",%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
							user.getUsername(), user.getPassword(), user.getSex(), user.getUnit(), 
							user.getEmail(),user.getUserid(), user.getPicture(),user.getType()
							,user.getEntryTime(),user.getIDcard(),user.getPhone());
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InserRepair(Repair Re) {
		try {
			stm = con.createStatement();
			String sql = "INSERT INTO repair (EquNumber, EquUnit, Application, applicant, Applicantdate, phone, location, EquClass, Sta, conductor, EquName,OverDate,title) VALUES " +
					String.format("(%d, \"%s\",\"%s\", \"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
							   Re.getEquNumber(),Re.getEquUnit(),Re.getApplication(),Re.getApplicant(),Re.getApplicationDate(),Re.getPhone()
							   ,Re.getLocation(),Re.getEquClass(),Re.getSta(),Re.getConductor(),Re.getEquName(),Re.getOverDate(),Re.getTitle());
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Vector<Cs> selectEqu(int page,String unit,int type) {
		Vector<Cs> ret=new Vector<Cs>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM cs limit %d,5",page*5);
			else if(type==0)
				sql=  String.format("SELECT * FROM cs where EquUnit = '%s' and EquSta regexp '%s' limit %d,5",unit,"空闲",page*5);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Cs Cp=new Cs();
				
				Cp.setEquNumber(res.getInt("EquNumber"));
				Cp.setEquQua(res.getString("EquQua"));
				Cp.setEquName(res.getString("EquName"));
				Cp.setModelSpe(res.getString("ModelSpe"));
				Cp.setEquDate(res.getString("EquDate"));
								
				Cp.setEquSta(res.getString("EquSta"));
				Cp.setEquClass(res.getString("EquClass"));
				Cp.setEquUnit(res.getString("EquUnit"));
				Cp.setManufacturer(res.getString("Manufacturer"));
				Cp.setSupplier(res.getString("Supplier"));
				
				Cp.setSpecifications(res.getString("Specifications"));
				Cp.setOrderDate(res.getString("OrderDate"));
				Cp.setInspector(res.getString("Inspector"));
				Cp.setQuality(res.getString("Quality"));
				Cp.setMaintainer(res.getString("Maintainer"));
				
				Cp.setInventoryPosition(res.getString("InventoryPosition"));
				Cp.setPresentPosition(res.getString("PresentPosition"));
				Cp.setUnitPrice(res.getString("UnitPrice"));
				
				Cp.setOrderQuantity(res.getInt("OrderQuantity"));
				Cp.setHandler(res.getString("Handler"));
				Cp.setExtra(res.getString("extra"));
				
				ret.add(Cp);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
	
	public Vector<Cs> selectyear(String year,String unit,String EquClass,int type,int page) {
		Vector<Cs> ret=new Vector<Cs>();
		try {
			stm = con.createStatement();						
			String year2=year+"-12-31";
			year=year+"-01-01";
			String sql="";
			if(type==0)
				sql = String.format("select * from  cs where EquDate between '%s' and '%s' and EquUnit = '%s' and EquClass = '%s' limit %d,5",year,year2,unit,EquClass,page*5);
			else if (type==1)
				sql = String.format("select * from  cs where EquDate between '%s' and '%s' and EquClass = '%s' limit %d,5",year,year2,EquClass,page*5);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Cs Cp=new Cs();
				
				Cp.setEquNumber(res.getInt("EquNumber"));
				Cp.setEquQua(res.getString("EquQua"));
				Cp.setEquName(res.getString("EquName"));
				Cp.setModelSpe(res.getString("ModelSpe"));
				Cp.setEquDate(res.getString("EquDate"));
				
				Cp.setEquSta(res.getString("EquSta"));
				Cp.setEquClass(res.getString("EquClass"));
				Cp.setEquUnit(res.getString("EquUnit"));
				Cp.setManufacturer(res.getString("Manufacturer"));
				Cp.setSupplier(res.getString("Supplier"));
				
				Cp.setSpecifications(res.getString("Specifications"));
				Cp.setOrderDate(res.getString("OrderDate"));
				Cp.setInspector(res.getString("Inspector"));
				Cp.setQuality(res.getString("Quality"));
				Cp.setMaintainer(res.getString("Maintainer"));
				
				Cp.setInventoryPosition(res.getString("InventoryPosition"));
				Cp.setPresentPosition(res.getString("PresentPosition"));
				Cp.setUnitPrice(res.getString("UnitPrice"));
				
				Cp.setOrderQuantity(res.getInt("OrderQuantity"));

				Cp.setHandler(res.getString("Handler"));

				Cp.setExtra(res.getString("extra"));

				ret.add(Cp);
			}
			stm.close();
		  }catch (SQLException e) {
				e.printStackTrace();
			}
		return ret;
	}
	
	public Vector<Cs> selectCsAll(String aim,String unit,int type,int page) {
		Vector<Cs> ret=new Vector<Cs>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM cs where concat(EquNumber, EquName, EquQua, ModelSpe, EquDate, EquSta, EquClass, "
						+ "EquUnit, Manufacturer, Supplier, Specifications, OrderDate, Inspector, Quality,"
						+ "  Maintainer, InventoryPosition, PresentPosition, UnitPrice,"
						+ " OrderQuantity, Handler,extra) like  \"%%%s%%\"and  EquUnit ='%s' limit %d,5",aim,unit,page*5);
			else if(type==1)
				sql=String.format("SELECT * FROM cs where concat(EquNumber, EquName, EquQua, ModelSpe, EquDate, EquSta, EquClass, "
						+ "EquUnit, Manufacturer, Supplier, Specifications, OrderDate, Inspector, Quality,"
						+ " Maintainer, InventoryPosition, PresentPosition, UnitPrice,"
						+ " OrderQuantity, Handler, extra) like  \"%%%s%%\" limit %d,5",aim,page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Cs Cp=new Cs();
				
				Cp.setEquNumber(res.getInt("EquNumber"));
				Cp.setEquQua(res.getString("EquQua"));
				Cp.setEquName(res.getString("EquName"));
				Cp.setModelSpe(res.getString("ModelSpe"));
				Cp.setEquDate(res.getString("EquDate"));
				
				Cp.setEquSta(res.getString("EquSta"));
				Cp.setEquClass(res.getString("EquClass"));
				Cp.setEquUnit(res.getString("EquUnit"));
				Cp.setManufacturer(res.getString("Manufacturer"));
				Cp.setSupplier(res.getString("Supplier"));
				
				Cp.setSpecifications(res.getString("Specifications"));
				Cp.setOrderDate(res.getString("OrderDate"));
				Cp.setInspector(res.getString("Inspector"));
				Cp.setQuality(res.getString("Quality"));
				Cp.setMaintainer(res.getString("Maintainer"));
				
				Cp.setInventoryPosition(res.getString("InventoryPosition"));
				Cp.setPresentPosition(res.getString("PresentPosition"));
				Cp.setUnitPrice(res.getString("UnitPrice"));

				Cp.setOrderQuantity(res.getInt("OrderQuantity"));

				Cp.setHandler(res.getString("Handler"));

				Cp.setExtra(res.getString("extra"));
				
				ret.add(Cp);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public Cs selectEquNumber(int EquNumber) {
		Cs Cp=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM cs WHERE EquNumber = %d ", EquNumber);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Cp=new Cs();
				
				
				Cp.setEquNumber(res.getInt("EquNumber"));
				Cp.setEquQua(res.getString("EquQua"));
				Cp.setEquName(res.getString("EquName"));
				Cp.setModelSpe(res.getString("ModelSpe"));
				Cp.setEquDate(res.getString("EquDate"));
				
				Cp.setEquSta(res.getString("EquSta"));
				Cp.setEquClass(res.getString("EquClass"));
				Cp.setEquUnit(res.getString("EquUnit"));
				Cp.setManufacturer(res.getString("Manufacturer"));
				Cp.setSupplier(res.getString("Supplier"));
				
				Cp.setSpecifications(res.getString("Specifications"));
				Cp.setOrderDate(res.getString("OrderDate"));
				Cp.setInspector(res.getString("Inspector"));
				Cp.setQuality(res.getString("Quality"));
				Cp.setMaintainer(res.getString("Maintainer"));
				
				Cp.setInventoryPosition(res.getString("InventoryPosition"));
				Cp.setPresentPosition(res.getString("PresentPosition"));
				Cp.setUnitPrice(res.getString("UnitPrice"));
				
				Cp.setOrderQuantity(res.getInt("OrderQuantity"));

				Cp.setHandler(res.getString("Handler"));

				Cp.setExtra(res.getString("extra"));
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cp;
	}
	
	public int Getlendid() {
		int p=0;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT count(*) number FROM lendin");
			res = stm.executeQuery(sql);
			if(res.next()) {
				p=res.getInt("number");
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void updateCsSta(String sta,int id) {
		try {
			stm = con.createStatement();
			String sql = String.format("update cs set Equsta='%s' where EquNumber=%d",sta,id);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertLend(Lendin lend) {
		try {
			stm = con.createStatement();
			String sql = "INSERT INTO lendin (LendNumber,Equname, LendUnit, maintext, application,unitlend,Sta,ApplicationDate1,ApplicationDate2,Applicant,Approver,Countdown) VALUES " +
					String.format("(%d,\"%s\",\"%s\", \"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");"
							, lend.getLendNumber(),lend.getEquName(), lend.getLendUnit()
							, lend.getMaintext(), lend.getApplication(),lend.getUnitLend(),lend.getSta()
							,lend.getApplicationDate1(),lend.getApplicationDate2(),lend.getApplicant(),lend.getApprover(),lend.getCountdown());
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertRetire(Retirement re) {
		try {
			stm = con.createStatement();
			String sql = "INSERT INTO retire(EquNumber,EquName,EquDate, ApplicationDate, Applicant, RetireDate"
					+ ",Approver,EquUnit,EquClass,InventoryPosition,UnitPrice,Handler,EquSta,Application) VALUES " +
					String.format("(%d,\"%s\",\"%s\",\"%s\", \"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");"
							,re.getEquNumber(),re.getEquName(),re.getEquDate(),re.getApplicationDate(),re.getApplicant(),re.getRetireDate()
							,re.getApprover(),re.getEquUnit(),re.getEquClass(),re.getInventoryPosition(),re.getUnitPrice(),re.getHandler(),re.getEquSta(),re.getApplication());
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<Lendin> getlendins(String sta,String unit,int type,int page) {
		Vector<Lendin> ret=new Vector<Lendin>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0) //查询本单位目前的借出申请
				sql = String.format("SELECT * FROM lendin where Sta regexp '%s' and  lendunit='%s' limit %d,5","借|未",unit,page*5);
			else if(type==1) //查询所有未审批的借出申请
				sql = String.format("SELECT * FROM lendin limit %d,5",page*5);
			else if (type==2)//查询已借到的设备
				sql = String.format("SELECT * FROM lendin where Sta like \"%%%s%%\" and unitlend='%s' limit %d,5",sta,unit,page*5);
			else if (type==3)//查询所有已经转借的设备
				sql = String.format("SELECT * FROM lendin where Sta like \"%%%s%%\" limit %d,5","转借",page*5);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Lendin Cp=new Lendin();
				Cp.setMaintext(res.getString("maintext"));
				Cp.setEquName(res.getString("Equname"));
				Cp.setLendNumber(res.getInt("LendNumber"));
				Cp.setLendUnit(res.getString("LendUnit"));
				Cp.setUnitLend(res.getString("unitlend"));
				Cp.setSta(res.getString("Sta"));
				Cp.setApplicant(res.getString("Applicant"));
				Cp.setApplicationDate1(res.getString("ApplicationDate1"));
				Cp.setApplicationDate2(res.getString("ApplicationDate2"));
				Cp.setApprover(res.getString("Approver"));			
				Cp.setCountdown(res.getString("Countdown"));
				ret.add(Cp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public Vector<Retirement> selectRetir(String unit,int page) {
		Vector<Retirement> reh=new Vector<Retirement>();
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM retire where EquUnit = '%s' limit %d,5",unit,page*5);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Retirement Re=new Retirement();
				
				Re.setEquNumber(res.getInt("EquNumber"));
				Re.setEquName(res.getString("EquName"));
				Re.setEquDate(res.getString("EquDate"));
				Re.setApplication(res.getString("Application"));
				Re.setApplicant(res.getString("Applicant"));
				Re.setRetireDate(res.getString("RetireDate"));
				Re.setApprover(res.getString("Approver"));
				Re.setEquUnit(res.getString("EquUnit"));
				Re.setEquClass(res.getString("EquClass"));
				Re.setInventoryPosition(res.getString("InventoryPosition"));
				Re.setUnitPrice(res.getString("UnitPrice"));
				Re.setHandler(res.getString("Handler"));
				Re.setEquSta(res.getString("EquSta"));
				Re.setApplicationDate(res.getString("ApplicationDate"));
				reh.add(Re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reh;
	}
	
	public Vector<Retirement> selectRetirAdmin(int type,int page,String unit) {
		Vector<Retirement> reh=new Vector<Retirement>();
		try {
			stm = con.createStatement();
			String sql=null;
			if(type==0)
				sql = String.format("SELECT * FROM retire where EquSta like \"%%%s%%\" limit %d,5","审批",page*5);
			else if(type==1)
				sql = String.format("SELECT * FROM retire where EquSta like \"%%%s%%\" limit %d,5","待",page*5);
			else if(type==2)
				sql = String.format("SELECT * FROM retire where EquUnit = '%s' and EquSta like \"%%%s%%\" limit %d,5",unit,"审批",page*5);
			else if(type==3)
				sql = String.format("SELECT * FROM retire where EquUnit = '%s' and EquSta like \"%%%s%%\" limit %d,5",unit,"待",page*5);
			else
				sql = String.format("SELECT * FROM retire limit %d,3",page*3);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Retirement Re=new Retirement();
				
				Re.setEquNumber(res.getInt("EquNumber"));
				Re.setEquName(res.getString("EquName"));
				Re.setEquDate(res.getString("EquDate"));
				Re.setApplication(res.getString("Application"));
				Re.setApplicant(res.getString("Applicant"));
				Re.setRetireDate(res.getString("RetireDate"));
				Re.setApprover(res.getString("Approver"));
				Re.setEquUnit(res.getString("EquUnit"));
				Re.setEquClass(res.getString("EquClass"));
				Re.setInventoryPosition(res.getString("InventoryPosition"));
				Re.setUnitPrice(res.getString("UnitPrice"));
				Re.setHandler(res.getString("Handler"));
				Re.setEquSta(res.getString("EquSta"));
				Re.setApplicationDate(res.getString("ApplicationDate"));
				reh.add(Re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reh;
	}
	
	public Vector<Lendin> SelectAdminLend(int type,int page,String unit) {
		Vector<Lendin> ret=new Vector<Lendin>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql = String.format("SELECT * FROM lendin where Sta like \"%%%s%%\" limit %d,5","转借",page*5);
			else if(type==1)
				sql = String.format("SELECT * FROM lendin where Sta like \"%%%s%%\" limit %d,5","待",page*5);
			else if(type==2)
				sql = String.format("SELECT * FROM lendin where  Lendunit = '%s' and Sta like \"%%%s%%\" limit %d,5",unit,"转借",page*5);
			else if(type==3)
				sql = String.format("SELECT * FROM lendin where  Lendunit = '%s' and Sta like \"%%%s%%\" limit %d,5",unit,"待",page*5);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Lendin Cp=new Lendin();
				
				Cp.setMaintext(res.getString("maintext"));
				Cp.setEquName(res.getString("Equname"));
				Cp.setLendNumber(res.getInt("LendNumber"));
				Cp.setLendUnit(res.getString("LendUnit"));
				Cp.setUnitLend(res.getString("unitlend"));
				Cp.setSta(res.getString("Sta"));
				Cp.setApplicant(res.getString("Applicant"));
				Cp.setApplicationDate1(res.getString("ApplicationDate1"));
				Cp.setApplicationDate2(res.getString("ApplicationDate2"));
				Cp.setApprover(res.getString("Approver"));		
				Cp.setCountdown(res.getString("Countdown"));
				ret.add(Cp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public void UpdateCs(int EquNumber,String ModelSpe,Date EquDate,String Manufacturer,String Supplier,Date OrderDate,String Inspector,String InventoryPosition,String PresentPosition,String UnitPrice,String Handler) {
		try {
			stm = con.createStatement();
			String sql = String.format("update cs set ModelSpe='%s',EquDate='%s',Manufacturer='%s',Supplier='%s',"
					+ "OrderDate='%s',Inspector='%s',InventoryPosition='%s',PresentPosition='%s',"
					+ "UnitPrice='%s',Handler='%s' where EquNumber=%d",ModelSpe,EquDate,Manufacturer,Supplier,OrderDate,Inspector,InventoryPosition,PresentPosition,UnitPrice,Handler,EquNumber);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Lendin SelectLendById(int EquNumber) {
		Lendin Cp=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM lendin where LendNumber = %d",EquNumber);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Cp=new Lendin();
				Cp.setMaintext(res.getString("Maintext"));
				Cp.setEquName(res.getString("Equname"));
				Cp.setLendNumber(res.getInt("LendNumber"));
				Cp.setLendUnit(res.getString("Lendunit"));
				Cp.setUnitLend(res.getString("unitlend"));
				Cp.setSta(res.getString("Sta"));
				Cp.setApplicant(res.getString("Applicant"));
				Cp.setApplicationDate1(res.getString("ApplicationDate1"));
				Cp.setApplicationDate2(res.getString("ApplicationDate2"));
				Cp.setApprover(res.getString("Approver")); 
				Cp.setApplication(res.getString("Application"));
				Cp.setCountdown(res.getString("Countdown"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cp;
	}

	public void AgreeRetire(String asd,int EquNumber,String date,String name) {
		try {
			stm = con.createStatement();			
			String sql=String.format("update retire set EquSta='%s' ,Approver = '%s',RetireDate ='%s' where EquNumber=%d",asd,name,date,EquNumber);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Retirement selectRetirByID(int EquNumber) {
		Retirement Re=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM retire where EquNumber = %d",EquNumber);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Re=new Retirement();
				
				Re.setEquNumber(res.getInt("EquNumber"));
				Re.setEquName(res.getString("EquName"));
				Re.setEquDate(res.getString("EquDate"));
				Re.setApplication(res.getString("Application"));
				Re.setApplicant(res.getString("Applicant"));
				Re.setRetireDate(res.getString("RetireDate"));
				Re.setApprover(res.getString("Approver"));
				Re.setEquUnit(res.getString("EquUnit"));
				Re.setEquClass(res.getString("EquClass"));
				Re.setInventoryPosition(res.getString("InventoryPosition"));
				Re.setUnitPrice(res.getString("UnitPrice"));
				Re.setHandler(res.getString("Handler"));
				Re.setEquSta(res.getString("EquSta"));
				Re.setApplicationDate((res.getString("ApplicationDate")));;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Re;
	}
	
	public void updateLend1(String sta,int EquNumber,String unitLend) {
		try {
			stm=con.createStatement();
			String sql=String.format("update cs set extra='%s' ,EquUnit = '%s' where EquNumber=%d",sta,unitLend,EquNumber);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void UpdateLend2(String sta,int EquNumber,String name) {
		try {
			stm=con.createStatement();
			String sql=String.format("update lendin set Sta='%s' ,Approver = '%s'where LendNumber=%d",sta,name,EquNumber);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void DeleteLendin(int EquNumber) {
		try {
			stm=con.createStatement();
			String sql=String.format("delete from lendin where LendNumber=%d",EquNumber);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void AddCs(Cs ch) {
		try {
			stm = con.createStatement();
			String sql = "INSERT INTO cs (EquNumber, EquName, EquQua, ModelSpe, EquDate, EquSta, EquClass, EquUnit, EquPic, Manufacturer, Supplier, Specifications,"
					+ "OrderDate, Inspector, Quality, Maintainer, InventoryPosition, PresentPosition, UnitPrice, OrderQuantity, Handler, extra) VALUES " +
					String.format("(%d,\"%s\",%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\""
							+ ",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%d,\"%s\",\"%s\");"
							,ch.getEquNumber(),ch.getEquName(),1,"IS-201","2017-01-01","空闲","Micro-Computer",ch.getEquUnit(),"null","华硕","华硕旗舰店","台/箱",
							"2015-06-03","张三","合格","李四","计算机301库房","理学楼203","7299",1,"王五","null");
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Vector<String> invitecode() {
		Vector<String> ret=new Vector<String>();
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM invite where flag='%s'","有效");
			res = stm.executeQuery(sql);
			while(res.next()) {
				String Re="";
				Re=res.getString("invitateid");
				ret.add(Re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public int invitenumber(int type) {
		int p=0;
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				 sql = String.format("SELECT count(*) number FROM invite where flag='%s'","有效");
			else if(type==1)
				sql = String.format("SELECT count(*) number FROM invite where flag='%s'","无效");
			else if(type==3)
				sql = String.format("SELECT count(*) number FROM invite");
			res = stm.executeQuery(sql);
			if(res.next()) {
				p=res.getInt("number");
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	public void CreatNewInvite(String invite,int id) {
		try {
			stm = con.createStatement();
			String sql = "INSERT INTO invite (id,invitateid, type, flag) VALUES " +
					String.format("(%d,\"%s\",\"%s\",\"%s\");"
							,id,invite,"0","有效" );
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Vector<Repair> selectRepair(int type,String unit) {
		Vector<Repair>  reh=new Vector<Repair> ();
		try {
			stm = con.createStatement();
		    String sql="";
		    if(type==0)
		    	sql = String.format("SELECT * FROM repair where EquUnit= '%s' and Sta like \"%%%s%%\"",unit,"待");
		    else if(type==1)
		    	sql = String.format("SELECT * FROM repair where Sta like \"%%%s%%\"","已维");
		    else if(type==2)
		    	sql = String.format("SELECT * FROM repair where Sta like \"%%%s%%\"","待");
			res = stm.executeQuery(sql);
			while(res.next()) {
				Repair Re=new Repair();
				
				Re.setTitle(res.getString("title"));
				Re.setEquName(res.getString("EquName"));
				Re.setEquNumber(res.getInt("EquNumber"));
				Re.setApplicant(res.getString("Applicant"));
				Re.setApplication(res.getString("Application"));
				Re.setApplicationDate(res.getString("Applicantdate"));
				Re.setLocation(res.getString("location"));
				Re.setPhone(res.getString("phone"));
				Re.setOverDate(res.getString("OverDate"));
				Re.setEquUnit(res.getString("EquUnit"));
				Re.setConductor(res.getString("conductor"));                       
				Re.setEquClass(res.getString("EquClass"));
				Re.setSta(res.getString("Sta"));
				Re.setOverDate(res.getString("OverDate"));
				reh.add(Re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reh;
	}
	public void UpdateRepair(int EquNumber,String name,String data) {
		try {
			stm=con.createStatement();
			String sql=String.format("update repair set Sta='%s',OverDate='%s',conductor='%s'where EquNumber=%d","已维修",data,name,EquNumber);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteRepair(int EquNumber) {
		try {
			stm=con.createStatement();
			String sql=String.format("delete from repair where EquNumber=%d",EquNumber);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if (con != null) con.close();
			if (stm != null) stm.close();
			if (res != null) res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public Vector<Patient> selectPatient(int page,String unit,int type) {//主界面患者管理大表,获得Vector
		Vector<Patient> ret=new Vector<Patient>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM patient limit %d,5",page*5);
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				Patient Pa=new Patient();
				
				Pa.setId(res.getInt("id"));
				Pa.setName(res.getString("name"));
				Pa.setDatebirth(res.getString("datebirth"));
				Pa.setSex(res.getString("sex"));
				Pa.setAddress(res.getString("address"));
				Pa.setTelephone(res.getString("telephone"));
				Pa.setEmergency_person(res.getString("emergency_person"));
				Pa.setEmergency_person_telephone(res.getString("emergency_person_telephone"));
				Pa.setUsername(res.getString("username"));
				Pa.setPassword(res.getString("password"));
				Pa.setMail(res.getString("mail"));
				Pa.setAge(res.getString("age"));
				Pa.setAddresscode(res.getString("addresscode"));
				Pa.setLanguage(res.getString("language"));
				Pa.setInsurance(res.getString("insurance"));
				
				ret.add(Pa);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Patient selectPatientNumber(int id) {//update修改患者信息,获得单个Pa
		Patient Pa=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM patient WHERE id = %d ", id);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Pa=new Patient();
				
				Pa.setId(res.getInt("id"));
				Pa.setName(res.getString("name"));
				Pa.setDatebirth(res.getString("datebirth"));
				Pa.setSex(res.getString("sex"));
				Pa.setAddress(res.getString("address"));
				Pa.setTelephone(res.getString("telephone"));
				Pa.setEmergency_person(res.getString("emergency_person"));
				Pa.setEmergency_person_telephone(res.getString("emergency_person_telephone"));
				Pa.setUsername(res.getString("username"));
				Pa.setPassword(res.getString("password"));
				Pa.setMail(res.getString("mail"));
				Pa.setAge(res.getString("age"));
				Pa.setAddresscode(res.getString("addresscode"));
				Pa.setLanguage(res.getString("language"));
				Pa.setInsurance(res.getString("insurance"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Pa;
	}
	public void UpdatePatient(int id,
			String name,

			String sex,
			String address,
			String telephone,
			String emergency_person,
			String emergency_person_telephone,

			String password,
			String mail,
			String age,
			String addresscode,
			String language,
			String insurance) {
		try {
			stm = con.createStatement();
			String sql = String.format("update patient set name='%s',sex='%s',address='%s',telephone='%s',"
					+ "emergency_person='%s',emergency_person_telephone='%s',password='%s',mail='%s',age='%s',addresscode='%s',"
					+ "language='%s',insurance='%s' where id=%d",name,sex,address,telephone,emergency_person,emergency_person_telephone,password,mail,age,addresscode,language,insurance,id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void AddPatient(Patient Pa) {
		try {
			stm = con.createStatement();//15个
			String sql = "INSERT INTO patient (id, name, datebirth, sex, address, telephone, emergency_person, emergency_person_telephone, username, password, mail, age, addresscode, language, insurance)"
					+ " VALUES " +
					String.format("(%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\""
							+ ",\"%s\",\"%s\",\"%s\");"
							,Pa.getId(),Pa.getName(),Pa.getDatebirth(),Pa.getSex(),Pa.getAddress(),Pa.getTelephone(),Pa.getEmergency_person(),Pa.getEmergency_person_telephone(),Pa.getUsername(),Pa.getPassword(),Pa.getMail(),Pa.getAge(),Pa.getAddresscode(),Pa.getLanguage(),Pa.getInsurance());
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Vector<Patient> selectPatientAll(String aim,String unit,int type,int page) {
		Vector<Patient> ret=new Vector<Patient>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM patient where concat(id, name, datebirth, sex, address, telephone, username, "
						+ "mail, age, language, insurance "
						+ ") like  \"%%%s%%\"and  EquUnit ='%s' limit %d,5",aim,unit,page*5);
			else if(type==1)//就是这个，上面那个没啥用
				sql=String.format("SELECT * FROM patient where concat(id, name, datebirth, sex, address, telephone, username, "
						+ "mail, age, language, insurance "
						+ ") like  \"%%%s%%\" limit %d,5",aim,page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Patient Pa=new Patient();
				
				Pa.setId(res.getInt("id"));
				Pa.setName(res.getString("name"));
				Pa.setDatebirth(res.getString("datebirth"));
				Pa.setSex(res.getString("sex"));
				Pa.setAddress(res.getString("address"));
				Pa.setTelephone(res.getString("telephone"));
				Pa.setEmergency_person(res.getString("emergency_person"));
				Pa.setEmergency_person_telephone(res.getString("emergency_person_telephone"));
				Pa.setUsername(res.getString("username"));
				Pa.setPassword(res.getString("password"));
				Pa.setMail(res.getString("mail"));
				Pa.setAge(res.getString("age"));
				Pa.setAddresscode(res.getString("addresscode"));
				Pa.setLanguage(res.getString("language"));
				Pa.setInsurance(res.getString("insurance"));
				
				ret.add(Pa);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void PatientDeleteExecute(int id) {
		try {
			stm = con.createStatement();
			String sql = String.format("DELETE from patient where id='%d'"
						,id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Exam> selectExam(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<Exam> ret=new Vector<Exam>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM exam limit %d,5",page*5);
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				Exam Ex=new Exam();
				
				Ex.setExam_id(res.getInt("exam_id"));
				Ex.setPatient_id(res.getInt("patient_id"));
				Ex.setTime(res.getString("time"));
				Ex.setHeight(res.getString("height"));
				Ex.setWeight(res.getString("weight"));
				Ex.setPulserate(res.getString("pulserate"));
				Ex.setBloodpressure(res.getString("bloodpressure"));
				Ex.setSpo(res.getString("spo"));
				Ex.setTemperature(res.getString("temperature"));
				Ex.setBwh(res.getString("bwh"));
				Ex.setResult(res.getString("result"));
				Ex.setPatientname(res.getString("patientname"));
				Ex.setSex(res.getString("sex"));
				Ex.setAge(res.getString("age"));
				
				ret.add(Ex);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Exam selectExamNumber(int exam_id) {//update修改信息,获得单个
		Exam Ex=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM exam WHERE exam_id = %d ", exam_id);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Ex=new Exam();
				
				Ex.setExam_id(res.getInt("exam_id"));
				Ex.setPatient_id(res.getInt("patient_id"));
				Ex.setTime(res.getString("time"));
				Ex.setHeight(res.getString("height"));
				Ex.setWeight(res.getString("weight"));
				Ex.setPulserate(res.getString("pulserate"));
				Ex.setBloodpressure(res.getString("bloodpressure"));
				Ex.setSpo(res.getString("spo"));
				Ex.setTemperature(res.getString("temperature"));
				Ex.setBwh(res.getString("bwh"));
				Ex.setResult(res.getString("result"));
				Ex.setPatientname(res.getString("patientname"));
				Ex.setSex(res.getString("sex"));
				Ex.setAge(res.getString("age"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Ex;
	}
	public void ExamUpdate(int exam_id,
			int patient_id,

			String patientname,
			String time,
			String height,
			String weight,
			String pulserate,
			String bloodpressure,
			String spo,
			String temperature,
			String bwh
			) {
		try {
			stm = con.createStatement();
			String sql = String.format("update exam set patientname='%s',time='%s',height='%s',weight='%s',"
					+ "pulserate='%s',bloodpressure='%s',spo='%s',temperature='%s',bwh='%s'"
					+ "where exam_id=%d",patientname,time,height,weight,pulserate,bloodpressure,spo,temperature,bwh,exam_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ExamAdd(Exam Ex) {
		try {
			stm = con.createStatement();//12ge
			String sql = "INSERT INTO exam (exam_id, time, height, weight, pulserate, bloodpressure, spo, temperature, bwh, patientname, sex, age)"
					+ " VALUES " +
					String.format("(%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\","
							+ "\"%s\",\"%s\");"
							,Ex.getExam_id(),Ex.getTime(),Ex.getHeight(),Ex.getWeight(),Ex.getPulserate(),Ex.getBloodpressure(),Ex.getSpo(),Ex.getTemperature(),Ex.getBwh(),Ex.getPatientname(),Ex.getSex(),Ex.getAge());
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Vector<Exam> ExamselectAll(String aim,String unit,int type,int page) {
		Vector<Exam> ret=new Vector<Exam>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM exam where concat(patientname, sex, age, time"
						+ " "
						+ ") like  \"%%%s%%\"and  EquUnit ='%s' limit %d,5",aim,unit,page*5);
			else if(type==1)//就是这个，上面那个没啥用
				sql=String.format("SELECT * FROM exam where concat(patientname, sex, age, time"
						+ " "
						+ ") like  \"%%%s%%\" limit %d,5",aim,page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Exam Ex=new Exam();
				
				Ex.setExam_id(res.getInt("exam_id"));
				Ex.setPatient_id(res.getInt("patient_id"));
				Ex.setTime(res.getString("time"));
				Ex.setHeight(res.getString("height"));
				Ex.setWeight(res.getString("weight"));
				Ex.setPulserate(res.getString("pulserate"));
				Ex.setBloodpressure(res.getString("bloodpressure"));
				Ex.setSpo(res.getString("spo"));
				Ex.setTemperature(res.getString("temperature"));
				Ex.setBwh(res.getString("bwh"));
				Ex.setResult(res.getString("result"));
				Ex.setPatientname(res.getString("patientname"));
				Ex.setSex(res.getString("sex"));
				Ex.setAge(res.getString("age"));
				
				ret.add(Ex);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void ExamDeleteExecute(int exam_id) {
		try {
			stm = con.createStatement();
			String sql = String.format("DELETE from exam where exam_id='%d'"
						,exam_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Case> selectCase(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<Case> ret=new Vector<Case>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM case_history limit %d,5",page*5);
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				Case Ca=new Case();
				Ca.setCase_id(res.getInt("case_id"));
				Ca.setDoctor_id(res.getInt("doctor_id"));
				Ca.setPatient_id(res.getInt("patient_id"));
				Ca.setRecep_id(res.getInt("recep_id"));
				Ca.setDescription(res.getString("description"));
				Ca.setDiagnose(res.getString("diagnose"));
				Ca.setDepartment(res.getString("department"));
				Ca.setDate(res.getString("date"));
				Ca.setPatientname(res.getString("patientname"));
				Ca.setPatientage(res.getString("patientage"));
				Ca.setPatientsex(res.getString("patientsex"));
				Ca.setDoctorname(res.getString("doctorname"));
				Ca.setDoctorage(res.getString("doctorage"));
				Ca.setDoctorsex(res.getString("doctorsex"));
				
				ret.add(Ca);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Case selectCaseNumber(int case_id) {//update修改信息,获得单个
		Case Ca=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM case_history WHERE case_id = %d ", case_id);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Ca=new Case();
				
				Ca.setCase_id(res.getInt("case_id"));
				Ca.setDoctor_id(res.getInt("doctor_id"));
				Ca.setPatient_id(res.getInt("patient_id"));
				Ca.setRecep_id(res.getInt("recep_id"));
				Ca.setDescription(res.getString("description"));
				Ca.setDiagnose(res.getString("diagnose"));
				Ca.setDepartment(res.getString("department"));
				Ca.setDate(res.getString("date"));
				Ca.setPatientname(res.getString("patientname"));
				Ca.setPatientage(res.getString("patientage"));
				Ca.setPatientsex(res.getString("patientsex"));
				Ca.setDoctorname(res.getString("doctorname"));
				Ca.setDoctorage(res.getString("doctorage"));
				Ca.setDoctorsex(res.getString("doctorsex"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Ca;
	}
	public Vector<Case> CaseselectAll(String aim,String unit,int type,int page) {
		Vector<Case> ret=new Vector<Case>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM case_history where concat(department, patientname, doctorname, date"
						+ " "
						+ ") like  \"%%%s%%\"and  EquUnit ='%s' limit %d,5",aim,unit,page*5);
			else if(type==1)//就是这个，上面那个没啥用
				sql=String.format("SELECT * FROM case_history where concat(department, patientname, doctorname, date"
						+ " "
						+ ") like  \"%%%s%%\" limit %d,5",aim,page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Case Ca =new Case();
				
				Ca.setCase_id(res.getInt("case_id"));
				Ca.setDoctor_id(res.getInt("doctor_id"));
				Ca.setPatient_id(res.getInt("patient_id"));
				Ca.setRecep_id(res.getInt("recep_id"));
				Ca.setDescription(res.getString("description"));
				Ca.setDiagnose(res.getString("diagnose"));
				Ca.setDepartment(res.getString("department"));
				Ca.setDate(res.getString("date"));
				Ca.setPatientname(res.getString("patientname"));
				Ca.setPatientage(res.getString("patientage"));
				Ca.setPatientsex(res.getString("patientsex"));
				Ca.setDoctorname(res.getString("doctorname"));
				Ca.setDoctorage(res.getString("doctorage"));
				Ca.setDoctorsex(res.getString("doctorsex"));
				
				ret.add(Ca);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void CaseDeleteExecute(int case_id) {
		try {
			stm = con.createStatement();
			String sql = String.format("DELETE from case_history where case_id='%d'"
						,case_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Doctor> selectDoctor(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<Doctor> ret=new Vector<Doctor>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM doctor limit %d,5",page*5);
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				Doctor Doct=new Doctor();
				
				Doct.setDoctor_id(res.getInt("doctor_id"));
				Doct.setUsername(res.getString("username"));
				Doct.setPassword(res.getString("password"));
				Doct.setReal_id(res.getString("real_id"));
				Doct.setReal_name(res.getString("real_name"));
				Doct.setSex(res.getString("sex"));
				Doct.setAge(res.getString("age"));
				Doct.setSafe_question(res.getString("safe_question"));
				Doct.setStd_answer(res.getString("std_answer"));
				Doct.setClinic(res.getString("clinic"));
				Doct.setDepartment(res.getString("department"));
				Doct.setAddress(res.getString("address"));
				Doct.setEmail(res.getString("email"));
				Doct.setPhone(res.getString("phone"));
				Doct.setInsuranceget(res.getString("insuranceget"));
				Doct.setBirthday(res.getString("birthday"));
				Doct.setIntroduction(res.getString("introduction"));
				Doct.setLicence1(res.getString("licence1"));
				Doct.setLicence2(res.getString("licence2"));
				Doct.setPicture(res.getString("picture"));
				Doct.setVerificationcode(res.getString("verificationcode"));
				Doct.setSta(res.getInt("sta"));
				
				ret.add(Doct);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Doctor selectDoctorNumber(int doctor_id) {//update修改信息,获得单个
		Doctor Doct=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM doctor WHERE doctor_id = %d ", doctor_id);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Doct=new Doctor();
				
				Doct.setDoctor_id(res.getInt("doctor_id"));
				Doct.setUsername(res.getString("username"));
				Doct.setPassword(res.getString("password"));
				Doct.setReal_id(res.getString("real_id"));
				Doct.setReal_name(res.getString("real_name"));
				Doct.setSex(res.getString("sex"));
				Doct.setAge(res.getString("age"));
				Doct.setSafe_question(res.getString("safe_question"));
				Doct.setStd_answer(res.getString("std_answer"));
				Doct.setClinic(res.getString("clinic"));
				Doct.setDepartment(res.getString("department"));
				Doct.setAddress(res.getString("address"));
				Doct.setEmail(res.getString("email"));
				Doct.setPhone(res.getString("phone"));
				Doct.setInsuranceget(res.getString("insuranceget"));
				Doct.setBirthday(res.getString("birthday"));
				Doct.setIntroduction(res.getString("introduction"));
				Doct.setLicence1(res.getString("licence1"));
				Doct.setLicence2(res.getString("licence2"));
				Doct.setPicture(res.getString("picture"));
				Doct.setVerificationcode(res.getString("verificationcode"));
				Doct.setSta(res.getInt("sta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Doct;
	}
	public void DoctorUpdate(int doctor_id,
			String username,
			String password,
			String real_id,
			String real_name,
			String sex,
			String age,
			String safe_question,
			String std_answer,
			String clinic,
			String department,
			String address,
			String email,
			String phone,
			String insuranceget,
			String birthday,
			String introduction,
			String licence1,
			String licence2,
			String picture,
			String verificationcode,
			int sta
			) {
		try {
			stm = con.createStatement();
			String sql = String.format("update doctor set real_name='%s',sex='%s',age='%s',address='%s',phone='%s',"
					+ "email='%s',birthday='%s',password='%s',clinic='%s',department='%s',introduction='%s',"
					+ "verificationcode='%s',insuranceget='%s' where doctor_id=%d",real_name,sex,age,address,phone,email,birthday,password,clinic,department,introduction,verificationcode,insuranceget,doctor_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void DoctorUpdateSta(int doctor_id
			
			) {
		try {
			stm = con.createStatement();
			String sql = String.format("update doctor set sta='%d'"
					+ ""
					+ " where doctor_id=%d",1,doctor_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Vector<Doctor> DoctorselectAll(String aim,String unit,int type,int page) {
		Vector<Doctor> ret=new Vector<Doctor>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM doctor where concat(real_name, sex, clinic, department, sta"
						+ " "
						+ ") like  \"%%%s%%\"and  EquUnit ='%s' limit %d,5",aim,unit,page*5);
			else if(type==1)//就是这个，上面那个没啥用
				sql=String.format("SELECT * FROM doctor where concat(real_name, sex, clinic, department, sta"
						+ " "
						+ ") like  \"%%%s%%\" limit %d,5",aim,page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Doctor Doct=new Doctor();
				
				Doct.setDoctor_id(res.getInt("doctor_id"));
				Doct.setUsername(res.getString("username"));
				Doct.setPassword(res.getString("password"));
				Doct.setReal_id(res.getString("real_id"));
				Doct.setReal_name(res.getString("real_name"));
				Doct.setSex(res.getString("sex"));
				Doct.setAge(res.getString("age"));
				Doct.setSafe_question(res.getString("safe_question"));
				Doct.setStd_answer(res.getString("std_answer"));
				Doct.setClinic(res.getString("clinic"));
				Doct.setDepartment(res.getString("department"));
				Doct.setAddress(res.getString("address"));
				Doct.setEmail(res.getString("email"));
				Doct.setPhone(res.getString("phone"));
				Doct.setInsuranceget(res.getString("insuranceget"));
				Doct.setBirthday(res.getString("birthday"));
				Doct.setIntroduction(res.getString("introduction"));
				Doct.setLicence1(res.getString("licence1"));
				Doct.setLicence2(res.getString("licence2"));
				Doct.setPicture(res.getString("picture"));
				Doct.setVerificationcode(res.getString("verificationcode"));
				Doct.setSta(res.getInt("sta"));
				
				ret.add(Doct);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void DoctorDeleteExecute(int doctor_id) {
		try {
			stm = con.createStatement();
			String sql = String.format("DELETE from doctor where doctor_id='%d'"
						,doctor_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public Vector<Department_question> selectQuestionVect(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<Department_question> ret=new Vector<Department_question>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM department_question");
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				Department_question Ques=new Department_question();
				
				Ques.setQuestion_id(res.getInt("question_id"));
				Ques.setQuestion_pre(res.getString("question_pre"));
				Ques.setDepartment(res.getString("department"));
				Ques.setTypedisease(res.getString("typedisease"));
				
				ret.add(Ques);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Vector<Department_question> QuestionSelectAll(String aim,String unit,int type,int page) {
		Vector<Department_question> ret=new Vector<Department_question>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM department_question where concat(typedisease"
						+ " "
						+ ") like  \"%%%s%%\"and  EquUnit ='%s' limit %d",aim,unit);
			else if(type==1)//就是这个，上面那个没啥用
				sql=String.format("SELECT * FROM department_question where concat(typedisease"
						+ " "
						+ ") like  \"%%%s%%\" ",aim);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Department_question Ques=new Department_question();
				
				Ques.setQuestion_id(res.getInt("question_id"));
				Ques.setQuestion_pre(res.getString("question_pre"));
				Ques.setDepartment(res.getString("department"));
				Ques.setTypedisease(res.getString("typedisease"));
				
				ret.add(Ques);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void QuestionAdd(Department_question Ques) {
		try {
			stm = con.createStatement();//
			String sql = "INSERT INTO department_question (question_pre, typedisease)"
					+ " VALUES " +
					String.format("(\"%s\","
							+ "\"%s\");"
							,Ques.getQuestion_pre(),Ques.getTypedisease());
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void QuestionDeleteExecute(int question_id) {
		try {
			stm = con.createStatement();
			String sql = String.format("DELETE from department_question where question_id='%d'"
						,question_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Vector<Department_question> selectQuestion(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<Department_question> ret=new Vector<Department_question>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM department_question");
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				Department_question Ques=new Department_question();
				
				Ques.setQuestion_id(res.getInt("question_id"));
				Ques.setQuestion_pre(res.getString("question_pre"));
				Ques.setDepartment(res.getString("department"));
				Ques.setTypedisease(res.getString("typedisease"));
				
				ret.add(Ques);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
	public Vector<Patientanswer> selectAnswer(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<Patientanswer> ret=new Vector<Patientanswer>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM patientanswer ");
				//sql = String.format("SELECT * FROM patientanswer limit %d,5",page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Patientanswer Ans=new Patientanswer();
				
				Ans.setPatientanswer_id(res.getInt("patientanswer_id"));
				Ans.setQuestion_id(res.getInt("question_id"));
				Ans.setPatient_id(res.getInt("patient_id"));
				Ans.setAnswer_content(res.getString("answer_content"));
				Ans.setTime(res.getString("time"));
				Ans.setQuestion_content(res.getString("question_content"));
				Ans.setTypedisease(res.getString("typedisease"));
				Ans.setPatientname(res.getString("patientname"));
				Ans.setDepartment(res.getString("department"));
				Ans.setRecep_id(res.getInt("recep_id"));
				Ans.setSta(res.getInt("sta"));

				ret.add(Ans);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Patientanswer selectAnswerNumber(int patientanswer_id) {//update修改信息,获得单个
		Patientanswer Ans=null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM patientanswer WHERE patientanswer_id = %d ", patientanswer_id);
			res = stm.executeQuery(sql);
			if(res.next()) {
				Ans=new Patientanswer();
				
				Ans.setPatientanswer_id(res.getInt("patientanswer_id"));
				Ans.setQuestion_id(res.getInt("question_id"));
				Ans.setPatient_id(res.getInt("patient_id"));
				Ans.setAnswer_content(res.getString("answer_content"));
				Ans.setTime(res.getString("time"));
				Ans.setQuestion_content(res.getString("question_content"));
				Ans.setTypedisease(res.getString("typedisease"));
				Ans.setPatientname(res.getString("patientname"));
				Ans.setDepartment(res.getString("department"));
				Ans.setRecep_id(res.getInt("recep_id"));
				Ans.setSta(res.getInt("sta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Ans;
	}
	public void AnswerUpdateSta(int patientanswer_id
				
				) {
			try {
				stm = con.createStatement();
				String sql = String.format("update patientanswer set sta='%d'"
						+ ""
						+ " where patientanswer_id=%d",0,patientanswer_id);
				System.out.println(sql);
				stm.executeUpdate(sql);
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	public Vector<Patientanswer> PatientselectAll(String aim,String unit,int type,int page) {
		Vector<Patientanswer> ret=new Vector<Patientanswer>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM patientanswer where concat(typedisease, patientname, time"
						+ " "
						+ ") like  \"%%%s%%\"and  EquUnit ='%s' limit %d,5",aim,unit,page*5);
			else if(type==1)//就是这个，上面那个没啥用
				sql=String.format("SELECT * FROM patientanswer where concat(typedisease, patientname, time"
						+ " "
						+ ") like  \"%%%s%%\" ",aim);
						//+ ") like  \"%%%s%%\" limit %d,5",aim,page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Patientanswer Ans =new Patientanswer();
				
				Ans.setPatientanswer_id(res.getInt("patientanswer_id"));
				Ans.setQuestion_id(res.getInt("question_id"));
				Ans.setPatient_id(res.getInt("patient_id"));
				Ans.setAnswer_content(res.getString("answer_content"));
				Ans.setTime(res.getString("time"));
				Ans.setQuestion_content(res.getString("question_content"));
				Ans.setTypedisease(res.getString("typedisease"));
				Ans.setPatientname(res.getString("patientname"));
				Ans.setDepartment(res.getString("department"));
				Ans.setRecep_id(res.getInt("recep_id"));
				Ans.setSta(res.getInt("sta"));
				
				ret.add(Ans);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Vector<AnswerStatis> selectAnswerStatis(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<AnswerStatis> ret=new Vector<AnswerStatis>();
		try {
			stm = con.createStatement();
			String sql="";
			
			//sql = String.format("truncate answerstatis;");
			//res = stm.executeQuery(sql);
			sql = String.format("truncate answerstatis");
			System.out.println(sql);
			stm.executeUpdate(sql);
			
			sql = String.format("insert into answerstatis (question_content,question_id,countsta) (select question_content,question_id,count(question_id) from patientanswer where question_id in (Select question_id from patientanswer where sta='0') group by question_id)");
			System.out.println(sql);
			stm.executeUpdate(sql);
			
			sql = String.format("SELECT * FROM answerstatis ");
			System.out.println(sql);
			res = stm.executeQuery(sql);
			
			while(res.next()) {
				AnswerStatis Ans=new AnswerStatis();
				
				Ans.setQuestion_content(res.getString("question_content"));
				Ans.setQuestion_id(res.getInt("question_id"));
				Ans.setCountsta(res.getInt("countsta"));

				ret.add(Ans);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void AnswerDeleteExecute(int patientanswer_id) {
		try {
			stm = con.createStatement();
			String sql = String.format("DELETE from patientanswer where patientanswer_id='%d'"
						,patientanswer_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> GetQuestionByType(String typedisease){
		ArrayList<String> Description = new ArrayList<String>();//题目描述
		int i=0;
		try {
			stm = con.createStatement();
			String sql="";
			
			sql = String.format("SELECT * FROM department_question WHERE typedisease = '%s' ",typedisease);
			System.out.println("sql"+sql);
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				i++;
				Description.add(res.getString("typedisease")+"问题"+i+":  "+res.getString("question_pre"));
				System.out.println(res.getString("question_pre"));
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Description;
	}
	
	
	public Vector<Assess> selectAssess(int page,String unit,int type) {//主界面管理大表,获得Vector
		Vector<Assess> ret=new Vector<Assess>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==1)
				sql = String.format("SELECT * FROM assess limit %d,5",page*5);
			
			res = stm.executeQuery(sql);
			while(res.next()) {
				Assess Ass=new Assess();
				
				Ass.setAssess_id(res.getInt("assess_id"));
				Ass.setDoctor_id(res.getInt("doctor_id"));
				Ass.setPatient_id(res.getInt("patient_id"));
				Ass.setDoctorname(res.getString("doctorname"));
				Ass.setPatientname(res.getString("patientname"));
				Ass.setTime(res.getString("time"));
				Ass.setContent(res.getString("content"));
				
				ret.add(Ass);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void AssessAdd(Assess Ass) {
		try {
			stm = con.createStatement();//
			String sql = "INSERT INTO assess (doctor_id, patient_id, doctorname, patientname, time, content)"
					+ " VALUES " +
					String.format("(%d,\"%d\",\"%s\",\"%s\","
							+ "\"%s\",\"%s\");"
							,Ass.getDoctor_id(),Ass.getPatient_id(),Ass.getDoctorname(),Ass.getPatientname(),Ass.getTime(),Ass.getContent());
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Vector<Assess> AssessSelectAll(String aim,String unit,int type,int page) {
		Vector<Assess> ret=new Vector<Assess>();
		try {
			stm = con.createStatement();
			String sql="";
			if(type==0)
				sql=String.format("SELECT * FROM assess where concat(doctorname"
						+ " "
						+ ") like  \"%%%s%%\"and  EquUnit ='%s' limit %d,5",aim,unit,page*5);
			else if(type==1)//就是这个，上面那个没啥用
				sql=String.format("SELECT * FROM assess where concat(doctorname"
						+ " "
						+ ") like  \"%%%s%%\" limit %d,5",aim,page*5);
			System.out.println(sql);
			res = stm.executeQuery(sql);
			while(res.next()) {
				Assess Ass=new Assess();
				
				Ass.setAssess_id(res.getInt("assess_id"));
				Ass.setDoctor_id(res.getInt("doctor_id"));
				Ass.setPatient_id(res.getInt("patient_id"));
				Ass.setDoctorname(res.getString("doctorname"));
				Ass.setPatientname(res.getString("patientname"));
				Ass.setTime(res.getString("time"));
				Ass.setContent(res.getString("content"));
				
				ret.add(Ass);
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public void AssessDeleteExecute(int assess_id) {
		try {
			stm = con.createStatement();
			String sql = String.format("DELETE from assess where assess_id='%d'"
						,assess_id);
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
	}
}
