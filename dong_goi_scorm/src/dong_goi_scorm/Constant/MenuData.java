/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dong_goi_scorm.Constant;
import dong_goi_scorm.MainFrame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author Henry
 */
public class MenuData {
    private static ArrayList<MenuItem> dictMenu = new ArrayList<MenuItem>();
    private static ArrayList<MenuItem> listMenuIcon = new ArrayList<MenuItem>();
    private ActionMenu actionMenu;
    public MenuData(ActionMenu _actionMenu){
        actionMenu=_actionMenu;
        setListMenuIcon();
        initChildMenuBar();
    }
    public ArrayList<MenuItem> setListMenuIcon(){
        if(listMenuIcon.size() > 0){
            return listMenuIcon;
        }
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuSelectUI,setImgIcon("selectUI.PNG","Chá»�n giao diá»‡n")));
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuTutorial,setImgIcon("help.PNG","HÆ°á»›ng dÃ£n sá»­ dá»¥ng")));
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuOpen,setImgIcon("openFolder.PNG", "Má»Ÿ...")));
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuOpenLibraries,setImgIcon("openLibary.PNG", "Má»Ÿ tá»« thÆ° viá»‡n")));
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuCreateNew,setImgIcon("newFile.PNG", "Táº¡o má»›i")));
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuViewAll,setImgIcon("viewAll.PNG", "Xem toÃ n bá»™")));
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuSave,setImgIcon("save.PNG", "LÆ°u")));
        listMenuIcon.add(new MenuItem(actionMenu.clickMenuPackage,setImgIcon("fixPackge.PNG", "Ä�Ã³ng gÃ³i")));
        return listMenuIcon;
    }
    
    private static ImageIcon setImgIcon(String url,String text){
        url="C:\\Users\\Henry\\Documents\\NetBeansProjects\\dong_goi_scorm\\src\\dong_goi_scorm\\Resource\\"+url;
        return new ImageIcon(url,text);
    }
    
    public ArrayList<MenuItem> initChildMenuBar() {
        if (dictMenu.size() > 0) {
            return dictMenu;
        }
        dictMenu.add(new MenuItem(null,"Bài giảng", new ArrayList<MenuItem>() {
            {
                add(new MenuItem("Táº¡o má»›i (F2)"));
                add(new MenuItem("Má»Ÿ"));
                add(new MenuItem("LÆ°u vÃ o"));
                add(new MenuItem("Má»Ÿ tá»« Ä‘Ã¡m mÃ¢y"));
                add(new MenuItem("LÆ°u trá»¯ lÃªn Ä‘Ã¡m mÃ¢y"));
                add(new MenuItem("Má»Ÿ thÆ° viÃªn"));
                add(new MenuItem("Chia sáº»"));
                add(new MenuItem("Ä�Ã³ng gÃ³i"));
                add(new MenuItem("Thoát"));
            }
        }));
        dictMenu.add(new MenuItem(null,"Soạn thảo", new ArrayList<MenuItem>() {
            {
                add(new MenuItem("Phục hồi (Ctrl+Z)"));
                add(new MenuItem("Làm lại (Ctrl+Y)"));
                add(new MenuItem("Cắt đề mục (Ctrl+X)"));
                add(new MenuItem("Chép đề mục (Ctrl+C)"));
                add(new MenuItem("Dán đề mục (Ctrl+V)"));
                add(new MenuItem("Dịch mục lên"));
                add(new MenuItem("Dịch mục xuống"));
            }
        }));
        dictMenu.add(new MenuItem(null,"Nội dung", new ArrayList<MenuItem>() {
            {
                add(new MenuItem(null,"Thêm đề mục (F5)"));
                add(new MenuItem(null,"Sửa đổi thông tin (F6)"));
                add(new MenuItem(null,"Đồng bộ Video/Audio (F7)"));
                add(new MenuItem(null,"Xóa đề mục"));
                add(new MenuItem(null,"Chọn trang bìa"));
                add(new MenuItem(null,"Chọn giao diện (F8)"));
                add(new MenuItem(null,"Soạn thảo hình nền"));
                add(new MenuItem(null,"Xem toàn bộ"));
            }
        }));
        dictMenu.add(new MenuItem(null,"Tùy chọn", new ArrayList<MenuItem>() {
            {
                add(new MenuItem(null,"Cập nhật chức năng mới"));
                add(new MenuItem(null,"Cập nhật mẫu giao diện mới"));
                add(new MenuItem(null,"Cập nhật thư viện bổ sung"));
                add(new MenuItem(null,"Các phần mềm hỗ trợ",new ArrayList<MenuItem>(){
                    {
                        add(new MenuItem(null,"Bộ bõ tiếng việt Unikey"));
                        add(new MenuItem(null,"Teamviewer hỗ trợ nhanh"));
                    }
                }));
                add(new MenuItem(null,""));
                add(new MenuItem(null,"Chá»�n giao diá»‡n (F8)"));
            }
        }));
        dictMenu.add(new MenuItem(null,"Trợ giúp", new ArrayList<MenuItem>() {
            {
                add(new MenuItem(null,"Hỏi đáp/Góp ý"));
                add(new MenuItem(null,"Các wwebsite hữu ích"));
                add(new MenuItem(null,"Nâng cấp"));
                add(new MenuItem(null,"Giới thiệu"));
            }
        }));
        dictMenu.add(new MenuItem(null,"Tài khoản", new ArrayList<MenuItem>() {
            {
                add(new MenuItem(null,"Đăng nhập"));
                add(new MenuItem(null,"Thông tin tài khoản"));
                add(new MenuItem(null,"Tài khoản thanh toán"));
                add(new MenuItem(null,"Thông tin bản quyền"));
                add(new MenuItem(null,"Đăng nhập lại"));
                add(new MenuItem(null,"Đăng xuất"));
            }
        }));

        return dictMenu;
    }
}
