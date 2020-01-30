/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dong_goi_scorm.hearder;
import dong_goi_scorm.Constant.ActionMenu;
import dong_goi_scorm.Constant.MenuData;
import dong_goi_scorm.Constant.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Henry
 */
public class HearderComponent extends JMenuBar{
    public HearderComponent(MenuData menuData){
        createMenu(menuData.initChildMenuBar());
    }  
    private void createMenu(ArrayList<MenuItem> listMenu){
        for(MenuItem item:listMenu){
            this.add(this.createHeader(item));
        }
    }
    private JMenu createHeader(MenuItem data)
    {
        JMenu menuBar = new JMenu();
        menuBar.setText(data.text);
        menuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(data.action!=null){
                    data.action.onClick(data);
                }
            }
        });
        if(data.child!=null && data.child.size()>0){
            for(MenuItem item:data.child){
                menuBar.add(createHeader(item));
            }
        }
        return menuBar;
    }
}
