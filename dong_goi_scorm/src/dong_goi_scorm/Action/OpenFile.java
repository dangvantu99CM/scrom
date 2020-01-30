package dong_goi_scorm.Action;

import dong_goi_scorm.Constant.ActionMenu;
import dong_goi_scorm.Constant.MenuItem;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import dong_goi_scorm.hearder.HearderComponent;
import dong_goi_scorm.hearder.IconHeader;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFile{
    private File file=null; // get file by selected
    public OpenFile(){
        openFile();
    }
    public File getFile(){
        return file;
    }
    public void openFile(){  
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xvl","jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            file=chooser.getSelectedFile();
        }
    }
    
}
