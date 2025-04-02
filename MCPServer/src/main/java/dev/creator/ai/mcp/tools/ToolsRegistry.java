package dev.creator.ai.mcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class ToolsRegistry {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ToolsRegistry(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Tool(name = "get_customer_by_id", description = "Retrieve customer details for a given customer ID")
    public Map<String, Object> getCustomerById(int customerId) {
        try {
            Map<String, Object> customer = jdbcTemplate.queryForMap("select * from customers where customerNumber = :id", Map.of("id", customerId));
            System.out.println(customer);
            return customer;
        } catch (DataAccessException e) {
            return Map.of("error", e.getMessage());
        }
    }

    @Tool(name = "get_orders_by_customer_id", description = "Retrieve a list of orders placed by a specific customer ID")
    public List<?> getOrdersByCustomerId(int customerId) {
        List<?> customers = jdbcTemplate.queryForList("SELECT * FROM orders WHERE customerNumber = :customerId", Map.of("customerId", customerId));
        System.out.println(customers);
        return customers;
    }

    @Tool(name = "get_order_details_by_order_id", description = "Retrieve details of a specific order by order ID")
    public List<?> getOrderDetailsByOrderId(int orderId) {
        List<?> orders = jdbcTemplate.queryForList("SELECT * FROM orderdetails where orderNumber = :orderId", Map.of("orderId", orderId));
        System.out.println(orders);
        return orders;
    }

    @Tool(name = "get_payments_by_customer_id", description = "Retrieve payments made by a customer with given ID")
    public List<?> getPaymentsByCustomerId(int customerId) {
        List<?> payments = jdbcTemplate.queryForList("SELECT * FROM payments WHERE customerNumber = :customerId", Map.of("customerId", customerId));
        System.out.println(payments);
        return payments;
    }
}
