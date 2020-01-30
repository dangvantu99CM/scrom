
package dong_goi_scorm.Content.Left_Content;

import dong_goi_scorm.Constant.ActionMenuItem;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Heading extends JPanel{
    private String title="";
    private String url_img="";
    private ActionMenuItem action=null; 
    public Heading() {}
    public Heading(String title,String url_img){
        this.title = title;
        this.url_img = url_img;
    }
    
}
