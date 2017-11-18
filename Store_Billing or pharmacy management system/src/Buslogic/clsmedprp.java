
package Buslogic;




public class clsmedprp implements intmed
{
    private int medcod;
    private String mednam,medgnrnam,medcpc,medcmp,medprc,medtyp;
   
    {
        mednam=new String();
         medgnrnam=new String();
          medcpc=new String();
           medcmp=new String();
            medprc=new String();
            medtyp=new String();
    }
    @Override
    public void setmedcod(int mcod) {
        medcod=mcod;
    }

    @Override
    public void setmednam(String mnam) {
       mednam=mnam;
    }

    @Override
    public void setmedgnrnam(String mgnrnam) {
        medgnrnam=mgnrnam;
    }

    @Override
    public void setmedcpc(String mcpc) {
        medcpc=mcpc;
    }

    @Override
    public void setmedcmp(String mcmp) {
        medcmp=mcmp;
    }

    @Override
    public void setmedprc(String mprc) {
        medprc=mprc;
    }

    @Override
    public void setmedtyp(String mtyp) {
        medtyp=mtyp;
    }

    @Override
    public int getmedcod() {
       return medcod;
    }

    @Override
    public String getmednam() {
       return mednam;
    }

    @Override
    public String getmedgnrnam() {
        return medgnrnam;
    }

    @Override
    public String getmedcpc() {
       return medcpc;
    }

    @Override
    public String getmedcmp() {
        return medcmp;
    }

    @Override
    public String getmedprc() {
        return medprc;
    }

    @Override
    public String getmedtyp() {
        return medtyp;
    }
    
}
