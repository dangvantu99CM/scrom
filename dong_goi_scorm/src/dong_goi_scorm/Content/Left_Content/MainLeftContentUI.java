package dong_goi_scorm.Content.Left_Content;

import javax.swing.JPanel;

import org.w3c.dom.NodeList;

import com.sun.javafx.binding.ContentBinding;

import dong_goi_scorm.Content.Left_Content.Content.ContentUI;

public class MainLeftContentUI extends JPanel{
    public MainLeftContentUI(NodeList nodeList) {
        this.setSize(200, 800);
        this.setLocation(0,0);
        setLeftContentUI(nodeList);
    }
    public void setLeftContentUI(NodeList nodeList) {
        this.add(new Heading());
        this.add(new ContentUI(nodeList));
    }
}
