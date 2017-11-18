
package Buslogic;

import java.util.Date;

public interface intbil {
    
    public void setbilcod(int bcod);
    public void setbildat(Date bdat);
    public void setbilcstnam(String bcstnam);
    public void setbilcstphn(String bcstphn);
   
    
    public int getbilcod();
    public Date getbildat();
    public String getbilcstnam();
    public String getbilcstphn(); 
     
}
