package finalProject.helper.randomGenerete;

import com.github.javafaker.Faker;

public class UserGenerate {

    private static final Faker faker = new Faker();

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getFullName(){
        return faker.name().fullName();
    }

    public static String getEmail(){
        return faker.internet().emailAddress();
    }

    public static String getPhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }

    public static String getUsername(){
        return faker.name().username();
    }

    public static String getCity(){
        return faker.address().city();
    }

    public static String getCountry(){
        return faker.address().country();
    }

    public static String getStreetAddress(){
        return faker.address().streetAddress();
    }

    public static String getCompanyName(){
        return faker.company().name();
    }

}
