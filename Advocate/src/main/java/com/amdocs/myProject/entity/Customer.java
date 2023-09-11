package com.amdocs.myProject.entity;

public class Customer extends Object {
	
		private int id;
		private String firstName;
		private String lastName;
		private String email;
		private String phno;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getphno() {
			return phno;
		}
		public void setphno(String phno) {
			this.phno = phno;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
					+ " PhNo:" + phno + "EmailId: " + email + "]";
		}

	}

