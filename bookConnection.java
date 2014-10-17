package actions;




            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","wazi");
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
    public void closeConnection(Connection con)
    {
        if(con!=null)
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}
