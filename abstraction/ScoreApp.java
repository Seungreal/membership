package abstraction;

import java.util.Scanner;

public class ScoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScoreController controller = new ScoreController();
        ScoreDTO score = null;
        while(true) {
            System.out.print("1.성적입력 2.성적수정 3.성적삭제 4.석차출력 0.종료\n>");
            switch (scanner.next()) {
            case "1":
                score = new ScoreDTO();
                System.out.print("이름:");
                score.setName(scanner.next());
                System.out.print("국어:");
                score.setKor(scanner.nextInt());
                System.out.print("영어:");
                score.setEng(scanner.nextInt());
                System.out.print("수학:");
                score.setMath(scanner.nextInt());
                controller.postScore(score);
                break;
            case "2":
                score = new ScoreDTO();
                System.out.print("이름:");
                score.setName(scanner.next());
                System.out.print("국어:");
                score.setKor(scanner.nextInt());
                System.out.print("영어:");
                score.setEng(scanner.nextInt());
                System.out.print("수학:");
                score.setMath(scanner.nextInt());
                controller.putScore(score);
                break;
            case "3":
                score = new ScoreDTO();
                System.out.print("이름:");
                score.setName(scanner.next());
                controller.deleteScore(score);
                break;
            case "4":
                ScoreDTO[] list = controller.getSortScore();
                for(int i=0;i<list.length;i++) {
                    System.out.println(list[i]);
                }
                break;
            case "0":
                System.out.println("종료합니다.");
                scanner.close();
                return;
            }
        }
    }
}
class ScoreDTO {
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
        return "성적 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum
                + ", avg=" + avg + "]";
    }
}
interface ScoreService{
    public void addScore(ScoreDTO score);
    public void updateScore(ScoreDTO score);
    public void deleteScore(ScoreDTO score);
    public int sum(ScoreDTO score);
    public float avg(ScoreDTO score);
    public ScoreDTO[] sortScore();
}
class ScoreServiceImpl implements ScoreService{
    ScoreDTO[] scores;
    public ScoreServiceImpl() {
        scores = new ScoreDTO[0];
    }
    @Override
    public void addScore(ScoreDTO score) {
        score.setSum(sum(score));
        score.setAvg(avg(score));
        int size = scores.length;
        ScoreDTO[] temp = new ScoreDTO[size+1];
        for(int i=0;i<size;i++)
            temp[i]=scores[i];
        temp[size]=score;
        scores = temp;
    }
    @Override
    public void updateScore(ScoreDTO score) {
        for(int i=0;i<scores.length;i++) {
            if(score.getName().equals(scores[i].getName())) {
                scores[i].setKor(score.getKor());
                scores[i].setEng(score.getEng());
                scores[i].setMath(score.getMath());
                scores[i].setSum(sum(score));
                scores[i].setAvg(avg(score));
                break;
            }
        }
    }
    @Override
    public void deleteScore(ScoreDTO score) {
        int size = scores.length;
        for(int i=0;i<size;i++) {
            if(score.getName().equals(scores[i].getName())) {
                ScoreDTO[] temp = new ScoreDTO[size-1];
                for(int j=0;j<i;j++) {
                    temp[j]=scores[j];
                }
                for(int j=i;j<size-1;j++) {
                    temp[j]=scores[j+1];
                }
                scores=temp;
                break;
            }
        }
    }
    @Override
    public int sum(ScoreDTO score) {
        return score.getKor()+score.getEng()+score.getMath();
    }
    @Override
    public float avg(ScoreDTO score) {
        return sum(score)/3.0f;
    }
    @Override
    public ScoreDTO[] sortScore() {
        int size = scores.length;
        for(int i=0;i<size-1;i++) {
            int max = i;
            for(int j=i;j<size;j++) {
                if(scores[i].getSum()<scores[j].getSum()) {
                    max=j;
                }
            }
            ScoreDTO temp = scores[i];
            scores[i]=scores[max];
            scores[max]=temp;
        }
        return scores;
    }
}
class ScoreController{
    ScoreService service = new ScoreServiceImpl();
    public void postScore(ScoreDTO score) {
        service.addScore(score);
    }
    public void putScore(ScoreDTO score) {
        service.updateScore(score);
    }
    public void deleteScore(ScoreDTO score) {
        service.deleteScore(score);
    }
    public int getSum(ScoreDTO score) {
        return service.sum(score);
    }
    public float getAvg(ScoreDTO score) {
        return service.avg(score);
    }
    public ScoreDTO[] getSortScore() {
        return service.sortScore();
    }
}    
