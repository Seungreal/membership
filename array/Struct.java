package array;
//구조체
//다양한 데이터타입을 하나의 데이터타입으로 만들어주는것

public class Struct {
    public static void main(String[] args) {
        //student클래스는 하나의 자료형이 될수있다.
        Student s = new Student();
        s.setId(1);
        s.setName("ㅇㅇㅇ");
        s.setKorean(70);
        s.setEnglish(70);
        s.setMath(70);
        
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("ㄹㄹㄹ");
        s2.setKorean(70);
        s2.setEnglish(70);
        s2.setMath(69);
        
        System.out.printf("번호: %d, 이름: %s\n",s.getId(),s.getName());
        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n",s.getKorean(),s.getEnglish(),s.getMath());
        System.out.printf("번호: %d, 이름: %s\n",s2.getId(),s2.getName());
        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n",s2.getKorean(),s2.getEnglish(),s2.getMath());
    }
}
