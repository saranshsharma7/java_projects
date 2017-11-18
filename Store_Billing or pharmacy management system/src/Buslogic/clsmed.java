
package Buslogic;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsmed {
     CallableStatement stm;
    public void save_rec(clsmedprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call insmed(?,?,?,?,?,?)}");
            stm.setString(1,p.getmednam());           
            stm.setString(2,p.getmedgnrnam());
            stm.setString(3,p.getmedcpc());
            stm.setString(4, p.getmedcmp());
            stm.setString(5, p.getmedprc());
            stm.setString(6,p.getmedtyp());
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
    }
    public void upd_rec(clsmedprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call updmed(?,?,?,?,?,?,?)}");
            stm.setInt(1, p.getmedcod());
            stm.setString(2,p.getmednam());           
            stm.setString(3,p.getmedgnrnam());
            stm.setString(4,p.getmedcpc());
            stm.setString(5, p.getmedcmp());
            stm.setString(6, p.getmedprc());
            stm.setString(7,p.getmedtyp());
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }    
    public List<clsmedprp> disp_rec()
    {
        List<clsmedprp> arr=new ArrayList<clsmedprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call dispmed()}");
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                clsmedprp p=new clsmedprp();
                p.setmedcod(rs.getInt("medcod"));
                p.setmednam(rs.getString("mednam"));
               p.setmedgnrnam(rs.getString("medgnrnam"));
                p.setmedcpc(rs.getString("medcpc"));               
                p.setmedcmp(rs.getString("medcmp"));
               p.setmedprc(rs.getString("medprc"));
                p.setmedtyp(rs.getString("medtyp"));              
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
  public  clsmedprp find_rec(int mcod)
    {
        clsmedprp p=new clsmedprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call findmed(?)}");
            stm.setInt(1, mcod);
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                p.setmedcod(rs.getInt("medcod"));
                p.setmednam(rs.getString("mednam"));
               p.setmedgnrnam(rs.getString("medgnrnam"));
                p.setmedcpc(rs.getString("medcpc"));               
                p.setmedcmp(rs.getString("medcmp"));
               p.setmedprc(rs.getString("medprc"));
                p.setmedtyp(rs.getString("medtyp"));   
                
            }
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return p;
    }
   
 public void del_rec(clsmedprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call delmed(?)}");
            stm.setInt(1,p.getmedcod());
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
