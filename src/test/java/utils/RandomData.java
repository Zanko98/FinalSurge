package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomData {

    public static String randomString(int count) {
        return new Faker().random().hex(count);
    }

    public static String randomDate() {
        Random r = new Random();
        return String.format("%s/%s/2022", r.nextInt(30) + 1, r.nextInt(12) + 1);
    }
}
