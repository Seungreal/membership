package grade;

public class GradeController {
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
