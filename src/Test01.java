import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lambda 表达式
 */
public class Test01 {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("word");
        strList.add("aord");
        strList.add("dord");
        strList.add("cord");
//        List<String> lowerNames = strList.stream().map(String::toLowerCase)
//                .collect(Collectors.toList());
        //原版写法
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //lambda-1，省略参数类型
        Collections.sort(strList, (o1, o2) -> o1.compareTo(o2));

        //lambda-2,当参数只有一个，可以省略小括号
        List<String> lowerNames = strList.stream().map(name -> {
            System.out.println(name);
            return name.toLowerCase();
        }).collect(Collectors.toList());

        //lambda-3,当执行语句只有一行时，可以省略{}、return关键字
        List<String> lowerNames2 = strList.stream().map(name -> name.toLowerCase())
                .collect(Collectors.toList());

        //lambda-4,在3的基础上,传递方法引用
        List<String> lowerNames3 = strList.stream().map(String::toUpperCase)
                .collect(Collectors.toList());



    }
}
