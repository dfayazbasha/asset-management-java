package managementapp;

import java.util.List;

import dao.assetdao;
import dao.reservationsdao;
import model.reservations;

public class getallreservations {
	public static void main(String[] args) {
		
		reservationsdao  reservdao=new reservationsdao();
		List<reservations> reserv=reservdao.getAllReservations();
		if(reserv.isEmpty()) {
			System.out.println("reserve table is empty:");
		}
		else {
			for(reservations res:reserv) {
				System.out.println(res);
				
			}
		}
		
	}

}
