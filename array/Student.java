package array;

public class Student {
    private int id;
    private String name;
    private int korean;
    private int english;
    private int math;
    private final int SUBJECT_SIZE = 3;
    
    public int calculateSum() {
        //이 메소드는 파라미터가 존재하지않는다
        //이 메소드를 실행하는 객체의
        //국영수 점수로 총점을 계산하기 때문이다.
        //해당 객체의 국영수 점수는
        //필드에 저장됨
        return korean+english+math;
    }
    
    public double calculateAvr() {
        return calculateSum()/(double)SUBJECT_SIZE;
    }
    
    //생성자
    public Student() {
        id=-1;
        name=new String();
        korean=-1;
        english=-1;
        math=-1;
    }
    
    public Student(int id,String name,int korean,int english,int math) {
        this.id=id;
        this.name=name;
        this.korean=korean;
        this.english=english;
        this.math=math;
    }
    
    public String toString() {
        return "학생 번호: "+id+"학생 이름: "+name+"국어 점수: "+korean+"영어 점수: "+english+"수학 점수: "+math;
    }
    
    public boolean equals(Object o) {
        //파라미터로 넘어온 o가
        //Student 클래스 객체인지 확인해서
        //맞다면 형변환을 통해서 Student 객체로 바꿔준다
        //그후 특정 필드들을 비교하여
        //필ㄷ드들의 값이 값으면 리턴 트루해준다.
        //1.o가 student클래스 객체인지 확인
        //  instanceof라는 키워드를 통해서 확인
        if(o instanceof Student) {
            Student s= (Student)o;
            if(this.id==s.id&&this.name==s.name)
                return true;
        }
        
        return false;
    }
    
    //getter/setter
    public void setId(int id) {
        this.id=id;
    }
    public int getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    
    public void setKorean(int korean) {
        this.korean=korean;
    }
    public int getKorean() {
        return korean;
    }
    
    public void setEnglish(int english) {
        this.english=english;
    }
    public int getEnglish() {
        return english;
    }
    
    public void setMath(int math) {
        this.math=math;
    }
    public int getMath() {
        return math;
    }
    
    public void printInfo() {
        System.out.println("---------------");
        System.out.printf("번호: %d, 이름: %s\n", id, name);
        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n", 
                korean, english,math);
        System.out.printf("총점: %03d점, 평균:%.2f점\n", calculateSum(), calculateAvr());
        System.out.println("---------------");
    }
}