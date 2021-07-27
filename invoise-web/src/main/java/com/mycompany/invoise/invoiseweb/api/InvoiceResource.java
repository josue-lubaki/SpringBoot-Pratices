package com.mycompany.invoise.invoiseweb.api;

import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    /**
     * BindingResult : retourne les erreurs contenues dans le formulaire avec la methode hasErrors()
     * et BindingResult doit toujours être placé après le dernier @ModelAttribute si plusieurs
     * */
    @PostMapping()
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> list(){
        return invoiceService.getInvoiceList();
    }

    /**
     * Methode qui permet de retourner les informations d'une facture en particulier
     * @return String (ViewName)
     * */
    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        return invoiceService.getInvoiceByNumber(number);
    }

    /*@GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute("invoiceForm") InvoiceForm invoice){
        return "invoice-create-form";
    }*/

}
