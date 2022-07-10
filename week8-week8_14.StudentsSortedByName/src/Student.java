public class Student implements Comparable<Student>{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student student)
    {
        if(this.getName() == student.getName())
        {
            return 0;
        }
        else if(this.getName().compareToIgnoreCase(student.getName()) > 1)
        {
            return 1;
        }
        else
            return -1;
        /*
        OR: return this.getName().compareToIgnoreCase(student.getName());
        */
    }
}