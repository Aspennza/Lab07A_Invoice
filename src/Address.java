import java.util.Objects;

public class Address
{
    private String street;
    private String apt;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String apt, String city, String state, String zip)
    {
        this.street = street;
        this.apt = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address(String street, String city, String state, String zip)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    //May not need?
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", apt='" + apt + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    //May not need?
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(apt, address.apt) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip, address.zip);
    }

    //May not need?
    @Override
    public int hashCode() {
        return Objects.hash(street, apt, city, state, zip);
    }

    public String getFormattedAddress()
    {
        if(apt != null) {
            return street.trim() + " " + apt.trim() + "\n" + city.trim() + ", " + state.trim() + " " + zip.trim();
        } else {
            return street.trim() + "\n" + city.trim() + ", " + state.trim() + " " + zip.trim();
        }
    }
}
