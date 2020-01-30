/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dong_goi_scorm.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuItem {
    public String text="";
    public ActionMenuItem action=null;
    public ArrayList<MenuItem> child= new ArrayList();
    public ImageIcon imgIcon=null;
    public MenuItem(String _text){
        this.text=_text;
    }
    public MenuItem(ActionMenuItem clickItem,ImageIcon imgIcon){
        this.imgIcon=imgIcon;
        this.action = clickItem;
    }
    public MenuItem(ActionMenuItem menuItemId,String _text){
        this.action=menuItemId;
        this.text=_text;
    }
    public MenuItem(ActionMenuItem menuItemId,String _text,List<MenuItem> _child){
         this.action=menuItemId;
        this.text=_text;
        if(_child!=null && _child.size()>0){
            this.child.addAll(_child);
        }
    }
}
