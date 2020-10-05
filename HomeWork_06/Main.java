package HomeWork_06;

class Main {
    public static void main(String[] args) {
        // Ссылка общего типа испольщуется просто для привыкания, что так иногда будет
        Animal Bobik = new Dog();
        Animal Sharik = new Dog();
        Animal Kirpich = new Cat();

        Bobik.run(500);
        Sharik.run(500);
        Kirpich.jumpOver(2D);
        Kirpich.swim(500);
    }
}
