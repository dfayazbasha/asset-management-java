package managementapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.assetdao;
import model.Assets;

public class assetapp {
	public static void main(String[] args) {
		Assets asset=new Assets();
		assetdao dao=new assetdao();
		Scanner sc=new Scanner(System.in);
//		this.asset_id=asset_id;
//		this.name=name;
//		this.type=type;
//		this.serial_number=serial_number;
//		this.purchase_date=purchase_date;
//		this.location=location;
//		this.status=status;
//		this.owner_id=owner_id;
		
		System.out.println("enter name of asset to insert");
		String assetname=sc.nextLine();
		asset.setname(assetname);
//		sc.nextLine();
		System.out.println("Enter the type of asset: electronic or meterials ");
		String type=sc.nextLine();
		asset.settype(type);
		System.out.println("Enter serial number of asset:");
		int serialnumber=sc.nextInt();
		asset.setserial_number(serialnumber);
		sc.nextLine();
		 System.out.println("Enter purchase date (yyyy-MM-dd):");
	        String dateStr = sc.nextLine();

	        try {
	            // Convert user input to java.sql.Date
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date utilDate = sdf.parse(dateStr);
	            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	            asset.setpurchase_date(sqlDate);
	        } catch (Exception e) {
	            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
	            sc.close();
	            return;
	        }
	        
	        
	       System.out.println("ENter asset location:");
	       String location=sc.nextLine();
	       asset.setlocation(location);
	       System.out.println("enter asset status Available/not Available:");
	       String status=sc.nextLine();
	       asset.setstatus(status);
	       System.out.println("");
	       
	       
	       dao.addasset(asset);
	       System.out.println("Asset added succssfully ");
	       
		
	}

}
