package com.mycompany.chessgame;

public class Move {
     public final int startX;
     public final int startY;
     public  final int endX;
     public  final int endY;

    public Move(int startX, int startY, int endX, int endY, String type) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    
    public Move(){
        this.startX = 0;
        this.startY = 0;
        this.endX = 0;
        this.endY = 0;
    }

    
    public boolean isValidRookMove() {
    // Kiểm tra xem nó di chuyển theo hàng hoặc cột không
    if (startX == endX || startY == endY) {
        // Kiểm tra xem không có quân cờ nào cản trở trên đường đi
        // Kiểm tra theo hàng
        if (startX == endX) {
            int minY = Math.min(startY, endY);
            int maxY = Math.max(startY, endY);
            for (int y = minY + 1; y < maxY; y++) {
                if (ChessGame.getPiece(startX, y) != null) {
                    return false; // Có quân cờ cản trở
                }
            }
        } else { // Kiểm tra theo cột
            int minX = Math.min(startX, endX);
            int maxX = Math.max(startX, endX);
            for (int x = minX + 1; x < maxX; x++) {
                if (ChessGame.getPiece(x, startY) != null) {
                    return false; // Có quân cờ cản trở
                }
            }
        }
        return true; // Không có quân cờ cản trở
    }
    return false; // Không di chuyển theo hàng hoặc cột
}
   public boolean isValidPawnMove() {
    // Tính toán độ chênh lệch theo trục X và trục Y
    int deltaY = Math.abs(endY - startY);
    int deltaX = Math.abs(endX - startX);

    // Kiểm tra điều kiện cho quân tốt di chuyển
    if (deltaX == 0) { // Di chuyển theo cột
        if (deltaY == 1) { // Di chuyển một bước
            // Kiểm tra xem có quân cờ trên đường di chuyển không
            if (ChessGame.getPiece(endX, endY) == null) {
                return true; // Di chuyển hợp lệ nếu không có quân cờ trên đường di chuyển
            }
        } else if (deltaY == 2 && startY == 1) { // Di chuyển hai bước từ hàng ban đầu
            // Kiểm tra xem có quân cờ trên đường di chuyển không
            if (ChessGame.getPiece(endX, endY) == null && ChessGame.getPiece(endX, endY - 1) == null) {
                return true; // Di chuyển hợp lệ nếu không có quân cờ trên đường di chuyển
            }
        }
    }

    return false; // Trả về false nếu không thỏa mãn các điều kiện trên
}

public boolean isValidKnightMove() {
    // Kiểm tra xem quân mã di chuyển theo hình dạng "L"
    int deltaX = Math.abs(endX - startX);
    int deltaY = Math.abs(endY - startY);
    if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1)) {
        return true; // Nếu di chuyển theo hình dạng "L"
    }
    return false; // Nếu không di chuyển theo hình dạng "L"
}
public boolean isValidBishopMove() {
    // Kiểm tra xem quân tượng di chuyển theo đường chéo không
    if (Math.abs(startX - endX) == Math.abs(startY - endY)) {
        // Xác định hướng di chuyển (tăng/giảm)
        int directionX = (endX > startX) ? 1 : -1;
        int directionY = (endY > startY) ? 1 : -1;
        
        // Kiểm tra không có quân cờ nào cản trở trên đường đi
        int x = startX + directionX;
        int y = startY + directionY;
        while (x != endX && y != endY) {
            if (ChessGame.getPiece(x, y) != null) {
                return false; // Có quân cờ cản trở
            }
            x += directionX;
            y += directionY;
        }
        return true; // Không có quân cờ cản trở
    }
    return false; // Không di chuyển theo đường chéo
}

public boolean isValidQueenMove() {
    // Kiểm tra xem quân hậu di chuyển theo hàng, cột hoặc đường chéo
    if (startX == endX || startY == endY || Math.abs(endX - startX) == Math.abs(endY - startY)) {
        // Kiểm tra xem không có quân cờ nào cản trở trên đường đi

        // Kiểm tra theo hàng
        if (startX == endX) {
            int minY = Math.min(startY, endY);
            int maxY = Math.max(startY, endY);
            for (int y = minY + 1; y < maxY; y++) {
                if (ChessGame.getPiece(startX, y) != null) {
                    return false; // Có quân cờ cản trở
                }
            }
        }
        // Kiểm tra theo cột
        else if (startY == endY) {
            int minX = Math.min(startX, endX);
            int maxX = Math.max(startX, endX);
            for (int x = minX + 1; x < maxX; x++) {
                if (ChessGame.getPiece(x, startY) != null) {
                    return false; // Có quân cờ cản trở
                }
            }
        }
        // Kiểm tra theo đường chéo
        else {
            int minX = Math.min(startX, endX);
            int minY = Math.min(startY, endY);
            int maxX = Math.max(startX, endX);
            int maxY = Math.max(startY, endY);
            int x = minX + 1;
            int y = minY + 1;
            while (x < maxX && y < maxY) {
                if (ChessGame.getPiece(x, y) != null) {
                    return false; // Có quân cờ cản trở
                }
                x++;
                y++;
            }
        }
        return true; // Không có quân cờ cản trở
    }
    return false; // Không di chuyển theo hàng, cột hoặc đường chéo
}
public boolean isValidKingMove() {
    // Kiểm tra khoảng cách di chuyển của quân tướng không vượt quá 1 ô
    int deltaX = Math.abs(endX - startX);
    int deltaY = Math.abs(endY - startY);
    if ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 1)) {
        return true; // Di chuyển chỉ diễn ra trong 1 ô
    }
    return false; // Không hợp lệ nếu di chuyển vượt quá 1 ô
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
