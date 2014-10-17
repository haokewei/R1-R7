package actions;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
import sun.print.resources.serviceui;

 

 
public class bookModel {
    public ArrayList getList()
    {
        ArrayList list=new ArrayList();
        try
        {
            bookConnection connection=new bookConnection();
            Connection mycon=connection.getConnection();
            Statement st=mycon.createStatement();
            ResultSet set=st.executeQuery("select * from blog");
            while(set.next())
            {
                book blog=new book();
                blog.setauthorid(set.getInt("authorid")+"");
                blog.setage(set.getString("age"));
                blog.setname(set.getString("name"));
                blog.setcountry(set.getInt("country")+"");
                list.add(blog);
            }
        }
        catch(Exception e){}
        return list;
    }
    public void delete(String isbn)
    {
            try {
                bookConnection connection=new bookConnection();
                Connection mycon=connection.getConnection();
                Statement st=mycon.createStatement();
                st.executeUpdate("delete from blog where isbn='"+isbn+"'");
                connection.closeConnection(mycon);
            } catch (Exception e) {
                // TODO: handle exception
            }
    }
    public void save(String user_id,String title,String content)
    {
        try {
            bookConnection connection=new bookConnection();
            Connection mycon=connection.getConnection();
            Statement st=mycon.createStatement();
            st.executeUpdate("insert into blog (title,content,user_id) values ('"+title+"','"+content+"','"+user_id+"')");
            connection.closeConnection(mycon);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void update(String user_id,String title,String content,String blog_id)
    {
        try {
            bookConnection connection=new bookConnection();
            Connection mycon=connection.getConnection();
            Statement st=mycon.createStatement();
            st.executeUpdate("update blog set blog_id='"+blog_id+"',user_id='"+user_id+"',title='"+title+"',content='"+content+"' where blog_id="+blog_id);
            connection.closeConnection(mycon);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public book get_one(String blog_id_var)
    {
        book stu=new book();
        try{
        bookConnection con=new bookConnection();
        java.sql.Connection mycon=con.getConnection();
        Statement st=mycon.createStatement();
         
        ResultSet rs=st.executeQuery("select * from blog where blog_id="+blog_id_var);
        if(rs.next())
        {
            String name=rs.getString("name");
            String country=rs.getString("country");
            String age=rs.getString("age");
            String authorid=rs.getString("authorid");
            stu.setauthorid(authorid);
            stu.setage(age);
            stu.setcountry(country);
            stu.setname(name);
        }
        con.closeConnection(mycon);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return stu;
    }
}
