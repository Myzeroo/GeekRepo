package HomeWork_05;

class Employee {
    String name;
    String surname;
    String patronymic;
    String position;
    String email;
    String telephone;
    double salary;
    int age;

    public Employee(String name, String surname, String patronymic, String position, String email, String telephone, double salary, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    void getInfo(){
        String str = "ФИО: " + surname + " " + name + " " + patronymic + ", дожность " + position + "\nemail:" + email
                + ", тел.:" + telephone + ", зарплата: " + salary + ", возраст: " + age + "\n";
        System.out.println(str);
    }
}
