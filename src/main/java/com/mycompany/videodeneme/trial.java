package com.mycompany.videodeneme;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.tess4j.*;
import org.opencv.highgui.*;
import org.opencv.core.*;
import org.opencv.imgproc.*;

public class trial {
    
    public static void main(String[] args) {
        
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        Mat destination = new Mat();
        Mat source = Highgui.imread("C:\\Users\\yasarcanc\\Desktop\\image\\odeonn.jpg");
        
        
        for (int i = 0; i < 4; i++) {
            
        destination= new Mat(source.rows(), source.cols(), source.type());
        Imgproc.GaussianBlur(source, destination, new Size(0,0), 10);
        Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
        
        Highgui.imwrite("C:\\Users\\yasarcanc\\Desktop\\image\\destinationImg.jpg", destination);
        source=destination;
        
        }
        
        Mat resultMat = new Mat();
        Imgproc.threshold(destination, resultMat, 55, 255, Imgproc.THRESH_BINARY);
        Highgui.imwrite("C:\\Users\\yasarcanc\\Desktop\\image\\resultImg.jpg", resultMat);
        
       
        
        
        
        
        
       
        String result = null;
        File imageFile = new File("C:\\Users\\yasarcanc\\Desktop\\image\\resultImg.jpg");
        
        Tesseract instance = new Tesseract();
        instance.setDatapath("C:\\Users\\yasarcanc\\Desktop\\Tess4J\\tessdata");
        
        try {
            result = instance.doOCR(imageFile);
        } catch (TesseractException ex) {
            Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        
        
    }
    
}
