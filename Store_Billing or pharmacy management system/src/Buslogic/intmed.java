
package Buslogic;

import java.util.Date;


public interface intmed {
     public void setmedcod(int mcod);
    public void setmednam(String mnam);
    public void setmedgnrnam(String mgnrnam);
    public void setmedcpc(String mcpc);
    public void setmedcmp(String mcmp);
    public void setmedprc(String mprc);
    public void setmedtyp(String mtyp);
   
    
    public int getmedcod();
    public String getmednam();
    public String getmedgnrnam();
    public String getmedcpc(); 
    public String getmedcmp();
    public String getmedprc();
    public String getmedtyp();
}
