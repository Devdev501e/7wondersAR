package domain;

import java.util.ArrayList;




    public class Construction {
        private final ArrayList<ConstructionPiece> allPieces = new ArrayList(5);
        private final int[] alexandriePoints = {4,3,6,5,7};
        private final int[] babylonPoints = {3,0,5,7,5};
        private final int[] rhodesPoints = {4,4,5,6,7};
        private final int[] halicarnassePoints = {3,3,6,5,7};
        private final int[] ephesePoints = {3,3,4,5,7};
        private final int[] gizehPoints = {4,5,6,7,8};
        private final int[] olympiePoints = {3,2,5,5,7};

        public Construction(Wonder wonder) {
            createList(wonder);
        }

        private void createList(Wonder wonder) {
            for (int i = 0; i < 5; i++) {
                int points = 0;

                boolean equal = i%2 == 0;
                int nbPieces = 1;
                switch (i){
                    case 0:
                    case 1:
                        nbPieces=2;
                        break;
                    case 2:
                    case 3:
                        nbPieces=3;
                        break;
                    case 4:
                        nbPieces=4;
                        break;
                }

                switch (wonder) {
                    case Gizeh:
                        points = gizehPoints[i];
                        break;
                    case Ephese:
                        points = ephesePoints[i];
                        break;
                    case Rhodes:
                        points = rhodesPoints[i];
                        break;
                    case Olympie:
                        points = olympiePoints[i];
                        break;
                    case Babylone:
                        points = babylonPoints[i];
                        break;
                    case Alexandrie:
                        points = alexandriePoints[i];
                        break;
                    case Halicarnasse:
                        points = halicarnassePoints[i];
                        break;
                }

                allPieces.add(new ConstructionPiece(points, !equal, nbPieces, false));

            }
        }

        public ArrayList<ConstructionPiece> getAllPieces() {
            return allPieces;
        }
    }


