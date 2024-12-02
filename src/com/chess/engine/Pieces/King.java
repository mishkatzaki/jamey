package com.chess.engine.Pieces;
b
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATE = {-9, -8, -7, -1, 1, 7, 8, 9};
//    represent the diagonal moves from its position
//    •	Diagonal moves: -9, -7, 7, 9.
//	•	Horizontal moves: -1, 1.
//	•	Vertical moves: -8, 8.

    King(int piecePostion, Alliancee pieceAlliance) {
        super(piecePostion, pieceAlliance);
    }
//    override

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCadidateOffset : CANDIDATE_MOVE_COORDINATE) {
            final int candidateDestinationCoordinate = this.piecePostion + currentCadidateOffset;

            if (isFirstColumnExclusion(this.piecePostion,currentCadidateOffset ||
                    isEighthColumnExclusion(this.piecePostion,currentCadidateOffset))) {
                continue;
            }


            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
//                ensures the destination coordinate lies within the valid board range (0–63 for a chessboard).

                if (!candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));

                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                    if (this.pieceAlliance != pieceAlliance) {
                        legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
//                    	If it’s an opponent’s piece, creates an AttackMove object to represent a capture.

                }


            }


        }


        return ImmutableList.copyOf(legalMoves);
//        ensuring that it cannot be modified after calculation.
    }

    private static boolean isFirstColumnExclusion (final int currentPosition , final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset==-9|| candidateOffset==-1 ||
                candidateOffset==7 );
//        	•	-9: Top-left diagonal.
//	•	-1: Horizontal left move.
//	•	7: Bottom-left diagonal.
    }
    private static boolean isEighthColumnExclusion (final int currentPosition , final int candidateOffset){
        return BoardUtils.EIGHTH_COLUMN[currentPosition]&& (candidateOffset==1|| candidateOffset ==9|| candidateOffset==-7);



}
