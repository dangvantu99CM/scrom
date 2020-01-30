package dong_goi_scorm.Content.Left_Content.Content;

import java.awt.MenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.w3c.dom.NodeList;
import com.sun.corba.se.impl.orbutil.graph.Node;
import org.w3c.dom.Element; 
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import dong_goi_scorm.Content.Left_Content.ReadFile;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;


public class ContentUI extends JPanel{
    public ContentUI(NodeList nodeList) {
        setViewContentUI(nodeList);
    }
    public void setViewContentUI(NodeList nodeList) {
        JMenuBar menuBar = new JMenuBar();
        if(nodeList != null && nodeList.getLength() > 0) {	
            for(int i=0; i < nodeList.getLength(); i++){  
                org.w3c.dom.Node n = (org.w3c.dom.Node) nodeList.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
                    JMenu menu = new JMenu(n.getNodeName());
                    Element node = (Element) n;
                    NodeList nodeChilden = n.getChildNodes();
                    int sizeChilden = nodeChilden.getLength();
                    System.out.println("node parent===="+n.getNodeName());
                    if(nodeChilden.getLength() != 0){
                        for(int j = 0; j < sizeChilden; j++){
                            if(nodeChilden.item(i).getNodeName() == "ITEM_INFO"){
                                System.out.println("\t node childen==="+nodeChilden.item(i).getNodeName());
                                Element node_text = (Element) nodeChilden.item(i);
                                JMenuItem me_it = new JMenuItem(node_text.getAttribute("label"));
                                menu.add(me_it);
                            }
                        }
                    }
                    menuBar.add(menu); 
                }
            }
        }
        JRootPane rootPane = new JRootPane();
        rootPane.setJMenuBar(menuBar);
        this.add(rootPane);
    }
}
