package member;

import java.sql.Timestamp;

public class LogonDataBean
{
  private String id;
  private String passwd;
  private String name;
  private String jumin1;
  private String jumin2;
  private String tel;
  private String email;
  private Timestamp reg_date;
  private String zipcode;
  private String address;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getPasswd()
  {
    return this.passwd;
  }
  
  public void setPasswd(String passwd)
  {
    this.passwd = passwd;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getJumin1()
  {
    return this.jumin1;
  }
  
  public void setJumin1(String jumin1)
  {
    this.jumin1 = jumin1;
  }
  
  public String getJumin2()
  {
    return this.jumin2;
  }
  
  public void setJumin2(String jumin2)
  {
    this.jumin2 = jumin2;
  }
  
  public String getTel()
  {
    return this.tel;
  }
  
  public void setTel(String tel)
  {
    this.tel = tel;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public Timestamp getReg_date()
  {
    return this.reg_date;
  }
  
  public void setReg_date(Timestamp reg_date)
  {
    this.reg_date = reg_date;
  }
  
  public String getZipcode()
  {
    return this.zipcode;
  }
  
  public void setZipcode(String zipcode)
  {
    this.zipcode = zipcode;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
}
