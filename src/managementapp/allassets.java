package managementapp;

import java.util.List;

import dao.assetdao;
import model.Assets;

public class allassets {
	public static void main(String[] args) {
		assetdao dao=new assetdao();
		List<Assets> assets=dao.getallassets();
		if(assets.isEmpty()) {
			System.out.println("Assets list is empty:");
		}
		else {
			for(Assets asset:assets) {
				System.out.println(asset
						);
			}
		}
	}

}
