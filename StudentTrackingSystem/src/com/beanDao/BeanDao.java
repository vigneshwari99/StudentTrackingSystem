package com.beanDao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.CircularBean;
import com.bean.Staff;
import com.bean.Student;
import com.bean.subject;



	public class BeanDao {
		public static Connection getConnection(){
			Connection con = null;
			try{
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentTracking","postgres","admin");
				}
			catch(Exception e){
				System.out.println(e);
			}
			return con;
		}
		
		//-------------------connection closed----------------------------------------------------------------------
			public static int save(Staff s){
				int status =0;
				
				try{
				Connection con = BeanDao.getConnection();
				int id = 1;
				Statement st1 = con.createStatement();
				Statement  st2 = con.createStatement();
				ResultSet rs1 = st1.executeQuery("select max(id) as max_id from Staff");
				if (rs1.next()) {
					int fid = rs1.getInt("max_id");
					id = fid + 1;
				    s.setId(id);
				}
				ResultSet rs2 = st2.executeQuery("select * from Staff where email = '"+s.getEmail()+"' ");
				if(rs2.next()){
					System.out.println("duplicate data");
					status = 0;
				}
				
				else{
				PreparedStatement ps  = con.prepareStatement("insert into staff(id,name,email,univname,pass,dob) values(?,?,?,?,?,?)");
				ps.setInt(1,s.getId());
				ps.setString(2,s.getName());
			
		        ps.setString(3,s.getEmail());
		        ps.setString(4,s.getUnivname());
		        ps.setString(5,s.getPass());
		      
		        ps.setDate(6,(Date) s.getDate());
		        
				status = ps.executeUpdate();
				}
				}
				catch(Exception e){
					System.out.println(e);
				}
				return status;
			}
			//---------insert staff record--------------------------------------------------------------------------------
			public static int sign(Student stud){
				int status =0;
				try{
				Connection con = BeanDao.getConnection();
				
				PreparedStatement ps  = con.prepareStatement("insert into student(roll,name,email,pname,mob,dob) values(?,?,?,?,?,?)");
				ps.setInt(1,stud.getRoll());
				ps.setString(2,stud.getName());
			    ps.setString(3,stud.getEmail());
		        ps.setString(4,stud.getPname());
		        ps.setInt(5,stud.getMob());
		        ps.setDate(6,(Date) stud.getDate());
				status = ps.executeUpdate();
				
				}
				catch(Exception e){
					System.out.println(e);
				}
				return status;
			}
			//----------------insert student personal details -------------------------------------------------------------------------
			public static Staff login(Staff bean) {
				
		         //preparing some objects for connection 
		         Statement stmt = null;    
			
		         String email = bean.getEmail();    
		         String password = bean.getPass();   
			    
		         String searchQuery =
		               "select * from staff where email='"  + email  + "' AND pass='" + password   + "'";
			    
		      // "System.out.println" prints in the console; Normally used to trace the process
		     /* System.out.println("Your user name is " + email);          
		      System.out.println("Your password is " + password);
		      System.out.println("Query: "+searchQuery);*/
			    
		      try 
		      {
		         //connect to DB 
		         Connection con = BeanDao.getConnection();
		         Statement st= con.createStatement();
		         
		        		 
		      
		       ResultSet  rs = st.executeQuery(searchQuery);	        
		         boolean more = rs.next();
			       
		         // if user does not exist set the isValid variable to false
		         if (!more) 
		         {
		            System.out.println("Sorry, you are not a registered user! Please sign up first");
		            bean.setValid(false);
		         } 
			        
		         //if user exists set the isValid variable to true
		         else if (more) 
		         {
		            String firstName = rs.getString("name");
		         
			     	
		            System.out.println("Welcome " + firstName);
		            bean.setName(firstName);
		           
		            bean.setValid(true);
		         }
		      } 

		      catch (Exception ex) 
		      {
		         System.out.println("Log In failed: An Exception has occurred! " + ex);
		      } 
			    
		      //some exception handling
		      finally 
		      {
		         
			
		         if (stmt != null) {
		            try {
		               stmt.close();
		            } catch (Exception e) {}
		               stmt = null;
		            }
			
		         
		      }

		return bean;
			
		      }	
			
			//------------staff login-----------------------------------------------------------------------------			
			public static Student user(Student e) {
				
		         //preparing some objects for connection 
		         Statement stmt = null;    
			
		         int roll = e.getRoll();    
		         Date dob = e.getDate();   
			    
		         String searchQuery =
		               "select * from student where roll='"  + roll  + "' AND dob='" + dob   + "'";
			    
		         String sq1 ="select * from student_detail where roll= '" +roll+"'";
			    
		      try 
		      {
		        
		         Connection con = BeanDao.getConnection();
		         Statement st= con.createStatement();
		         Statement st1= con.createStatement();
		         
		       ResultSet  rs = st.executeQuery(searchQuery);
		       ResultSet rs1 = st1.executeQuery(sq1);
		       
		       while(rs1.next()){
		    	   e.setRoll(rs1.getInt(1));
	                e.setSub1(rs1.getInt(2));
	                e.setSub2(rs1.getInt(3));
	                e.setSub3(rs1.getInt(4));
	                e.setSub4(rs1.getInt(5));
	                e.setSub5(rs1.getInt(6));
	                e.setPercent(rs1.getInt(7));
	                e.setAtd(rs1.getInt(8));
	                e.setSem(rs1.getString(9));
		       }
		         boolean more = rs.next();
			      
		         if (!more) 
		         {
		            System.out.println("Sorry, you are not a registered user! Please sign up first");
		            e.setValid(false);
		         } 
			      
		         else if (more) 
		         {
		            String firstName = rs.getString("name");
		            String parentName = rs.getString("pname");
			     	
		            System.out.println("Welcome " + firstName);
		            e.setName(firstName);
		            e.setPname(parentName);
		            e.setValid(true);
		         }
		      } 

		      catch (Exception ex) 
		      {
		         System.out.println("Log In failed: An Exception has occurred! " + ex);
		      } 
			    
		      //some exception handling
		      finally 
		      {
		         
			
		         if (stmt != null) {
		            try {
		               stmt.close();
		            } catch (Exception ex) {}
		               stmt = null;
		            }
			
		         
		      }

		return e;
			
		      }	

//--------------student login---------------------------------------------------------------------------
			public static int marksave(subject s){
				int status =0;
				try{
				Connection con = BeanDao.getConnection();
				
				PreparedStatement ps  = con.prepareStatement("insert into student_detail(roll,sub1,sub2,sub3,sub4,sub5,percent,attendance,semester) values(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1,s.getRoll());
				ps.setFloat(2,s.getSub1());
				ps.setFloat(3,s.getSub2());
				ps.setFloat(4,s.getSub3());
				ps.setFloat(5,s.getSub4());
				ps.setFloat(6,s.getSub5());
				ps.setFloat(7,s.getPercent());
				ps.setInt(8,s.getAtd());
				ps.setString(9,s.getSem());
				status = ps.executeUpdate();
				
				}
				catch(Exception e){
					System.out.println(e);
				}
				return status;
			}
	//		------------------------------------list of student report---------
			public static List<Student> getAllEmployees() {
				List<Student> list = new ArrayList<Student>();

				try {
					Connection con = BeanDao.getConnection();
					PreparedStatement ps = con.prepareStatement("SELECT student.roll,student_detail.semester,student.name,student.dob,student_detail.sub1,Student_detail.sub2,Student_detail.sub3,Student_detail.sub4,Student_detail.sub5,Student_detail.percent,Student_detail.attendance,student.pname,student.mob FROM student ,student_detail WHERE  student.roll =student_detail.roll;");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						
						Student e = new Student();
		                e.setRoll(rs.getInt(1));
		                e.setSem(rs.getString(2));
		                e.setName(rs.getString(3));
		                e.setDate(rs.getDate(4));
						e.setSub1(rs.getInt(5));
						e.setSub2(rs.getInt(6));
						e.setSub3(rs.getInt(7));
						e.setSub4(rs.getInt(8));
						e.setSub5(rs.getInt(9));
						e.setPercent(rs.getFloat(10));
						e.setAtd(rs.getInt(11));
						e.setPname(rs.getString(12));
						e.setMob(rs.getInt(13));
						list.add(e);
					}
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				return list;
			}
	//		--------------------delete particular record--------------
			public static int delete(int id){  
		        int status=0;  
		        try{  
		            Connection con=BeanDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("delete from student_detail where roll=?");  
		            ps.setInt(1,id);  
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception e){e.printStackTrace();}  
		          
		        return status;  
		    }  
			//--------------------edit thhe record--------
			public static subject getEmployeeById(int id){  
		       subject e=new subject();  
		          
		        try{  
		            Connection con=BeanDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from student_detail where roll=?");  
		           ps.setInt(1,id);  
		            ResultSet rs=ps.executeQuery();  
		            if(rs.next()){  
		                
		                e.setRoll(rs.getInt(1));
		                e.setSub1(rs.getInt(2));
		                e.setSub2(rs.getInt(3));
		                e.setSub3(rs.getInt(4));
		                e.setSub4(rs.getInt(5));
		                e.setSub5(rs.getInt(6));
		                e.setPercent(rs.getInt(7));
		                e.setAtd(rs.getInt(8));
		                e.setSem(rs.getString(9));
		            }  
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return e;  
		    }  
			//----------------------update record--------------
			public static int update(subject s){  
		        int status=0;  
		        try{  
		            Connection con=BeanDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement(  
		            		"update student_detail set  roll=?,sub1=?,sub2=?, sub3 = ?, sub4=?,sub5 =?,percent=?,attendance = ?,semester=? where roll='"+s.getRoll()+"'");  
		            
		            ps.setInt(1,s.getRoll());
					ps.setFloat(2,s.getSub1());
					ps.setFloat(3,s.getSub2());
					ps.setFloat(4,s.getSub3());
					ps.setFloat(5,s.getSub4());
					ps.setFloat(6,s.getSub5());
					ps.setFloat(7,s.getPercent());
					ps.setInt(8,s.getAtd());
					ps.setString(9,s.getSem());
		        
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return status; 		       
		    }
			//---------------------------view record---------------------------------
			public static Student getEmp(Student e) {
				
				try {
					System.out.println("connected");
					Connection con = BeanDao.getConnection();
					PreparedStatement ps = con.prepareStatement("select * from student_detail  where roll='"+e.getRoll()+"'");

					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						
		                e.setRoll(rs.getInt(1));
						e.setSub1(rs.getInt(2));
						e.setSub2(rs.getInt(3));
						e.setSub3(rs.getInt(4));
						e.setSub4(rs.getInt(5));
						e.setSub5(rs.getInt(6));
						e.setPercent(rs.getFloat(7));
						e.setAtd(rs.getInt(8));
						e.setSem(rs.getString(9));
						 e.setId(true);
					   
					}
				} 
					catch (Exception ex) {
					ex.printStackTrace();
				}
				return e;
			}
		//	--------------------------Describing circular------------------------
public static int describe(CircularBean cb) {
				int status =0;
				try {
					
					Connection con = BeanDao.getConnection();
					PreparedStatement ps = con.prepareStatement("insert into circular(circulardate,circularname,circulardes) values(?,?,?) ");
						ps.setDate(1,cb.getD());
						ps.setString(2,cb.getName());
						ps.setString(3,cb.getText());
						
						
						status = ps.executeUpdate();
					/*ResultSet rs =	ps.executeQuery();
					while(rs.next()){
						cb.setD(rs.getDate(1));
						cb.setName(rs.getString(2));
						cb.setText(rs.getString(3));
						cb.setValid(true);
					}*/
						
				} 
					catch (Exception ex) {
					ex.printStackTrace();
				}
				return status;
			}
//--------------------------view only one user data--------------

public static Student display(Student s) {
	
	int roll = s.getRoll();
	String searchQuery =
            "select * from student_detail where roll='"  + roll  + "'";
	    
   
	    
   try 
   {
      //connect to DB 
      Connection con = BeanDao.getConnection();
      Statement st= con.createStatement();
      
     		 
   
    ResultSet  rs = st.executeQuery(searchQuery);	        
      boolean more = rs.next();
	       
      // if user does not exist set the isValid variable to false
      if (!more) 
      {
         System.out.println("Sorry, you are not a registered user! Please sign up first");
         s.setValid(false);
      } 
	        
      //if user exists set the isValid variable to true
      else if (more) 
      {
         String firstName = rs.getString("name");
      
	     	
         System.out.println("Welcome " + firstName);
         s.setName(firstName);
        
         s.setValid(true);
      }
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	    
   //some exception handling
   

return s;
	
	
}
//------------------------------------view email id--------------

	
	public static List<Student> getEmployees() throws Exception {
		Connection con = BeanDao.getConnection();
	      
		PreparedStatement ps = con.prepareStatement("select email from student");
		ResultSet rs = ps.executeQuery();
		List<Student> result = new ArrayList<Student>();
		int count=0;
		while (rs.next()) {
			Student s = new Student();
			s.setEmail(rs.getString("email"));
			s.setValid(true);
			count++;
			System.out.println(count);
			result.add(s);

		}
		
		return result;
	}

	

//---------------------------------------------------------------------------
public static Student getAllEmail(Student s) {
	String searchQuery = "select count(email) from student";	   
   try 
   {
     Connection con = BeanDao.getConnection();
      Statement st= con.createStatement();
      ResultSet  rs = st.executeQuery(searchQuery);	 
      System.out.println(rs);
      boolean more = rs.next();
	if (!more) 
      {
         System.out.println("Sorry, you are not a registered user! Please sign up first");
         s.setValid(false);
      }
      else if (more) 
      {
         s.setValid(true);
      }
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	return s;
	}
//----------------------------------view circular-----------------------------------
public static List<CircularBean> getCircular() throws Exception {
	Connection con = BeanDao.getConnection();
      
	PreparedStatement ps = con.prepareStatement("select * from circular");
	ResultSet rs = ps.executeQuery();
	List<CircularBean> result = new ArrayList<CircularBean>();
	int count=0;
	while (rs.next()) {
		CircularBean c = new CircularBean();
		c.setD(rs.getDate(1));
	    c.setName(rs.getString(2));
	    c.setText(rs.getString(3));
		System.out.println(count);
		result.add(c);
	}
		return result;
}



	}