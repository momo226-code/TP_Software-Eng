// Factory : le seul endroit où l'on crée des objets Program.
public class ProgramFactory {

    public static ProgramInterface createProgram(int type) {
        switch (type) {
            case 1: return new Program1();
            case 2: return new Program2();
            case 3: return new Program3();
            default: throw new IllegalArgumentException("Programme inconnu : " + type);
        }
    }
}