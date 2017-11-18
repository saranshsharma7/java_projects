
package Buslogic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsbildet {
     CallableStatement stm;
    public void save_rec(clsbildetprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call insbildet(?,?,?)}");
            stm.setInt(1,p.getbildetbilcod());
            stm.setInt(2,p.getbildetstkcod());
            stm.setInt(3,p.getbildetqty());
            
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
    }
    public void upd_rec(clsbildetprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call updbildet(?,?,?,?)}");
            stm.setInt(1, p.getbildetcod());
            stm.setInt(1,p.getbildetbilcod());
            stm.setInt(2,p.getbildetstkcod());
            stm.setInt(3,p.getbildetqty());
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }    
    public List<clsbildetprp> disp_rec(int bilcod)
    {
        List<clsbildetprp> arr=new ArrayList<clsbildetprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call dispbildet(?)}");
            stm.setInt(1, bilcod);
            
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                clsbildetprp p=new clsbildetprp();
                p.setbildetcod(rs.getInt("bildetcod"));
                p.setbildetbilcod(rs.getInt("bildetbilcod"));
               p.setbildetstkcod(rs.getInt("bildetstkcod"));
                p.setbildetqty(rs.getInt("bildetqty"));               
                             
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
  public  clsbildetprp find_rec(int bdcod)
    {
        clsbildetprp p=new clsbildetprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call findbildet(?)}");
            stm.setInt(1, bdcod);
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                p.setbildetcod(rs.getInt("bildetcod"));
                p.setbildetbilcod(rs.getInt("bildetbilcod"));
               p.setbildetstkcod(rs.getInt("bildetstkcod"));
                p.setbildetqty(rs.getInt("bildetqty"));               
                              
                
            }
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return p;
    }
   
 public void del_rec(clsbildetprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call delbildet(?)}");
            stm.setInt(1,p.getbildetcod());
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
