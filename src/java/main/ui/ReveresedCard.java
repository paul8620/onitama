package main.ui;

import main.Card;

import javax.swing.*;
import java.awt.*;

public class ReveresedCard extends JComponent {
   private Card card;
   private Color positionColor = Color.black;
   private Color possibleMoveColor = Color.GRAY;

   public ReveresedCard(int x,int y, Card card) {
      this.card = card;
      setBackground(Color.WHITE);
      setSize(100,100);
      setBounds(x,y,100,100);

   }

   @Override
   public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D)g;
      float thick = 1;
      for (int i = 4; i>=0;i--){
         for(int j = 4; j>=0; j--){
            Shape rectangle = new Rectangle(80-i*20,80-j*10,20,10);
            g2.setColor(Color.black);
            g2.draw(rectangle);
            if(card.mask[j][i]){
               g2.setColor(possibleMoveColor);
               g2.fill(rectangle);
            }
            if(i==2 && j==2){
               g2.setColor(positionColor);
               g2.fill(rectangle);
            }
         }
      }
      g2.setColor(Color.black);
      g2.drawString(card.name,0,10);

   }
}
