package empcontrols;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.reservationsdao;
import model.reservations;

public class reservasset {
	reservationsdao  reservdao=new reservationsdao();
	Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		reservationsdao  reservdao=new reservationsdao();
		Scanner sc= new Scanner(System.in);
		reservations reserv=new reservations();
		System.out.println("enter   asset_id you want:");
		int asset_id=sc.nextInt();
		reserv.setAsset_id(asset_id);
		sc.nextLine();
		
		System.out.println("enter  your _Id   : employee_id  : ");
		int employee_id=sc.nextInt();
		sc.nextLine();
		reserv.setEmployee_id(employee_id);
		
		 System.out.println("Enter reservation  date (yyyy-MM-dd):");
	        String reservdate  = sc.nextLine();

	        try {
	            // Convert user input to java.sql.Date
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date utilDate = sdf.parse(reservdate);
	            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	            reserv.setReservation_date(sqlDate);
	        } catch (Exception e) {
	            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
	            sc.close();
	            return;
	        }
		
	        System.out.println("Enter start  date (yyyy-MM-dd):");
	        String startdate  = sc.nextLine();

	        try {
	            // Convert user input to java.sql.Date
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date utilDate = sdf.parse(startdate);
	            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	            reserv.setStart_date(sqlDate);
	        } catch (Exception e) {
	            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
	            sc.close();
	            return;
	        }
	        
	        
	        System.out.println("Enter end  date (yyyy-MM-dd):");
	        String enddate  = sc.nextLine();

	        try {
	            // Convert user input to java.sql.Date
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date utilDate = sdf.parse(enddate);
	            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	            reserv.setEnd_date(sqlDate);
	        } catch (Exception e) {
	            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
	            sc.close();
	            return;
	        }
	        
	        reservdao.addreservation(reserv);
	        System.out.println("reservation added you will get  it approval  soon ");
//		asset_id, employee_id, reservation_date, start_date, end_date) V
	}

}
