import java.util.ArrayList;

public class ReceiptContext 
{
     private ReceiptStrategy receiptStrategy;
     
     public ReceiptContext(ReceiptStrategy receiptStrategy)
     {
    	 this.receiptStrategy = receiptStrategy;
     }
     
     public void executeStrategy()
     {
    	 receiptStrategy.printReceipt();
     }
}
