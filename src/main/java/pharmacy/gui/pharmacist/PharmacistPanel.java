package pharmacy.gui.pharmacist;

import pharmacy.service.ReceiptService;
import pharmacy.service.ReceiptServiceImpl;
import pharmacy.service.UserProfileService;
import pharmacy.utils.CurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class PharmacistPanel extends JPanel {

    private JLabel userNameLabel, dateLabel, saleLabel, medicineListLabel, basketListLabel, totalLabel;
    private JButton logOutButton, payButton, cashButton, cardButton;
    private JScrollPane medicineListScroller, basketListScroller;
    private JList<String> medicineList, basketList;
    private JTextField totalDisplayTF, paymentProcessingTF;
    private BufferedImage img;

    private CurrentDate currentDate = new CurrentDate();
    private ReceiptService receiptService = new ReceiptServiceImpl();

    public PharmacistPanel() {
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        userNameLabel = new JLabel(UserProfileService.getFirstName(), SwingConstants.CENTER);
        userNameLabel.setBounds(555, 15, 80, 50);
        userNameLabel.setFont(userNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(currentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100, 50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("LOG OUT");
        logOutButton.setBounds(555, 55, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            mainFrame.logout();
        });

        saleLabel = new JLabel("SALE MODE",SwingConstants.CENTER);
        saleLabel.setBounds(300, 25, 100, 50);
        saleLabel.setFont(saleLabel.getFont().deriveFont(15f));

        medicineListLabel = new JLabel("Medicines", SwingConstants.CENTER);
        medicineListLabel.setBounds(145, 115, 100, 50 );
        medicineListLabel.setFont(medicineListLabel.getFont().deriveFont(15f));

        medicineList = new JList(receiptService.getMedicineAndPriceDisplayList());
        medicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));
        medicineList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    receiptService.updateMedicineQty(index);
                    receiptService.updateBasketData(index);
                    updateBasketList();
                }
            }
        });

        medicineListScroller = new JScrollPane();
        medicineListScroller.setViewportView(medicineList);
        medicineListScroller.setBounds(70, 160, 250, 240);

        basketListLabel = new JLabel("Basket", SwingConstants.CENTER);
        basketListLabel.setBounds(455, 115, 100, 50 );
        basketListLabel.setFont(basketListLabel.getFont().deriveFont(15f));

        basketList = new JList(receiptService.getBasket());
        basketList.setEnabled(false);
        basketList.setFont(basketList.getFont().deriveFont(15f));

        basketListScroller = new JScrollPane();
        basketListScroller.setViewportView(basketList);
        basketListScroller.setBounds(380, 160, 250, 240);

        totalLabel = new JLabel("TOTAL");
        totalLabel.setBounds(380,410,80,50);
        totalLabel.setFont(totalLabel.getFont().deriveFont(15f));

        totalDisplayTF = new JTextField(receiptService.getTotal() + "$");
        totalDisplayTF.setFont(totalDisplayTF.getFont().deriveFont(15f));
        totalDisplayTF.setBounds(460,410,80,50);
        totalDisplayTF.setEditable(false);

        payButton = new JButton("PAY");
        payButton.setBounds(155, 410, 80, 50 );
        payButton.setFont(payButton.getFont().deriveFont(15f));
        payButton.addActionListener(e -> {
            if (receiptService.getBasket()[0] == null) {
                JOptionPane.showMessageDialog(this, "EMPTY BASKET");
            } else {
                enableCashAndCardButton();
                paymentProcessingTF.setVisible(true);
            }
        });

        cashButton = new JButton("CASH");
        cashButton.setBounds(70, 410, 80, 80);
        cashButton.setFont(cashButton.getFont().deriveFont(15f));
        cashButton.setEnabled(false);
        cashButton.setVisible(false);
        cashButton.addActionListener(e -> {
            paymentProcessing();
            enablePayButton();
            paymentProcessingTF.setVisible(false);
        });

        cardButton = new JButton("CARD");
        cardButton.setBounds(240, 410, 80, 80 );
        cardButton.setFont(cardButton.getFont().deriveFont(15f));
        cardButton.setEnabled(false);
        cardButton.setVisible(false);
        cardButton.addActionListener(e -> {
            paymentProcessing();
            enablePayButton();
            paymentProcessingTF.setVisible(false);
        });

        paymentProcessingTF = new JTextField("Payment processing..",SwingConstants.CENTER);
        paymentProcessingTF.setBounds(250, 500, 200, 70);
        paymentProcessingTF.setFont(paymentProcessingTF.getFont().deriveFont(17f));
        paymentProcessingTF.setEditable(false);
        paymentProcessingTF.setVisible(false);
        paymentProcessingTF.setOpaque(true);
        paymentProcessingTF.setBackground(Color.ORANGE);

        add(userNameLabel);
        add(dateLabel);
        add(logOutButton);
        add(saleLabel);
        add(medicineListLabel);
        add(medicineListScroller);
        add(basketListLabel);
        add(basketListScroller);
        add(totalLabel);
        add(totalDisplayTF);
        add(payButton);
        add(cashButton);
        add(cardButton);
        add(paymentProcessingTF);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }


    /* Disables Cash and Card Button and enables Pay Button instead */
    private void enablePayButton() {
        cashButton.setEnabled(false);
        cashButton.setVisible(false);
        cardButton.setEnabled(false);
        cardButton.setVisible(false);
        payButton.setEnabled(true);
        payButton.setVisible(true);
    }

    private void enableCashAndCardButton() {
        cashButton.setEnabled(true);
        cashButton.setVisible(true);
        cardButton.setEnabled(true);
        cardButton.setVisible(true);
        payButton.setEnabled(false);
        payButton.setVisible(false);
    }

    private void paymentProcessing() {
        paymentProcessingTF.setVisible(true);
        receiptService.updatePharmacyStorageQuantityData();
        receiptService.addNewReceipt();
        receiptService.setTotal(0);
        receiptService.setBasket();
        receiptService.setBasketData();
        updateBasketList();
        paymentProcessingTF.setVisible(false);
        JOptionPane.showMessageDialog(null, "Payment accepted","Success",1);
    }

    private void updateBasketList() {
        basketList = new JList(receiptService.getBasket());
        basketList.setFont(basketList.getFont().deriveFont(15f));
        basketListScroller.setViewportView(basketList);
        totalDisplayTF.setText(receiptService.getTotal() + "$");
        totalDisplayTF.setFont(totalDisplayTF.getFont().deriveFont(15f));
    }
}