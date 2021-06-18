package providers;

import Pages.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
    public class RandomStringGenerator  {
        public String getRandomString(int length){
            return RandomStringUtils.randomAlphabetic(length);
        }
    }
