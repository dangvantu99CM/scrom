
package dong_goi_scorm;

import dong_goi_scorm.Action.OpenFile;
import dong_goi_scorm.Constant.ActionMenu;
import dong_goi_scorm.Constant.ActionMenuItem;
import dong_goi_scorm.Constant.MenuData;
import dong_goi_scorm.Constant.MenuItem;
import dong_goi_scorm.Content.Left_Content.MainLeftContentUI;
import dong_goi_scorm.Content.Left_Content.ReadFile;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import dong_goi_scorm.hearder.HearderComponent;
import dong_goi_scorm.hearder.IconHeader;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    MainFrame mf = this;
    ActionMenuItem clickMenuCreateNew =new ActionMenuItem() {
       @Override
        public void onClick(MenuItem data) {
            
        }
    };
    ActionMenuItem clickMenuOpen = new ActionMenuItem(){
        @Override      
        public void onClick(MenuItem data) {
            OpenFile of = new OpenFile();
            ReadFile rf = new ReadFile(of.getFile());
            JLabel lb = new JLabel("sssssssssssss");
            mf.add(lb);
            mf.add(new MainLeftContentUI(rf.getNodeList()));
        }
    };
    public MainFrame(){
        super();
        ActionMenu actionMenu= new ActionMenu();
        actionMenu.clickMenuCreateNew=clickMenuCreateNew;
        actionMenu.clickMenuOpen=clickMenuOpen;
        actionMenu.clickMenuCreateNew=clickMenuCreateNew;
        actionMenu.clickMenuCreateNew=clickMenuCreateNew;
        actionMenu.clickMenuCreateNew=clickMenuCreateNew;
        MenuData menuData= new MenuData(actionMenu);
        initFrame(menuData);
    }
    
    public void initFrame(MenuData menuData){
        this.setLayout(new BorderLayout());
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar( new HearderComponent(menuData));
        this.add(new IconHeader(menuData));
    }
    
    public void run(){
        this.setVisible(true);
    }
    
    public static void main(String[]args){
        MainFrame mf = new MainFrame();
        mf.run();
    }
}
