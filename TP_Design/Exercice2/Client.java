// Client : utilise la Factory et l'interface, sans jamais faire "new Program...".
public class Client {

    public static void main1(int type) {
        ProgramInterface p = ProgramFactory.createProgram(type);
        System.out.println("I am main1");
        p.go();
    }

    public static void main2(int type) {
        ProgramInterface p = ProgramFactory.createProgram(type);
        System.out.println("I am main2");
        p.go();
    }

    public static void main3(int type) {
        ProgramInterface p = ProgramFactory.createProgram(type);
        System.out.println("I am main3");
        p.go();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage : java Client <numero du programme (1 a 4)>");
            return;
        }
        int type = Integer.parseInt(args[0]);
        main1(type);
        main2(type);
        main3(type);
    }
}