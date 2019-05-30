package LamadaLearn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Stream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        List<String> lists = list.stream().filter(a -> Integer.valueOf(a) > 3).collect(Collectors.toList());
        System.out.println(lists);
    }
}
