import java.util.*;

public class MusicalPillarSimulator {
    public static void main(String[] args) {
        // Step 1: Pillar to note mapping
        HashMap<String, String> pillars = new HashMap<>();
        pillars.put("P1", "Sa");
        pillars.put("P2", "Re");
        pillars.put("P3", "Ga");
        pillars.put("P4", "Ma");
        pillars.put("P5", "Pa");
        pillars.put("P6", "Da");
        pillars.put("P7", "Ni");

        // Step 2: Define ragas
        HashMap<String, List<String>> ragas = new HashMap<>();
        ragas.put("Mohanam", Arrays.asList("Sa", "Re", "Ga", "Pa", "Da"));
        ragas.put("Kalyani", Arrays.asList("Sa", "Re", "Ga", "Ma", "Pa", "Da", "Ni"));

        // Step 3: Input sequence
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pillar sequence (e.g., P1 P3 P5):");
        String[] sequence = sc.nextLine().split(" ");

        List<String> notesPlayed = new ArrayList<>();
        for (String pillar : sequence) {
            notesPlayed.add(pillars.getOrDefault(pillar, "?"));
        }

        System.out.println("Notes played: " + notesPlayed);

        // Step 4: Detect raga
        boolean found = false;
        for (Map.Entry<String, List<String>> entry : ragas.entrySet()) {
            if (notesPlayed.equals(entry.getValue())) {
                System.out.println("You played Raga: " + entry.getKey());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No raga detected.");
        }
    }
}
