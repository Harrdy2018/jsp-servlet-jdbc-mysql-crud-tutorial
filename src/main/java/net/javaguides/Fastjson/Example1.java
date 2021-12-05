package net.javaguides.Fastjson;

import com.alibaba.fastjson.JSON;

public class Example1 {
    public static void main(String[] args) {
        Grade group = new Grade();
        group.setId(0L);
        group.setName("admin");

        Student student = new Student();
        student.setId(2L);
        student.setName("guest");

        Student rootUser = new Student();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addStudent(student);
        group.addStudent(rootUser);

        // 转换为 JSON
        String jsonString = JSON.toJSONString(group);
        System.out.println("JSON字符串：" + jsonString);

        // 转换为 对象BEAN
        Grade grade = JSON.parseObject(jsonString, Grade.class);
        System.out.println("JavaBean对象：" + grade);

        /*
        如果设置 group.setId(null);
        序列化 JSON字符串：{"name":"admin","users":[{"id":2,"name":"guest"},{"id":3,"name":"root"}]}
        JavaBean对象：Grade{id=null, name='admin', users=[Student{id=2, name='guest'}, Student{id=3, name='root'}]}
        */

        /*
        // "null"反序列化的结果为null
        String testNull = "{\"id\":\"null\",\"name\":\"admin\",\"users\":[{\"id\":2,\"name\":\"guest\"},{\"id\":3,\"name\":\"root\"}]}";
        Grade gradeA = JSON.parseObject(testNull, Grade.class);
        System.out.println("JavaBean对象：" + gradeA);
        */

        /*
        高版本中，反序列化时JSON会首先尝试调用默认构造函数，如果没有默认构造函数，则会寻找相匹配的有参构造函数。
        如果已经存在有参构造函数，但并没有提供默认构造函数时，某些场景下会出现反序列化的对象的属性值为空的情况。
        因此建议，JavaBean存在有参构造函数时，都显式提供默认构造函数。
        */
    }
}
