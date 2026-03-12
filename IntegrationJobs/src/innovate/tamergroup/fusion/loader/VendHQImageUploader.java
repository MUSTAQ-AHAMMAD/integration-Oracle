package innovate.tamergroup.fusion.loader;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.SendEmailNotification;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.services.VendHQItemService;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;

public class VendHQImageUploader {
    public VendHQImageUploader() {
        super();
    }

    public static void main(String[] args) throws NamingException, IOException {
        SessionEJB session = EJBClientUtil.getSessionEJB();
        String region = "BH";
        SendEmailNotification emailNotify = new SendEmailNotification(350, region);
        VendhqCredentials vendParaCredentials = session.getVendHqCredentialByRegion(region);
        
        VendHQItemService itemService = new VendHQItemService(vendParaCredentials.getDomainName(), new Credential(vendParaCredentials.getPersonalToken()));
        String[] noIdItems = new String[0]; /*{"1010031161", "1010061173", "1010252226", "1020012112", "1020022113", "1020032116", "1020042123",
                                           "1020052124", "1020062125", "1020072135", "1020082136", "1020092137", "1020102140", "1020112147",
                                           "1020122148", "1020132149", "1020142152", "1020152159", "1020162160", "1020172161", "1020182162",
                                           "1020192163", "1020202164", "1020212165", "1020222166", "1020232167", "1020242168", "1020252169", 
                                           "1020262171", "1020272172", "1020282173", "1020292174", "1020302175", "1020312176", "1020322177",
                                           "1020332178", "1020342179", "1020352180", "1020362181", "1020372210", "1020382211", "1020532032",
                                           "1020542029", "1020902030", "1020912033", "1020921995", "1020941994", "1020952063", "1021022085",
                                           "1021031004", "1021082046", "1021092057", "1021141985", "1021152040", "1021281358", "1021901082",
                                           "1021911084", "1022271648", "1022281312", "1022291888", "1022322282", "1022381016", "1022391221",
                                           "1022442285", "1022451923", "1022502207", "1022512274", "1022651501", "1023271218", "1023282289",
                                           "1023641017", "1023652064", "1023661225", "1023692317", "1023761306", "1023811867", "1023821857",
                                           "1023881374", "1024021955", "1050112235"};*/
        List<String> noIdItemsList = Arrays.asList(noIdItems);
        
        File imagesfolder = new File("C:\\Users\\mmumer\\Downloads\\Pos Item Images New");
        File[] listOfFiles = imagesfolder.listFiles();  
        
        int count = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String itemNumber = file.getName().substring(0, file.getName().indexOf(" "));
                //if (!noIdItemsList.contains(itemNumber)) continue;
                System.out.println(itemNumber);
                String productId = session.getVendHQItemIDFromNumber(itemNumber, region);
                System.out.println(productId.isEmpty() ? "No Product ID" : productId);
                
                if (!productId.isEmpty()) {
                    int tries = 0;
                    while (tries < 5) {
                        try {
                            Boolean status = itemService.insertVendHQItemImage(file.getAbsolutePath(), productId);
                            System.out.println(status ? "Image Upload Success" : "Image Upload Failed");
                            if (status) {
                                emailNotify.addInfoLine("Item Image", "Image for Item#: " + itemNumber + " uploaded succesfully. Image Size: " + (file.length()/1024) + " KB");
                                break;
                            }
                            else if (tries == 4) 
                                emailNotify.addErrorLine("Item Image", "Image for Item#: " + itemNumber + " upload failed!");
                        } catch (Exception e) {
                            tries++;
                        }
                    }
                } else emailNotify.addErrorLine("Item Image", "Product ID for Item#: " + itemNumber + " not found!");
                System.out.println();
            }
            System.out.println("#: " + count++);
        }
        emailNotify.setSubject("Items Image Upload Results");
        emailNotify.execute();
    }
}
