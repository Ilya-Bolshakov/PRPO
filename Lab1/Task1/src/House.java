import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class House {
    private ArrayList<Door> doors;
    private ArrayList<Window> windows;

    public House(int countDoors, int countWindows) {
        doors = new ArrayList<Door>(countDoors);
        for (int i = 0; i < countDoors; i++) {
            doors.add(new Door(false));
        }
        windows = new ArrayList<Window>(countWindows);
        for (int i = 0; i < countWindows; i++) {
            windows.add(new Window(false));
        }
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public ArrayList<Window> getWindows() {
        return windows;
    }

    public int windowCount() {
        return this.getWindows().size();
    }
    public int doorCount() {
        return doors.size();
    }

    public void addDoor(Door door) {
        doors.add(door);
    }

    public void addWindow(Window window) {
        windows.add(window);
    }

    public List<HouseObject> SortObjects() {
        ArrayList<HouseObject> houseObjects = new ArrayList<>(doors);
        houseObjects.addAll(windows);
        return houseObjects.stream().sorted(HouseObject::compareTo).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return doors.equals(house.doors) && windows.equals(house.windows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doors, windows);
    }

    @Override
    public String toString() {
        return "House{" +
                "doors=" + doors +
                ", windows=" + windows +
                '}';
    }
}
