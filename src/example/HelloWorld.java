package example;
import com.demo.database.ConnectionUtil;
import com.demo.model.Room;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class HelloWorld {

  Connection connection = ConnectionUtil.getConnection();

  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }

  @WebMethod
  public int totalValue(int first, int second) {
    int result = first+second;
    System.out.println(result);
    return result;
  }

  @WebMethod
  public List<Room> getAllRooms(){
    List<Room> list = new ArrayList<>();
    String sql = "SELECT * FROM product";
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next())
      {
        int id  = rs.getInt("id");
        String name = rs.getString("name");
        int priceperday = rs.getInt("priceperday");
        int pricepermonth = rs.getInt("pricepermonth");
        Room room = new Room(id,name,priceperday,pricepermonth);
        list.add(room);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return list;
  }

  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);
  }
}
