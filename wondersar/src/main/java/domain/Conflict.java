package domain;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Conflict {
    ArrayList<Boolean> allConflicts = new ArrayList<>();

    public Conflict(int nbPlayers) {
        int nbConflicts = min(nbPlayers, 6);
        nbConflicts = max(nbConflicts, 3);

        for (int i = 0; i < nbConflicts; i++) {
            allConflicts.add(true);
        }
    }

    public ArrayList<Boolean> getAllConflicts() {
        return allConflicts;
    }

    public void setAllConflicts(ArrayList<Boolean> allConflicts) {
        this.allConflicts = allConflicts;
    }
}
