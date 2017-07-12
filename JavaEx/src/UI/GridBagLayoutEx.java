/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author dobong
 */
public class GridBagLayoutEx extends JFrame{
      
      public GridBagLayoutEx(){
            
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            JButton btn1 = new JButton("One");
            JButton btn2 = new JButton("Two");
            JButton btn3 = new JButton("Three");
            JButton btn4 = new JButton("Four");
            JButton btn5 = new JButton("Five");
            JButton btn6 = new JButton("Six");
            JButton btn7 = new JButton("Seven");
            
            GridBagLayout gbl = new GridBagLayout();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            setLayout(gbl);
            
            addGrid(gbl, gbc, btn1, 0, 0, 1, 1, 0, 0);
            addGrid(gbl, gbc, btn2, 1, 0, 1, 1, 1, 0);
            addGrid(gbl, gbc, btn3, 2, 0, 1, 1, 0, 0);
            addGrid(gbl, gbc, btn4, 0, 1, 2, 1, 0, 0);
            addGrid(gbl, gbc, btn5, 2, 1, 1, 2, 0, 1);
            addGrid(gbl, gbc, btn6, 0, 2, 1, 1, 0, 0);
            addGrid(gbl, gbc, btn7, 1, 2, 1, 1, 1, 0);
            
            pack();
            setVisible(true);
      }
      
      private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c,  
                  int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty) {
            gbc.gridx = gridx;
            gbc.gridy = gridy;
            gbc.gridwidth = gridwidth;
            gbc.gridheight = gridheight;
            gbc.weightx = weightx;
            gbc.weighty = weighty;
            gbl.setConstraints(c, gbc);
            add(c);
      }
      
      /*
        GridBagConstraints.NONE  으로  설정되면  컨테이너의  크기는  변경되지  않는다. 
        GridBagConstraints.HORIZONTAL  으로  설정되면  가로축이  확장된다. 
        GridBagConstraints.VERTICAL  으로  설정되면  세로축이  확장된다. 
        GridBagConstraints.BOTH  인  경우에는  가로/세로  방향으로  모두  확장된다.
        */

      public static void main(String[] args){
            new GridBagLayoutEx();
      }
}

