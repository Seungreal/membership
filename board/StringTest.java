package board;

public class StringTest {
    public static void main(String[] args) {
        String str = new String();
        System.out.println("str의 현재값: " + str);

        str = new String("abcDEFghi");
        System.out.println("str의 현재값: " + str);

        str = "가나다라abc마바사아";
        System.out.println("str의 현재값: " + str);

        // 1.문자열의 특정 위치에 존재하는
        // char가 알고 싶을때는 charAt
        // String에서 위치를 샐때는 0부터 샌다.
        System.out.println("str.charAt(4): " + str.charAt(4));

        // 2.2개의 문자열을 이어서
        // 하나의 커다란 문자열로 만들때는 concat()
        // 자바에서는 String의 경우
        // +연산자는 concat()을 실행하도록 미리 구현
        System.out.println("str.concat(\"def\")" + str.concat("def"));

        // 3. 특정 문자열이 해당 문자열에 존재하는지를
        // 확인할 때에는 contains()
        System.out.println("str.contains(\"가나\"):" + str.contains("가나"));
        System.out.println("str.contains(\"1234\"):" + str.contains("1234"));

        // 4. 만약 String이 특정 문자열로 끝나는지
        // 확인할 때에는 endsWith()
        System.out.println("str.endsWith(\"아\"):" + str.endsWith("아"));
        System.out.println("str.endsWith(\"가\"):" + str.endsWith("가"));

        // 5. 해당 String에서 특정 문자 등의
        // 위치가 궁금할 때에는 endsWith()
        // 만약 해당 문자열에 파라미터가 존재하지 않으면
        // -1이 리턴
        System.out.println("str.indexOf(\"다라\"):" + str.indexOf("다라"));
        System.out.println("str.indexOf(\"123\"):" + str.indexOf("123"));

        // 6. 만약 String이 공백으로만 이루어졌는지
        // 확인할 때에는 isBlank()
        // java version 에 따라서 있을수도 있고 없을수도 있다!
        str = "    ";
        //System.out.println("str.isBlank(): " + str.isBlank());
        str = "abc";
        //System.out.println("str.isBlank():" + str.isBlank());

        // 7. 만약 String이 빈 문자열, 즉 아무런 문자도 없는지
        // 확인할 때에는 isEmpty()
        str = new String();
        System.out.println("str.isBlank():" + str.isEmpty());
        str = "    ";
        System.out.println("str.isBlank():" + str.isEmpty());
        str = "abc";
        System.out.println("str.isBlank():" + str.isEmpty());

        // 8. 만약 문자열에서 파라미터가 가장 마지막으로 나온 위치가
        // 알고 싶을 대에는 lastIndexOf()
        str = "www.daum.net/news/sports/12345";
        System.out.println("str.lastIndexOf(\"/\"):" + str.lastIndexOf("/"));
        System.out.println("str.lastIndexOf(\"0\"):" + str.lastIndexOf("0"));

        // 9.해당 문자열의 길이가 알고 싶을 때에는 length()
        str = "123456789";
        System.out.println("str.lengt():" + str.length());

        // 10.해당 문자열이 특정 정규표현식에 따라서
        // 패턴이 맞는지를 체크할 때에는 matches()
        String pattern = "\\d*";// \\d*는 모든 문자가 숫자로 이루어져있는지 확인
        System.out.println("str.matches(pattern):" + str.matches(pattern));
        pattern = "\\w*";// \\w*는 모든 문자가 알파벳과 숫자로 이루어져있는지 확인
        System.out.println("str.matches(pattern):" + str.matches(pattern));
        pattern = "\\d{3}";// \\d{3}은 문자열이 숫자 3자리로 이루어져있는지를 확인
        System.out.println("str.matches(pattern):" + str.matches(pattern));
        pattern = "[가-힣]*";// [가-힣]*은 문자열이 가~힣까지의 글자로 이루어져있는지를 확인함
        System.out.println("str.matches(pattern):" + str.matches(pattern));

        // 11. 해당 문자열이 특정 문자열로 시작하는지
        // 확인할 때에는 startsWith()
        System.out.println("str.startsWith(\"1234\"):" + str.startsWith("1234"));
        System.out.println("str.startsWith(\"abcd\"):" + str.startsWith("abcd"));

        // 12.문자열을 쪼갤때에는 substring()을 사용
        // 파라미터가 int 1개이면 해당 인덱스부터 문자열이 끝날때까지
        System.out.println("str.substring(3):" + str.substring(3));
        // 파라미터가 int 2개이면 앞에 숫자 인덱스~뒤의 숫자 인덱스 전까지
        System.out.println("str.substring(3,6):" + str.substring(3, 6));

        // 13.문자열의 모든 문자를 소문자로 변환할 때에는 toLowerCase()
        str = "abcDEFghi";
        System.out.println("str.toLowerCase(): " + str.toLowerCase());

        // 14.문자열의 모든 글자를 대문자로 변환할 때에는 toUpperCase()
        System.out.println("str.toUpperrCase(): " + str.toUpperCase());
        
        // 15.문자열의 앞뒤 공백을 제거할 때에는 trim()
        str="     1     \n";
        System.out.println("str.trim()전: "+str);
        System.out.println("str.trim()후: "+str.trim());
        System.out.println("-------");
    }
}
