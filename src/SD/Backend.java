package SD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Backend {
    public ArrayList<Passenger> upperBerth = new ArrayList<>();
    public ArrayList<Passenger> middleBerth = new ArrayList<>();
    public ArrayList<Passenger> lowerBerth = new ArrayList<>();
    public Queue<Passenger> rac = new LinkedList<>();
    public Queue<Passenger> wl = new LinkedList<>();
    public HashMap<String, Integer> passengerId = new HashMap<>();

    public int getPassengerId(String name) {
        return passengerId.getOrDefault(name, -1);
    }

public void bookTickets(Passenger p) {
    passengerId.put(p.getName(), p.getId());

    if (upperBerth.size() < 21) {
        upperBerth.add(p);
        System.out.println(p.getId() + " U");
    } else if (middleBerth.size() < 21) {
        middleBerth.add(p);
        System.out.println(p.getId() + " M");
    } else if (lowerBerth.size() < 21) {
        lowerBerth.add(p);
        System.out.println(p.getId() + " L");
    } else if (rac.size() < 18) {
        rac.offer(p);
        System.out.println(p.getId() + " RAC");
    } else if (wl.size() < 10) {
        wl.offer(p);
        System.out.println(p.getId() + " WL");
    } else {
        System.out.println("All tickets full!");
    }
}


    public void cancelTickets(Passenger p, int id) {
        if (!(upperBerth.isEmpty() && middleBerth.isEmpty() && lowerBerth.isEmpty())) {
            if (upperBerth.contains(p) && p.getId() == id) {
                upperBerth.remove(p);
                upperBerth.add(rac.poll());
                rac.offer(wl.poll());
            }
            else if (middleBerth.contains(p) && p.getId() == id) {
                middleBerth.remove(p);
                middleBerth.add(rac.poll());
                rac.offer(wl.poll());
            }
            else if (lowerBerth.contains(p) && p.getId() == id) {
                lowerBerth.remove(p);
                lowerBerth.add(rac.poll());
                rac.offer(wl.poll());
            }
            else {
                System.out.println("Ticket not found!");
            }
        }
        else if (rac.contains(p) && p.getId() == id) {
            rac.remove(p);
            rac.offer(wl.poll());
        }
        else if (wl.contains(p) && p.getId() == id) {
            wl.remove(p);
        }
        else {
            System.out.println("Ticket not found!");
        }
    }

    public void printAvailableTickets() {
    System.out.println("Upper berth: " + (21 - upperBerth.size()) +
            "\nMiddle berth: " + (21 - middleBerth.size()) +
            "\nLower berth: " + (21 - lowerBerth.size()) +
            "\nRac: " + (18 - rac.size()) +
            "\nWL: " + (10 - wl.size()) + "\n");
}

    public void printBookedTickets(int id) {
    if (upperBerth.stream().anyMatch(p -> p.getId() == id)) {
        System.out.println(id + " U ");
    } else if (middleBerth.stream().anyMatch(p -> p.getId() == id)) {
        System.out.println(id + " M ");
    } else if (lowerBerth.stream().anyMatch(p -> p.getId() == id)) {
        System.out.println(id + " L ");
    } else if (rac.stream().anyMatch(p -> p.getId() == id)) {
        System.out.println(id + " RAC ");
    } else if (wl.stream().anyMatch(p -> p.getId() == id)) {
        System.out.println(id + " WL ");
    } else {
        System.out.println("Ticket not found!");
    }
}
}
