
package Buslogic;

import java.util.Date;

public interface intstk {
    
    public void setstkcod(int scod);
    public void setstkdat(Date sdat);
    public void setstkmedcod(int smedcod);
    public void setstkqty(int sqty);
    public void setstkprc(float sprc);
    public void setstkmnfdat(Date smnfdat);
    public void setstkexpdat(Date sexpdat);
    
    public int getstkcod();
    public Date getstkdat();
    public int getstkmedcod();
    public int getstkqty(); 
    public float getstkprc();
    public Date getstkmnfdat();
    public Date getstkexpdat();
}
