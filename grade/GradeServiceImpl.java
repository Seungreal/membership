package grade;

public class GradeServiceImpl implements GradeService{
    GradeDTO[] users;
    
    public GradeServiceImpl() {
        users=new GradeDTO[3];
        users[0]= new GradeDTO();
        users[0].setName("a");
        users[0].setKor(70);
        users[0].setEng(70);
        users[0].setMath(70);
        users[0].setSum(210);
        users[0].setAvg(70);
        users[1]= new GradeDTO();
        users[1].setName("b");
        users[1].setKor(50);
        users[1].setEng(50);
        users[1].setMath(50);
        users[1].setSum(150);
        users[1].setAvg(50);
        users[2]= new GradeDTO();
        users[2].setName("c");
        users[2].setKor(90);
        users[2].setEng(80);
        users[2].setMath(70);
        users[2].setSum(240);
        users[2].setAvg(80);
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
