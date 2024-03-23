package com.mycompany.chessgame;

import java.util.LinkedList;
/**
 *
 * @author ACER
 */
public class Piece {
        int xp;
        int yp;
        boolean isWhite;
        LinkedList<Piece> ps;
        String name;
       public Piece(int xp ,int yp ,String n, boolean isWhite , LinkedList<Piece> ps){
           this.xp = xp;
           this.yp = yp;
           this.isWhite = isWhite;
           this.ps = ps;
           name = n;
           ps.add(this);
       } 
       
        public void move(int xp,int yp){
            ps.stream().filter((p) -> (p.xp==xp&&p.yp==yp)).forEachOrdered((p) ->{
                p.kill();
            });
            this.xp=xp;
            this.yp=yp;
        }
        public void kill(){
            ps.remove(this);
        }
}
