import java.time.LocalDate;

public class Worker {
    private String name;
    private int age;
    private String dept;
    private LocalDate dob;
    private double sal;

    public Worker(String name, int age, String dept, LocalDate dob, double sal) {
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.dob = dob;
        this.sal = sal;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDate(LocalDate dob) {
        this.dob = dob;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", dob=" + dob +
                ", sal =" + sal +
                '}';
    }
}
