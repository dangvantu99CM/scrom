/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dong_goi_scorm.hearder;

import dong_goi_scorm.Constant.ActionMenu;
import dong_goi_scorm.Constant.MenuData;
import dong_goi_scorm.Constant.MenuItem;
import dong_goi_scorm.MainFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class IconHeader extends JPanel{
    public IconHeader(MenuData menuData){
        createMenuIcon(menuData.setListMenuIcon());
    }
    private void createMenuIcon(ArrayList<MenuItem> listMenuItem){
        if(listMenuItem.size() > 0){
            for(MenuItem it:listMenuItem){
                if(it.imgIcon != null){
                    JLabel lb = new JLabel();
                    lb.setIcon(it.imgIcon);
                    lb.setHorizontalAlignment(SwingConstants.LEFT);
                    lb.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            if(it.action!=null){
                                it.action.onClick(it);
                            }
                        }
                    });
                    this.add(lb);
                }
            } 
        } 
    }
    
}
