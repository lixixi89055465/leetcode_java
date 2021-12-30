package baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class example05 {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> stu1 = new HashMap<String, Object>();
        stu1.put("name", "卫庄");
        stu1.put("score", 80.0);
        list.add(stu1);
        Map<String, Object> stu2 = new HashMap<String, Object>();
        stu2.put("name", "盖聂");
        stu2.put("score", 90.0);
        list.add(stu2);
        Map<String, Object> stu3 = new HashMap<String, Object>();
        stu3.put("name", "天明");
        stu3.put("score", 60.0);
        list.add(stu3);
        double sum = list.stream().collect(Collectors.summingDouble(x -> ((Double) x.get("score"))));
        System.out.println("三人总分：" + sum);
    }
}
