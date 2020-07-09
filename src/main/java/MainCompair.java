import java.util.Comparator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainCompair {
    public static void main(String[] args) {
//        TreeSet<String> ts = new TreeSet<>();
//        ts.add("Vaska");
//        ts.add("Jorick");
//        ts.add("Petr");
//        ts.add("Sofia");

        TreeSet<Employee> ts = new TreeSet<>(new MyComp());
        ts.add(new Employee(20));
        ts.add(new Employee(120));
        ts.add(new Employee(200));
        ts.add(new Employee(10));

        System.out.println(ts);
    }

    private static boolean checkPassword(String s) {
        Pattern p = Pattern.compile("^(?=.{8,20})(?=.*[a-z])");
        Matcher m = p.matcher(s);
        return m.matches();
    }
}

class MyComp implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}

class Employee {
    private int salary;

    public Employee(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.valueOf(salary);
    }
}