/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hack_36_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;

/**
 *
 * @author asus
 */
public class BookMark_Index {
    
    public static ArrayList<Item> list=new ArrayList<>();
    
    BookMark_Index()
    {
        
    }
    
    public static PDDocument document=null;
    public static void getallindex(String path)
    {
        try {
            document = PDDocument.load(new File(path));
            PDDocumentOutline outline =  document.getDocumentCatalog().getDocumentOutline();
            printBookmark(outline, "");
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(BookMark_Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void printBookmark(PDOutlineNode bookmark, String indentation) throws IOException
    {
        PDOutlineItem current = bookmark.getFirstChild();
        while (current != null)
        {
            System.out.println(indentation + current.getTitle());
            PDPage currentPage = current.findDestinationPage(document);
        
            Integer pageNumber = document.getDocumentCatalog().getPages().indexOf(currentPage) + 1;
            System.out.println(pageNumber);
            printBookmark(current, indentation + "    ");
        
            storeinlist(pageNumber,current.getTitle());
            current = current.getNextSibling();
        }
    }
    
    private static void storeinlist(int pageNumber,String Title)
    {
        
        list.add(new Item(pageNumber,Title));
    }
    
    public static Item getpreviouspage(int page)
    {
        Item previous=null;
        for(int i=0;i<list.size();i++)
        {
            Item item=list.get(i);
            int pagenumber=item.getKey();
            String title=item.getTitle();
             
         //   System.out.println(pagenumber);
          //  System.out.println(title);
            
            if(pagenumber>page)
            {
                if(i>0)
                {
                    return previous;
                }
            }
            
            previous=item;
        }
        
        return previous;
    }
    
    
}
