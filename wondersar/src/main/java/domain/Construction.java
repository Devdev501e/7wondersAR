package domain;

import java.util.ArrayList;




    public class Construction {
        private final ArrayList<ConstructionPiece> allPieces = new ArrayList(5);

        public Construction(Wonder wonder) {
            createList(wonder);
        }

        private void createList(Wonder wonder) {
            for (int i = 0; i < 5; i++) {
                boolean power = false;
                int points = 0;

                boolean equal = i%2 == 0;
                int nbPieces = 1;
                nbPieces = (equal) ? ++nbPieces : nbPieces;

                if (i>0) {
                    power = i%2 == 1;
                }

                switch (wonder) {
                    case Gizeh:
                        points = 4+i;
                        power = false;
                        break;
                    case Ephese:
                        if (i == 0) {
                            points = 3;
                        }
                        else if (i == 4) {
                            points = 7;
                        }
                        else {
                            points += 2;
                        }
                        if (i == 2) {
                            power = true;
                        }
                        break;
                    case Rhodes:
                        points = (i<2)? 4 : points+1;
                        break;
                    case Olympie:
                        points = (i%2 == 0)? 3+i : points;
                        if (i == 1) {
                            points -= 1;
                        }
                        break;
                    case Babylone:
                        points = (i%2 == 0)? 3+i : points;
                        if (i == 1) {
                            points = 0;
                        }
                        break;
                    case Alexandrie:
                        points = (i%2 == 0)? points-=1 : Math.min(7, i+4);
                        break;
                    case Halicarnasse:
                        if ( i < 2) {
                            points = 3;
                        }
                        else if (i == 2) {
                            points = 6;
                        }
                        else {
                            points += 2;
                        }
                        break;
                }

                allPieces.add(new ConstructionPiece(points, !equal, nbPieces,power , false));

            }
        }

        public ArrayList<ConstructionPiece> getAllPieces() {
            return allPieces;
        }
    }


