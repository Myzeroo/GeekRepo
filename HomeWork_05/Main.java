package HomeWork_05;

class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];

        empArray[0] = new Employee(
                "Иван",
                "Иванов",
                "Иванович",
                "Слесарь",
                "VaniaSlesar@mail.ru",
                "8(901)123-45-67",
                17_000.00,
                45);

        empArray[1] = new Employee(
                "Сидор",
                "Сидоров",
                "Сидорович",
                "Инженер",
                "SSSidor@mail.ru",
                "8(901)123-45-68",
                23_000.00,
                43);

        empArray[2] = new Employee(
                "Петр",
                "Петров",
                "Петрович",
                "Механик",
                "PetyaMech@mail.ru",
                "8(901)123-45-69",
                19_000.00,
                39);

        empArray[3] = new Employee(
                "Тихон",
                "Тихонов",
                "Тихонович",
                "Оценщик",
                "Tihiy@mail.ru",
                "8(901)123-46-67",
                17_000.00,
                25);

        empArray[4] = new Employee(
                "Азиз",
                "Азизов",
                "Азизович",
                "Менджер",
                "mylifemyrule@mail.ru",
                "8(901)111-45-67",
                210_000.00,
                40);

        for (Employee emp: empArray) {
            if(emp.age>40){
                emp.getInfo();
            }
        }
    }
}
