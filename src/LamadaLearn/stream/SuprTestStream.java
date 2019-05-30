package LamadaLearn.stream;

import LamadaLearn.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SuprTestStream {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("james", "NJ", 22),
                new User("Lannister", "BJ", 23),
                new User("sophia", "TJ", 22),
                new User("tony", "SH", 18)
        );
        Map<Integer, List<User>>  userMap = users.stream().collect(Collectors.groupingBy(p -> p.getAge()));
        userMap.forEach((age, p) -> System.out.format("age %s: %s , %s\n", age, p));
    }
}
