/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chessgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author ACER
 */
public class ChessGame {
 public static LinkedList<Piece> ps = new LinkedList<>();
 public static Piece selectedPiece=null;
 public static boolean isWhiteTurn; 
 public static ArrayList<Move> movesHistory = new ArrayList<>();
 public static void main(String[] args) throws IOException {         
     JOptionPane.showMessageDialog(null,"Chào mừng đến với trò chơi ");
     Random random = new Random();
     isWhiteTurn = random.nextBoolean();
     String playerColor = isWhiteTurn? "Trắng":"Đen";
     JOptionPane.showMessageDialog(null,"Người chơi đi trước là:"+playerColor);
     BufferedImage all=ImageIO.read(new File("D:\\chess.png"));
        Image imgs[]=new Image[12];
        int ind=0;
        for(int y=0;y<400;y+=200){
        for(int x=0;x<1200;x+=200){
            imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
        ind++;
        }
        }
     Piece brook=new Piece(0,0,false,"rook",ps);
        Piece bkinght=new Piece(1,0,false,"kinght",ps);
        Piece bbishop=new Piece(2,0,false,"bishop",ps);
        Piece bqueen=new Piece(3,0,false,"queen",ps);
        Piece bking=new Piece(4,0,false,"king",ps);
        Piece bbishop2=new Piece(5,0,false,"bishop",ps);
        Piece bkinght2=new Piece(6,0,false,"kinght",ps);
        Piece brook2=new Piece(7,0,false,"rook",ps);
        Piece bpawn1=new Piece(1,1,false,"pawn",ps);
        Piece bpawn2=new Piece(2,1,false,"pawn",ps);
        Piece bpawn3=new Piece(3,1,false,"pawn",ps);
        Piece bpawn4=new Piece(4,1,false,"pawn",ps);
        Piece bpawn5=new Piece(5,1,false,"pawn",ps);
        Piece bpawn6=new Piece(6,1,false,"pawn",ps);
        Piece bpawn7=new Piece(7,1,false,"pawn",ps);
        Piece bpawn8=new Piece(0,1,false,"pawn",ps);
        
        Piece wrook=new Piece(0,7,true,"rook",ps);
        Piece wkinght=new Piece(1,7,true,"kinght",ps);
        Piece wbishop=new Piece(2,7,true,"bishop",ps);
        Piece wqueen=new Piece(3,7,true,"queen",ps);
        Piece wking=new Piece(4,7,true,"king",ps);
        Piece wbishop2=new Piece(5,7,true,"bishop",ps);
        Piece wkinght2=new Piece(6,7,true,"kinght",ps);
        Piece wrook2=new Piece(7,7,true,"rook",ps);
        Piece wpawn1=new Piece(1,6,true,"pawn",ps);
        Piece wpawn2=new Piece(2,6,true,"pawn",ps);
        Piece wpawn3=new Piece(3,6,true,"pawn",ps);
        Piece wpawn4=new Piece(4,6,true,"pawn",ps);
        Piece wpawn5=new Piece(5,6,true,"pawn",ps);
        Piece wpawn6=new Piece(6,6,true,"pawn",ps);
        Piece wpawn7=new Piece(7,6,true,"pawn",ps);
        Piece wpawn8=new Piece(0,6,true,"pawn",ps);
        
       JFrame frame = new JFrame();
       frame.setBounds(10,10,512,512);
       frame.setUndecorated(true);
       JPanel pn = new JPanel(){

           @Override
           public void paint(Graphics g) {
           boolean white=true;
           for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(white){
                    g.setColor(Color.white.darker());
                }else{
                    g.setColor(Color.gray);
                    
                }
                g.fillRect(x*64, y*64, 64, 64);
            white=!white;
           }
           white=!white;
           }
           for(Piece p : ps){
               int ind=0;
               if(p.name.equalsIgnoreCase("king")){
                   ind=0;
               }
               if(p.name.equalsIgnoreCase("queen")){
                   ind=1;
               }
               if(p.name.equalsIgnoreCase("bishop")){
                   ind=2;
               }
               if(p.name.equalsIgnoreCase("kinght")){
                   ind=3;
               }
               if(p.name.equalsIgnoreCase("rook")){
                   ind=4;
               }
               if(p.name.equalsIgnoreCase("pawn")){
                   ind=5;
               }
               if(!p.isWhite){
                   ind+=6;
               }
               g.drawImage(imgs[ind],p.x,p.y, this);
           }
           }
       };
       frame.add(pn);
       frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e){
              if(selectedPiece!=null){
                  selectedPiece.x=e.getX()-32;
                  selectedPiece.y=e.getY()-32;
                  frame.repaint();
              }
            }

            @Override
            public void mouseMoved(MouseEvent e){
            }
        });
        frame.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
            }

            @Override
            public void mousePressed(MouseEvent e){
                 //System.out.print((getPiece(e.getX(),e.getY()).isWhite?"white":"black")+getPiece(e.getX(),e.getY()).name+"black");
                selectedPiece=getPiece(e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e){
               selectedPiece.move(e.getX()/64,e.getY()/64 );
               frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e){
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            }
        });
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setDefaultCloseOperation(3);
       frame.setVisible(true);
    }
public void move(int newX, int newY) {
    // Lưu vị trí hiện tại của quân cờ
    int oldX = this.xp;
    int oldY = this.yp;
    
    // Di chuyển quân cờ đến vị trí mới
    this.xp = newX;
    this.yp = newY;
    
    // Tạo đối tượng Move và thêm vào movesHistory
    Move move = new Move(oldX, oldY, newX, newY);
    ChessGame.movesHistory.add(move);
}
public static void checkGameOver() {
    boolean wkingExists = false;
    boolean bkingExists = false;
    
    for (Piece p : ps) {
        if (p.name.equalsIgnoreCase("king")) {
            if (p.isWhite) {
                wkingExists = true;
            } else {
                bkingExists = true;
            }
        }
    }
    
    if (!wkingExists) {
        JOptionPane.showMessageDialog(null, "Black wins!");
        showMoveHistory();
        System.exit(0);
    }
    
    if (!bkingExists) {
        JOptionPane.showMessageDialog(null, "White wins!");
        showMoveHistory();
        System.exit(0);
    }
}
public static boolean askForMoveHistory(){
    int choice = 
            JOptionPane.showConfirmDialog(null,"Bạn muốn xem bảng tổng kết","Xem bảng tổng kết",JOptionPane.YES_NO_OPTION);
    return choice == JOptionPane.YES_OPTION;
}
public static void showMoveHistory(){
     StringBuilder history = new StringBuilder();
        for (int i = 0; i < movesHistory.size(); i++) {
            Move move = movesHistory.get(i);
            history.append("Bước").append(i+1).append(":");
            history.append(move.toString()).append("\n");
        }
            JOptionPane.showMessageDialog(null, history.toString(),"Bảng tổng kết",JOptionPane.INFORMATION_MESSAGE);      
}

    public static Piece getPiece(int x,int y){
       int xp=x/64;
       int yp=y/64;
       for(Piece p: ps){
           if(p.xp==xp&&p.yp==yp){
               return p;
           }
       }
       return null;
    }
public class Move {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Move(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public String toString() {
        char startColumn = (char) ('A' + startX);
        char endColumn = (char) ('A' + endX);
        int startRow = 8 - startY;
        int endRow = 8 - endY;
        return "Từ " + startColumn + startRow + " đến " + endColumn + endRow;
    }
}
}
   
    


