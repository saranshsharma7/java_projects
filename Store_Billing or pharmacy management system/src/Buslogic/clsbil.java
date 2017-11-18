
package Buslogic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class clsbil {
      CallableStatement stm;
    public int save_rec(clsbilprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call insbil(?,?,?,?)}");
            java.sql.Date s = new java.sql.Date(p.getbildat().getTime());
            stm.setDate(1,s);                
            stm.setString(2,p.getbilcstnam());
            stm.setString(3,p.getbilcstphn());
  stm.registerOutParameter(4,Types.INTEGER);
            stm.execute();
        int a=stm.getInt(4);
            obj.disconnect();
            return a;
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return -1;
    }
    public void upd_rec(clsbilprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call updbil(?,?,?,?)}");
            stm.setInt(1, p.getbilcod());
            java.sql.Date s = new java.sql.Date(p.getbildat().getTime());
            stm.setDate(2,s);         
             stm.setString(3,p.getbilcstnam());
            stm.setString(4,p.getbilcstphn());
            
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }    
    public List<clsbilprp> disp_rec()
    {
        List<clsbilprp> arr=new ArrayList<clsbilprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call dispbil()}");
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                clsbilprp p=new clsbilprp();
                p.setbilcod(rs.getInt("bilcod"));
                p.setbildat(rs.getDate("bildat"));
               p.setbilcstnam(rs.getString("bilcstnam"));
                p.setbilcstphn(rs.getString("bilcstphn"));               
                             
                arr.add(p);
            }
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return arr;
    }
  public  clsbilprp find_rec(int bcod)
    {
        clsbilprp p=new clsbilprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call findbil(?)}");
            stm.setInt(1, bcod);
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                p.setbilcod(rs.getInt("bilcod"));
                p.setbildat(rs.getDate("bildat"));
               p.setbilcstnam(rs.getString("bilcstnam"));
                p.setbilcstphn(rs.getString("bilcstphn")); 
                
            }
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return p;
    }
   
 public void del_rec(clsbilprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call delbil(?)}");
            stm.setInt(1,p.getbilcod());
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
