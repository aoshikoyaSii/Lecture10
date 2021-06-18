package Models;

public class User {
    private Gender gender;
    private String customerFirstname;
    private String customerLastname;
    private String companyName;
    private String company;
    private String companyAddress1;
    private String email;
    private String password;
    private String daySelector;
    private String monthSelector;
    private String yearSelector;
    private String AddressFirstname;
    private String AddressLastname;
    private String city;
    private String states;
    private String postcode;
    private String countries;
    private String textNote;
    private String mobilephone;
    private String futureAddress;

    public User(Gender gender, String customerFirstname, String customerLastname, String companyName, String companyAddress1, String email, String password, String daySelector, String monthSelector, String yearSelector, String addressFirstname, String addressLastname, String city, String states, String postcode, String countries, String textNote, String phone, String futureAddress) {
        this.gender = gender;
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.companyName = companyName;
        this.companyAddress1 = companyAddress1;
        this.email = email;
        this.password = password;
        this.daySelector = daySelector;
        this.monthSelector = monthSelector;
        this.yearSelector = yearSelector;
        AddressFirstname = addressFirstname;
        AddressLastname = addressLastname;
        this.city = city;
        this.states = states;
        this.postcode = postcode;
        this.countries = countries;
        this.textNote = textNote;
        this.mobilephone = phone;
        this.futureAddress = futureAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress1() {
        return companyAddress1;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDaySelector() {
        return daySelector;
    }

    public String getMonthSelector() {
        return monthSelector;
    }

    public String getYearSelector() {
        return yearSelector;
    }

    public String getAddressFirstname() {
        return AddressFirstname;
    }

    public String getAddressLastname() {
        return AddressLastname;
    }

    public String getCity() {
        return city;
    }

    public String getStates() {
        return states;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountries() {
        return countries;
    }

    public String getTextNote() {
        return textNote;
    }

    public String getPhone() {
        return mobilephone;
    }

    public String getFutureAddress() {
        return futureAddress;
    }

    public static final class Builder {
        private Gender gender;
        private String customerFirstname;
        private String customerLastname;
        private String email;
        private String password;
        private String daySelector;
        private String monthSelector;
        private String yearSelector;

        // Billing address
        private String addressFirstname;
        private String addressLastname;
        private String companyName;
        private String companyAddress1;
        private String city;
        private String states;
        private String postcode;
        private String countries;
        private String textNote;
        private String mobilephone;
        private String futureAddress;

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setfirstname(String customerFirstname) {
            this.customerFirstname = customerFirstname;
            return this;
        }

        public Builder setlastname(String customerLastname) {
            this.customerLastname = customerLastname;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setAddress(String address) {
            this.companyAddress1 = address;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDaySelector(String daySelector) {
            this.daySelector = daySelector;
            return this;
        }

        public Builder setMonthSelector(String monthSelector) {
            this.monthSelector = monthSelector;
            return this;
        }

        public Builder setYearSelector(String yearSelector) {
            this.yearSelector = yearSelector;
            return this;
        }

        public Builder setAddressFirstname(String addressFirstname) {
            this.addressFirstname = addressFirstname;
            return this;
        }

        public Builder setAddressLastname(String addressLastname) {
            this.addressLastname = addressLastname;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setStates(String states) {
            this.states = states;
            return this;
        }

        public Builder setPostcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public Builder setCountries(String countries) {
            this.countries = countries;
            return this;
        }

        public Builder setTextNote(String textNote) {
            this.textNote = textNote;
            return this;
        }

        public Builder setPhone(String phone) {
            this.mobilephone = phone;
            return this;
        }

        public Builder setFutureAddress(String futureAddress) {
            this.futureAddress = futureAddress;
            return this;
        }

        public User buildData(){
            if(email.isEmpty()){
                throw new IllegalStateException("email cannot be empty");
            }

            if(password.isEmpty()){
                throw new IllegalStateException("password cannot be empty");
            }
    return new User(gender, this.customerFirstname, this.customerLastname, this.companyName,  this.companyAddress1, this.email, this.password, this.daySelector, this.monthSelector,  this.yearSelector, this.addressFirstname, this.addressLastname, this.city, this.states, this.postcode, this.countries, this.textNote, this.mobilephone, this.futureAddress);
        }
    }
}


//public static nolombokbuilder builder(){return new nolombokbuilder()