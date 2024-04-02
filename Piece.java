package com.mycompany.chessgame;

import java.util.LinkedList;
public class Piece {
        int xp;
        int yp;
        int x;
        int y;
        boolean isWhite;
        LinkedList<Piece> ps;
        String name;
        String type;
       public Piece(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps){
           this.xp = xp;
           this.yp = yp;
           x=xp*64;
           y=yp*64;
           this.isWhite = isWhite;
           this.ps = ps;
           this.type=type;
           name = n;
           ps.add(this);
       } 
        public void move(int xp,int yp){
        if(ChessGame.getPiece(xp*64, yp*64)!=null){
            if(ChessGame.getPiece(xp*64, yp*64).isWhite!=isWhite){
            ChessGame.getPiece(xp*64, yp*64).kill();
           }else{              
                x=this.xp*64;
                y=this.yp*64;
                return;
            }
        }
         Move move = new Move(this.xp, this.yp, xp, yp, this.type);   
        if (this.type != null && this.type.equals("rook")&& move.isValidRookMove()) {
    // Đây là một quân xe (Rook)
     
        // Kiểm tra nếu ô đích có quân cờ đối phương
        Piece destinationPiece = ChessGame.getPiece(xp, yp);
        if (destinationPiece != null) {
            // Xóa quân cờ đối phương
            destinationPiece.kill();
        }
        // Cập nhật vị trí mới cho quân cờ
        this.xp = xp;
        this.yp = yp;
        this.x = xp * 64;
        this.y = yp * 64;
} else if (this.type != null && this.type.equals("pawn")&& move.isValidPawnMove()) {
    if(ChessGame.getPiece(xp, yp)!=null){
        Piece destinationPiece = ChessGame.getPiece(xp,yp);
        destinationPiece.kill();
        }
    this.xp=xp;
    this.yp=yp;
    this.x=xp*64;
    this.y=yp*64;
} else if (this.type != null && this.type.equals("knight")&& move.isValidKnightMove()) {
     if(ChessGame.getPiece(xp, yp)!=null){
        Piece destinationPiece = ChessGame.getPiece(xp,yp);
        destinationPiece.kill();
        }
    this.xp=xp;
    this.yp=yp;
    this.x=xp*64;
    this.y=yp*64;
} else if (this.type != null && this.type.equals("bishop")&& move.isValidBishopMove()) {
     if(ChessGame.getPiece(xp, yp)!=null){
        Piece destinationPiece = ChessGame.getPiece(xp,yp);
        destinationPiece.kill();
        }
    this.xp=xp;
    this.yp=yp;
    this.x=xp*64;
    this.y=yp*64;
} else if (this.type != null && this.type.equals("queen")&& move.isValidQueenMove()) {
      if(ChessGame.getPiece(xp, yp)!=null){
        Piece destinationPiece = ChessGame.getPiece(xp,yp);
        destinationPiece.kill();
        }
    this.xp=xp;
    this.yp=yp;
    this.x=xp*64;
    this.y=yp*64;
} else if (this.type != null && this.type.equals("king")&& move.isValidKingMove()) {
     if(ChessGame.getPiece(xp, yp)!=null){
        Piece destinationPiece = ChessGame.getPiece(xp,yp);
        destinationPiece.kill();
        }
    this.xp=xp;
    this.yp=yp;
    this.x=xp*64;
    this.y=yp*64;
} else {
    System.out.println("Nước đi không hợp lệ cho quân cờ loại: " + this.type);
}
            this.xp=xp;
            this.yp=yp;
            x=xp*64;
            y=yp*64;
            
            
        }
        public void kill(){
            ps.remove(this);
            if(name.equalsIgnoreCase("king")){
                ChessGame.checkGameOver();
            }
        }

    
}
