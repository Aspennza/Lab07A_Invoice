import java.util.Objects;

/**
 * Allows the creation of objects representing addresses,
 * including street address, apartment address, city, state, and zip code.
 * Also includes functions for acting on and formatting said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class Address
{
    //This String stores the street address for each Address object
    private String street;

    //This String stores the apartment address for each Address object
    private String apt;

    //This String stores the city for each Address object
    private String city;

    //This String stores the state for each Address object
    private String state;

    //This String stores the zip code for each address object
    private String zip;

    //This constructor creates Address objects including apartment numbers
    public Address(String street, String apt, String city, String state, String zip)
    {
        this.street = street;
        this.apt = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    //This constructor creates Address objects excluding apartment numbers
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

    @Override
    public String toString() {
        if(apt != null) {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", apt='" + apt + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zip='" + zip + '\'' +
                    '}';
        } else {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zip='" + zip + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        if (apt != null && address.apt != null) {
            return Objects.equals(street, address.street) && Objects.equals(apt, address.apt) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip, address.zip);
        } if (apt == null && address.apt == null) {
            return Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip, address.zip);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        if(apt != null) {
            return Objects.hash(street, apt, city, state, zip);
        } else {
            return Objects.hash(street, city, state, zip);
        }
    }

    /**
     * Concatenates an Address' street, (optionally) apartment, city, state, and zip code in a readable format.
     * @return a String containing all the data held in the Address.
     */
    public String getFormattedAddress()
    {
        if(apt != null) {
            return street.trim() + " " + apt.trim() + "\n" + city.trim() + ", " + state.trim() + " " + zip.trim();
        } else {
            return street.trim() + "\n" + city.trim() + ", " + state.trim() + " " + zip.trim();
        }
    }
}
