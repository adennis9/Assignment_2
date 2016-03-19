/**
 *
 * @author Andrew
 */
package Assignment_2;


public class Gameazon 
{
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String ageRange;
    private float wallet;
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getAgeRange()
    {
        return ageRange;
    }
    
    public float getWallet()
    {
        return wallet;
    }
    
    
    public void setFirstName(String fName)
    {
        firstName = fName;
    }
    
    public void setLastName(String lName)
    {
        lastName = lName;
    }
    
    public void setUserName(String uName)
    {
        userName = uName;
    }
    
    public void setPassword(String pass)
    {
        password = pass;
    }
    
    public void setEmail(String em)
    {
        email = em;
    }
    
    public void setAgeRange(String age)
    {
        ageRange = age;
    }
    
    public void setWallet(float money)
    {
        wallet = money;
    }
}
