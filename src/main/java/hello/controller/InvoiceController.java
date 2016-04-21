package hello.controller;


import hello.data.model.Invoices;
import hello.data.model.Users;
import hello.data.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InvoiceController {

    @Autowired
    Repository repository;

    @RequestMapping("/")
    @ResponseBody
    String home() {

        for (int i = 0; i < 10; i++) {
            Users user = new Users();
            user.setUsername("pesho"+i);
            user.setPassword("parola"+i);

            Users dbUser = this.repository.createUser(user);

            Invoices invoice = new Invoices();
            invoice.setUserId(dbUser.getId());

            this.repository.createInvoce(invoice);
        }



        return this.repository.getUserByInvoce(4).toString();
    }
}