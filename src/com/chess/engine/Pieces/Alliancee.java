package com.chess.engine.Pieces;

public enum Alliancee {
    WHITE {
        //   override
      public  int getDirection(){
            return -1;
        }

        @Override
        public boolean isWhite() {
            return true;
        }

        @Override
        public boolean isBlack() {
            return false;
        }

    },
    BLACK {
       public int getDirection() {
            return 1;

        }

        @Override
        public boolean isWhite() {
            return false;
        }

        @Override
        public boolean isBlack() {
            return true;
        }
    };


    //    here above we must make an implement




    public abstract int getDirection();

    public abstract boolean isWhite();
    public abstract boolean isBlack();
}
