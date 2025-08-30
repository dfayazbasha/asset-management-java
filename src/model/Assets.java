package model;

import java.util.*;

public class Assets {
	private int asset_id;
	private String name;
	private String type;
	private  int serial_number;
	private Date purchase_date;
	private String location;
	private String status;
	private int owner_id;
	
	
	
	// cpnstructors
	public Assets() {}
	public Assets(int asset_id,String name,String type,int serial_number,Date purchase_date,String location ,String status) {
		this.asset_id=asset_id;
		this.name=name;
		this.type=type;
		this.serial_number=serial_number;
		this.purchase_date=purchase_date;
		this.location=location;
		this.status=status;
		
	}
	public int getasset_id() {
		return asset_id;
	}
	public void setasset_id(int asset_id) {
		this.asset_id=asset_id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type=type;
	}
	public int getserial_number() {
		return serial_number;
	}
	public void setserial_number(int serial_number) {
		this.serial_number=serial_number;
	}
	public Date getpurchase_date() {
		return purchase_date;
	}
	public void setpurchase_date(Date purchase_date) {
		this.purchase_date=purchase_date;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location=location;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status=status;
	}
//	public int getowner_id() {
//		return owner_id;
//	}
//	public void setowner_id(int owner_id) {
//		this.owner_id=owner_id;
//	}

	@Override
	public String toString() {
	    return "Asset ID: " + asset_id +
	           ", Name: " + name +
	           ", Type: " + type +
	           ", Serial No: " + serial_number +
	           ", Purchase Date: " + purchase_date +
	           ", Location: " + location +
	           ", Status: " + status ;
	}

}
