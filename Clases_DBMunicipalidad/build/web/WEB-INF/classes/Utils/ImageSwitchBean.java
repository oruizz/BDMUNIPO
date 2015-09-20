package Utils;

import java.util.ArrayList;  
import java.util.List;  
  
public class ImageSwitchBean {  
  
    private List<String> images;  
  
    public ImageSwitchBean() {  
            }  
    public List<String> getImagesEmpresa() {  
        images = new ArrayList<String>();  
        images.add("muni-morropon4.jpg");  
        images.add("muni-morropon1.jpg");  
        images.add("muni-morropon2.jpg");  
        images.add("muni-morropon3.jpg");  
        images.add("muni-morropon5.jpg");  
        return images;  
    }  
}  