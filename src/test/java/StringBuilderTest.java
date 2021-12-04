import org.junit.Test;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringBuilderTest {

    @Test
    public void stringBuilderTest() {
        StringBuilder sb1 = new StringBuilder();            // StringBuilders are mutable!!!
        StringBuilder sb2 = new StringBuilder();
        Character[] ch = {'f','o','o','b','a','r'};
        List<Character> chList = Arrays.asList(ch);

        for(char c : ch)
            sb1 = sb1.append(c);

        System.out.println("sb1 original: " + sb1);
        System.out.println(sb1.hashCode());
        sb1.insert(6, 'z');
        System.out.println("sb1 modified: " + sb1);
        System.out.println(sb1.hashCode());

        System.out.println("\nchList original: " + chList);
        chList.forEach(c -> { sb2.append(c); });
        System.out.println("chList -> sb2: " + sb2);
        chList.stream().map(x -> String.format("%s, ", x)).forEach(System.out::println);
    }
}
