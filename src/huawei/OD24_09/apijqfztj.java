package huawei.OD24_09;

import java.util.*;

/**
 * 华为OD机试统一考试D卷C卷 - API集群负载统计
 * 题目描述
 * 某个产品的RESTful API集合部署在服务器集群的多个节点上，近期对客户端访问日志进行了采集，需要统计各个API的访问频次，根据热点信息在服务器节点之间做负载均衡，现在需要实现热点信息统计查询功能。
 * <p>
 * RESTful API是由多个层级构成，层级之间使用 / 连接，如 /A/B/C/D 这个地址，A属于第一级，B属于第二级，C属于第三级，D属于第四级。
 * <p>
 * 现在负载均衡模块需要知道给定层级上某个名字出现的频次，未出现过用0表示，实现这个功能。
 * <p>
 * 输入描述
 * 第一行为N，表示访问历史日志的条数，0 ＜ N ≤ 100。
 * <p>
 * 接下来N行，每一行为一个RESTful API的URL地址，约束地址中仅包含英文字母和连接符 / ，最大层级为10，每层级字符串最大长度为10。
 * <p>
 * 最后一行为层级L和要查询的关键字
 * <p>
 * 输出描述
 * 输出给定层级上，关键字出现的频次，使用完全匹配方式（大小写敏感）。
 * <p>
 * 用例
 * 输入
 * <p>
 * 5
 * /huawei/computing/no/one
 * /huawei/computing
 * /huawei
 * /huawei/cloud/no/one
 * /huawei/wireless/no/one
 * 2 computing
 * <p>
 * 输出
 * <p>
 * 2
 * <p>
 * 说明
 * <p>
 * 在第二层级上，computing出现了2次，因此输出2
 * <p>
 * 用例2
 * 输入
 * <p>
 * 5
 * /huawei/computing/no/one
 * /huawei/computing
 * /huawei
 * /huawei/cloud/no/one
 * /huawei/wireless/no/one
 * 4 two
 * <p>
 * 输出
 * <p>
 * 0
 * <p>
 * 说明
 * <p>
 * 存在第四层级的URL上，没有出现two，因此频次是0
 * <p>
 * 作者：不上岸不改名！
 * 链接：https://www.nowcoder.com/discuss/619838223975452672
 * 来源：牛客网
 */
public class apijqfztj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < num; i++) {
            String[] split = scanner.nextLine().split("/");
            for (int j = 0; j < split.length; j++) {
                if (split[j].length() > 0) {
                    if (!map.containsKey(split[j])) {
                        ArrayList<Integer> list = new ArrayList<>();
                        for (int k = 0; k < 10; k++) {
                            list.add(0);
                        }
                        map.put(split[j], list);
                    }
                    ArrayList<Integer> integers = map.get(split[j]);
                    integers.set(j - 1, integers.get(j - 1) + 1);
                }
            }
        }
//        System.out.println(map);
        String[] s = scanner.nextLine().split(" ");
        Integer num1 = Integer.parseInt(s[0]);
        if (!map.containsKey(s[1])) {
            System.out.println(0);
        } else {
            ArrayList<Integer> strRe = map.get(s[1]);
            Integer integer = strRe.get(num1 - 1);
            System.out.println(integer);
        }
    }
}
