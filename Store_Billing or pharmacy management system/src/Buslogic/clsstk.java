
package Buslogic;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
        
public class clsstk {
     CallableStatement stm;
    public void save_rec(clsstkprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call insstk(?,?,?,?,?,?)}");
            java.sql.Date s = new java.sql.Date(p.getstkdat().getTime());
            stm.setDate(1,s);           
            stm.setInt(2,p.getstkmedcod());
            stm.setInt(3,p.getstkqty());
            stm.setFloat(4, p.getstkprc());
            java.sql.Date s1 = new java.sql.Date(p.getstkmnfdat().getTime());
            stm.setDate(5,s1);
             java.sql.Date s2 = new java.sql.Date(p.getstkexpdat().getTime());
            stm.setDate(6,s2);
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
    }
    public void upd_rec(clsstkprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call updstk(?,?,?,?,?,?,?)}");
            stm.setInt(1, p.getstkcod());
           java.sql.Date s = new java.sql.Date(p.getstkdat().getTime());
            stm.setDate(2,s);       
           stm.setInt(3,p.getstkmedcod());
            stm.setInt(4,p.getstkqty());
            stm.setFloat(5, p.getstkprc());
            java.sql.Date s1 = new java.sql.Date(p.getstkmnfdat().getTime());
            stm.setDate(6,s1);
             java.sql.Date s2 = new java.sql.Date(p.getstkexpdat().getTime());
            stm.setDate(7,s2);
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }    
    //stkcod,stkexpdat,stkmandat,stkprc,qtylft
    public List<clsstkprp> dspmedstk(int mcod)
    {
        List<clsstkprp> arr=new ArrayList<clsstkprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call dspmedstk(?)}");
             stm.setInt(1,mcod);
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                clsstkprp p=new clsstkprp();
                p.setstkcod(rs.getInt("stkcod"));
                p.setstkqty(rs.getInt("qtylft"));               
                p.setstkprc(rs.getFloat("stkprc"));
               p.setstkmnfdat(rs.getDate("stkmandat"));
                p.setstkexpdat(rs.getDate("stkexpdat"));              
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
    
    
    public List<clsstkprp> disp_rec(int mcod)
    {
        List<clsstkprp> arr=new ArrayList<clsstkprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call dispstk(?)}");
             stm.setInt(1,mcod);
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                clsstkprp p=new clsstkprp();
                p.setstkcod(rs.getInt("stkcod"));
                p.setstkdat(rs.getDate("stkdat"));
               p.setstkmedcod(rs.getInt("stkmedcod"));
                p.setstkqty(rs.getInt("stkqty"));               
                p.setstkprc(rs.getFloat("stkprc"));
               p.setstkmnfdat(rs.getDate("stkmandat"));
                p.setstkexpdat(rs.getDate("stkexpdat"));              
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
  public  clsstkprp find_rec(int scod)
    {
        clsstkprp p=new clsstkprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call findstk(?)}");
            stm.setInt(1, scod);
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                p.setstkcod(rs.getInt("stkcod"));
                p.setstkdat(rs.getDate("stkdat"));
               p.setstkmedcod(rs.getInt("stkmedcod"));
                p.setstkqty(rs.getInt("stkqty"));               
                p.setstkprc(rs.getFloat("stkprc"));
               p.setstkmnfdat(rs.getDate("stkmandat"));
                p.setstkexpdat(rs.getDate("stkexpdat"));
                
            }
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return p;
    }
   
 public void del_rec(clsstkprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call delstk(?)}");
            stm.setInt(1,p.getstkcod());
            stm.execute();  
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
