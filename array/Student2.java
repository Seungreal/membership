package array;

public class Student2 {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("s.id:"+s.getId());
        System.out.println("s.name:"+s.getName());
        
        s = new Student(1,"ㄱㄱㄱ",100,100,100);
        System.out.println("s.id:"+s.getId());
        System.out.println("s.name:"+s.getName());
        
        s.setId(1);
        s.setName("이승렬");
        s.setKorean(89);
        s.setEnglish(89);
        s.setMath(88);
        
        System.out.println("s.calculateSum(): "+s.calculateSum());
        
        Student s2 = new Student();
        
        s2.setId(2);
        s2.setName("철수");
        s2.setKorean(70);
        s2.setEnglish(70);
        s2.setMath(69);
        
        System.out.println("s2.calculateSum(): "+s2.calculateSum());
        
        Student s3 = null;
        s3 = new Student();
        System.out.println("s3.calculateSum(): "+s3.calculateSum());
        
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);
        
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1.equals(str2));
        
        s=new Student(1,"a",1,1,1);
        s2=new Student(1,"a",1,1,1);
        s3=new Student(2,"b",2,2,2);
        
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);
        
        System.out.println("s.equals(s2): "+s.equals(s2));
        System.out.println("s.equals(s3): "+s.equals(s3));
        System.out.println("s2.equals(s3): "+s2.equals(s3));
    }
}
