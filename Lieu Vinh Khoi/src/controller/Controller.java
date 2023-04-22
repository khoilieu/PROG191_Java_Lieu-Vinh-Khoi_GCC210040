/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import addPro.addPro;
import home.home;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.Product;
import model.Sale;
import model.XFile;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.Account;

/**
 *
 * @author Liêu Vinh Khôi
 */
public class Controller {

    DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
    public int currentRow = -1;
    public String filePathAcc = "./src/model/account.dat";
    public String filePath = "./src/model/product.dat";
    public String filePathSale = "./src/model/sale.dat";
    public ArrayList<Account> accList;
    public ArrayList<Product> proList;
    public ArrayList<Sale> saleList;
    public List<String> snacks;
    public String checkName;
    public int checklog;
    public int total = 0;

    public Controller() {
        snacks = new ArrayList<>();
        proList = new ArrayList<>();
        saleList = new ArrayList<>();
        currentRow = -1;
    }

    public boolean checkLogin(String user, String pass) {
        boolean flag = false;
        if (user.length() > 0 && pass.length() > 0) {
            for (Account acc : accList) {
                if (user.equals(acc.getUser()) && pass.equals(acc.getPass())) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            } else {
                checklog = 0;
                return false;
            }
        } else {
            checklog = 1;
            return false;
        }
    }

    public void loadcbPro() {
        cbModel.addElement("Choose a product");
        for (Product n : proList) {
            cbModel.addElement(n.getName() + " " + "~" + " " + n.getPrice() + " " + "vnd");
        }
        home.cbPro.setModel(cbModel);
    }

    public boolean loadFile() {
        if (XFile.readObject(filePath) == null) {
            return false;
        }
        proList = (ArrayList<Product>) XFile.readObject(filePath);
        return true;
    }

    public boolean loadFileSale() {
        if (XFile.readObject(filePathSale) == null) {
            return false;
        }
        saleList = (ArrayList<Sale>) XFile.readObject(filePathSale);
        return true;
    }

    public void deletePro() {
        proList.remove(currentRow);
        int id = 0;
        for (Product product : proList) {
            id++;
            product.setId(id);
        }
    }

    public void saveFilePro() {
        XFile.writeObject(filePath, proList);
    }

    public void readFilePro() {
        proList = (ArrayList<Product>) XFile.readObject(filePath);
    }

    public void readFileAcc() {
        accList = (ArrayList<Account>) XFile.readObject(filePathAcc);
    }

    public void addSale() {
        for (Product product : proList) {
            if (checkName.contains(product.getName())) {
                total += product.getPrice();
            }
        }
        Sale s = new Sale(saleList.size() + 1, checkName, snacks.toString(), new Date().toString(), total);
        saleList.add(s);
        XFile.writeObject(filePathSale, saleList);
    }

    public void testSale() {
        for (Product product : proList) {
            if (checkName.contains(product.getName())) {
                total += Integer.valueOf(product.getPrice());
            }
        }
    }
    public boolean[] checkEmpty = new boolean[5];
    public boolean addPro(String names, String prices, String nations, String dess, int indexNation) {
        int price;
        for (int i = 0; i < 5; i++) {
            checkEmpty[i] = true;
        }
        try {
            price = Integer.parseInt(prices);
        } catch (NumberFormatException e) {
            price = 0;
        }
        if (names.equals("") && price == 0 && indexNation == 0 && dess.equals("")) {
            checkEmpty[0] = false; 
            return false;
        } else if (names.equals("")) {
            checkEmpty[1] = false;
            return false;
        } else if (price <= 0) {
            checkEmpty[2] = false;
            return false;
        } else if (indexNation == 0) {
            checkEmpty[3] = false;
            return false;
        } else if (dess.equals("")) {
            checkEmpty[4] = false;
            return false;
        } else {
            Product c = new Product(proList.size() + 1, names, price, nations, dess, "");
            proList.add(c);
            return true;
        }
    }

    public boolean upPro(String names, String prices, String nations, String dess, int indexNation) {
        int price;
        for (int i = 0; i < 5; i++) {
            checkEmpty[i] = true;
        }
        try {
            price = Integer.parseInt(prices);
        } catch (NumberFormatException e) {
            price = 0;
        }
        if (names.equals("") && price == 0 && indexNation == 0 && dess.equals("")) {
            checkEmpty[0] = false;
            return false;
        } else if (names.equals("")) {
            checkEmpty[1] = false;
            return false;
        } else if (price <= 0) {
            checkEmpty[2] = false;
            return false;
        } else if (indexNation == 0) {
            checkEmpty[3] = false;
            return false;
        } else if (dess.equals("")) {
            checkEmpty[4] = false;
            return false;
        } else {
            int selectedRow = home.tbPro.getSelectedRow();
            Product p = proList.get(selectedRow);
            p.setName(names);
            p.setPrice(price);
            p.setNation(nations);
            p.setDes(dess);
            return true;
        }
    }

    public void loadImg() {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        f.setDialogTitle("Open File");
        int re = f.showOpenDialog(null);
        if (re == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();
            BufferedImage b;
            try {
                b = ImageIO.read(file);
                addPro.lbPic.setIcon(new ImageIcon(resizeImage(b)));
            } catch (IOException e) {}
        }
    }

    private Image resizeImage(BufferedImage value) {
        ImageIcon icon = new ImageIcon(value);
        Image image = icon.getImage();
        return image.getScaledInstance(190, 175, Image.SCALE_SMOOTH);
    }

}
