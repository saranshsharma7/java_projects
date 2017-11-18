
package Buslogic;

import java.util.Date;


public class clsstkprp implements intstk
{
    private int stkcod,stkmedcod,stkqty;
   
   private Date stkdat,stkmnfdat,stkexpdat;
   private float stkprc;
    
    @Override
    public void setstkcod(int scod) {
      stkcod=scod;
    }

    @Override
    public void setstkdat(Date sdat) {
        stkdat=sdat;
    }

    @Override
    public void setstkmedcod(int smedcod) {
        stkmedcod=smedcod;
    }

    @Override
    public void setstkqty(int sqty) {
        stkqty=sqty;
    }

    @Override
    public void setstkprc(float sprc) {
        stkprc=sprc;
    }

    @Override
    public void setstkmnfdat(Date smnfdat) {
       stkmnfdat=smnfdat;
    }

    @Override
    public int getstkcod() {
       return stkcod;
    }

    @Override
    public Date getstkdat() {
        return stkdat;
    }

    @Override
    public int getstkmedcod() {
       return stkmedcod;
    }

    @Override
    public int getstkqty() {
       return stkqty;
    }

    @Override
    public float getstkprc() {
       return stkprc;
    }

    @Override
    public Date getstkmnfdat() {
        return stkmnfdat;
    }

    @Override
    public void setstkexpdat(Date sexpdat) {
       stkexpdat=sexpdat;
    }

    @Override
    public Date getstkexpdat() {
       return stkexpdat;
    }
    
}
