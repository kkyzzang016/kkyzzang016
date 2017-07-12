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
        GridBagConstraints.NONE  ����  �����Ǹ�  �����̳���  ũ���  �������  �ʴ´�. 
        GridBagConstraints.HORIZONTAL  ����  �����Ǹ�  ��������  Ȯ��ȴ�. 
        GridBagConstraints.VERTICAL  ����  �����Ǹ�  ��������  Ȯ��ȴ�. 
        GridBagConstraints.BOTH  ��  ��쿡��  ����/����  ��������  ���  Ȯ��ȴ�.
        */

      public static void main(String[] args){
            new GridBagLayoutEx();
      }
}

