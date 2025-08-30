package Main;
import java.util .*;
import dao.EmployeeDAO;
import model.Employee;
public class empMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO dao=new EmployeeDAO();
		int choice;
		do {
			System.out.println("=====EMPLOYEE MANAGEMENHT SYSTEM======");
			System.out.println("\n========enter your choice==========");
			System.out.println("1 .ADD Employee");
			System.out.println("2.view all employees");
			System.out.println("3.get employee by id");
			System.out.println("4. update eployee");
			System.out.println("5.delete employee");
			System.out.println("6.exit");
			
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				Employee emp=new Employee();
				System.out.println("enter id:");
				emp.setEmployee_id(sc.nextInt());
				sc.nextLine();
				System.out.println("enter name:");
				emp.setName(sc.nextLine());
				System.out.println("enter department");
				emp.setDepartment(sc.nextLine());
				System.out.println("enter email:");
				emp.setEmail(sc.nextLine());
				System.out.println("enter password:");
				emp.setPassword(sc.nextLine());
				if(dao.addEmployee(emp)) {
					System.out.println("Successfully added");
				}else {
					System.out.println("Failed to add employee details");
				}
				break;
			case 2:
				List<Employee> list=dao.getallemployees();
				for(Employee e:list) {
					System.out.println(  e.getEmployee_id()+"| "+e.getName()+" |"+e.getDepartment()+" |"+e.getEmail());
				}
				break;
			case 3:
				System.out.println("Enter employee id to search");
				int employeeid=sc.nextInt();
				Employee found=dao.getEmployeebyid(employeeid);
				if(found !=null) {
					System.out.println("ID:"+found.getEmployee_id());
					System.out.print("Name:"+found.getName());
					System.out.println("Department:"+found.getDepartment());
					System.out.println("Email:"+found.getEmail());
				}
				else {
					System.out.println("Employee not found.");
				}
				break;
			case 4:
				Employee update=new Employee();
				System.out.println("enter id to update ");
				update .setEmployee_id(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter eployee name to update");
				update .setName(sc.next());
				System.out.println("Enter department");
				update .setDepartment(sc.nextLine());
				System.out.println("Enter Email");
				update.setEmail(sc.nextLine());
				System.out.println("Enter pasword");
				update.setPassword(sc.nextLine());
				if(dao. updateEmployee(update)) {
					System.out.println("Employee updated succesfully:");
				}else {
					System.out.println("failed to update:");
				}
				break;
			case 5:
				System.out.println("Enter ID to delete:");
				int deleid=sc.nextInt();
				if(dao.deleteemployee(deleid)) {
					System.out.println("employee deleted succesfully");
				}
				else {
					System.out.println("Failed to delete:");
				}
				break;
			case 6:
				System.out.println("Exiting .Good bye🫡👋");
				break;
			default:
				System.out.println("Invalid choice.");
		    }
		   
		}while(choice!=6);
		 
	}

}
