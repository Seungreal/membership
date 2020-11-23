package abstraction;

import java.util.Scanner;

public class GradeApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GradeController control = new GradeController();
        
        while(true) {
            System.out.println("성적 입출력 시스템");
            System.out.printf("1.성적등록 2.등수발표\n>");
            switch (scan.next()) {
            case "1":
                GradeDTO grade = new GradeDTO();
                System.out.print("이름: ");
                grade.setName(scan.next());
                System.out.print("국어점수: ");
                grade.setKor(scan.nextInt());
                System.out.print("영어점수: ");
                grade.setEng(scan.nextInt());
                System.out.print("수학점수: ");
                grade.setMath(scan.nextInt());
                control.postGrade(grade);
                break;
            case "2":
                GradeDTO[] list = control.getGradeSort();
                for(int i=0;i<list.length;i++) {
                    System.out.println(list[i]);
                }
                break;
            case "0":
                scan.close();
                return;
            }
        }
    }
}

class GradeDTO {
    private String name;
    private int kor,eng,math,sum;
    private float avg;
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getKor() {return kor;}
    public void setKor(int kor) {this.kor = kor;}
    public int getEng() {return eng;}
    public void setEng(int eng) {this.eng = eng;}
    public int getMath() {return math;}
    public void setMath(int math) {this.math = math;}
    public int getSum() {return sum;}
    public void setSum(int sum) {this.sum = sum;}
    public float getAvg() {return avg;}
    public void setAvg(float avg) {this.avg = avg;}
    @Override
    public String toString() {
        return "GradeDTO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
                + avg + "]";
    }
}

interface GradeService {
    public void inputGrade(GradeDTO grade);
    public void updateGrade(GradeDTO grade);
    public void deleteGrade(GradeDTO grade);
    public int sum(GradeDTO grade);
    public float avg(int sum);
    public GradeDTO[] gradeSort();
}

class GradeServiceImpl implements GradeService{
    GradeDTO[] users;
    
    public GradeServiceImpl() {
        users=new GradeDTO[0];
    }

    @Override
    public void inputGrade(GradeDTO grade) {
        grade.setSum(sum(grade));
        grade.setAvg(avg(grade.getSum()));
        GradeDTO[] temp = users;
        users=new GradeDTO[temp.length+1];
        for(int i=0;i<temp.length;i++) {
            users[i]=temp[i];
        }
        users[temp.length]=grade;
    }
    
    @Override
    public void updateGrade(GradeDTO grade) {
        for(int i=0;i<users.length;i++) {
            if(grade.getName().equals(users[i].getName())) {
                users[i].setKor(grade.getKor());
                users[i].setEng(grade.getEng());
                users[i].setMath(grade.getMath());
                users[i].setSum(sum(grade));
                users[i].setAvg(avg(grade.getSum()));
                break;
            }
        }
    }

    @Override
    public void deleteGrade(GradeDTO grade) {
        int length = users.length;
        int index=-1;
        for(int i=0;i<length;i++) {
            if(grade.getName().equals(users[i].getName())) {
                index=i;
                break;
            }
        }
        if(index!=-1) {
            GradeDTO[] temp = new GradeDTO[length];
            users = new GradeDTO[length-1];
            for(int i=0;i<index;i++) {
                users[i]=temp[i];
            }
            for(int i=index;i<length-1;i++) {
                users[i]=temp[i+1];
            }
        }
    }

    @Override
    public int sum(GradeDTO grade) {
        return grade.getKor()+grade.getEng()+grade.getMath();
    }

    @Override
    public float avg(int sum) {
        return sum/3.0f;
    }

    @Override
    public GradeDTO[] gradeSort() {
        int length = users.length;
        for(int i=0;i<length;i++) {
            int max=i;
            for(int j=i+1;j<length;j++) {
                if(users[max].getSum()<users[j].getSum()) {
                    max=j;
                }
            }
            GradeDTO temp = users[i];
            users[i] = users[max];
            users[max] = temp;
        }
        return users;
    }

}

class GradeController {
    GradeService service = new GradeServiceImpl();
    
    public void postGrade(GradeDTO grade) {
        service.inputGrade(grade);
    }
    public void putGrade(GradeDTO grade) {
        service.updateGrade(grade);
    }
    public void deleteGrade(GradeDTO grade) {
        service.deleteGrade(grade);
    }
    public int getSum(GradeDTO grade) {
        return service.sum(grade);
    }
    public float getAvg(int sum) {
        return service.avg(sum);
    }
    public GradeDTO[] getGradeSort() {
        return service.gradeSort();
    }
}