//package com.mycompany.invoice.core.repository.database;
//
//import com.mycompany.invoice.core.entity.Invoice;
//import com.mycompany.invoice.core.repository.InvoiceRepositoryInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    private static List<Invoice> invoices = new ArrayList<>();
//
//    public Invoice create (Invoice invoice){
//        KeyHolder kh = new GeneratedKeyHolder();
//        // creation et récupération de la clé générée
//       jdbcTemplate.update(connection -> {
//           PreparedStatement ps = connection.prepareStatement("INSERT INTO INVOICE(CUSTOMER_NAME, ORDER_NUMBER) VALUES(?,?)",
//                   Statement.RETURN_GENERATED_KEYS);
//           // Valoriser les paramètres
//           ps.setString(1, invoice.getCustomerName());
//           ps.setString(2, invoice.getOrderNumber());
//           return ps;
//       },kh);
//
//       invoice.setNumber(kh.getKey().toString());
//       return invoice;
//    }
//
//    /**
//     * Methode qui permet de recupérer les informations de toutes les Invoices
//     * @methods jdbcTemplate.query(sql, rowMapping<>)
//     * @return Invoice[]
//     * */
//    @Override
//    public List<Invoice> list() {
//       return jdbcTemplate.query("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE",
//               (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("CUSTOMER_NAME")));
//    }
//
//    /**
//     * Methode qui permet de recupérer les informations d'une Invoice en particulier
//     * @params number : identifiant de la facture (Invoice) à récupérer
//     * @methods jdbcTemplate.queryForObject(sql, args, rowMapping<>)
//     * @return Invoice
//     * */
//    @Override
//    public Invoice getById(String number) {
//       return jdbcTemplate.queryForObject(
//               "SELECT INVOICE_NUMBER, CUSTOMER_NAME, ORDER_NUMBER FROM INVOICE WHERE INVOICE_NUMBER=?",
//               new Object[]{number},
//               (rs, rowNum) -> new Invoice(
//                       String.valueOf(rs.getLong("INVOICE_NUMBER")),
//                       rs.getString("CUSTOMER_NAME"),
//                       rs.getString("ORDER_NUMBER")
//               )
//       );
//    }
//}
