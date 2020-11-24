package board;
//Calendar 클래스
//자바는 시간을 표시하거나
//시간을 설정하는 클래스가 다양하게 있다
//기존에는 Date혹은DateTime정도만 사용했지만
//자바 측에서는 해당 클래스들이 "Deprecated"
//구식이 되었으므로
//시간을 표시하거나 설정할때는 Calendar를,
//사간의 차이를 계산할 때에는 Chronicle을 권장

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import util.ScannerUtil;

//Calendar의 경우에는
//1970년 1월 1일부터 지금가지 혹은 사용자가 설정한 시간까지를
//1/1000초 단위로 계산한다
//그것을 기반으로 여러가지 값으로 보내주거나
//DateFormat이란 것을 사용하여
//원하는 형식으로 출력해줄 수도 있다

public class MyCalendar {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println("cal: "+cal);
        
        //캘린더에서 각 필드의 값을 알고 싶다면
        //get(Calendar.필드이름)으로 알 수 있다.
        System.out.println("cal.get(Calendar.DATE): "+cal.get(Calendar.DATE));
        //대표적으로 사용되는 것은
        //Calendar.DATE, Calendar.MONTH 등이 있다.
        
        //Calendar객체에 시간을 직접 넣어줄 때에는
        //set()메소드를 호출하면 되는데
        //1.특정 필드에 값을 직접 저장
        //2.연 월 일에 해당하는 값을 저장
        //3.연 월 일 시 분 에 해당하는 값을 저장
        //4.연 월 일 시 분 초 에 해당하는 값을 저장
        System.out.println("set 1번: 필드에 값 저장");
        System.out.println("저장전 cal.get(Calendar.DATE): "+cal.get(Calendar.DATE));
        cal.set(Calendar.DATE,25);
        System.out.println("저장후 cal.get(Calendar.DATE): "+cal.get(Calendar.DATE));
        
        System.out.println("set 2번: 연 월 일 저장");
        System.out.printf("저장전: %d년 %d월 %d일\n",cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE));
        cal.set(2009,8,5);
        System.out.printf("저장후: %d년 %d월 %d일\n",cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE));
        
        //시간을 이쁘게 출력해보기
        //DateFormat 혹은 SimpleDateFormat 클래스 객체를 통해서
        //포맷을 정해주어야 한다
        //포맷의 경우
        //년:y
        //월:m
        //일:d
        //시:12시간은 h 24시간은 H
        //분:m
        //초:s 를 사용하여 직접 지정
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        //DateFormat의 경우 1/1000초 단위를 지정한 양식으로
        //String으로 바꿔주는 역할도 하지만
        //입력한 String이 지정한 형식과 일치하면 1/1000초로 바꾸는 역할도 한다
        
        System.out.println("sdf 적용전: "+cal.getTime());
        System.out.println("sdf 적용후: "+sdf.format(cal.getTime()));
        sdf = new SimpleDateFormat("y-M-d H:m:s");
        System.out.println("sdf 적용전: "+cal.getTime());
        System.out.println("sdf 적용후: "+sdf.format(cal.getTime()));
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("년: ");
        int year = ScannerUtil.nextInt(scan);
        System.out.print("월: ");
        int month = ScannerUtil.nextInt(scan);
        System.out.print("일: ");
        int date = ScannerUtil.nextInt(scan);
        System.out.print("시: ");
        int hour = ScannerUtil.nextInt(scan);
        System.out.print("분: ");
        int minute = ScannerUtil.nextInt(scan);
        System.out.print("초: ");
        int second = ScannerUtil.nextInt(scan);
        
        String temp = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
        System.out.println("사용자가 입력한 값을 String: "+temp);
        
        
        //try/catch구조란
        //혹시라도 발생할 수있는 심각한 오류에 대비하여
        //그 오류가 날 수 있는 코드를 try에서 실행하고
        //만약 오류가 발생한다면 catch가 해결하는 형태의 코드
        try {
            //sdf가 변환한 temp를 cal에 저장
            //만약 정확하지 않은 값을 입력했을 때
            //cal객체의 셋팅에 따라 결과가 나뉜다
            //1.lenient 모드
            //  
            cal.setTime(sdf.parse(temp));
            System.out.println(cal.getTime());
            //2.strict 모드
            //모든 잘못된 시간은 변환하지 않는다.
            sdf.setLenient(false);
            cal=Calendar.getInstance();
            cal.setTime(sdf.parse(temp));
            System.out.println(cal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
