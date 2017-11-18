
package Buslogic;

import java.util.Date;

public class clsbildetprp implements intbildet
{   
    private int bildetcod,bildetbilcod,bildetstkcod,bildetqty;
   
    

    @Override
    public void setbildetcod(int bdcod) {
       bildetcod=bdcod;
    }

    @Override
    public void setbildetbilcod(int bdbilcod) {
        bildetbilcod=bdbilcod;
    }

    @Override
    public void setbildetstkcod(int bdstkcod) {
        bildetstkcod=bdstkcod;
    }

    @Override
    public void setbildetqty(int bdqty) {
       bildetqty=bdqty;
    }

    @Override
    public int getbildetcod() {
       return bildetcod;
    }

    @Override
    public int getbildetbilcod() {
       return bildetbilcod;
    }

    @Override
    public int getbildetstkcod() {
        return bildetstkcod;
    }

    @Override
    public int getbildetqty() {
       return bildetqty;
    }
    
}
