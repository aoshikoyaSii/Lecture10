package providers;

import Models.Gender;
import Models.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserFactory  {
    User user;

    public User registeringNewUser() {
        return new User.Builder()
                .setfirstname(System.getProperty("name"))
                .setlastname(System.getProperty("surname"))
                .setEmail(System.getProperty("email"))
                .setPassword(System.getProperty("password"))
                .setDaySelector(getRandomString(1))
                .setMonthSelector(getRandomString(2))
                .setYearSelector(getRandomString(4))
                .setAddressFirstname(getRandomText())
                .setAddressLastname(getRandomText())
                .setCompanyName(getRandomText())
                .setAddress(getRandomText())
                .setCity(getRandomText())
                .setStates(getRandomText())
                .setPostcode(System.getProperty("postcode"))
                .setCountries(System.getProperty("country"))
                .setTextNote(getRandomText())
                .setPhone(System.getProperty("phone"))
                .setFutureAddress(getRandomString(5))
                .setGender(Gender.getRandomGender())
                        .buildData();
    }


    private String getRandomText() {
        return RandomStringUtils.random(7, true, false);
    }

    public String getRandomString(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public User alreadyRegisteredUser(){
        return new User.Builder()
                .setEmail(System.getProperty("email"))
                .setPassword(System.getProperty("password"))
                .buildData();
    }

}