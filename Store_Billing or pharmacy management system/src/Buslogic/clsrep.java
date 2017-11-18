package Buslogic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clsrep
{
public ResultSet medexp()
{
     ResultSet rs=null;
    try {
        clscon obj=clscon.getInstance();
        obj.connect();
        CallableStatement stm=obj.con.prepareCall("{call medexp()}");
        rs=stm.executeQuery();
    } catch (SQLException ex) {
        Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
}
}
