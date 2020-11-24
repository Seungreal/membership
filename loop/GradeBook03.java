package loop;

import java.util.Scanner;

import util.ScannerUtil;

//메인 메소드가 모든걸 담당하지않고
//개별 메소드가 한가지 담당만 하는 버전
public class GradeBook03 {

    final static int SUBZECT_SIZE=3;
    
    //메뉴 출력
    //사용자가 어떤 기능을 실행할지 선택만 가능
    static void showMenu(Scanner scanner) {
        int id=0;
        String name=new String();
        int korean=-1,english=0,math=0;
        
        while(true) {
            System.out.println("1. 성적 입력 2. 성적 출력 3. 종료");
            int userChoice = ScannerUtil.nextInt(scanner,">", 1, 3);
            if(userChoice==1) {
                //성적 입력을 담당하는 코드 실행
                System.out.print("번호: ");
                id=scanner.nextInt();
                
                System.out.print("이름: ");
                name=ScannerUtil.nextLine(scanner);
                
                korean=ScannerUtil.nextInt(scanner, "국어: ", 0, 100);
                
                english=ScannerUtil.nextInt(scanner, "영어: ", 0, 100);
                
                math=ScannerUtil.nextInt(scanner, "수학: ", 0, 100);
            }else if(userChoice==2) {
                //성적 출력을 담당하는 메소드 실행
                printGrade(id, name, korean, english,math);
            }else if(userChoice==3) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
    
    static void printGrade(int id,String name,int korean,int english,int math) {
        if(korean==-1)
            System.out.println("아직 입력된 정보가 없습니다.");
        else {
            int total=korean+english+math;
            float avr=(float)total/SUBZECT_SIZE;
        
            System.out.printf("번호:%d번 이름:%s\n",id,name);
            System.out.printf("국어:%03d점 영어:%03d점 수학:%03d점\n",korean,english,math);
            System.out.printf("총점:%3d점 평균:%.2f점\n",total,avr);
        }
    }
    
    //자바에서 메소드에 파라미터를 넘겨줄 경우
    //파라미터의 데이터타입에 따라서
    //call by value와 call by reference가 발생하게 된다.
    //call by value: 값만 넘어가고 변수 자체는 넘어가지 않음
    //call by reference: 주소값을 넘겨주기 때문에 변경을 가하면
    //                   변수에도 변경이 가해짐
    //
    //call by value의 경우, 해당 변수의 값 복사본이 넘어가고
    //따라서 파라미터의 값을 변화시키더라도 원본의 값은 변하지 않는다.
    //
    //call by reference의 경우, 해당 변수의 주소값이 넘어가기 때문에
    //파라미터를 변화시키면 원본에도 해당 변화가 적용된다

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        showMenu(scanner);
        
        scanner.close();
    }
}
