package 算法和数据结构体系学习班.class14;


/**
 例题：
 每一个学生示例有三个属性 微信号，B站id ,github账号， 任何两个学生有任意两个属性相同，即可认为是一个人，请问这些实例公有几个"独立的人"
 思路：
 每个学生都作为一个单独的集合，学生这个示例作为"代表点"，三个属性代表其他节点。
 依次进行初始化，如果初始化到某个节点B，发现某个属性已经指向某个代表节点A，则把B与A进行合并

 例如(1,10,15) (2,10,37)(100,200,37) 是一个用户

 */

public class Code06_MergeUsers {

    public static class User{
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }





}
