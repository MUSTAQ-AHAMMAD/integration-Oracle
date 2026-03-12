package innovate.tamergroup.opencart.rest.services;

import innovate.tamergroup.opencart.rest.model.order.Order;
import innovate.tamergroup.opencart.rest.utils.FetchListOpencart;
import innovate.tamergroup.shared.utils.Credential;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class OpencartSalesService {
    
    private String domain;
    private Credential credential;


    public OpencartSalesService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }

    public List<Order> getOpencartSales (Date from, Date to) throws IOException {
        
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("filter_date_added_from", dateFormat.format(from));
        queryMap.put("filter_date_added_to", dateFormat.format(to));
        
        FetchListOpencart fetchVendHQList = new FetchListOpencart(domain, credential);
        List<Order> sales = fetchVendHQList.execute(Order.class, "order_admin", "listorderswithdetails", queryMap);
        
        return sales;
    }
    
    public static void main(String[] args) throws IOException, ParseException {
        OpencartSalesService salesService = new OpencartSalesService("saudi.ramaeg.net", new Credential("8Ni66uKnhyi6gUyGHkU2xfT7NwvI68kf"));
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -5);
        calendar.add(Calendar.DAY_OF_MONTH, 8);
        Date to = new Date(calendar.getTimeInMillis());
        //calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date from = new Date(calendar.getTimeInMillis());

        for (Order order : salesService.getOpencartSales(from, to)) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Order Date: " + order.getDateAdded());
            System.out.println("Subtotal: " + order.getSubtotal());
        }
    }
}
