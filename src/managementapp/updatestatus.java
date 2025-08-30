package managementapp;

import java.util.Scanner;

import dao.reservationsdao;

public class updatestatus {
	public static void main(String[] args) {
		reservationsdao  reservdao=new reservationsdao();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter the employee id to update :");
		int employeeid=sc.nextInt();
		reservdao.approveReservationByEmployeeId(employeeid);
		
		
	}

}
