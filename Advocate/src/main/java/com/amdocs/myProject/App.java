package com.amdocs.myProject;

import java.sql.SQLException;

import java.util.Scanner;

import com.amdocs.myProject.exceptions.*;
import com.amdocs.myProject.entity.Customer;
import com.amdocs.myProject.daoo.*;
import com.amdocs.myProject.dao.impl.*;

/**
 * Hello world!
 *
 */
public class App 
{
    	private static Scanner scanner = new Scanner(System.in);

    	public static void main(String[] args) {
    		try {
    			while (true) {
    				System.out.println("\n 1. Customer Details");
    				System.out.println("\n 2. Your Advocate details");
    				System.out.println("\n 3. Appointment ");
    				System.out.println("\n 4. Service");
    				System.out.println("\n 0. Exit");
    				int ch = Integer.parseInt(scanner.nextLine());
    				switch (ch) {
    				case 1:
    					System.out.println("\n 1.Press 1 for registering");
    					System.out.println("\n 2.Press 2 for modifying your details");
    					System.out.println("\n 3.Press 3 for delete your record");
    					System.out.println("\n 4.Press 4 to view your appointment details");
    					System.out.println("\n 5.Press 5 to view all appointment details");
    					System.out.println("\n 6.Press 0 to exit ");
    					int ch1 = Integer.parseInt(scanner.nextLine());
    					switch (ch1) {
    					case 1:
    						addCustomer();
    						break;
    				    case 2:
    				    	modifyCustomer();
    				    	break;
    				    case 3:
    				    	removeCustomer();
    				    	break;
    				    case 4:
    				    	viewDetails();
    				    	break;
    				    case 5:
    				    	viewAllDetails();
    				    	break;
    				    case 0:
    				    	System.exit(0);
    				    	break;
    				    	
    				    }
    					
    					break;
    				case 2:
    					System.out.println("\n 1.Press 1 to book an appointment");
    					System.out.println("\n 2.Press 2 to modify your appointment details");
    					System.out.println("\n 3.Press 3 to delete your appointment");
    					System.out.println("\n 4.Press 4 to view your appointment details");
    					System.out.println("\n 5.Press 5 to view all appointment details");
    					System.out.println("\n 6.Press 0 to exit ");
    					int ch2 = Integer.parseInt(scanner.nextLine());
    					switch (ch2) {
    					case 1:
    						bookAppointment();
    						break;
    					case 2:
    						modifyAppointment();
    						break;
    					case 3:
    						deleteAppointment();
    						break;
    					case 4:
    						viewDetails();
    						break;
    					case 5:
    						viewAllDetails();
    						break;
    					case 0:
    						System.exit(0);
    						break;
    					}
    					
    					break;
    				case 3:
    					System.out.println("Your Appointment Details will be messaged")	;				
    					break;
    				case 4:
    					System.out.println("Service option is currently unavailable");
    				case 0:
    					 System.exit(0);
    				default:
    					System.out.println("Try again");
    					break;
    				}
    			}
            } catch (NumberFormatException e) {
    			System.out.println("Number Format : " + e.getMessage()); 
    		} catch (Exception e) {

    			System.out.println("Error : " + e.getMessage());
    		}
    	}

    	

private static void viewAllDetails() throws SQLException, SystemException {
	
	
		dao.showAlldetails();
	//} catch (NumberFormatException e) {
		//throw new SystemException("Please Provide a number value\n " + e.getMessage());
			
			
		}
			
		



private static void viewDetails() throws SystemException, SQLException {
	try {
		System.out.println("Enter your Customer ID ");
		int custid = Integer.parseInt(scanner.nextLine());

		//scanner.nextLine();
		dao.showdetails(custid);
	} catch (NumberFormatException e) {
		throw new SystemException("Please Provide a number value\n " + e.getMessage());
			
			
		}
}



private static void modifyAppointment() throws SQLException, SystemException {
	try {
		System.out.println("Enter your Customer ID ");
		int custid = scanner.nextInt();

		System.out.println("Enter Advocate ID: ");
		int advid = scanner.nextInt();
		scanner.nextLine();
		dao.updateapp(custid, advid);
	} catch (NumberFormatException e) {
		throw new SystemException("Please Provide a number value\n " + e.getMessage());
	}

			
			
		}



private static void deleteAppointment() throws SQLException, SystemException {
	try {
		System.out.println("Enter your Customer ID ");
		int custid = scanner.nextInt();

		System.out.println("Enter Advocate ID: ");
		int advid = scanner.nextInt();
		scanner.nextLine();
		dao.deleteapp(custid, advid);
	} catch (NumberFormatException e) {
		throw new SystemException("Please Provide a number value\n " + e.getMessage());
	}

			
		}



private static void bookAppointment() throws SystemException, SQLException {
	try {
		System.out.println("Enter your Customer ID ");
		int custid = scanner.nextInt();

		System.out.println("Enter Advocate ID: ");
		int advid = scanner.nextInt();
		scanner.nextLine();
		dao.addapp(custid, advid);
	} catch (NumberFormatException e) {
		throw new SystemException("Please Provide a number value\n " + e.getMessage());
	}

			
		}



private static Customer createCustomer() throws SystemException, InvalidCustomerDataException  {
	Customer obj = new Customer();
	try {
		System.out.println("Enter The First Name: ");
		String firstName = scanner.nextLine();
		obj.setFirstName(firstName);
		firstName = obj.getFirstName();
		System.out.println("Enter The Last Name: ");
		String lastName = scanner.nextLine();
		obj.setLastName(lastName);
		lastName = obj.getLastName();
		System.out.println("Enter Your Phone Number: ");
		String phNo = scanner.nextLine();
		obj.setphno(phNo);
		System.out.println("Enter Your Email ID: ");
		String email = scanner.nextLine();
		obj.setEmail(email);
		if (!isValidPhoneNumber(phNo) || !isValidEmail(email)) {
			throw new InvalidCustomerDataException("Enetered Data is Invalid");
		}
		
	} catch (NumberFormatException e) {
		throw new SystemException("Please Provide a number value\n " + e.getMessage());
	}

	return obj;
}
private static Customer updateCustomer() throws SystemException, InvalidCustomerDataException {
	Customer obj = new Customer();
	try {
		System.out.println("Enter the Customer ID: ");
		int ID = scanner.nextInt();
		obj.setId(ID);
		scanner.nextLine();
		System.out.println("Enter The new First Name: ");
		String firstName = scanner.nextLine();
		obj.setFirstName(firstName);
		firstName = obj.getFirstName();
		System.out.println("Enter The new Last Name: ");
		String lastName = scanner.nextLine();
		obj.setLastName(lastName);
		lastName = obj.getLastName();
		System.out.println("Enter Your Phone Number: ");
		String phNo = scanner.nextLine();
		obj.setphno(phNo);
		System.out.println("Enter Your Email ID: ");
		String email = scanner.nextLine();
		obj.setEmail(email);
		if (!isValidPhoneNumber(phNo) || !isValidEmail(email)) {
			throw new InvalidCustomerDataException("Enetered Data is Invalid");
		}
	} catch (NumberFormatException e) {
		throw new SystemException("Please Provide a number value\n " + e.getMessage());
	}

	return obj;
}

private static Customer deleteCustomer() throws SystemException {
	Customer obj = new Customer();
	try {
		System.out.println("Enter your Customer ID: ");
		int ID = scanner.nextInt();
		obj.setId(ID);
		scanner.nextLine();
	} catch (NumberFormatException e) {
		throw new SystemException("Please Provide a number value\n " + e.getMessage());
	}
	return obj;
}


private static CustomerDao dao = new CustomerDaoImpl();

private static void addCustomer() throws InvalidCustomerDataException {
	Customer createCustomer;
	try {
		createCustomer = createCustomer();
		dao.add(createCustomer);
	} catch (SQLException e) {
		System.out.println(e);
	}catch (SystemException e) {
		System.out.println(e);
	}

}

private static void modifyCustomer() throws InvalidCustomerDataException {
	Customer updateCustomer;
	try {
		updateCustomer = updateCustomer();
		dao.update(updateCustomer);
	} catch (SQLException e) {
		System.out.println(e);
	}catch (SystemException e) {
		System.out.println(e);
	}

}
private static void removeCustomer() {
	Customer deleteCustomer;
	try {
		deleteCustomer = deleteCustomer();
		dao.delete(deleteCustomer);
	} catch (SQLException e) {
		System.out.println(e);
	}catch (SystemException e) {
		System.out.println(e);
	}

}
private static boolean isValidPhoneNumber(String phno) {
	return phno.matches("\\d{10}");
}
private static boolean isValidEmail(String email) {
	return email.endsWith("@gmail.com");
}

}

