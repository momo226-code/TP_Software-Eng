import java.util.ArrayList;
import java.util.List;

public interface Mission {
    void display(String indent);
    int getDuration(); // minutes
}

class SingleMission implements Mission {
    private final String name;
    private final int duration;

    public SingleMission(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + name + " (" + duration + " min)");
    }

    @Override
    public int getDuration() {
        return duration;
    }
}

class MissionCollection implements Mission {
    private final String name;
    private final List<Mission> children = new ArrayList<>();

    public MissionCollection(String name) {
        this.name = name;
    }

    public void add(Mission mission) {
        children.add(mission);
    }

    public void remove(Mission mission) {
        children.remove(mission);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ " + name + " (" + getDuration() + " min total)");
        for (Mission child : children) {
            child.display(indent + "  ");
        }
    }

    @Override
    public int getDuration() {
        int total = 0;
        for (Mission child : children) {
            total += child.getDuration();
        }
        return total;
    }
}

public class Level_2 {
    public static void main(String[] args) {
        Mission checkFuel = new SingleMission("Check fuel", 5);
        Mission loadRobots = new SingleMission("Load robots", 10);

        MissionCollection preparation = new MissionCollection("Preparation");
        preparation.add(checkFuel);
        preparation.add(loadRobots);

        Mission deploy = new SingleMission("Deploy", 8);

        MissionCollection launchOperation = new MissionCollection("Launch Operation");
        launchOperation.add(preparation);
        launchOperation.add(deploy);

        launchOperation.display("");
        System.out.println("Total root duration: " + launchOperation.getDuration() + " minutes");
    }
}