/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.security.KeyStore;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import static javax.swing.KeyStroke.getKeyStroke;

/**
 *
 * @author ADMIN
 */
public class JNotePad extends JFrame {

    private JMenuBar menuBar ,menuView;
    private JMenu mFile, mEdit, mFormat, mView, mHelp,mZoomin,mZoomout,mRestore;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemSetup, itemPageSetup, itemPrint, itemExit, itemFont;
    private JMenuItem itemstatusBar,itemZoomin,itemZoomout,itemRestore;
    private JMenuItem itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemSeacrhWithB, itemFind, itemFindNext, itemFindPrevious, itemReplace, itemGoto, itemSelectAll, itemTime;
    private JMenuItem itemViewhelp,itemSend,itemAbout;
    private JCheckBoxMenuItem itemWrap;
    private JTextArea txtEditor;
    private JFontDialog dialog;

    public JNotePad(String title) {
        super(title);
        CreateMenu();
        CreateGUI();
        ProcessEvent();
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void CreateMenu() {
        //Tạo đối tượng thanh thực đơn
        menuBar = new JMenuBar();
        //Tạo các thực đơn và thêm vào thanh thực đơn
        menuBar.add(mFile = new JMenu("File"));
        menuBar.add(mEdit = new JMenu("Edit"));
        menuBar.add(mFormat = new JMenu("Format"));
        menuBar.add(mView = new JMenu("View"));
        menuBar.add(mHelp = new JMenu("Help"));
        setJMenuBar(menuBar);
        //Tạo các item cho menu
        mFile.add(itemNew = new JMenuItem("New"));
        mFile.add(itemOpen = new JMenuItem("Open"));
        mFile.add(itemSave = new JMenuItem("Save..."));
        mFile.add(itemSaveAs = new JMenuItem("SaveAs..."));
        mFile.add(new JSeparator());
        mFile.add(itemPageSetup = new JMenuItem("PageSetup..."));
        mFile.add(itemPrint = new JMenuItem("Print...."));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Exit"));
        //Tạo các item cho edit
        mEdit.add(itemUndo=new JMenuItem("Undo"));
        mEdit.addSeparator();
        mEdit.add(itemCut=new JMenuItem("Cut"));
        mEdit.add(itemCopy=new JMenuItem("Copy"));
        mEdit.add(itemPaste=new JMenuItem("Paste"));
        mEdit.add(itemDelete=new JMenuItem("Delete"));
        mEdit.addSeparator();
        mEdit.add(itemSeacrhWithB=new JMenuItem("Search With Bing..."));
        mEdit.add(itemFind=new JMenuItem("Find"));
        mEdit.add(itemFindNext=new JMenuItem("Find Next"));
        mEdit.add(itemFindPrevious=new JMenuItem("Find Previous"));
        mEdit.add(itemReplace=new JMenuItem("Replace.."));
        mEdit.add(itemGoto=new JMenuItem("Go to"));        
        mEdit.addSeparator();
        mEdit.add(itemSelectAll=new JMenuItem("Select All"));
        mEdit.add(itemTime=new JMenuItem("Date/Time"));
        
        mFormat.add(itemWrap=new JCheckBoxMenuItem("Word Wrap",true));
        mFormat.add(itemFont=new JMenuItem("Font"));
        
        mView.add(menuView=new JMenuBar());
//        menuView.add(mZoomin=new JMenu("Zoom in"));
//        menuView.add(mZoomout=new JMenu("Zoom out"));
//        menuView.add(mRestore=new JMenu("Restore Default Zoom"));
        mView.add(itemstatusBar=new JCheckBoxMenuItem("Status Bar",true));
        
        mHelp.add(itemViewhelp=new JMenuItem("View Help"));
        mHelp.add(itemSend=new JMenuItem("Send FeedBack"));
        mHelp.add(itemAbout=new JMenuItem("About NotePad"));
        //Tạo phím nóng
        itemNew.setAccelerator(getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        itemPageSetup.setAccelerator(getKeyStroke("F1"));
        itemPrint.setAccelerator(getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        itemExit.setAccelerator(getKeyStroke("F2"));
        itemUndo.setAccelerator(getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        itemCopy.setAccelerator(getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        itemPaste.setAccelerator(getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        itemDelete.setAccelerator(getKeyStroke("Delete"));
        itemSeacrhWithB.setAccelerator(getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));
        itemFind.setAccelerator(getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_DOWN_MASK));
        itemFindNext.setAccelerator(getKeyStroke("F3"));
        itemFindPrevious.setAccelerator(getKeyStroke(KeyEvent.VK_F3,KeyEvent.SHIFT_DOWN_MASK));
        itemReplace.setAccelerator(getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_DOWN_MASK));
        itemGoto.setAccelerator(getKeyStroke(KeyEvent.VK_G,KeyEvent.CTRL_DOWN_MASK));
        itemSelectAll.setAccelerator(getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        itemTime.setAccelerator(getKeyStroke("F5"));
                
    }

    public JTextArea getTxtEditor() {
        return txtEditor;
    }

    private void CreateGUI() {
        txtEditor = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtEditor);
        add(scrollPane);
        txtEditor.setLineWrap(true);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    private void ProcessEvent() {
        itemFont.addActionListener((e)->{
        dialog = new JFontDialog(this, true);
        dialog.setVisible(true);
    });
        //xử lý item word wrap
        itemWrap.addItemListener((e)->{
            if(itemWrap.isSelected())
                txtEditor.setLineWrap(true);
            else
                txtEditor.setLineWrap(false);
    });
        //xử lý item open
        
    }
}
