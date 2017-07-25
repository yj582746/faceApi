package face.api.test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import face.api.pojo.HttpResult;
import face.api.utils.FaceApiUtils;

/**
 * ����ͷ������,����GUI
 * 
 * @author �ƾ�
 *
 */
public class Test2 {
    private static int num = 0;

    public static void main(String[] args) throws IOException {
        final Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);

        final JFrame window = new JFrame("����ͷ");
        window.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                webcam.close();
                window.dispose();
            }
        });
        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // final JButton button = new JButton("��ͼ");
        // window.add(panel, BorderLayout.CENTER);
        // window.add(button, BorderLayout.SOUTH);
        // window.setResizable(true);
        // window.pack();
        // window.setVisible(true);
        //
        // button.setEnabled(false);
        String fileName = "D://" + num;
        BufferedImage image = webcam.getImage();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        boolean b = ImageIO.write(image, ImageUtils.FORMAT_PNG, out);
        byte[] cs = out.toByteArray();
        HttpResult face = FaceApiUtils.Face(cs);
        System.out.println(face);
        WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
        webcam.close();
        window.dispose();
        // SwingUtilities.invokeLater(new Runnable() {
        //
        // public void run() {
        // JOptionPane.showMessageDialog(null, "��ͼ�ɹ�");
        //// button.setEnabled(true);
        // num++;
        // return;
        // }
        // });

        // button.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // button.setEnabled(false);
        // String fileName = "D://" + num;
        // WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
        // SwingUtilities.invokeLater(new Runnable() {
        //
        // public void run() {
        // JOptionPane.showMessageDialog(null, "��ͼ�ɹ�");
        // button.setEnabled(true);
        // num++;
        // return;
        // }
        // });
        // }
        // });
    }
}
