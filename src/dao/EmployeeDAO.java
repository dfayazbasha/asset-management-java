package dao;


import java.sql.*;

import java.util.*;
import java.util.List;

import db.DBConnection;
import model.Employee;

public class EmployeeDAO {
	public boolean addEmployee(Employee emp) {
		String query="INSERT INTO employees (employee_id,name,department,email,password) values(?, ?, ?, ?, ?)";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement pstm=conn.prepareStatement(query)){
					pstm.setInt(1,emp.getEmployee_id());
					pstm.setString(2, emp.getName());
					pstm.setString(3, emp.getDepartment());
					pstm.setString(4, emp.getEmail());
					pstm.setString(5, emp.getPassword());
					
					int rowsupdated=pstm.executeUpdate();
					return rowsupdated>0;
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				return false;
	}
	public List<Employee> getallemployees(){
		List<Employee> list=new ArrayList<>();
		String query="SELECT * from employees";
		try(Connection conn=DBConnection.getConnection();
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)){
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEmployee_id(rs.getInt("employee_id"));
				emp.setName(rs.getString("name"));
				emp.setDepartment(rs.getString("department"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				list.add(emp);
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		return list;
	}
	public Employee getEmployeebyid(int id)  {
		String query="SELECT * from employees where employee_id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement pstm=conn.prepareStatement(query)){
			pstm.setInt(1,id);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				Employee emp=new Employee();
				emp.setEmployee_id(rs.getInt("employee_id"));
				emp.setName(rs.getString("name"));
				emp.setDepartment(rs.getString("department"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				return emp;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}
	public boolean updateEmployee(Employee emp) {
		String query="Update employees set name=?,department=?,email=?,password=? where employee_id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement pstm=conn.prepareStatement(query)){
					 pstm.setString(1,emp.getName());
					 pstm.setString(2, emp.getDepartment());
					 pstm.setString(3,emp.getEmail());
					 pstm.setString(4, emp.getPassword());
					 pstm.setInt(5,emp.getEmployee_id());
					 
					 
					 int rowsupdated=pstm.executeUpdate();
					 return rowsupdated>0;
					 
				}catch(SQLException e) {
					e.printStackTrace();
				}
		return false;
	}
	public boolean deleteemployee(int id) {
		String query="delete from employees where employee_id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement pstm=conn.prepareStatement(query)){
			pstm.setInt(1, id);
			int rowsdeleted=pstm.executeUpdate();
			return rowsdeleted>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
