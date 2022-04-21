package codes.dirty.nego.negoweb.module.member.controller;

import codes.dirty.nego.negoweb.common.PurchaseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    public ProductController (){
    }

    @GetMapping(value = "/product/list")
    public @ResponseBody
    String productList(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Product List</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/product/buy\" method=\"post\">\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"purchaseQuantity\">구매수량</label>\n" +
                "            <input type=\"text\" id=\"purchaseQuantity\" name=\"purchaseQuantity\" value=\"1\">\n" +
                "        </div>\n" +
                "        <button type=\"submit\">구매</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    @PostMapping(value = "/product/buy")
    public ResponseEntity buy(PurchaseForm form) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long delay = 0;
        for (int i = 0; i < 10000; i++){
            for (int j = 0; j < 1000000; j++){
                delay += 1;
            }
        }
        System.out.println("Success purchasing");

        return ResponseEntity.ok("Success your purchasing : " + form.getPurchaseQuantity() + "개\n"+ (System.currentTimeMillis()-startTime)+"ms 지연 " + delay);
    }

    @GetMapping(value = "/product/success")
    public @ResponseBody
    String successPurchasing(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Product List</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <form action=\"/product/buy\" method=\"post\">\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"memberId\">구매수량</label>\n" +
                "            <input type=\"text\" id=\"purchaseQuantity\" name=\"purchaseQuantity\" value=\"1\">\n" +
                "        </div>\n" +
                "        <button type=\"submit\">구매</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
