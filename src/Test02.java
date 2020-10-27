import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream用法
 */
public class Test02 {

    public static void main(String[] args) {
        String[] str = new String[]{"word", "haha", "tea", "askdkasdasdalsdjkasj", "haha"};
        List<String> strings = Arrays.asList(str);


        //stream-0,创建stream
        List<String> list1 = Stream.of(str).filter(name -> name.length() < 10)
                .collect(Collectors.toList());
        list1.forEach(System.out::println);
        System.out.println("---------------");
        //stream-0-1,generate创建stream
        Stream<Double> s1 = Stream.generate(Math::random).limit(10);
        s1.collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------");

        //stream-0-2,Collection接口子类创建Stream
        strings.stream();

        //stream-1,过滤长度小于10的字符串
        List<String> strings1 = strings.stream().filter(name -> name.length() < 10)
                .collect(Collectors.toList());
        strings1.forEach(System.out::println);
        System.out.println("---------------");

        //stream-2,转换stream
        //2.1,distinct()去重
        List<String> distinctStrs = strings.stream().distinct()
                .collect(Collectors.toList());
        distinctStrs.forEach(System.out::println);
        System.out.println("---------------");

        //2.2 map(),对其中的元素进行转换
        List<String> mapList = strings.stream().map(it -> it += "yes")
                .collect(Collectors.toList());
        mapList.forEach(System.out::println);
        System.out.println("---------------");

        //2.3 flatMap(),将多个流扁平化成一个流(衔接多个流)
        List<String> spList = strings.stream().map(it -> it.split(""))
                .flatMap(it -> Arrays.stream(it)).distinct()
                .collect(Collectors.toList());
        spList.forEach(System.out::println);
        System.out.println("---------------");

        //flatMap(),衔接多个list-1
        List<Integer> nums = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))
                .flatMap(it -> it.stream()).collect(Collectors.toList());
        nums.forEach(System.out::print);
        System.out.println("\n---------------");

        //flatMap(),衔接多个list-2
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");
        List<String> teams = Stream.of(teamIndia, teamAustralia, teamEngland, teamNewZeland,
                teamSouthAfrica, teamWestIndies, teamSriLanka, teamPakistan)
                .flatMap(it -> it.stream())
                .map(it -> it+=" yes")
                //2.4 limit,只取一定数量的元素
                .limit(3)
                //2.5 skip(),跳过前n个元素
                .skip(1)
                //2.6 peek(),与map()类似,用于访问元素的状态，不能改变流中的元素
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("---------------");


    }
}
