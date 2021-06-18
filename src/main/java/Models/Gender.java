package Models;

import java.util.Random;

public enum Gender {

    male,female;

    public static Gender getRandomGender(){
        return values()[new Random().nextInt(values().length)];
    }
}
