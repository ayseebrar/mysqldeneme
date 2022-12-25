package mysqualdeneme;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Mysql {
static final String DB="jdbc:mysql://localhost:3306/ogrenci";
static final String USER="root";
static final String PASS="rott";
static final String QUERY="SELECT *FROM kayıt"+" WHERE adi='Ali'";//where süzme işlemini yapıyor yani hangisini istediğimizi gösteriyor.
	public static void main(String[] args)  throws SQLException{
	Connection con=DriverManager.getConnection(DB,USER,PASS);
	Statement st=con.createStatement();
System.out.println("Veri Tabanına Bağlandı");
/*System.out.println("veri tabanında aradiginiz adini giriniz: ");
Scanner i=new Scanner(System.in);
String name=i.next();

 
 String sql="SELECT *FROM kayıt"+" WHERE adi='"+name+"'";
 */
System.out.println("veri tabanına aradığınız yaşı giriniz: ");
Scanner i=new Scanner(System.in);
int old=i.nextInt();
String sql="SELECT *FROM kayıt"+ " WHERE yaş="+old+"";
ResultSet rs=st.executeQuery(sql);
while(rs.next()) {
	System.out.print("ID: "+rs.getInt("id"));
	System.out.print("Yaş:  "+rs.getInt("yaş"));
	
	System.out.print("Adı: "+ rs.getString("adi"));
	System.out.println("Soyadı: "+rs.getString("soyadi"));
}
rs.close();

/*String sql="INSERT INTO kayıt VALUES(101,'Ali','veli',30)";
   st.executeUpdate(sql);*/
   /*String sql2="INSERT INTO kayıt VALUES(102,'Ayşe','Bağcı',20)";
   st.executeUpdate(sql2);
   String sql2="INSERT INTO kayıt VALUES(106,'sevgi','sağlam',25)";
   st.executeUpdate(sql2);*/

   
	}

}
