package com.mingrisoft.dao.model;
//主要用于存储数据
public class TbSpinfo implements java.io.Serializable{
    private String id;
    private String spname;
    private String jc;
    private String cd;
    private String dw;
    private String gg;
    private String bz;
    private String ph;
    private String pzwh;
    private String memo;
    private String gysname;
    public TbSpinfo(){}//缺省构造方法
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSpname() {
        return spname;
    }
    public void setSpname(String spname) {
        this.spname = spname;
    }
    public String getJc() {
        return jc;
    }
    public void setJc(String jc) {
        this.jc = jc;
    }
    public String getCd() {
        return cd;
    }
    public void setCd(String cd) {
        this.cd = cd;
    }
    public String getDw() {
        return dw;
    }
    public void setDw(String dw) {
        this.dw = dw;
    }
    public String getGg() {
        return gg;
    }
    public void setGg(String gg) {
        this.gg = gg;
    }
    public String getBz() {
        return bz;
    }
    public void setBz(String bz) {
        this.bz = bz;
    }
    public String getPh() {
        return ph;
    }
    public void setPh(String ph) {
        this.ph = ph;
    }
    public String getPzwh() {
        return pzwh;
    }
    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getGysname() {
        return gysname;
    }
    public void setGysname(String gysname) {
        this.gysname = gysname;
    }
    @Override
    public String toString(){
        return  getSpname();
    }
    @Override
    public int hashCode(){
        final  int PRIME=31;
        int result=1;
        result=PRIME*result+((bz==null)?0:bz.hashCode());
        result=PRIME*result+((cd==null)?0:cd.hashCode());
        result=PRIME*result+((dw==null)?0:dw.hashCode());
        result=PRIME*result+((gg==null)?0:gg.hashCode());
        result=PRIME*result+((gysname==null)?0:gysname.hashCode());
        result=PRIME*result+((id==null)?0:id.hashCode());
        result=PRIME*result+((jc==null)?0:jc.hashCode());
        result=PRIME*result+((memo==null)?0:memo.hashCode());
        result=PRIME*result+((ph==null)?0:ph.hashCode());
        result=PRIME*result+((pzwh==null)?0:pzwh.hashCode());
        result=PRIME*result+((spname==null)?0:spname.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (getClass()!=obj.getClass()){
            return false;
        }
        final  TbSpinfo other=(TbSpinfo) obj;
        if(bz==null){
            if (other.bz!=null){
                return false;
            }
        }
        else if(!bz.equals(other.bz)){
            return false;
        }
        if(cd==null){
            if (other.cd!=null){
                return false;
            }
        }
        else if(!cd.equals(other.cd)){
            return false;
        }
        if(dw==null){
            if (other.dw!=null){
                return false;
            }
        }
        else if(!dw.equals(other.dw)){
            return false;
        }
        if(gg==null){
            if (other.gg!=null){
                return false;
            }
        }
        else if(!gg.equals(other.gg)){
            return false;
        }
        if(gysname==null){
            if (other.gysname!=null){
                return false;
            }
        }
        else if(!gysname.equals(other.gysname)){
            return false;
        }
        if(id==null){
            if (other.id!=null){
                return false;
            }
        }
        else if(!id.equals(other.id)){
            return false;
        }
        if(jc==null){
            if (other.jc!=null){
                return false;
            }
        }
        else if(!jc.equals(other.jc)){
            return false;
        }
        if(memo==null){
            if (other.memo!=null){
                return false;
            }
        }
        else if(!memo.equals(other.memo)){
            return false;
        }
        if(ph==null){
            if (other.ph!=null){
                return false;
            }
        }
        else if(!ph.equals(other.ph)){
            return false;
        }
        if(pzwh==null){
            if (other.pzwh!=null){
                return false;
            }
        }
        else if(!pzwh.equals(other.pzwh)){
            return false;
        }
        if(spname==null){
            if (other.spname!=null){
                return false;
            }
        }
        else if(!spname.equals(other.spname)){
            return false;
        }
        return true;
    }
}
