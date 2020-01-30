package dong_goi_scorm.Content.Left_Content;

import dong_goi_scorm.Action.OpenFile;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Element;

public class ReadFile {
	private NodeList nodeList = null;
        private ArrayList<Node> treeList = new ArrayList<>();
	public ReadFile(File file) {
            if (file != null) {
                readFile(file);
            }
	}
	public NodeList getNodeList() {
            return nodeList;
	}
        public ArrayList<Node> getTreeNode(){
            return treeList;
        }
	private void readFile(File file) {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                nodeList = doc.getElementsByTagName("SECTION_INFO");
                System.out.println("node ====" + nodeList);
                for(int i=0; i < nodeList.getLength(); i++) {
                    Node n = (Node) nodeList.item(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("File không tồn tại");
            }
	}
      
	public static void main(String[] args) {

	}
}
