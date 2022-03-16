package com.jeetp.tp.servicesImpl;

import com.jeetp.tp.entities.Customer;
import com.jeetp.tp.entities.Item;
import com.jeetp.tp.entities.Order;
import com.jeetp.tp.entities.OrderDetail;
import com.jeetp.tp.repository.CustomerRepository;
import com.jeetp.tp.repository.OrderRepository;
import com.jeetp.tp.sevices.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    OrderRepository orderRepository;

    @Override
    public void getCustomerWithMaxOrders(){
        Page<Customer[]> customersWithMaxOrders = customerRepository.getCustomerWithMaxOrders(PageRequest.of(0,1));

        if(customersWithMaxOrders.getContent().size() <= 5) {
            Customer[] customers = customersWithMaxOrders.getContent().get(0) ;
            for (Customer customer : customers) {
                System.out.println("les 5 tops clients de l'application, selon le nombre de commandes \n" +
                         customer.getName()  );
            }
        }
    }

    @Override
    public void getHighestSpendingCustomers() {
        Page<Customer[]> HighestSpendingCustomers = customerRepository.getHighestSpendingCustomers(PageRequest.of(0,1));

        if(HighestSpendingCustomers.getContent().size() <= 5) {
            Customer[] customers = HighestSpendingCustomers.getContent().get(0) ;
            for (Customer customer : customers) {
                System.out.println("les 5 tops clients de l'application, selon le montant d'argent dépensé \n" +
                        customer.getName()  );
            }
        }
    }

    @Override
    public void getCustomersWithMoreThan10kgOrders() {
        Page<Customer[]> customersWithMoreThan10kgOrders = customerRepository.getCustomersWithMoreThan10kgOrders(PageRequest.of(0,1));

        if(customersWithMoreThan10kgOrders.getContent().size() > 0) {
            Customer[] customers = customersWithMoreThan10kgOrders.getContent().get(0) ;
            for (Customer customer : customers) {
                System.out.println("Afficher les clients qui ont demandé des ordres dont dépassent le 10 kg " + customer.getName()  );
            }
        }
    }
}
