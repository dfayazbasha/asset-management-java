package model;

import java.util.Date;

public class assetsallocation {
	
	
	 private int allocation_id;
	 private int asset_id;
	 private int employee_id;
	 private Date allocation_date;
	 private Date return_date;
	 
	 
	 
	 public assetsallocation(){}
	 public assetsallocation( int allocation_id,int asset_id, int employee_id, Date allocation_date, Date return_date ) {
		 this.allocation_id=allocation_id;
		 this.asset_id=asset_id;
		 this.employee_id=employee_id;
		 this.allocation_date=allocation_date;
		 this.return_date=return_date;
	 }
	 public int getallocation_id() {
		 return allocation_id;
	 }
	 public void setallocation_id(int allocation_id) {
		 this.allocation_id=allocation_id;
	 }
	 public int getasset_id() {
		 
		 return asset_id;
	 }
	 public void setasset_id(int asset_id) {
		 this.asset_id=asset_id;
	 }
	 public int employee_id() {
		 return employee_id;
	 }
	 public void setemployee_id(int employee_id) {
		 this.employee_id=employee_id;
	 }
	 public Date getallocation_date() {
		 return allocation_date;
	 }
	 public void setallocation_date(Date allocation_date) {
		 this.allocation_date=allocation_date;
	 }
	 public Date getreturn_date() {
		 return return_date;
	 }
	 public void setreturn_date(Date return_date) {
		 this.return_date=return_date;
	 }
	 public String toString() {
		 return "allocation_id  - "+allocation_id+" |asset_id  - "+asset_id+" |employee_id  -  "+employee_id+" |allocation_date  -  "+allocation_date+" |return date  -  "+return_date;
	 }
	 
	 
	

}
