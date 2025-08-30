package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import model.Assets;
import model.assetsallocation;
import model.reservations;

public class assetsallocationdao {
	private Connection conn;
	public assetsallocationdao() {
		conn=DBConnection.getConnection();
	}
	public  List<assetsallocation> getallassets(){
		List<assetsallocation> assets=new ArrayList<>();
		String sql="SELECT * from asset_allocations";
		try(Statement stmt=conn.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			while( rs.next()) {
				assetsallocation asset=new assetsallocation(
						 rs.getInt("allocation_id"),
						 rs.getInt("asset_id"),
						 rs.getInt("employee_id"),
						 rs.getDate("allocation_date"),
						 rs.getDate("return_date")
						 
//						 "allocation_id"+allocation_id+"asset_id"+asset_id+"employee_id"+employee_id+"allocation_date"+allocation_date+"return date"+return_date;
			                );
				assets.add(asset);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return assets;
	}
	public List<assetsallocation> getmyassets(int employee_id){
		List<assetsallocation > assets=new ArrayList<>();
		String sql="select * from asset_allocations where employee_id=?";
		try(PreparedStatement ps=conn.prepareStatement(sql) ){
			ps.setInt(1,employee_id);
			try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    assetsallocation as = new assetsallocation(
                    		rs.getInt("allocation_id"),rs.getInt("asset_id"),rs.getInt("employee_id"),rs.getDate("allocation_date"),rs.getDate("return_date"));
                    assets.add(as);
                    		
                    		
                }
			} 
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return assets;
	}
		
	

}
