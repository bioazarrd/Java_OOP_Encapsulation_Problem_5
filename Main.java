package D_JavaAdvancedOOP.Lecture3_Encapsulation.ExProblem5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();
        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];

            try {
                if (command.equals("Team")) {
                    teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                } else if (command.equals("Add")) {
                    if (teams.containsKey(tokens[1])) {
                        Player player = new Player(tokens[2],
                                Integer.parseInt(tokens[3]),
                                Integer.parseInt(tokens[4]),
                                Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]),
                                Integer.parseInt(tokens[7])
                        );
                        teams.get(tokens[1]).addPlayer(player);
                    } else {
                        System.out.println(String.format("Team " + tokens[1] + " does not exist."));
                    }
                } else if (command.equals("Remove")) {
                    if (teams.get(tokens[1]).hasPLayer(tokens[2])) {
                        teams.get(tokens[1]).removePlayer(tokens[2]);
                    } else {
                        System.out.println("Player "
                                + tokens[2]
                                + " is not in "
                                + tokens[1]+ " team.");
                    }
                } else if (command.equals("Rating")) {
                    if (teams.containsKey(tokens[1])) {
                        int rating = (int) Math.round(teams.get(tokens[1]).getRating());
                        System.out.println(String.format(tokens[1] + " - " + rating));
                    } else {
                        System.out.println(String.format("Team " + tokens[1] + " does not exist."));
                    }

                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }



            input = reader.readLine();
        }

    }
}