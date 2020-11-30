import java.util.Scanner;

public class Showroom {
    static double total=0;
    static int sk[]= {0,15,10,20};	
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("WELCOME TO SHOWROOM");		
       int choice;
       while(true) 
      {  
      System.out.println(); 	   
	  System.out.println("1.For Customer Data");
	  System.out.println("2.For Enquiry");
	  System.out.println("3.For Billing");
	  System.out.println("4.Add Stock");
	  System.out.println("5.Exit");
	  System.out.print("Your Choice:");
	   
	   Customer cstmr=new Customer();
	   Enquiry eqy=new Enquiry();
	   Billing blg=new Billing();
	   Stock stk=new Stock();
	   
	   choice=sc.nextInt();
	  if(choice==1) {
		  cstmr.cstSection();   
	  }
	  else if(choice==2) {
		 eqy.enquSection();
	  }
       else if(choice==3) {  
 		  blg.blingSection();
	  }
       else if(choice==4) {
    	   stk.StckSection();
	  }
       else if(choice==5) {
    	   System.out.println("\nThank you for Visiting. Have a nice day...");
    	   break;
	  }   	  
       else {
    	   System.out.println("Wrong Entry try again...");
       }
   }
   sc.close();    
 }
}

class Customer{
	Scanner sc=new Scanner(System.in);
	String cName;
	String cbikeN;
	static int cstNo;
	Customer cstmr[];
	Customer(){
           cstNo=-1;
           cstmr=new Customer[50]; 
    }
    Customer(String cstmn,String bkn){
      cName=cstmn;
      cbikeN=bkn;
    }
	void view() {
		System.out.println("  Customer name"+"            Bike name");
		System.out.println("   Ajit Jadhav"+"              Pulsar");
		System.out.println("   Akshay Patil"+"             Shine");
		
		for(int i=0;i<=cstNo;i++) {
			 System.out.print("   ");
			  System.out.format("%-20s     %-20s",cstmr[i].cName,cstmr[i].cbikeN);
			  System.out.println();
			 }
	  }
	
	void add() {
		   cstNo=cstNo+1;
	       System.out.print("Enter customer name:");
                   String cstmn=sc.nextLine();	
		   System.out.print("Enter customer bike name:");
		           String bkn=sc.nextLine();
	           cstmr[cstNo]=new Customer(cstmn,bkn);
		   System.out.println("Data added Successfully");
	}
	void cstSection(){
                 Customer cst=new Customer();
		while(true) 
	      {   System.out.println(); 	
	    	  System.out.println("1.View Customer Details");
	    	  System.out.println("2.Add Customer Details");
	    	  System.out.println("3.Exit");
	    	  System.out.print("Your Choice:");
	    	  int cstchoice=sc.nextInt();
	    	  if(cstchoice==1) {
	    		  cst.view(); }
	    	  else if(cstchoice==2) {
	    		  cst.add(); }
	    	  else if(cstchoice==3) {
	    		  break;     }
	    	  else {
	        	   System.out.println("Wrong Entry try again...");}
	      }
	}
}

class Enquiry{
	Scanner sc=new Scanner(System.in);
	    int SrNo[]=    {1,2,3,4};
	    String Nm[]=   {"Shine ","Unicorn","Pulsar","Discover"};
	    String clr[]=  {" White","Black"," Black","Blue"};
	    int Ecap[]=    {150,160,180,125};
	    String Dbk[]=  {"Yes","Yes","Yes","No "};
        double price[]={105000.0,130000.0,110000.0,100000.0};
       
        void viewAll() {
            System.out.println("No   Name       Colour    E.Capa(cc)  Disc break   Price         Stock");
            	for(int i=0;i<4;i++) {
      System.out.println(SrNo[i]+"   "+Nm[i]+"      "+clr[i]+"        "+Ecap[i]+"       "+Dbk[i]+"        "+price[i]+"        "+Showroom.sk[i]);
            	}
            }
     
        void pwise() {//105000.0,130000.0,110000.0,100000.0
        	int min=0;
        	int max=0;
        		
        		for(int i=0,j=0;i<4;i++,j++) {
        		    if(price[i]<price[min]) {
        			  min=i;
        		    }
        		    if(price[j]>price[max]) {
          			  max=j;
          		    }
        	     }  

        	System.out.println("Bike with max price:");
        	for(int i=max;i<=max;i++) {
   System.out.println("No   Name        Colour    E.Capa(cc)  Disc break   Price         Stock");     		
   System.out.println(SrNo[i]+"   "+Nm[i]+"      "+clr[i]+"        "+Ecap[i]+"       "+Dbk[i]+"        "+price[i]+"        "+Showroom.sk[i]);
   
        	}
        	
        	System.out.println("Bike with min price:");
        	for(int i=min;i<=min;i++) {
  System.out.println("No   Name        Colour    E.Capa(cc)  Disc break   Price         Stock");      		
  System.out.println(SrNo[i]+"   "+Nm[i]+"      "+clr[i]+"        "+Ecap[i]+"       "+Dbk[i]+"        "+price[i]+"        "+Showroom.sk[i]);
             }
        }
        
	void enquSection() {
                Enquiry enq=new Enquiry();
		while(true) 
	      {   System.out.println();
	          System.out.println("1.To see list");
	          System.out.println("2.To see max & min bike price");
	    	  System.out.println("3.Exit");
	    	  System.out.print("Your Choice:");
	    	  int enqchoice=sc.nextInt();
	    	  if(enqchoice==1) {
	    		  enq.viewAll(); }
	    	  else if(enqchoice==2) {
	    		  enq.pwise(); }
	    	  
	    	  else if(enqchoice==3) {
	    		  break;          }
	    	  else {
	        	   System.out.println("Wrong Entry try again..."); }
	      }
	}
}
class Billing{ 
	Enquiry enqry;
	Scanner sc=new Scanner(System.in);
	static double amount;
	Billing(){                                                    
             enqry=new Enquiry();            
        }
	void blingSection(){
		while(true) 
      { 
	      System.out.println("\nPlease select bike");
	      System.out.println("1.Shine   2.Unicorn  3.Pulsar   4.Discover  5.Exit");
	      System.out.print("Your choice:");
	      int opt=sc.nextInt();
	        if((opt==1||opt==2||opt==3||opt==4 ) && Showroom.sk[opt-1]>=1 ) 	                                        
	    	{
	        	 System.out.println("Bike: "+enqry.Nm[opt-1]+"    Price="+enqry.price[opt-1]);
	             System.out.print("Enter payment amount:");
	             amount=sc.nextInt();
	        		    if(amount==enqry.price[opt-1]) {
	        			  Showroom.total=Showroom.total+amount;
                          Showroom.sk[opt-1]=Showroom.sk[opt-1]-1; //to delete pertical stock depend of option
	        			  System.out.println("Payment Successful");
	        			  System.out.println("You will get your bike at dispatch section.Thank You");
	        		    }
	        		    else {
	        			  System.out.println("Payment not Successful.Please pay full amount.");
	        		    }
	         }              
	         else if((opt==1||opt==2||opt==3||opt==4 ) && Showroom.sk[opt-1]<1 ) {
	        		System.out.println("Bike not available in stock");
	         	}
	         else if(opt==5) { 
       		                    break;
       		  }
       	     else {
	        	   System.out.println("Wrong Entry try again...");   
	          } 
	    }  
	}
}
class Stock{
	int nwstk;
	Scanner sc=new Scanner(System.in);   
	void StckSection() {
		while(true) 
	      {   System.out.println(); 
	          System.out.println("Add stock For"); 
	    	  System.out.println("1.Shine 2.unicorn 3.pulsar 4.Discover  5.Exit");
	    	  System.out.print("Your Choice:");
	    	  int sel=sc.nextInt();
	    	  
	          if(sel>=1 && sel<=4) {
	        	  System.out.print("Enter stock that you want to add:");
		          nwstk=sc.nextInt();
	        	  Showroom.sk[sel-1]=Showroom.sk[sel-1]+nwstk;
	        	  }
	          
	         if(sel==1) {System.out.println("\nbike:Shine     New Stock:"+Showroom.sk[sel-1]);} 	    
	    else if(sel==2) {System.out.println("\nbike:Unicorn   New Stock:"+Showroom.sk[sel-1]);}
	    else if(sel==3) {System.out.println("\nbike:Pulsar    New Stock:"+Showroom.sk[sel-1]);} 
	    else if(sel==4) {System.out.println("\nbike:Discover  New Stock:"+Showroom.sk[sel-1]);} 
	    else if(sel==5) {break;} 
	    else {System.out.println("Wrong Entry try again...");  }
	      }       
	}
}
