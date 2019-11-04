package exercise;

public class Person
{

    private String firstName;
    private String lastName;
    private String userId;
    private Integer version;
    private String insurance;


    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public String getInsurance()
    {
        return insurance;
    }

    public void setInsurance(String insurance)
    {
        this.insurance = insurance;
    }
}
