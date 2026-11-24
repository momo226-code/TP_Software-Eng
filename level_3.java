import java.util.ArrayList;
import java.util.List;


interface BattleUnit {
    void attack();
    int getPower();
    void printReport(String indent); 
}


class ModernRobot implements BattleUnit {
    private final String name;
    private final int power;
    private final String attackMessage;

    public ModernRobot(String name, int power) {
        this(name, power, "deploys plasma blades!");
    }

    public ModernRobot(String name, int power, String attackMessage) {
        if (power <= 0) {
            throw new IllegalArgumentException("La puissance doit être positive.");
        }
        this.name = name;
        this.power = power;
        this.attackMessage = attackMessage;
    }

    @Override
    public void attack() {
        System.out.println("[MODERN] " + name + " " + attackMessage);
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void printReport(String indent) {
        System.out.println(indent + "- " + name + " (ModernRobot) : " + power + " PWR");
    }
}


class OldRobot {
    private final String model;
    private final int laserPower;

    public OldRobot(String model, int laserPower) {
        this.model = model;
        this.laserPower = laserPower;
    }

    public void fireLaser() {
        System.out.println(model + " fires a laser!");
    }

    public int getLaserPower() {
        return laserPower;
    }
}

class OldRobotAdapter implements BattleUnit {
    private final OldRobot oldRobot;

    public OldRobotAdapter(OldRobot oldRobot) {
        this.oldRobot = oldRobot;
    }

    @Override
    public void attack() {
        System.out.print("[LEGACY] ");
        oldRobot.fireLaser();
    }

    @Override
    public int getPower() {
        return oldRobot.getLaserPower();
    }

    @Override
    public void printReport(String indent) {
        System.out.println(indent + "- Legacy Unit (OldRobotAdapter) : " + getPower() + " PWR");
    }
}


class RobotSquad implements BattleUnit {
    private final String name;
    private final List<BattleUnit> children = new ArrayList<>();
    private final int maxPowerBudget; // Optionnel : -1 si illimité

    public RobotSquad(String name) {
        this(name, -1);
    }

    public RobotSquad(String name, int maxPowerBudget) {
        this.name = name;
        this.maxPowerBudget = maxPowerBudget;
    }

    public boolean add(BattleUnit unit) {
        if (unit == null || unit == this) {
            return false;
        }
        // Upgrade Part E (Power budget) : vérifie la limite si définie
        if (maxPowerBudget > 0 && (getPower() + unit.getPower() > maxPowerBudget)) {
            System.out.println("[ALERTE BUDGET] Impossible d'ajouter l'unité à " + name
                    + " (dépasse la limite de " + maxPowerBudget + " PWR).");
            return false;
        }
        children.add(unit);
        return true;
    }

    public void remove(BattleUnit unit) {
        children.remove(unit);
    }

    @Override
    public void attack() {
        System.out.println(">> Escouade [" + name + "] passe à l'attaque :");
        for (BattleUnit child : children) {
            child.attack();
        }
    }

    @Override
    public int getPower() {
        int totalPower = 0;
        for (BattleUnit child : children) {
            totalPower += child.getPower();
        }
        return totalPower;
    }

    @Override
    public void printReport(String indent) {
        System.out.println(indent + "+ [" + name + "] (Total : " + getPower() + " PWR)");
        for (BattleUnit child : children) {
            child.printReport(indent + "  ");
        }
    }
}


    public static void main(String[] args) {
        
}
