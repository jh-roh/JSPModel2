package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//MSSQL 데이터베이스에 연결하고 select, insert, update, delete 작업을 실행해주는 클래스
public class MemberDao {

	String id = "sa";
	String pass = "JVM";
	
	//접속 url
	//String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=JSPTest;user=sa;password=JVM;trustServerCertificate=true;";
	String connectionUrl = "jdbc:sqlserver://localhost\\sqlepxress:50678;databaseName=JSPTest;user=sa;password=JVM;trustServerCertificate=true;";
	
	Connection con; //데이터베이스에 접근할 수 있도록 설정
	PreparedStatement pstmt; //데이터베이스에서 쿼리를 실행시켜주는 객체
	ResultSet rs; //데이터베이스의 테이블의 결과를 리턴받아 자바에 저장해주는 객체
	
	
	//데이터베이스 접근할 수 있또록 도와주는 메소드
	public void getCon() {
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			
			con = DriverManager.getConnection(connectionUrl);
			
		} catch(Exception e) {
			e.printStackTrace();
			// TODO : handle exception
		}
		
		
	}
	
	public void insertMethod(MemberBean mbean) {
		
		getCon();
		//접속 후 쿼리 준비하여 쿼리를 사용하록 설정
		String sql = "insert into member values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//?에 맞게 데이터를 맵핑
					
			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPass1());
			pstmt.setString(3, mbean.getEmail());
			pstmt.setString(4, mbean.getTel());
			pstmt.setString(5, mbean.getHobby());
			pstmt.setString(6, mbean.getJob());
			pstmt.setString(7, mbean.getAge());
			pstmt.setString(8, mbean.getInfo());
			
			//MSSQL 쿼리를 실행하시오.
			pstmt.executeUpdate(); //insert, update,delete 시 사용하는 메소드
			
			//자원 반납
	        con.close();
	           
		}catch(Exception e) {
			// TODO : handle exception
			e.printStackTrace();
		}
		
	}
	
	//모든 회원의 정보를 리턴해주는 메소드 호출
	public Vector<MemberBean> getAllMember() {
		
		Vector<MemberBean> v = new Vector<>();
		
		//무조건 데이터 베이스는 예외처리를 해야한다.
		try {
			//커넥션 연결
			getCon();
			
			//쿼리 준비
			String sql = "select * from member";
			
			pstmt = con.prepareStatement(sql);
			//쿼리를 실행 시킨 결과를 리턴해서 받아줌(테이블의 검색된 결과를 자바 객체에 저장)
			
			rs = pstmt.executeQuery();
			
			//반복문을 사용해서 ResultSet에 저장된 데이터를 추출해놓아야 함.
			
			while(rs.next()) {//저장된 데이터 만큼까지 반복문을 돌리겠다.
				MemberBean bean = new MemberBean();
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
				
				//패키징된 memberBean 클래스를 벡터에 저장
				v.add(bean); //0번지부터 순서대로 데이터가 저장
			}
			
		}catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // 자원 반납
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		//다 저장된 벡터를 리턴
		return v;
		
	}
	
	//한 사람의 대한 정보를 리턴하는 메소드 작성
	public MemberBean getOneMember(String id) {
		
		//한 사람데 대한 정보만 리턴하기에 빈클래스 객체 생성
		MemberBean bean = new MemberBean();
		try {
			//커넥션 연결
			getCon();
			String sql = "select * from member where id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			//?에 값을 맵핑
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //레코드가 있다면
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
			}
			
		}catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // 자원 반납
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		return bean;
	}
	
	//한 회원의 패스워드 값을 리턴하는 메소드 작성
	public String getPass(String id) {
		//스트링으로 리턴을 해야하기에 스트링 변수 순언
		
		String pass = "";
		
		try {
			//커넥션 연결
			getCon();
			String sql = "select pass1 from member where id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			//?에 값을 맵핑
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //레코드가 있다면
				pass = rs.getString(1);
			}
		}catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // 자원 반납
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		return pass;
	}
	
	//한 회원의 정보를 수정하는 메소드
	public void updateMember(MemberBean bean) {
		getCon();
		
		try {
			
			String sql = "update member set email=?, tel=? where id=?";
			
			//쿼리실행 객체 선언
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getId());
			
			
			//쿼리 실행
			pstmt.executeUpdate();
		}catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // 자원 반납
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		
	}
	
	
	
}
