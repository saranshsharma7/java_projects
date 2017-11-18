
package Buslogic;

import java.util.Date;


public class clsbilprp implements intbil
{
private int bilcod;
    private String bilcstnam,bilcstphn;
   private Date bildat;
    {
        bilcstnam=new String();
         bilcstphn=new String();
          
    }
    @Override
    public void setbilcod(int bcod) {
        bilcod=bcod;
    }

    @Override
    public void setbildat(Date bdat) {
        bildat=bdat;
    }

    @Override
    public void setbilcstnam(String bcstnam) {
        bilcstnam=bcstnam;
    }

    @Override
    public void setbilcstphn(String bcstphn) {
       bilcstphn=bcstphn;
    }

    @Override
    public int getbilcod() {
       return bilcod;
    }

    @Override
    public Date getbildat() {
        return bildat;
    }

    @Override
    public String getbilcstnam() {
        return bilcstnam;
    }

    @Override
    public String getbilcstphn() {
       return bilcstphn;
    }
    
}
