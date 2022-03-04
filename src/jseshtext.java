/**
 * How to use JSesh to create bitmaps in Java.
 * compile: javac -cp .:/FOLDER_CONTAINING/jsesh.jar TestJSeshBitmap.java
 * run: java -cp .:/FOLDER_CONTAINING/jsesh.jar TestJSeshBitmap
 * 
 * jseshGlyphs.jar and jvectClipboard-1.0.jar should be in the same folder as jsesh.jar.
 * (normally, there is no need to add them explicitely to the class path , as jsesh.jar contains the necessary 
 * information in its manifest.
 */

import java.awt.image.* ;
import java.io.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import jsesh.mdc.*;
import jsesh.mdcDisplayer.draw.*;
import jsesh.mdcDisplayer.preferences.*;

public class jseshtext {
    public static BufferedImage buildImage(String mdcText) throws MDCSyntaxError {
        // Create the drawing system:                
        MDCDrawingFacade drawing = new MDCDrawingFacade();
        
        // Override JSesh's max size parameter to something absurdly huge
        // so that images don't crop arbitrarily at 2000 pixels wide
        // - christiancasey 04-03-2022
        drawing.setMaxSize(500000,10000); 
        
        // Change the scale, choosing the cadrat height in pixels.
        drawing.setCadratHeight(60);
        // Change a number of parameters 
        DrawingSpecification drawingSpecifications = new DrawingSpecificationsImplementation();
        PageLayout pageLayout= new PageLayout();
        pageLayout.setLeftMargin(5);
        pageLayout.setTopMargin(5);
        drawingSpecifications.setPageLayout(pageLayout);
        drawing.setDrawingSpecifications(drawingSpecifications);
        // Create the picture 
       BufferedImage result = drawing.createImage(mdcText);
       return result;
    }

    static String stripExtension (String str) {
          if (str == null) return null;
          int pos = str.lastIndexOf(".");
          if (pos == -1) return str;
          return str.substring(0, pos);
    }

	public static void main(String args[]) throws MDCSyntaxError, IOException {
		File folder = new File("text");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()){
				if (listOfFiles[i].getName().endsWith(".txt")) {
                    String filename = stripExtension(listOfFiles[i].getName());
				  	File filepng = new File("text/"+filename+".png");
				  	if(!filepng.exists()) { 
						System.out.println("Engraving hieroglyph: text/"+filename+".png");
						DataInputStream dis = new DataInputStream (new FileInputStream ("text/"+filename+".txt"));
						byte[] datainBytes = new byte[dis.available()];
						dis.readFully(datainBytes);
						dis.close();
						String content = new String(datainBytes, 0, datainBytes.length);
	         			BufferedImage img= buildImage(content);
	         			File f = new File("text/"+filename+".png");
	         			ImageIO.write(img, "png", f);
					}
				}
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}
}
