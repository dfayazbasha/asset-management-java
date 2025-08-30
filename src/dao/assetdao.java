package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBConnection;
import model.Assets;
import java.util.*;

public class assetdao {
	private Connection conn;
	public assetdao() {
		conn=DBConnection.getConnection();
	}
	public void addasset(Assets assets) {
		String sql = "INSERT INTO assets(name, type, serial_number, purchase_date, location, status) VALUES (?, ?, ?, ?, ?, ?)";

		try(PreparedStatement ps= conn.prepareStatement(sql)){
			ps.setString(1,assets.getname());
			ps.setString(2,assets.gettype());
			 ps.setInt(3, assets.getserial_number());    // serial_number
			    ps.setDate(4, new java.sql.Date(assets.getpurchase_date().getTime())); // purchase_date
			    ps.setString(5, assets.getlocation());        // location
			    ps.setString(6, assets.getstatus());          // status
			              // owner_id
			    ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public  List<Assets> getallassets(){
		List<Assets> assets=new ArrayList<>();
		String sql="SELECT * from assets";
		try(Statement stmt=conn.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			while( rs.next()) {
				Assets asset=new Assets(
						 rs.getInt("asset_id"),
			                rs.getString("name"),
			                rs.getString("type"),
			                rs.getInt("serial_number"),
			                rs.getDate("purchase_date"),
			                rs.getString("location"),
			                rs.getString("status")
			              
			                );
				assets.add(asset);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return assets;
		
	}
	public void deleteasset(int asset_id) {
		String sql="DELETE from assets where asset_id=?";
		try(PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setInt(1,asset_id);
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
