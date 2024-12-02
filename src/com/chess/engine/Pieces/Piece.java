package com.chess.engine.Pieces;

public class Piece {
    protected final int piecePostion;
    protected final Alliancee pieceAlliance;
    protected final boolean isFirstMove;
//    cause the pawn in the first move has an option to go 8 or 16


    Piece(final int piecePostion, final Alliancee pieceAlliance){
        this.pieceAlliance=pieceAlliance;
        this.piecePostion=piecePostion;
        this.isFirstMove=false;

    }


    public   Alliancee getPieceAlliance(){
        return this.pieceAlliance;
    }

    public boolean isFirstMove(){
        return this.isFirstMove;
    }




    public abstract Collection<Move> calculateLegalMoves(final Board board);

}
