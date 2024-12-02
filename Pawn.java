public class Pawn  {

private final static int[] CANDIDATE_MOVE_COORDINATE = {8};
// count 8 squares to get the opposite move

    Pawn (int piecePosition, Alliance pieceAlliance){
        super(piecePosition,pieceAlliance);

    }
//    from previous code

    public Collection<Move> calculateLegalMoves(Board board){
        final List<Move> legalMoves = new ArrayList();
        for(final int currentCadidateOffset : CANDIDATE_MOVE_COORDINATE) {

            int candidateDestinationCoordinate = this.piecePosition + currentCadidateOffset;

//            override from previous code
//            the formula above calculate the movement of the black pawn(cause they move in the positive direction)
//            to solve this we must declare a methode in the alliance class returns directionary



        }





    }





}

