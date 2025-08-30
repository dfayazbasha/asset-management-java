package empcontrols;

import java.util.List;
import java.util.Scanner;

import dao.assetsallocationdao;
import model.assetsallocation;

public class getmyassets {
	public static void main(String[] args) {
		assetsallocationdao aa=new assetsallocationdao();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter you id");
		int employee_id=sc.nextInt();
		List<assetsallocation> assets=aa.getmyassets(employee_id);
		if(assets.isEmpty()) {
			System.out.println(" Table list is empty");
		}else {
			for(assetsallocation a:assets) {
				System.out.println(a);
			}
		}
	}

}
