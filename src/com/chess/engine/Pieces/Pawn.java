package com.chess.engine.Pieces;

import java.util.ArrayList;

public class Pawn  {

    private final static int[] CANDIDATE_MOVE_COORDINATE = {8,16,9,7};
    private int piecePosition;
// count 8 squares to get the opposite move

    Pawn (final int piecePosition, final Alliancee pieceAlliance){
        super();

    }
//    from previous code

    public Collection<Move> calculateLegalMoves(final Board board) {
//        the move has a class in the previous code
        final List<Move> legalMoves = new ArrayList();

        for (final int currentCadidateOffset : CANDIDATE_MOVE_COORDINATE) {

           final int candidateDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getPieceAlliance().getDirection() * currentCadidateOffset);
//             would apply 8 for black and -8 for white

//            override from previous code
//            the formula above calculate the movement of the black pawn(cause they move in the positive direction)
//            to solve this we must declare a methode in the alliance class returns directionary

if (!BoardUtilis.isValidTileCoordinate(candidateDestinationCoordinate)){
    continue;
        }
if(currentCadidateOffset==8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()){
//   need to Do PROMOTION
    legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
            }
//non attacking move

else if (currentCadidateOffset==16 && this.isFirstMove() &&
        (BoardUtils.SECOND_ROW[this.piecePosition]&& this.getPieceAlliance().isBlack()) ||
        (BoardUtils.SEVENTH_ROW[this.piecePosition]&& this.getPieceAlliance().isWhite()))
//the conditions above represent the positions of the black and white
{
    final int behindCandidateDestinationCoordinate =  this.piecePosition + (this.pieceAlliance.getDirection() *8);



    if(!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied()&&
    !board.getTile(candidateDestinationCoordinate).isTileOccupied()){
        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
    }
            }

//     the pawn jump
            else if (currentCadidateOffset==7 &&
                     !((BoardUtils.EIGHTH_COLUMN[this,piecePosition]&&this.pieceAlliance.isWhite( ) ||
                    (BoardUtils.FIRST_COLUMN[this.piecePosition]&& this.pieceAalliance.isBlack()))))
            {
                if(board.getTile(candidateDestinationCoordinate).isTileOccupied()){
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.piecAlliance != pieceOnCandidate.getPieceAlliance()){
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                    }
            }

    }
            else if (currentCadidateOffset==9 &&
                    !((BoardUtils.FIRST_COLUMN[this,piecePosition]&&this.pieceAlliance.isWhite() ||
                    (BoardUtils.EIGHTH_COLUMN[this.piecePosition]&& this.pieceAalliance.isBlack()))))
            {
                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.piecAlliance != pieceOnCandidate.getPieceAlliance()) {
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));

                    }
                }
            }
//kill in diagonal
//            promotion is miising
//            NEED EXPLAINATION!!!!!!!!
        return ImmutableList.copyOf(legalMoves);

    }





}

