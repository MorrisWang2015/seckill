import org.junit.Test;

public class testApplication {
    
    @Test
    public void test() {
        
        String sql = "SELECT\n" +
                "\tr.id,S1.OrderSN,\n" +
                "\tS1.PolicyNo,\n" +
                "\t( CASE WHEN s2.sparefield1 = 'PJ' THEN CONCAT( '-', CONVERT ( S2.totalAmount, DECIMAL ( 12, 2 ) ) ) ELSE CONVERT ( S2.totalAmount, DECIMAL ( 12, 2 ) ) END ) AS timePrem \n" +
                "FROM\n" +
                "\t( SDOrders S2, sdinformation i, SDInformationRiskType S1 )\n" +
                "\tLEFT JOIN sdreceipt r ON r.ordersn = S1.orderSn \n" +
                "WHERE\n" +
                "\ti.orderSn = s2.orderSn \n" +
                "\tAND S1.appstatus IN ( '1', '4' ) \n" +
                "\tAND S1.orderSn = S2.orderSn \n" +
                "\tAND s2.orderSn LIKE ? \n" +
                "\tAND S2.sparefield1 IN ( 'G', 'PZ', 'PJ', 'BG') \n" +
                "\tAND ( S2.isbatchtemp <> 3 OR S2.isbatchtemp IS NULL ) \n" +
                "\tAND ( r.receiptstatus IS NULL OR r.receiptstatus = '' OR  r.receiptstatus = '1') \n" +
                "GROUP BY\n" +
                "\tPolicyNo";
        
        System.out.println(sql);
        
    }
}
