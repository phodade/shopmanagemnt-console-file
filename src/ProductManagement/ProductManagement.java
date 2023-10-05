package ProductManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagement{
	
	static ArrayList<Product> al=new ArrayList();
	
	public static void ProductManagement() throws IOException
	{
	loadDataFromFileToArrayList();
	
	   Scanner scanner=new Scanner(System.in);
				
	   boolean canIKeepRunningTheProgram=true;
				
	   while(canIKeepRunningTheProgram==true)
   	{
		System.out.println("WELCOME TO product MANAGEMENT");
		System.out.println("\n");
		System.out.println("WHAT WOULD YOU LIKE TO DO..?");
		System.out.println("1.Add product");
		System.out.println("2.search product");
		System.out.println("3.Deleteproduct");
		System.out.println("4.Edit product");
		System.out.println("5.Quit");
		

		int optionSelectedByproduct=scanner.nextInt();
		
		if(optionSelectedByproduct==ProductOptions.QUIT)
		{
		
		File file=new File("C:\\Users\\Pratiksha\\eclipse-workspace\\ProductManagement\\src\\ArrayListLearning\\product.txt");
		FileWriter fileWriter=new FileWriter(file,false);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		
		for(Product product:al)
		{
			bufferedWriter.write(product.Id+","+product.quality+","+","+product.price+","+product.name+","+product.catory+",");
		}
		
		bufferedWriter.close();
		fileWriter.close();
		file=null;
		
        System.out.println("PROGRAM CLOSED...!!!!");
		canIKeepRunningTheProgram=false;
		}
		else if(optionSelectedByproduct==ProductOptions.ADD_Product)
		{
			addproduct();
			System.out.println("\n");
			
		}
		else if(optionSelectedByproduct==ProductOptions.SEARCH_Product)
		{
			System.out.println("Enter The product Name To Serach : ");
			scanner.nextLine();
			String sn =scanner.nextLine();
			searchproduct(sn);
			System.out.println("\n");
			
		}
		else if(optionSelectedByproduct==ProductOptions.DELETE_Product)
		{
			System.out.println("Enter The product Name To delete : ");
			scanner.nextLine();
			String sn =scanner.nextLine();
			deleteproduct(sn);
			System.out.println("\n");
			
		}
		else if(optionSelectedByproduct==ProductOptions.EDIT_Product)
		{
			System.out.println("Enter The product Name To edit : ");
			scanner.nextLine();
			String editproductName =scanner.nextLine();
			editproduct(editproductName);
			System.out.println("\n");
			
		}
		
	}
	System.out.println("\n");
	System.out.println("AFTER WHILE LOOP");
	
	for(Product product:al)
	{
		System.out.println(product.Id);
		System.out.println(product.name);
		System.out.println(product.quality);
		System.out.println(product.catory);
		System.out.println(product.price);
	}
	
}

  public static void addproduct()
	{
		Scanner scanner=new Scanner(System.in);
		Product productObject=new Product();
		
		System.out.println("product Name:");
		productObject.name=scanner.nextLine();
		
		System.out.println("Catory :");
		productObject.catory=scanner.nextLine();
		
		System.out.println("Product Id:");
		productObject.Id=scanner.nextLine();
		
		System.out.println("Price");
		productObject.price=scanner.nextLine();
		
		System.out.println("Quality:");
		productObject.quality=scanner.nextLine();
		
		System.out.println("product Name:"+productObject.name);
		System.out.println("Product id:"+productObject.Id);
		System.out.println("Quality:"+productObject.quality);
		System.out.println("Price :"+productObject.price);
		System.out.println("Catory :"+productObject.catory);
		
		al.add(productObject);
	}

	public static void searchproduct(String ProductName)
	 {
		for(Product u : al)
		 {
			if(u.name.equalsIgnoreCase(ProductName))
			{
				System.out.println("product Name:"+u.name);
				System.out.println("Product Id:"+u.Id);
				System.out.println("Quality:"+u.quality);
				System.out.println("Price:"+u.price);
				System.out.println("Catory:"+u.catory);
				return;
			}
		}
		
		System.out.println("product Not Found");
	}

	public static void deleteproduct(String productName)
	{
		Iterator<Product>Iterator=al.iterator();
		
		while(Iterator.hasNext())
		{
			Product product=Iterator.next();
			if(product.name.equalsIgnoreCase(productName))
			{
				Iterator.remove();
				System.out.println("Product" + product.name+"has been deleted.");
				break;
			}
		}
		
	}
	
	public static void editproduct(String productName)
	{
		for(Product u : al)
		{
			if(u.name.equalsIgnoreCase(productName))
			{
		        Scanner scanner=new Scanner(System.in);
				System.out.println("Editing product :"+u.name);

				System.out.println("New product Name:");
				u.name=scanner.nextLine();
				
				System.out.println("New catory:");
				u.Id=scanner.nextLine();
				
				System.out.println("New price:");
				u.price=scanner.nextLine();
				
				System.out.println("New quality");
				u.catory=scanner.nextLine();
				
				System.out.println("New id :");
				u.quality=scanner.nextLine();
				
				
				System.out.println("product Information Updated");
				
				return;

			}
		}
		
		System.out.println("User not found");
	}
	
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file=new File("C:\\Users\\Pratiksha\\eclipse-workspace\\ProductManagement\\src\\ArrayListLearning\\product.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String Line="";
		while((Line= br.readLine())!=null)
		{
			Product product=new Product();
			String[] productDataArray=Line.split(",");
			
			if(productDataArray.length>3)
			{
				product.name=productDataArray[0];
				product.Id=productDataArray[1];
				product.price=productDataArray[2];
				product.quality=productDataArray[3];
				product.catory=productDataArray[4];
				
                al.add(product);
             }
		}
		 br.close();
		 fr.close();
		 file=null;
		 
	}
}
		
		

