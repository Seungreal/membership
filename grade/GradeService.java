package grade;

public interface GradeService {
    public void inputGrade(GradeDTO grade);
    public void updateGrade(GradeDTO grade);
    public void deleteGrade(GradeDTO grade);
    public int sum(GradeDTO grade);
    public float avg(int sum);
    public GradeDTO[] gradeSort();
}
