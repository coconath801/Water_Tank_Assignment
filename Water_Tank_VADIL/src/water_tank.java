import javax.swing.*;

abstract class WaterTank {
    protected int capacity;
    protected int currentLevel;

    public WaterTank(int capacity) {
        this.capacity = capacity;
        this.currentLevel = 0; // start empty
    }

    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract void checkStatus();
}

// ================== HomeTank ==================
class HomeTank extends WaterTank {
    public HomeTank() {
        super(220); // capacity 220 liters
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            currentLevel = capacity;
            JOptionPane.showMessageDialog(null, "Tank overflow prevented. Tank filled to maximum capacity!");
        } else {
            currentLevel += liters;
            JOptionPane.showMessageDialog(null, liters + " liters added. Current level: " + currentLevel + "/" + capacity);
        }
        checkStatus();
    }

    @Override
    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            JOptionPane.showMessageDialog(null, "Not enough water! Tank is already empty.");
            currentLevel = 0;
        } else {
            currentLevel -= liters;
            JOptionPane.showMessageDialog(null, liters + " liters used. Current level: " + currentLevel + "/" + capacity);
        }
        checkStatus();
    }

    @Override
    public void checkStatus() {
        if (currentLevel == 0) {
            JOptionPane.showMessageDialog(null, "Tank is Empty! Program ended.");
            System.exit(0);
        } else if (currentLevel == capacity) {
            JOptionPane.showMessageDialog(null, "Tank is Full! Program ended.");
            System.exit(0); // ✅ added exit for full tank
        } else {
            JOptionPane.showMessageDialog(null, "Tank is In Use.");
        }
    }
}

// ================== BuildingTank ==================
class BuildingTank extends WaterTank {
    public BuildingTank() {
        super(1000); // capacity 1000 liters
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            currentLevel = capacity;
            JOptionPane.showMessageDialog(null, "Tank overflow prevented. Tank filled to maximum capacity!");
        } else {
            currentLevel += liters;
            JOptionPane.showMessageDialog(null, liters + " liters added. Current level: " + currentLevel + "/" + capacity);
        }
        checkStatus();
    }

    @Override
    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            JOptionPane.showMessageDialog(null, "Not enough water! Tank is already empty.");
            currentLevel = 0;
        } else {
            currentLevel -= liters;
            JOptionPane.showMessageDialog(null, liters + " liters used. Current level: " + currentLevel + "/" + capacity);
        }
        checkStatus();
    }

    @Override
    public void checkStatus() {
        if (currentLevel == 0) {
            JOptionPane.showMessageDialog(null, "Tank is Empty! Program ended.");
            System.exit(0);
        } else if (currentLevel == capacity) {
            JOptionPane.showMessageDialog(null, "Tank is Full! Program ended.");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Tank is In Use.");
        }
    }
}

// ================== Main Program ==================
public class water_tank {
    public static void main(String[] args) {
        WaterTank tank = null;

        // Choose tank type
        String choice = JOptionPane.showInputDialog("Enter type of tank: (1) HomeTank (2) BuildingTank");
        if (choice.equals("1")) {
            tank = new HomeTank();
        } else if (choice.equals("2")) {
            tank = new BuildingTank();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Choice! Exiting...");
            System.exit(0);
        }

        // Menu loop
        while (true) {
            String action = JOptionPane.showInputDialog("Choose action: (1) Fill Tank (2) Use Water (3) Exit");

            if (action.equals("1")) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill:"));
                tank.fillTank(liters);
            } else if (action.equals("2")) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use:"));
                tank.useWater(liters); // ✅ now works
            } else if (action.equals("3")) {
                JOptionPane.showMessageDialog(null, "Program ended by user.");
                System.exit(0); // ✅ exit option added
            } else {
                JOptionPane.showMessageDialog(null, "Invalid action!");
            }
        }
    }
}
