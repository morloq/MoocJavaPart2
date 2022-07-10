
public class RegistrationPlate {
    // don't change the code which is already given to you
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }
    
    public String getregCode()
    {
        return this.regCode;
    }
    
    public String getCountry()
    {
        return this.country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }

        RegistrationPlate compared = (RegistrationPlate) object;

        if (this.regCode != compared.getregCode()) {
            return false;
        }

        if (this.country == null || !this.country.equals(compared.getCountry())) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        if (this.regCode == null || this.country == null) {
            return 7;
        }

        return this.regCode.hashCode();
    }
}