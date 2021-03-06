package no.ntnu.bildur.model;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;


/**
 * Responsible for creating and writing photo albums as a PDF document.<br>
 * Uses library from https://itextpdf.com/
 */
public class ExportPDF {

    /**
     * Constructor of ExportPDF.
     */
    public ExportPDF(){
    }

    /**
     * Takes in a list of image URL and adds the images the URL is pointing at to a pdf document.
     *
     * @param imageURL List of URLs to add.
     * @param outputDir the folder to place the created PDF.
     * @throws FileNotFoundException Cant find the file of the URL.
     * @throws MalformedURLException A malformed URL has occurred.
     */
    public void exportListToPDF(List<String> imageURL, String outputDir)
            throws FileNotFoundException, MalformedURLException {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outputDir + "/MyAlbum.pdf"));
        Document document = new Document(pdfDocument);

        for (String pictureURL : imageURL){
            ImageData imageData = ImageDataFactory.create(pictureURL);
            Image image = new Image(imageData);
            image.setWidth(pdfDocument.getDefaultPageSize().getWidth() - 50);
            image.setAutoScaleHeight(true);
            document.add(image);
        }
        pdfDocument.close();
    }


}