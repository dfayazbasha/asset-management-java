package managementapp;

import java.util.List;
import java.util.Scanner;

import dao.assetsallocationdao;

public class assetsallocation {
	
	
	
	
	
	
	
	
	
	


		public static void main(String[] args) {
			assetsallocationdao aa=new assetsallocationdao();
			Scanner sc=new Scanner(System.in);
		
			
			List<model.assetsallocation> assets=aa.getallassets();
			if(assets.isEmpty()) {
				System.out.println(" Table list is empty");
			}else {
				for(model.assetsallocation a:assets) {
					System.out.println(a);
				}
			}
		}

	


}
