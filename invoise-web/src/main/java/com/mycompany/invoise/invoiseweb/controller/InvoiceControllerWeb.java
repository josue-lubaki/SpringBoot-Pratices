package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoice.core.controller.InvoiceControllerInterface;
import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }


    public void createInvoice(){

        Scanner scan = new Scanner(System.in);
        String customerName = "Tesla";

        // instancier la facture et y inscrire le nom du client
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);
    }

    @RequestMapping("/home")
    public ModelAndView displayHome(){
        System.out.println("La methode display home a été invoqué");
        ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices", invoiceService.getInvoiceList());
        return mv;
    }

    /**
     * Methode qui permet de retourner les informations d'une facture en particulier
     * @return String (ViewName)
     * */
    @RequestMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La methode display Invoice a été invoqué");
        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
        return "invoice-details";
    }

}
