package bitirmejava;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class bitirmepro {
static int bir,iki,uc,dort,bes,alti,yedi,sekiz,dokuz,on,onbir,oniki,onuc,ondort,onbes,onalti,onyedi,onsekiz,ondokuz,yirmi,yirmibir,yirmiiki,yirmiuc,yirmidort,yirmibes,yirmialti,yirmiyedi,yirmisekiz,yirmidokuz,otuz;
static String birlestir="";
static String siralikarakter="";
static int ttt_sayisi=0;
static int ttg_sayisi=0;
static int ttc_sayisi=0;
	public static void main(String[] args) throws IOException {
		mutasyonbul();
		
		//arraylist();
	/*	 String text = "";
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Bir Metin Giriniz ");
	        text = reader.readLine();
	 
	        SuffixArray suffixarray = new SuffixArray(text);
	        suffixarray.createSuffixArray();
	*/
	}
	
	
	
	public static int satirgetirveri(){
		int sayac=0;
		String str="";
		
		
		try{
			FileInputStream fStream = new FileInputStream("veri.TXT");
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader  bReader = new BufferedReader(new InputStreamReader(dStream));
			
			while((str=bReader.readLine()) != null ){
				if(!(str.isEmpty())  && str.charAt(0)!='>'){
					sayac++;	
				}
			}
			dStream.close();
		}catch(Exception e){
			System.err.println("Hata :  " + e.getMessage());
		}
		
		return sayac;
	}
	
	public static void mutasyonbul(){
		int ss=satirgetirveri();
		System.out.println(ss);
		String str="";
		String dene="ATCACGACTTTCTGGAGACGCCGGTTCAGCTCCGGGTTGG";
	
		
		
		ArrayList<String> normal= new ArrayList<String>();  
		ArrayList<String> mutasyon= new ArrayList<String>();
		int sayac=0;
		try{
			FileInputStream fStream = new FileInputStream("veri.TXT");
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader  bReader = new BufferedReader(new InputStreamReader(dStream));
			while((str=bReader.readLine()) != null){
				
				if(!(str.isEmpty())  && str.charAt(0)!='>'){
				
					switch(sayac){
					case 1 :
						normal.add(str.trim());
						break;
					case 2 :
						
						mutasyon.add(str.trim());
						break;
					}
					}
					else if(str.charAt(0)=='>'){
						sayac++;
					}
			}
			
			dStream.close();
		}catch(Exception e){
			System.err.println("Hata :  " + e.getMessage());
		}
		
		sayac=0;
		int random_index[]=new int[200000];
		try{
			FileInputStream fStream = new FileInputStream("index.TXT");
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader  bReader = new BufferedReader(new InputStreamReader(dStream));
			for(int i=0;i<200000;i++){
				str=bReader.readLine();
				random_index[i]=Integer.parseInt(str);
			}
			dStream.close();
		}catch(Exception e){
			System.err.println("Hata :  " + e.getMessage());
		}
	
		//System.out.println("---"+random_index[199999]);
		
		for(int i=0;i<normal.size();i+=20){
			
			if(i+20>normal.size()){
				
				for( int j=i;j<normal.size();j++){
					birlestir+=normal.get(j);
				//	System.out.println(j);
				}
				break;
			}
			//System.out.println(i);
			
			birlestir+=normal.get(i).concat(normal.get(i+1)).concat(normal.get(i+2)).concat(normal.get(i+3)).concat(normal.get(i+4)).concat(normal.get(i+5)).concat(normal.get(i+6)).concat(normal.get(i+7)).concat(normal.get(i+8)).concat(normal.get(i+9)).concat(normal.get(i+10)).concat(normal.get(i+11)).concat(normal.get(i+12)).concat(normal.get(i+13)).concat(normal.get(i+14)).concat(normal.get(i+15)).concat(normal.get(i+16)).concat(normal.get(i+17)).concat(normal.get(i+18)).concat(normal.get(i+19));
			
			
		}
		// VERÝ ÝÇERÝSÝNDEKÝ BÝRBÝRÝNDEN FARKLI KARAKTERLERÝ BUL
		    int index[]=new int[birlestir.length()];
	        for(int i=0;i<birlestir.length();i++){// -200 den küçük suffix ele
	        	index[i]=i;
	        }
	        String karakter="w";
	        for(int i=0;i<birlestir.length();i++){
	        	boolean bool=true;
	        	for(int j=0;j<karakter.length();j++){
	        	if(birlestir.charAt(i)==karakter.charAt(j)){
	        		//karakter=karakter+text.charAt(i);
	        		bool=false;
	        	}
	        	}
	        	if(bool==true){
	        		//bool=false;
	        		karakter=karakter+birlestir.charAt(i);
	        	}
	        }
	        
	        
	        karakter=karakter.substring(1, karakter.length());
	        //BÝRBÝRÝNDEN FARKLI KARAKTERLERÝ BUL SON
	      //BUNLARI SIRAYA KOY
	        
	        int index2[]=new int[karakter.length()];
	        for(int i=0;i<karakter.length();i++){
	        	index2[i]=i;
	        }
	        
	        
	        int temp;
	        boolean bool = false;    
	        while(bool==false){
	     	   bool=true;
	         for(int i=0;i<karakter.length()-1;i++){
	         	if(karakter.substring(index2[i], karakter.length()).charAt(0)>karakter.substring(index2[i+1], karakter.length()).charAt(0)){
	         		temp=index2[i+1];
	         		index2[i+1]=index2[i];
	         		index2[i]=temp;
	         		bool=false;
	         	}
	         	}
	         }
	        for(int i=0;i<karakter.length();i++){
	        	siralikarakter+=karakter.substring(index2[i], karakter.length()).charAt(0);
	        	
	        }
	        
	        System.out.println("-----"+siralikarakter);
	        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        //BUNLARI SIRAYA KOY SON
	        // SUFFÝX ÝNDEXLERÝNÝ SIRALA
	        int temp2=0;
	        int neresi=0;    
	        int sinir[] = new int[5];
	        sinir[0]=0;
	        int sinirindex=0;
	        	char cotrol=siralikarakter.charAt(0); 
	         
	        	for(int k=0;k<siralikarakter.length();k++){
	        		cotrol=siralikarakter.charAt(k);
	        		
	        	for(int i=0;i<birlestir.length();i++){
		    if(birlestir.charAt(index[i])==cotrol){
			   temp2=index[i];
	   		   index[i]=index[neresi];
	   		   index[neresi]=temp2;
	   		   neresi++;
		      }         
	         }
	        	sinir[++sinirindex]=neresi;
	        	}
	        	sinir[4]=neresi-1;
	        	neresi=0;
	        	temp2=0;
	        	for(int m=0;m<sinir.length-1;m++){
	        	for(int k=0;k<siralikarakter.length();k++){
	        		cotrol=siralikarakter.charAt(k);
	        	for(int i=sinir[m];i<sinir[m+1];i++){
	        		if((index[i])!=birlestir.length()-1)
	        		if(birlestir.charAt(index[i]+1)==cotrol){
	        			 temp2=index[i];
	        	   		   index[i]=index[neresi];
	        	   		   index[neresi]=temp2;
	        	   		   neresi++;
	        		}
	        	}
	        	//System.out.println(neresi);
	        	}
	        	}
	        	///////////////////////////////////////////////////////7
	        	//3. karakter siralamasi
	        	
	        	neresi=0;
	        	temp2=0;
	        	
	        	
	        	for(int m=0;m<sinir.length-1;m++){
	        	for(int i=sinir[m];i<sinir[m+1];i++){
	        		
	        		if(index.length-index[i]>3)
	        		if(birlestir.charAt(index[i]+1)==siralikarakter.charAt(0)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(0)){
	        			   temp2=index[i];
	        	   		   index[i]=index[neresi];
	        	   		   index[neresi]=temp2;
	        	   		   neresi++;
	        		}
	        	}
	        	
	        	neresi=sinir[m+1];
	           	temp2=0;
	        	}
	        	// baslama indexleri bul.................
	        	
	        	int sinir3[] = new int[4];
	        	for(int j=0;j<siralikarakter.length();j++){
	        		for(int i=0;i<index.length;i++){
	        			if(index.length-index[i]>3)
	                		if(birlestir.charAt(index[i])==siralikarakter.charAt(j)&&birlestir.charAt(index[i]+1)==siralikarakter.charAt(0)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(0)){
	                			
	                			sinir3[j]=i;
	                			break;
	                		}
	        			
	        		}
	        	}
	        	
	        	
	        	int sinir4[] = new int[4];
	        	for(int j=0;j<siralikarakter.length();j++){
	        		for (int k=0;k<siralikarakter.length();k++){
	        		for(int i=0;i<index.length;i++){
	        			if(index.length-index[i]>3)
	                		if(birlestir.charAt(index[i])==siralikarakter.charAt(j)&&birlestir.charAt(index[i]+1)==siralikarakter.charAt(0)&&birlestir.charAt(index[i]+2)!=siralikarakter.charAt(0)){
	                			
	                			sinir4[j]=i;
	                			break;
	                		}
	        			
	        		}
	        	}
	        	}
	        	int sinir5index= -1;
	        	int sinir5[] = new int[12];
	        	for(int j=0;j<siralikarakter.length();j++){
	        		for (int k=1;k<siralikarakter.length();k++){
	        		for(int i=0;i<index.length;i++){
	        			if(index.length-index[i]>3)
	                		if(birlestir.charAt(index[i])==siralikarakter.charAt(j)&&birlestir.charAt(index[i]+1)==siralikarakter.charAt(k)){
	                			
	                			sinir5[++sinir5index]=i;
	                			break;
	                		}
	        			
	        		}
	        	}
	        	}
	        	// ttt siralamasi
	         ttt_sayisi=0;
	        	for(int i=sinir5[10];i<index.length;i++){
	        		if(index.length-index[i]>3){
	            	if(birlestir.charAt(index[i]+1)==siralikarakter.charAt(3)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(3))
	            		ttt_sayisi++;
	        		if(birlestir.charAt(index[i]+1)==siralikarakter.charAt(3)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(2))
        				ttg_sayisi++;
        			if(birlestir.charAt(index[i]+1)==siralikarakter.charAt(3)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(1))
            			ttc_sayisi++;
	        		}
	        	}
	        	neresi=index.length-1;
	        	temp2=0;
	        	sayac=0;
	        	for(int i=sinir5[10];i<index.length;i++){
	        		
	        		if(index.length-index[i]>3)
	        		if(birlestir.charAt(index[i]+1)==siralikarakter.charAt(3)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(3)){
	        			 
	        			if(sayac==ttt_sayisi)
	        				  break;
	        			   temp2=index[i];
	        	   		   index[i]=index[neresi];
	        	   		   index[neresi]=temp2;
	        	   		   neresi--;
	        	   		   sayac++;
	        	   		   i--;
	        		}
	        	}
	        	ttt_sayisi=neresi+1;
	        	neresi=ttt_sayisi-1;
	        	temp2=0;
	        	sayac=0;
	        	for(int i=sinir5[10];i<neresi;i++){
	        		
	        		if(index.length-index[i]>3)
	        		if(birlestir.charAt(index[i]+1)==siralikarakter.charAt(3)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(2)){
	        			 
	        			if(sayac==ttg_sayisi)
	        				  break;
	        			   temp2=index[i];
	        	   		   index[i]=index[neresi];
	        	   		   index[neresi]=temp2;
	        	   		   neresi--;
	        	   		   sayac++;
	        	   		   i--;
	        		}
	        	}
	        	ttg_sayisi=neresi;
	        	
	        	neresi=ttg_sayisi;
	        	temp2=0;
	        	sayac=0;
	        	for(int i=sinir5[10];i<neresi;i++){
	        		
	        		if(index.length-index[i]>3)
	        		if(birlestir.charAt(index[i]+1)==siralikarakter.charAt(3)&&birlestir.charAt(index[i]+2)==siralikarakter.charAt(1)){
	        			 
	        			if(sayac==ttc_sayisi)
	        				  break;
	        			   temp2=index[i];
	        	   		   index[i]=index[neresi];
	        	   		   index[neresi]=temp2;
	        	   		   neresi--;
	        	   		   sayac++;
	        	   		   i--;
	        		}
	        	}
	        	ttc_sayisi=neresi;
	        //	System.out.println(birlestir.charAt(index[ttt_sayisi-2]));
	        //	System.out.println(birlestir.charAt(index[ttt_sayisi-2]+1));
	        //	System.out.println(birlestir.charAt(index[ttt_sayisi-2]+2));


	        //	System.out.println(birlestir.charAt(index[3015859]));
	         	//System.out.println(birlestir.substring(index[1000002], birlestir.length()).charAt(0)+"  "+index[1000002]);
	         
	        //SUFFÝX ÝNDEXLERÝNÝ SIRALA SON
	        	//MUTASYON BUL THR
	        	/*
	        	  System.out.println("basla");
	        	for(int k=0;k<100;k++){
	        		int basla=0;
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(0)){
	        			basla=sinir4[0];
	        			if(mutasyon.get(k).charAt(2)==siralikarakter.charAt(0))
	        				basla=sinir3[0];
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(1)){
	        			basla=sinir5[0];//292209;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(2)){
	        			basla=sinir5[1];//515147;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(3)){
	        			basla=sinir5[2];//718797;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(0)){
	        			basla=sinir4[1]; //986854;
	        			if(mutasyon.get(k).charAt(2)==siralikarakter.charAt(0))
	        				basla=sinir3[1];
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(1)){
	        			basla=sinir5[3];//1269418;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(2)){
	        			basla=sinir5[4];//1505613;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(3)){
	        			basla=sinir5[5];//1803549;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(0)){
	        			basla=sinir4[2];//2007501;
	        			if(mutasyon.get(k).charAt(2)==siralikarakter.charAt(0))
	        				basla=sinir3[2];
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(1)){
	        			basla=sinir5[6];//2236352;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(2)){
	        			basla=sinir5[7];//2566927;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(3)){
	        			basla=sinir5[8];//2797091;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(0)){
	        			basla=sinir4[3];//3015857;
	        			if(mutasyon.get(k).charAt(2)==siralikarakter.charAt(0))
	        				basla=sinir3[3];
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(1)){
	        			basla=sinir5[9];//3199086;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(2)){
	        			basla=sinir5[10];//3430025;
	        		}
	        		if(mutasyon.get(k).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(k).charAt(1)==siralikarakter.charAt(3)){
	        			basla=sinir5[11];//3706632;
	        			if(mutasyon.get(k).charAt(2)==siralikarakter.charAt(3))
	        				basla=ttt_sayisi;
	        			if(mutasyon.get(k).charAt(2)==siralikarakter.charAt(2))
	        				basla=ttg_sayisi;
	        			if(mutasyon.get(k).charAt(2)==siralikarakter.charAt(1))
	        				basla=ttc_sayisi;
	        		}
	        		
	        	 int sayi=0;
	         	 for(int i=basla;i<index.length;i++){
	             	int esit_karakter_sayisi=0;
	             	if(birlestir.length()-index[i]>=mutasyon.get(k).length())
	             	for(int j=0;j<mutasyon.get(k).length();j++){
	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(k).charAt(j)){
	             		esit_karakter_sayisi++;
	             	}
	             	}
	             	if(esit_karakter_sayisi==mutasyon.get(k).length()){
	             		// System.out.println(index[i]);
	             		sayi++;
	             		 break;
	             	}
	             	if((esit_karakter_sayisi>=mutasyon.get(k).length()-3)&&(index[i]==random_index[k])){  //
	             		 System.out.println(index[i]);
	             		 int konum=0;
	             		 for(int m=0;m<200;m++){
	             			 if(mutasyon.get(k).charAt(m)!=birlestir.charAt(index[i]+m)){
	             				konum=m;	             	
	             				break;
	             			 }
	             		 }
	             		 System.out.println("-"+ mutasyon.get(k).substring(konum,konum+30)+"   mutasyonlu");	             		 
	             		 System.out.println("*"+birlestir.substring(index[i]+konum,index[i]+konum+30)+"      "+ (index[i]/200+3)+".satýr"+"   "+((index[i]/200+1))+".sekens");
	             		 
	             		 sayi++;	         
	             		 break;
	             	}	             		             	             	
	         	 }
	         	if(sayi==0){
	         		int konum=0;
            		 for(int m=0;m<200;m++){
            			 if(mutasyon.get(k).charAt(m)!=birlestir.charAt(random_index[k]+m)){
            				konum=m;	             	
            				break;
            			 }
            		 }
	         		 System.out.println("cerceve kaymasý var");
	         		 System.out.println("-"+ mutasyon.get(k).substring(konum,konum+30)+"   mutasyonlu");
            		 System.out.println("*"+birlestir.substring(random_index[k]+konum,random_index[k]+konum+30)+"      "+ (random_index[k]/200+3)+".satýr"+"   "+((random_index[k]/200+1))+".sekens");
            		 
	         		
	         	//	System.out.println(index[shift]);
	         	//	System.out.println(birlestir.substring(random_index[k], random_index[k]+30));
	         	//	System.out.println( mutasyon.get(k));
	         	}
	        	}
	        	*/
	        	//--------------------------------------------------------------------------
	        	//ÝKÝLÝ SUFFÝX SON
	        	/*        	
	        	for(int k=0;k<500;k++){
	        		int basla=0;
	        		if(mutasyon.get(k).charAt(0)=='C'){
	        			basla=986854;
	        		}
	        		if(mutasyon.get(k).charAt(0)=='G'){
	        			basla=2007501;
	        		}
	        		if(mutasyon.get(k).charAt(0)=='T'){
	        			basla=3015858;  //KONTROL ET
	        		}
	         	 for(int i=basla;i<index.length;i++){
	             	int esit_karakter_sayisi=0;
	             	if(birlestir.length()-index[i]>=mutasyon.get(k).length())
	             	for(int j=0;j<mutasyon.get(k).length();j++){
	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(k).charAt(j)){
	             		esit_karakter_sayisi++;
	             	}
	             	}
	             	if(esit_karakter_sayisi==mutasyon.get(k).length()){
	             		// System.out.println(index[i]);
	             		 break;
	             	}
	             	if(esit_karakter_sayisi==mutasyon.get(k).length()-1){
	             		 System.out.println(index[i]);
	            // 		 System.out.println(mutasyon.get(k));
	            // 		for(int s=0;s<200;s++)
	            // 		System.out.print(birlestir.charAt(index[i]+s));

	             		 break;
	             	}
	             }
	        
	        	}
	        */
	        	System.out.println("basla");
	        	
	        	Thread t1=new Thread(){
	              	public void run(){
	              		
	              		karnel ( 0 , mutasyon, index, random_index, sinir3, sinir4, sinir5,0,200);
	              		/*
	              		for(bir=0;bir<400;bir++){
	    	        		int basla=0;
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[0];
	    	        			if(mutasyon.get(bir).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[0];
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[0];//292209;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[1];//515147;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[2];//718797;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[1]; //986854;
	    	        			if(mutasyon.get(bir).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[1];
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[3];//1269418;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[4];//1505613;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[5];//1803549;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[2];//2007501;
	    	        			if(mutasyon.get(bir).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[2];
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[6];//2236352;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[7];//2566927;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[8];//2797091;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[3];//3015857;
	    	        			if(mutasyon.get(bir).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[3];
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[9];//3199086;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[10];//3430025;
	    	        		}
	    	        		if(mutasyon.get(bir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bir).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[11];//3706632;
	    	        			if(mutasyon.get(bir).charAt(2)==siralikarakter.charAt(3))
	    	        				basla=ttt_sayisi;
	    	        			if(mutasyon.get(bir).charAt(2)==siralikarakter.charAt(2))
	    	        				basla=ttg_sayisi;
	    	        			if(mutasyon.get(bir).charAt(2)==siralikarakter.charAt(1))
	    	        				basla=ttc_sayisi;
	    	        		}	    	            	        		    	        			    	        		
	    	        		int sayi=0;
	    		         	 for(int i=basla;i<index.length;i++){
	    		             	int esit_karakter_sayisi=0;
	    		             	if(birlestir.length()-index[i]>=mutasyon.get(bir).length())
	    		             	for(int j=0;j<mutasyon.get(bir).length();j++){
	    		             	if(birlestir.charAt(index[i]+j)==mutasyon.get(bir).charAt(j)){
	    		             		esit_karakter_sayisi++;
	    		             	}
	    		             	}
	    		             	if(esit_karakter_sayisi==mutasyon.get(bir).length()){
	    		             		// System.out.println(index[i]);
	    		             		sayi++;
	    		             		 break;
	    		             	}
	    		             	if((esit_karakter_sayisi>=mutasyon.get(bir).length()-3)&&(index[i]==random_index[bir])){  //
	    		             		 System.out.println(index[i]);
	    		             		 int konum=0;
	    		             		 for(int m=0;m<200;m++){
	    		             			 if(mutasyon.get(bir).charAt(m)!=birlestir.charAt(index[i]+m)){
	    		             				konum=m;	             	
	    		             				break;
	    		             			 }
	    		             		 }
	    		             		 System.out.println("-"+ mutasyon.get(bir).substring(konum,konum+30)+"   mutasyonlu");	             		 
	    		             		 System.out.println("*"+birlestir.substring(index[i]+konum,index[i]+konum+30)+"      "+ (index[i]/200+3)+".satýr"+"   "+((index[i]/200+1))+".sekens");
	    		             		 
	    		             		 sayi++;	         
	    		             		 break;
	    		             	}	             		             	             	
	    		         	 }
	    		         	if(sayi==0){
	    		         		int konum=0;
	    	            		 for(int m=0;m<200;m++){
	    	            			 if(mutasyon.get(bir).charAt(m)!=birlestir.charAt(random_index[bir]+m)){
	    	            				konum=m;	             	
	    	            				break;
	    	            			 }
	    	            		 }
	    		         		 System.out.println("cerceve kaymasý var");
	    		         		 System.out.println("-"+ mutasyon.get(bir).substring(konum,konum+30)+"   mutasyonlu");
	    	            		 System.out.println("*"+birlestir.substring(random_index[bir]+konum,random_index[bir]+konum+30)+"      "+ (random_index[bir]/200+3)+".satýr"+"   "+((random_index[bir]/200+1))+".sekens");	    	            		 	    		         			    		         	
	    		         
	    		         	}	              			              			              			 	              			 	              		
	              		}
	              		*/
	              	}
	              };
	              
	              Thread t2=new Thread(){
	              	public void run(){
	              		karnel ( 1 , mutasyon, index, random_index, sinir3, sinir4, sinir5,200,400);
	              		
	              		/*
	              		for(iki=400;iki<800;iki++){
	              		
	    	        		int basla=0;
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[0];
	    	        			if(mutasyon.get(iki).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[0];
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[0];//292209;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[1];//515147;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[2];//718797;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[1]; //986854;
	    	        			if(mutasyon.get(iki).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[1];
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[3];//1269418;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[4];//1505613;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[5];//1803549;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[2];//2007501;
	    	        			if(mutasyon.get(iki).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[2];
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[6];//2236352;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[7];//2566927;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[8];//2797091;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(0)){
	    	        			basla=sinir4[3];//3015857;
	    	        			if(mutasyon.get(iki).charAt(2)==siralikarakter.charAt(0))
	    	        				basla=sinir3[3];
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(1)){
	    	        			basla=sinir5[9];//3199086;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(2)){
	    	        			basla=sinir5[10];//3430025;
	    	        		}
	    	        		if(mutasyon.get(iki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(iki).charAt(1)==siralikarakter.charAt(3)){
	    	        			basla=sinir5[11];//3706632;
	    	        			if(mutasyon.get(iki).charAt(2)==siralikarakter.charAt(3))
	    	        				basla=ttt_sayisi;
	    	        			if(mutasyon.get(iki).charAt(2)==siralikarakter.charAt(2))
	    	        				basla=ttg_sayisi;
	    	        			if(mutasyon.get(iki).charAt(2)==siralikarakter.charAt(1))
	    	        				basla=ttc_sayisi;
	    	        		}
	              			 for(int i=basla;i<index.length;i++){
	         	             	int esit_karakter_sayisi=0;
	         	             	if(birlestir.length()-index[i]>=mutasyon.get(iki).length())
	         	             	for(int j=0;j<mutasyon.get(iki).length();j++){
	         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(iki).charAt(j)){
	         	             		esit_karakter_sayisi++;
	         	             	}
	         	             	}
	         	             	if(esit_karakter_sayisi==mutasyon.get(iki).length()){
	         	             		// System.out.println(index[i]);
	         	             		 break;
	         	             	}
	         	             	if(esit_karakter_sayisi==mutasyon.get(iki).length()-1&&(index[i]==random_index[iki])){
		       	             		 System.out.println(index[i]);
		       	             		 break;
		         	             		}
	         	             }
	              		}
	              */
	              	}
	              
	              };
	              Thread t3=new Thread(){
		              	public void run(){
		              		karnel ( 2 , mutasyon, index, random_index, sinir3, sinir4, sinir5,400,600);
		              		/*
		              		for(uc=800;uc<1200;uc++){
		              		
		    	        		int basla=0;
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(0)){
		    	        			basla=sinir4[0];
		    	        			if(mutasyon.get(uc).charAt(2)==siralikarakter.charAt(0))
		    	        				basla=sinir3[0];
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(1)){
		    	        			basla=sinir5[0];//292209;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(2)){
		    	        			basla=sinir5[1];//515147;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(3)){
		    	        			basla=sinir5[2];//718797;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(0)){
		    	        			basla=sinir4[1]; //986854;
		    	        			if(mutasyon.get(uc).charAt(2)==siralikarakter.charAt(0))
		    	        				basla=sinir3[1];
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(1)){
		    	        			basla=sinir5[3];//1269418;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(2)){
		    	        			basla=sinir5[4];//1505613;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(3)){
		    	        			basla=sinir5[5];//1803549;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(0)){
		    	        			basla=sinir4[2];//2007501;
		    	        			if(mutasyon.get(uc).charAt(2)==siralikarakter.charAt(0))
		    	        				basla=sinir3[2];
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(1)){
		    	        			basla=sinir5[6];//2236352;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(2)){
		    	        			basla=sinir5[7];//2566927;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(3)){
		    	        			basla=sinir5[8];//2797091;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(0)){
		    	        			basla=sinir4[3];//3015857;
		    	        			if(mutasyon.get(uc).charAt(2)==siralikarakter.charAt(0))
		    	        				basla=sinir3[3];
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(1)){
		    	        			basla=sinir5[9];//3199086;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(2)){
		    	        			basla=sinir5[10];//3430025;
		    	        		}
		    	        		if(mutasyon.get(uc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(uc).charAt(1)==siralikarakter.charAt(3)){
		    	        			basla=sinir5[11];//3706632;
		    	        			if(mutasyon.get(uc).charAt(2)==siralikarakter.charAt(3))
		    	        				basla=ttt_sayisi;
		    	        			if(mutasyon.get(uc).charAt(2)==siralikarakter.charAt(2))
		    	        				basla=ttg_sayisi;
		    	        			if(mutasyon.get(uc).charAt(2)==siralikarakter.charAt(1))
		    	        				basla=ttc_sayisi;
		    	        		}
		              			 for(int i=basla;i<index.length;i++){
		         	             	int esit_karakter_sayisi=0;
		         	             	if(birlestir.length()-index[i]>=mutasyon.get(uc).length())
		         	             	for(int j=0;j<mutasyon.get(uc).length();j++){
		         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(uc).charAt(j)){
		         	             		esit_karakter_sayisi++;
		         	             	}
		         	             	}
		         	             	if(esit_karakter_sayisi==mutasyon.get(uc).length()){
		         	             		// System.out.println(index[i]);
		         	             		 break;
		         	             	}
		         	             	if(esit_karakter_sayisi==mutasyon.get(uc).length()-1&&(index[i]==random_index[uc])){
			       	             		 System.out.println(index[i]);
			       	             		 break;
			         	             		}
		         	             }
		              		}
		              		
		              		*/
		              	}
		              };
		              Thread t4=new Thread(){
			              	public void run(){
			              		
			              		karnel ( 3 , mutasyon, index, random_index, sinir3, sinir4, sinir5,600,800);		              		
			              		
			              		/*
			              		for(dort=1200;dort<1600;dort++){
			              			
			    	        		int basla=0;
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(0)){
			    	        			basla=sinir4[0];
			    	        			if(mutasyon.get(dort).charAt(2)==siralikarakter.charAt(0))
			    	        				basla=sinir3[0];
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(1)){
			    	        			basla=sinir5[0];//292209;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(2)){
			    	        			basla=sinir5[1];//515147;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(3)){
			    	        			basla=sinir5[2];//718797;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(0)){
			    	        			basla=sinir4[1]; //986854;
			    	        			if(mutasyon.get(dort).charAt(2)==siralikarakter.charAt(0))
			    	        				basla=sinir3[1];
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(1)){
			    	        			basla=sinir5[3];//1269418;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(2)){
			    	        			basla=sinir5[4];//1505613;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(3)){
			    	        			basla=sinir5[5];//1803549;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(0)){
			    	        			basla=sinir4[2];//2007501;
			    	        			if(mutasyon.get(dort).charAt(2)==siralikarakter.charAt(0))
			    	        				basla=sinir3[2];
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(1)){
			    	        			basla=sinir5[6];//2236352;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(2)){
			    	        			basla=sinir5[7];//2566927;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(3)){
			    	        			basla=sinir5[8];//2797091;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(0)){
			    	        			basla=sinir4[3];//3015857;
			    	        			if(mutasyon.get(dort).charAt(2)==siralikarakter.charAt(0))
			    	        				basla=sinir3[3];
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(1)){
			    	        			basla=sinir5[9];//3199086;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(2)){
			    	        			basla=sinir5[10];//3430025;
			    	        		}
			    	        		if(mutasyon.get(dort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dort).charAt(1)==siralikarakter.charAt(3)){
			    	        			basla=sinir5[11];//3706632;
			    	        			if(mutasyon.get(dort).charAt(2)==siralikarakter.charAt(3))
			    	        				basla=ttt_sayisi;
			    	        			if(mutasyon.get(dort).charAt(2)==siralikarakter.charAt(2))
			    	        				basla=ttg_sayisi;
			    	        			if(mutasyon.get(dort).charAt(2)==siralikarakter.charAt(1))
			    	        				basla=ttc_sayisi;
			    	        		}
			              			 for(int i=basla;i<index.length;i++){
			         	             	int esit_karakter_sayisi=0;
			         	             	if(birlestir.length()-index[i]>=mutasyon.get(dort).length())
			         	             	for(int j=0;j<mutasyon.get(dort).length();j++){
			         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(dort).charAt(j)){
			         	             		esit_karakter_sayisi++;
			         	             	}
			         	             	}
			         	             	if(esit_karakter_sayisi==mutasyon.get(dort).length()){
			         	             		// System.out.println(index[i]);
			         	             		 break;
			         	             	}
			         	             	if(esit_karakter_sayisi==mutasyon.get(dort).length()-1&&(index[i]==random_index[dort])){
				       	             		 System.out.println(index[i]);
				       	             		 break;
				         	             		}
			         	             }
			              		}
			              		*/
			              	}
			              };
			              Thread t5=new Thread(){
				              	public void run(){
				              		
				              		karnel ( 4 , mutasyon, index, random_index, sinir3, sinir4, sinir5,800,1000);
				              		
				              		/*
				              		for(bes=1600;bes<2000;bes++){
				              		
				    	        		int basla=0;
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(0)){
				    	        			basla=sinir4[0];
				    	        			if(mutasyon.get(bes).charAt(2)==siralikarakter.charAt(0))
				    	        				basla=sinir3[0];
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(1)){
				    	        			basla=sinir5[0];//292209;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(2)){
				    	        			basla=sinir5[1];//515147;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(3)){
				    	        			basla=sinir5[2];//718797;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(0)){
				    	        			basla=sinir4[1]; //986854;
				    	        			if(mutasyon.get(bes).charAt(2)==siralikarakter.charAt(0))
				    	        				basla=sinir3[1];
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(1)){
				    	        			basla=sinir5[3];//1269418;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(2)){
				    	        			basla=sinir5[4];//1505613;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(3)){
				    	        			basla=sinir5[5];//1803549;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(0)){
				    	        			basla=sinir4[2];//2007501;
				    	        			if(mutasyon.get(bes).charAt(2)==siralikarakter.charAt(0))
				    	        				basla=sinir3[2];
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(1)){
				    	        			basla=sinir5[6];//2236352;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(2)){
				    	        			basla=sinir5[7];//2566927;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(3)){
				    	        			basla=sinir5[8];//2797091;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(0)){
				    	        			basla=sinir4[3];//3015857;
				    	        			if(mutasyon.get(bes).charAt(2)==siralikarakter.charAt(0))
				    	        				basla=sinir3[3];
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(1)){
				    	        			basla=sinir5[9];//3199086;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(2)){
				    	        			basla=sinir5[10];//3430025;
				    	        		}
				    	        		if(mutasyon.get(bes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(bes).charAt(1)==siralikarakter.charAt(3)){
				    	        			basla=sinir5[11];//3706632;
				    	        			if(mutasyon.get(bes).charAt(2)==siralikarakter.charAt(3))
				    	        				basla=ttt_sayisi;
				    	        			if(mutasyon.get(bes).charAt(2)==siralikarakter.charAt(2))
				    	        				basla=ttg_sayisi;
				    	        			if(mutasyon.get(bes).charAt(2)==siralikarakter.charAt(1))
				    	        				basla=ttc_sayisi;
				    	        		}
				              			 for(int i=basla;i<index.length;i++){
				         	             	int esit_karakter_sayisi=0;
				         	             	if(birlestir.length()-index[i]>=mutasyon.get(bes).length())
				         	             	for(int j=0;j<mutasyon.get(bes).length();j++){
				         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(bes).charAt(j)){
				         	             		esit_karakter_sayisi++;
				         	             	}
				         	             	}
				         	             	if(esit_karakter_sayisi==mutasyon.get(bes).length()){
				         	             		// System.out.println(index[i]);
				         	             		 break;
				         	             	}
				         	             	if(esit_karakter_sayisi==mutasyon.get(bes).length()-1&&(index[i]==random_index[bes])){
					       	             		 System.out.println(index[i]);
					       	             		 break;
					         	             		}
				         	             }
				              		}
				              		
				              		*/
				              	}
				              };
				              Thread t6=new Thread(){
					              	public void run(){
					              		
					              	karnel ( 5 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1000,1200);

					              		
					              		/*
					              		for(alti=2000;alti<2400;alti++){
					              			
					    	        		int basla=0;
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(0)){
					    	        			basla=sinir4[0];
					    	        			if(mutasyon.get(alti).charAt(2)==siralikarakter.charAt(0))
					    	        				basla=sinir3[0];
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(1)){
					    	        			basla=sinir5[0];//292209;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(2)){
					    	        			basla=sinir5[1];//515147;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(3)){
					    	        			basla=sinir5[2];//718797;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(0)){
					    	        			basla=sinir4[1]; //986854;
					    	        			if(mutasyon.get(alti).charAt(2)==siralikarakter.charAt(0))
					    	        				basla=sinir3[1];
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(1)){
					    	        			basla=sinir5[3];//1269418;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(2)){
					    	        			basla=sinir5[4];//1505613;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(3)){
					    	        			basla=sinir5[5];//1803549;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(0)){
					    	        			basla=sinir4[2];//2007501;
					    	        			if(mutasyon.get(alti).charAt(2)==siralikarakter.charAt(0))
					    	        				basla=sinir3[2];
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(1)){
					    	        			basla=sinir5[6];//2236352;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(2)){
					    	        			basla=sinir5[7];//2566927;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(3)){
					    	        			basla=sinir5[8];//2797091;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(0)){
					    	        			basla=sinir4[3];//3015857;
					    	        			if(mutasyon.get(alti).charAt(2)==siralikarakter.charAt(0))
					    	        				basla=sinir3[3];
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(1)){
					    	        			basla=sinir5[9];//3199086;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(2)){
					    	        			basla=sinir5[10];//3430025;
					    	        		}
					    	        		if(mutasyon.get(alti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(alti).charAt(1)==siralikarakter.charAt(3)){
					    	        			basla=sinir5[11];//3706632;
					    	        			if(mutasyon.get(alti).charAt(2)==siralikarakter.charAt(3))
					    	        				basla=ttt_sayisi;
					    	        			if(mutasyon.get(alti).charAt(2)==siralikarakter.charAt(2))
					    	        				basla=ttg_sayisi;
					    	        			if(mutasyon.get(alti).charAt(2)==siralikarakter.charAt(1))
					    	        				basla=ttc_sayisi;
					    	        		}
					              			 for(int i=basla;i<index.length;i++){
					         	             	int esit_karakter_sayisi=0;
					         	             	if(birlestir.length()-index[i]>=mutasyon.get(alti).length())
					         	             	for(int j=0;j<mutasyon.get(alti).length();j++){
					         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(alti).charAt(j)){
					         	             		esit_karakter_sayisi++;
					         	             	}
					         	             	}
					         	             	if(esit_karakter_sayisi==mutasyon.get(alti).length()){
					         	             		// System.out.println(index[i]);
					         	             		 break;
					         	             	}
					         	             	if(esit_karakter_sayisi==mutasyon.get(alti).length()-1&&(index[i]==random_index[alti])){
						       	             		 System.out.println(index[i]);
						       	             		 break;
						         	             		}
					         	             }
					              		}
					              	*/	
					              	}
					              };
					              Thread t7=new Thread(){
						              	public void run(){
						              		
						              		karnel ( 6 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1200,1400);
						              		
						              		/*
						              		for(yedi=2400;yedi<2800;yedi++){
						              		
						    	        		int basla=0;
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(0)){
						    	        			basla=sinir4[0];
						    	        			if(mutasyon.get(yedi).charAt(2)==siralikarakter.charAt(0))
						    	        				basla=sinir3[0];
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(1)){
						    	        			basla=sinir5[0];//292209;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(2)){
						    	        			basla=sinir5[1];//515147;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(3)){
						    	        			basla=sinir5[2];//718797;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(0)){
						    	        			basla=sinir4[1]; //986854;
						    	        			if(mutasyon.get(yedi).charAt(2)==siralikarakter.charAt(0))
						    	        				basla=sinir3[1];
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(1)){
						    	        			basla=sinir5[3];//1269418;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(2)){
						    	        			basla=sinir5[4];//1505613;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(3)){
						    	        			basla=sinir5[5];//1803549;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(0)){
						    	        			basla=sinir4[2];//2007501;
						    	        			if(mutasyon.get(yedi).charAt(2)==siralikarakter.charAt(0))
						    	        				basla=sinir3[2];
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(1)){
						    	        			basla=sinir5[6];//2236352;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(2)){
						    	        			basla=sinir5[7];//2566927;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(3)){
						    	        			basla=sinir5[8];//2797091;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(0)){
						    	        			basla=sinir4[3];//3015857;
						    	        			if(mutasyon.get(yedi).charAt(2)==siralikarakter.charAt(0))
						    	        				basla=sinir3[3];
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(1)){
						    	        			basla=sinir5[9];//3199086;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(2)){
						    	        			basla=sinir5[10];//3430025;
						    	        		}
						    	        		if(mutasyon.get(yedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yedi).charAt(1)==siralikarakter.charAt(3)){
						    	        			basla=sinir5[11];//3706632;
						    	        			if(mutasyon.get(yedi).charAt(2)==siralikarakter.charAt(3))
						    	        				basla=ttt_sayisi;
						    	        			if(mutasyon.get(yedi).charAt(2)==siralikarakter.charAt(2))
						    	        				basla=ttg_sayisi;
						    	        			if(mutasyon.get(yedi).charAt(2)==siralikarakter.charAt(1))
						    	        				basla=ttc_sayisi;
						    	        		}
						              			 for(int i=basla;i<index.length;i++){
						         	             	int esit_karakter_sayisi=0;
						         	             	if(birlestir.length()-index[i]>=mutasyon.get(yedi).length())
						         	             	for(int j=0;j<mutasyon.get(yedi).length();j++){
						         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yedi).charAt(j)){
						         	             		esit_karakter_sayisi++;
						         	             	}
						         	             	}
						         	             	if(esit_karakter_sayisi==mutasyon.get(yedi).length()){
						         	             		// System.out.println(index[i]);
						         	             		 break;
						         	             	}
						         	             	if(esit_karakter_sayisi==mutasyon.get(yedi).length()-1&&(index[i]==random_index[yedi])){
							       	             		 System.out.println(index[i]);
							       	             		 break;
							         	             		}
						         	             }
						              		}
						              		*/
						              	}
						              };
						              Thread t8=new Thread(){
							              	public void run(){
							              		
							              		karnel ( 7 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1400,1600);
							              		/*
							              		for(sekiz=2800;sekiz<3200;sekiz++){
							              			
							    	        		int basla=0;
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(0)){
							    	        			basla=sinir4[0];
							    	        			if(mutasyon.get(sekiz).charAt(2)==siralikarakter.charAt(0))
							    	        				basla=sinir3[0];
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(1)){
							    	        			basla=sinir5[0];//292209;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(2)){
							    	        			basla=sinir5[1];//515147;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(3)){
							    	        			basla=sinir5[2];//718797;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(0)){
							    	        			basla=sinir4[1]; //986854;
							    	        			if(mutasyon.get(sekiz).charAt(2)==siralikarakter.charAt(0))
							    	        				basla=sinir3[1];
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(1)){
							    	        			basla=sinir5[3];//1269418;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(2)){
							    	        			basla=sinir5[4];//1505613;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(3)){
							    	        			basla=sinir5[5];//1803549;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(0)){
							    	        			basla=sinir4[2];//2007501;
							    	        			if(mutasyon.get(sekiz).charAt(2)==siralikarakter.charAt(0))
							    	        				basla=sinir3[2];
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(1)){
							    	        			basla=sinir5[6];//2236352;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(2)){
							    	        			basla=sinir5[7];//2566927;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(3)){
							    	        			basla=sinir5[8];//2797091;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(0)){
							    	        			basla=sinir4[3];//3015857;
							    	        			if(mutasyon.get(sekiz).charAt(2)==siralikarakter.charAt(0))
							    	        				basla=sinir3[3];
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(1)){
							    	        			basla=sinir5[9];//3199086;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(2)){
							    	        			basla=sinir5[10];//3430025;
							    	        		}
							    	        		if(mutasyon.get(sekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(sekiz).charAt(1)==siralikarakter.charAt(3)){
							    	        			basla=sinir5[11];//3706632;
							    	        			if(mutasyon.get(sekiz).charAt(2)==siralikarakter.charAt(3))
							    	        				basla=ttt_sayisi;
							    	        			if(mutasyon.get(sekiz).charAt(2)==siralikarakter.charAt(2))
							    	        				basla=ttg_sayisi;
							    	        			if(mutasyon.get(sekiz).charAt(2)==siralikarakter.charAt(1))
							    	        				basla=ttc_sayisi;
							    	        		}
							              			 for(int i=basla;i<index.length;i++){
							         	             	int esit_karakter_sayisi=0;
							         	             	if(birlestir.length()-index[i]>=mutasyon.get(sekiz).length())
							         	             	for(int j=0;j<mutasyon.get(sekiz).length();j++){
							         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(sekiz).charAt(j)){
							         	             		esit_karakter_sayisi++;
							         	             	}
							         	             	}
							         	             	if(esit_karakter_sayisi==mutasyon.get(sekiz).length()){
							         	             		// System.out.println(index[i]);
							         	             		 break;
							         	             	}
							         	             	if(esit_karakter_sayisi==mutasyon.get(sekiz).length()-1&&(index[i]==random_index[sekiz])){
								       	             		 System.out.println(index[i]);
								       	             		 break;
								         	             		}
							         	             }
							              		}
							              		*/
							              	}
							              };
							              Thread t9=new Thread(){
								              	public void run(){
								              		
								              	karnel ( 8 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1600,1800);
								              		
								              		/*
								              		for(dokuz=3200;dokuz<3600;dokuz++){
								              			
								    	        		int basla=0;
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(0)){
								    	        			basla=sinir4[0];
								    	        			if(mutasyon.get(dokuz).charAt(2)==siralikarakter.charAt(0))
								    	        				basla=sinir3[0];
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(1)){
								    	        			basla=sinir5[0];//292209;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(2)){
								    	        			basla=sinir5[1];//515147;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(3)){
								    	        			basla=sinir5[2];//718797;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(0)){
								    	        			basla=sinir4[1]; //986854;
								    	        			if(mutasyon.get(dokuz).charAt(2)==siralikarakter.charAt(0))
								    	        				basla=sinir3[1];
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(1)){
								    	        			basla=sinir5[3];//1269418;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(2)){
								    	        			basla=sinir5[4];//1505613;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(3)){
								    	        			basla=sinir5[5];//1803549;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(0)){
								    	        			basla=sinir4[2];//2007501;
								    	        			if(mutasyon.get(dokuz).charAt(2)==siralikarakter.charAt(0))
								    	        				basla=sinir3[2];
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(1)){
								    	        			basla=sinir5[6];//2236352;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(2)){
								    	        			basla=sinir5[7];//2566927;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(3)){
								    	        			basla=sinir5[8];//2797091;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(0)){
								    	        			basla=sinir4[3];//3015857;
								    	        			if(mutasyon.get(dokuz).charAt(2)==siralikarakter.charAt(0))
								    	        				basla=sinir3[3];
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(1)){
								    	        			basla=sinir5[9];//3199086;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(2)){
								    	        			basla=sinir5[10];//3430025;
								    	        		}
								    	        		if(mutasyon.get(dokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(dokuz).charAt(1)==siralikarakter.charAt(3)){
								    	        			basla=sinir5[11];//3706632;
								    	        			if(mutasyon.get(dokuz).charAt(2)==siralikarakter.charAt(3))
								    	        				basla=ttt_sayisi;
								    	        			if(mutasyon.get(dokuz).charAt(2)==siralikarakter.charAt(2))
								    	        				basla=ttg_sayisi;
								    	        			if(mutasyon.get(dokuz).charAt(2)==siralikarakter.charAt(1))
								    	        				basla=ttc_sayisi;
								    	        		}
								              			 for(int i=basla;i<index.length;i++){
								         	             	int esit_karakter_sayisi=0;
								         	             	if(birlestir.length()-index[i]>=mutasyon.get(dokuz).length())
								         	             	for(int j=0;j<mutasyon.get(dokuz).length();j++){
								         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(dokuz).charAt(j)){
								         	             		esit_karakter_sayisi++;
								         	             	}
								         	             	}
								         	             	if(esit_karakter_sayisi==mutasyon.get(dokuz).length()){
								         	             		// System.out.println(index[i]);
								         	             		 break;
								         	             	}
								         	             	if(esit_karakter_sayisi==mutasyon.get(dokuz).length()-1&&(index[i]==random_index[dokuz])){
									       	             		 System.out.println(index[i]);
									       	             		 break;
									         	             		}
								         	             }
								              		}
								              		*/
								              	}
								              };
								              Thread t10=new Thread(){
									              	public void run(){
									              		
									              	karnel ( 9 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1800,2000);
									              		
									              		/*
									              		for(on=3600;on<4000;on++){
									              			
									    	        		int basla=0;
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(0)){
									    	        			basla=sinir4[0];
									    	        			if(mutasyon.get(on).charAt(2)==siralikarakter.charAt(0))
									    	        				basla=sinir3[0];
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(1)){
									    	        			basla=sinir5[0];//292209;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(2)){
									    	        			basla=sinir5[1];//515147;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(3)){
									    	        			basla=sinir5[2];//718797;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(0)){
									    	        			basla=sinir4[1]; //986854;
									    	        			if(mutasyon.get(on).charAt(2)==siralikarakter.charAt(0))
									    	        				basla=sinir3[1];
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(1)){
									    	        			basla=sinir5[3];//1269418;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(2)){
									    	        			basla=sinir5[4];//1505613;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(3)){
									    	        			basla=sinir5[5];//1803549;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(0)){
									    	        			basla=sinir4[2];//2007501;
									    	        			if(mutasyon.get(on).charAt(2)==siralikarakter.charAt(0))
									    	        				basla=sinir3[2];
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(1)){
									    	        			basla=sinir5[6];//2236352;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(2)){
									    	        			basla=sinir5[7];//2566927;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(3)){
									    	        			basla=sinir5[8];//2797091;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(0)){
									    	        			basla=sinir4[3];//3015857;
									    	        			if(mutasyon.get(on).charAt(2)==siralikarakter.charAt(0))
									    	        				basla=sinir3[3];
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(1)){
									    	        			basla=sinir5[9];//3199086;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(2)){
									    	        			basla=sinir5[10];//3430025;
									    	        		}
									    	        		if(mutasyon.get(on).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(on).charAt(1)==siralikarakter.charAt(3)){
									    	        			basla=sinir5[11];//3706632;
									    	        			if(mutasyon.get(on).charAt(2)==siralikarakter.charAt(3))
									    	        				basla=ttt_sayisi;
									    	        			if(mutasyon.get(on).charAt(2)==siralikarakter.charAt(2))
									    	        				basla=ttg_sayisi;
									    	        			if(mutasyon.get(on).charAt(2)==siralikarakter.charAt(1))
									    	        				basla=ttc_sayisi;
									    	        		}
									              			 for(int i=basla;i<index.length;i++){
									         	             	int esit_karakter_sayisi=0;
									         	             	if(birlestir.length()-index[i]>=mutasyon.get(on).length())
									         	             	for(int j=0;j<mutasyon.get(on).length();j++){
									         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(on).charAt(j)){
									         	             		esit_karakter_sayisi++;
									         	             	}
									         	             	}
									         	             	if(esit_karakter_sayisi==mutasyon.get(on).length()){
									         	             		// System.out.println(index[i]);
									         	             		 break;
									         	             	}
									         	             	if(esit_karakter_sayisi==mutasyon.get(on).length()-1&&(index[i]==random_index[on])){
										       	             		 System.out.println(index[i]);
										       	             		 break;
										         	             		}
									         	             }
									              		}
									              		*/
									              	}
									              };
									              Thread t11=new Thread(){
										              	public void run(){
										              	karnel ( 10 , mutasyon, index, random_index, sinir3, sinir4, sinir5,4000,4400);
										              		/*
										              		for(onbir=4000;onbir<4400;onbir++){
										              		
										    	        		int basla=0;
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[0];
										    	        			if(mutasyon.get(onbir).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[0];
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[0];//292209;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[1];//515147;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[2];//718797;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[1]; //986854;
										    	        			if(mutasyon.get(onbir).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[1];
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[3];//1269418;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[4];//1505613;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[5];//1803549;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[2];//2007501;
										    	        			if(mutasyon.get(onbir).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[2];
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[6];//2236352;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[7];//2566927;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[8];//2797091;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[3];//3015857;
										    	        			if(mutasyon.get(onbir).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[3];
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[9];//3199086;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[10];//3430025;
										    	        		}
										    	        		if(mutasyon.get(onbir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbir).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[11];//3706632;
										    	        			if(mutasyon.get(onbir).charAt(2)==siralikarakter.charAt(3))
										    	        				basla=ttt_sayisi;
										    	        			if(mutasyon.get(onbir).charAt(2)==siralikarakter.charAt(2))
										    	        				basla=ttg_sayisi;
										    	        			if(mutasyon.get(onbir).charAt(2)==siralikarakter.charAt(1))
										    	        				basla=ttc_sayisi;
										    	        		}
										              			 for(int i=basla;i<index.length;i++){
										         	             	int esit_karakter_sayisi=0;
										         	             	if(birlestir.length()-index[i]>=mutasyon.get(onbir).length())
										         	             	for(int j=0;j<mutasyon.get(onbir).length();j++){
										         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(onbir).charAt(j)){
										         	             		esit_karakter_sayisi++;
										         	             	}
										         	             	}
										         	             	if(esit_karakter_sayisi==mutasyon.get(onbir).length()){
										         	             		// System.out.println(index[i]);
										         	             		 break;
										         	             	}
										         	             	if(esit_karakter_sayisi==mutasyon.get(onbir).length()-1&&(index[i]==random_index[onbir])){
										       	             		 System.out.println(index[i]);
										       	             		 break;
										         	             		}
										         	             	
										         	             }
										              		}
										              		*/
										              	}
										              };
										              
										              Thread t12=new Thread(){
										              	public void run(){
										              		
										              	karnel ( 11 , mutasyon, index, random_index, sinir3, sinir4, sinir5,4400,4800);
										              		
										              		/*
										              		for(oniki=4400;oniki<4800;oniki++){
										              			
										    	        		int basla=0;
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[0];
										    	        			if(mutasyon.get(oniki).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[0];
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[0];//292209;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[1];//515147;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[2];//718797;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[1]; //986854;
										    	        			if(mutasyon.get(oniki).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[1];
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[3];//1269418;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[4];//1505613;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[5];//1803549;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[2];//2007501;
										    	        			if(mutasyon.get(oniki).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[2];
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[6];//2236352;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[7];//2566927;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[8];//2797091;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(0)){
										    	        			basla=sinir4[3];//3015857;
										    	        			if(mutasyon.get(oniki).charAt(2)==siralikarakter.charAt(0))
										    	        				basla=sinir3[3];
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(1)){
										    	        			basla=sinir5[9];//3199086;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(2)){
										    	        			basla=sinir5[10];//3430025;
										    	        		}
										    	        		if(mutasyon.get(oniki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(oniki).charAt(1)==siralikarakter.charAt(3)){
										    	        			basla=sinir5[11];//3706632;
										    	        			if(mutasyon.get(oniki).charAt(2)==siralikarakter.charAt(3))
										    	        				basla=ttt_sayisi;
										    	        			if(mutasyon.get(oniki).charAt(2)==siralikarakter.charAt(2))
										    	        				basla=ttg_sayisi;
										    	        			if(mutasyon.get(oniki).charAt(2)==siralikarakter.charAt(1))
										    	        				basla=ttc_sayisi;
										    	        		}
										              			 for(int i=basla;i<index.length;i++){
										         	             	int esit_karakter_sayisi=0;
										         	             	if(birlestir.length()-index[i]>=mutasyon.get(oniki).length())
										         	             	for(int j=0;j<mutasyon.get(oniki).length();j++){
										         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(oniki).charAt(j)){
										         	             		esit_karakter_sayisi++;
										         	             	}
										         	             	}
										         	             	if(esit_karakter_sayisi==mutasyon.get(oniki).length()){
										         	             		// System.out.println(index[i]);
										         	             		 break;
										         	             	}
										         	             	if(esit_karakter_sayisi==mutasyon.get(oniki).length()-1&&(index[i]==random_index[oniki])){
											       	             		 System.out.println(index[i]);
											       	             		 break;
											         	             		}
										         	             }
										              		}
										              		*/
										              	}
										              };
										              Thread t13=new Thread(){
											              	public void run(){
											              		
												            karnel ( 12 , mutasyon, index, random_index, sinir3, sinir4, sinir5,4800,5200);
											              		
											              		/*
											              		for(onuc=4800;onuc<5200;onuc++){
											              		
											    	        		int basla=0;
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(0)){
											    	        			basla=sinir4[0];
											    	        			if(mutasyon.get(onuc).charAt(2)==siralikarakter.charAt(0))
											    	        				basla=sinir3[0];
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(1)){
											    	        			basla=sinir5[0];//292209;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(2)){
											    	        			basla=sinir5[1];//515147;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(3)){
											    	        			basla=sinir5[2];//718797;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(0)){
											    	        			basla=sinir4[1]; //986854;
											    	        			if(mutasyon.get(onuc).charAt(2)==siralikarakter.charAt(0))
											    	        				basla=sinir3[1];
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(1)){
											    	        			basla=sinir5[3];//1269418;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(2)){
											    	        			basla=sinir5[4];//1505613;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(3)){
											    	        			basla=sinir5[5];//1803549;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(0)){
											    	        			basla=sinir4[2];//2007501;
											    	        			if(mutasyon.get(onuc).charAt(2)==siralikarakter.charAt(0))
											    	        				basla=sinir3[2];
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(1)){
											    	        			basla=sinir5[6];//2236352;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(2)){
											    	        			basla=sinir5[7];//2566927;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(3)){
											    	        			basla=sinir5[8];//2797091;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(0)){
											    	        			basla=sinir4[3];//3015857;
											    	        			if(mutasyon.get(onuc).charAt(2)==siralikarakter.charAt(0))
											    	        				basla=sinir3[3];
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(1)){
											    	        			basla=sinir5[9];//3199086;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(2)){
											    	        			basla=sinir5[10];//3430025;
											    	        		}
											    	        		if(mutasyon.get(onuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onuc).charAt(1)==siralikarakter.charAt(3)){
											    	        			basla=sinir5[11];//3706632;
											    	        			if(mutasyon.get(onuc).charAt(2)==siralikarakter.charAt(3))
											    	        				basla=ttt_sayisi;
											    	        			if(mutasyon.get(onuc).charAt(2)==siralikarakter.charAt(2))
											    	        				basla=ttg_sayisi;
											    	        			if(mutasyon.get(onuc).charAt(2)==siralikarakter.charAt(1))
											    	        				basla=ttc_sayisi;
											    	        		}
											              			 for(int i=basla;i<index.length;i++){
											         	             	int esit_karakter_sayisi=0;
											         	             	if(birlestir.length()-index[i]>=mutasyon.get(onuc).length())
											         	             	for(int j=0;j<mutasyon.get(onuc).length();j++){
											         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(onuc).charAt(j)){
											         	             		esit_karakter_sayisi++;
											         	             	}
											         	             	}
											         	             	if(esit_karakter_sayisi==mutasyon.get(onuc).length()){
											         	             		// System.out.println(index[i]);
											         	             		 break;
											         	             	}
											         	             	if(esit_karakter_sayisi==mutasyon.get(onuc).length()-1&&(index[i]==random_index[onuc])){
												       	             		 System.out.println(index[i]);
												       	             		 break;
												         	             		}
											         	             }
											              		}
											              		*/
											              	}
											              };
											              Thread t14=new Thread(){
												              	public void run(){
												              		
														        karnel ( 13 , mutasyon, index, random_index, sinir3, sinir4, sinir5,5200,5600);

												              		
												              		/*
												              		for(ondort=5200;ondort<5600;ondort++){
												              			
												    	        		int basla=0;
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(0)){
												    	        			basla=sinir4[0];
												    	        			if(mutasyon.get(ondort).charAt(2)==siralikarakter.charAt(0))
												    	        				basla=sinir3[0];
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(1)){
												    	        			basla=sinir5[0];//292209;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(2)){
												    	        			basla=sinir5[1];//515147;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(3)){
												    	        			basla=sinir5[2];//718797;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(0)){
												    	        			basla=sinir4[1]; //986854;
												    	        			if(mutasyon.get(ondort).charAt(2)==siralikarakter.charAt(0))
												    	        				basla=sinir3[1];
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(1)){
												    	        			basla=sinir5[3];//1269418;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(2)){
												    	        			basla=sinir5[4];//1505613;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(3)){
												    	        			basla=sinir5[5];//1803549;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(0)){
												    	        			basla=sinir4[2];//2007501;
												    	        			if(mutasyon.get(ondort).charAt(2)==siralikarakter.charAt(0))
												    	        				basla=sinir3[2];
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(1)){
												    	        			basla=sinir5[6];//2236352;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(2)){
												    	        			basla=sinir5[7];//2566927;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(3)){
												    	        			basla=sinir5[8];//2797091;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(0)){
												    	        			basla=sinir4[3];//3015857;
												    	        			if(mutasyon.get(ondort).charAt(2)==siralikarakter.charAt(0))
												    	        				basla=sinir3[3];
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(1)){
												    	        			basla=sinir5[9];//3199086;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(2)){
												    	        			basla=sinir5[10];//3430025;
												    	        		}
												    	        		if(mutasyon.get(ondort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondort).charAt(1)==siralikarakter.charAt(3)){
												    	        			basla=sinir5[11];//3706632;
												    	        			if(mutasyon.get(ondort).charAt(2)==siralikarakter.charAt(3))
												    	        				basla=ttt_sayisi;
												    	        			if(mutasyon.get(ondort).charAt(2)==siralikarakter.charAt(2))
												    	        				basla=ttg_sayisi;
												    	        			if(mutasyon.get(ondort).charAt(2)==siralikarakter.charAt(1))
												    	        				basla=ttc_sayisi;
												    	        		}
												              			 for(int i=basla;i<index.length;i++){
												         	             	int esit_karakter_sayisi=0;
												         	             	if(birlestir.length()-index[i]>=mutasyon.get(ondort).length())
												         	             	for(int j=0;j<mutasyon.get(ondort).length();j++){
												         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(ondort).charAt(j)){
												         	             		esit_karakter_sayisi++;
												         	             	}
												         	             	}
												         	             	if(esit_karakter_sayisi==mutasyon.get(ondort).length()){
												         	             		// System.out.println(index[i]);
												         	             		 break;
												         	             	}
												         	             	if(esit_karakter_sayisi==mutasyon.get(ondort).length()-1&&(index[i]==random_index[ondort])){
													       	             		 System.out.println(index[i]);
													       	             		 break;
													         	             		}
												         	             }
												              		}
												              		*/
												              	}
												              };
												              Thread t15=new Thread(){
													              	public void run(){
																   
													              	karnel ( 14 , mutasyon, index, random_index, sinir3, sinir4, sinir5,5600,6000);
	
													              		
													              		/*
													              		for(onbes=5600;onbes<6000;onbes++){
													              			
													    	        		int basla=0;
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(0)){
													    	        			basla=sinir4[0];
													    	        			if(mutasyon.get(onbes).charAt(2)==siralikarakter.charAt(0))
													    	        				basla=sinir3[0];
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(1)){
													    	        			basla=sinir5[0];//292209;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(2)){
													    	        			basla=sinir5[1];//515147;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(3)){
													    	        			basla=sinir5[2];//718797;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(0)){
													    	        			basla=sinir4[1]; //986854;
													    	        			if(mutasyon.get(onbes).charAt(2)==siralikarakter.charAt(0))
													    	        				basla=sinir3[1];
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(1)){
													    	        			basla=sinir5[3];//1269418;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(2)){
													    	        			basla=sinir5[4];//1505613;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(3)){
													    	        			basla=sinir5[5];//1803549;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(0)){
													    	        			basla=sinir4[2];//2007501;
													    	        			if(mutasyon.get(onbes).charAt(2)==siralikarakter.charAt(0))
													    	        				basla=sinir3[2];
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(1)){
													    	        			basla=sinir5[6];//2236352;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(2)){
													    	        			basla=sinir5[7];//2566927;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(3)){
													    	        			basla=sinir5[8];//2797091;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(0)){
													    	        			basla=sinir4[3];//3015857;
													    	        			if(mutasyon.get(onbes).charAt(2)==siralikarakter.charAt(0))
													    	        				basla=sinir3[3];
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(1)){
													    	        			basla=sinir5[9];//3199086;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(2)){
													    	        			basla=sinir5[10];//3430025;
													    	        		}
													    	        		if(mutasyon.get(onbes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onbes).charAt(1)==siralikarakter.charAt(3)){
													    	        			basla=sinir5[11];//3706632;
													    	        			if(mutasyon.get(onbes).charAt(2)==siralikarakter.charAt(3))
													    	        				basla=ttt_sayisi;
													    	        			if(mutasyon.get(onbes).charAt(2)==siralikarakter.charAt(2))
													    	        				basla=ttg_sayisi;
													    	        			if(mutasyon.get(onbes).charAt(2)==siralikarakter.charAt(1))
													    	        				basla=ttc_sayisi;
													    	        		}
													              			 for(int i=basla;i<index.length;i++){
													         	             	int esit_karakter_sayisi=0;
													         	             	if(birlestir.length()-index[i]>=mutasyon.get(onbes).length())
													         	             	for(int j=0;j<mutasyon.get(onbes).length();j++){
													         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(onbes).charAt(j)){
													         	             		esit_karakter_sayisi++;
													         	             	}
													         	             	}
													         	             	if(esit_karakter_sayisi==mutasyon.get(onbes).length()){
													         	             		// System.out.println(index[i]);
													         	             		 break;
													         	             	}
													         	             	if(esit_karakter_sayisi==mutasyon.get(onbes).length()-1&&(index[i]==random_index[onbes])){
														       	             		 System.out.println(index[i]);
														       	             		 break;
														         	             		}
													         	             }
													              		}
													              		*/
													              	}
													              };
													              Thread t16=new Thread(){
														              	public void run(){
																	   
														              	karnel ( 15, mutasyon, index, random_index, sinir3, sinir4, sinir5,6000,6400);														              		
														              		
														              		/*
														              		for(onalti=6000;onalti<6400;onalti++){
														              		
														    	        		int basla=0;
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(0)){
														    	        			basla=sinir4[0];
														    	        			if(mutasyon.get(onalti).charAt(2)==siralikarakter.charAt(0))
														    	        				basla=sinir3[0];
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(1)){
														    	        			basla=sinir5[0];//292209;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(2)){
														    	        			basla=sinir5[1];//515147;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(3)){
														    	        			basla=sinir5[2];//718797;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(0)){
														    	        			basla=sinir4[1]; //986854;
														    	        			if(mutasyon.get(onalti).charAt(2)==siralikarakter.charAt(0))
														    	        				basla=sinir3[1];
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(1)){
														    	        			basla=sinir5[3];//1269418;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(2)){
														    	        			basla=sinir5[4];//1505613;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(3)){
														    	        			basla=sinir5[5];//1803549;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(0)){
														    	        			basla=sinir4[2];//2007501;
														    	        			if(mutasyon.get(onalti).charAt(2)==siralikarakter.charAt(0))
														    	        				basla=sinir3[2];
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(1)){
														    	        			basla=sinir5[6];//2236352;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(2)){
														    	        			basla=sinir5[7];//2566927;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(3)){
														    	        			basla=sinir5[8];//2797091;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(0)){
														    	        			basla=sinir4[3];//3015857;
														    	        			if(mutasyon.get(onalti).charAt(2)==siralikarakter.charAt(0))
														    	        				basla=sinir3[3];
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(1)){
														    	        			basla=sinir5[9];//3199086;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(2)){
														    	        			basla=sinir5[10];//3430025;
														    	        		}
														    	        		if(mutasyon.get(onalti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onalti).charAt(1)==siralikarakter.charAt(3)){
														    	        			basla=sinir5[11];//3706632;
														    	        			if(mutasyon.get(onalti).charAt(2)==siralikarakter.charAt(3))
														    	        				basla=ttt_sayisi;
														    	        			if(mutasyon.get(onalti).charAt(2)==siralikarakter.charAt(2))
														    	        				basla=ttg_sayisi;
														    	        			if(mutasyon.get(onalti).charAt(2)==siralikarakter.charAt(1))
														    	        				basla=ttc_sayisi;
														    	        		}
														              			 for(int i=basla;i<index.length;i++){
														         	             	int esit_karakter_sayisi=0;
														         	             	if(birlestir.length()-index[i]>=mutasyon.get(onalti).length())
														         	             	for(int j=0;j<mutasyon.get(onalti).length();j++){
														         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(onalti).charAt(j)){
														         	             		esit_karakter_sayisi++;
														         	             	}
														         	             	}
														         	             	if(esit_karakter_sayisi==mutasyon.get(onalti).length()){
														         	             		// System.out.println(index[i]);
														         	             		 break;
														         	             	}
														         	             	if(esit_karakter_sayisi==mutasyon.get(onalti).length()-1&&(index[i]==random_index[onalti])){
															       	             		 System.out.println(index[i]);
															       	             		 break;
															         	             		}
														         	             }
														              		}
														              		*/
														              	}
														              };
														              Thread t17=new Thread(){
															              	public void run(){
															              		
															              		karnel ( 16, mutasyon, index, random_index, sinir3, sinir4, sinir5,6400,6800);

															              		/*
															              		for(onyedi=6400;onyedi<6800;onyedi++){
															              			
															    	        		int basla=0;
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(0)){
															    	        			basla=sinir4[0];
															    	        			if(mutasyon.get(onyedi).charAt(2)==siralikarakter.charAt(0))
															    	        				basla=sinir3[0];
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(1)){
															    	        			basla=sinir5[0];//292209;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(2)){
															    	        			basla=sinir5[1];//515147;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(3)){
															    	        			basla=sinir5[2];//718797;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(0)){
															    	        			basla=sinir4[1]; //986854;
															    	        			if(mutasyon.get(onyedi).charAt(2)==siralikarakter.charAt(0))
															    	        				basla=sinir3[1];
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(1)){
															    	        			basla=sinir5[3];//1269418;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(2)){
															    	        			basla=sinir5[4];//1505613;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(3)){
															    	        			basla=sinir5[5];//1803549;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(0)){
															    	        			basla=sinir4[2];//2007501;
															    	        			if(mutasyon.get(onyedi).charAt(2)==siralikarakter.charAt(0))
															    	        				basla=sinir3[2];
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(1)){
															    	        			basla=sinir5[6];//2236352;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(2)){
															    	        			basla=sinir5[7];//2566927;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(3)){
															    	        			basla=sinir5[8];//2797091;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(0)){
															    	        			basla=sinir4[3];//3015857;
															    	        			if(mutasyon.get(onyedi).charAt(2)==siralikarakter.charAt(0))
															    	        				basla=sinir3[3];
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(1)){
															    	        			basla=sinir5[9];//3199086;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(2)){
															    	        			basla=sinir5[10];//3430025;
															    	        		}
															    	        		if(mutasyon.get(onyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onyedi).charAt(1)==siralikarakter.charAt(3)){
															    	        			basla=sinir5[11];//3706632;
															    	        			if(mutasyon.get(onyedi).charAt(2)==siralikarakter.charAt(3))
															    	        				basla=ttt_sayisi;
															    	        			if(mutasyon.get(onyedi).charAt(2)==siralikarakter.charAt(2))
															    	        				basla=ttg_sayisi;
															    	        			if(mutasyon.get(onyedi).charAt(2)==siralikarakter.charAt(1))
															    	        				basla=ttc_sayisi;
															    	        		}
															              			 for(int i=basla;i<index.length;i++){
															         	             	int esit_karakter_sayisi=0;
															         	             	if(birlestir.length()-index[i]>=mutasyon.get(onyedi).length())
															         	             	for(int j=0;j<mutasyon.get(onyedi).length();j++){
															         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(onyedi).charAt(j)){
															         	             		esit_karakter_sayisi++;
															         	             	}
															         	             	}
															         	             	if(esit_karakter_sayisi==mutasyon.get(onyedi).length()){
															         	             		// System.out.println(index[i]);
															         	             		 break;
															         	             	}
															         	             	if(esit_karakter_sayisi==mutasyon.get(onyedi).length()-1&&(index[i]==random_index[onyedi])){
																       	             		 System.out.println(index[i]);
																       	             		 break;
																         	             		}
															         	             }
															              		}
															              		*/
															              	}
															              };
															              Thread t18=new Thread(){
																              	public void run(){
																              		karnel ( 17, mutasyon, index, random_index, sinir3, sinir4, sinir5,6800,7200);

																              		/*
																              		for(onsekiz=6800;onsekiz<7200;onsekiz++){
																              			
																    	        		int basla=0;
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(0)){
																    	        			basla=sinir4[0];
																    	        			if(mutasyon.get(onsekiz).charAt(2)==siralikarakter.charAt(0))
																    	        				basla=sinir3[0];
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(1)){
																    	        			basla=sinir5[0];//292209;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(2)){
																    	        			basla=sinir5[1];//515147;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(3)){
																    	        			basla=sinir5[2];//718797;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(0)){
																    	        			basla=sinir4[1]; //986854;
																    	        			if(mutasyon.get(onsekiz).charAt(2)==siralikarakter.charAt(0))
																    	        				basla=sinir3[1];
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(1)){
																    	        			basla=sinir5[3];//1269418;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(2)){
																    	        			basla=sinir5[4];//1505613;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(3)){
																    	        			basla=sinir5[5];//1803549;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(0)){
																    	        			basla=sinir4[2];//2007501;
																    	        			if(mutasyon.get(onsekiz).charAt(2)==siralikarakter.charAt(0))
																    	        				basla=sinir3[2];
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(1)){
																    	        			basla=sinir5[6];//2236352;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(2)){
																    	        			basla=sinir5[7];//2566927;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(3)){
																    	        			basla=sinir5[8];//2797091;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(0)){
																    	        			basla=sinir4[3];//3015857;
																    	        			if(mutasyon.get(onsekiz).charAt(2)==siralikarakter.charAt(0))
																    	        				basla=sinir3[3];
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(1)){
																    	        			basla=sinir5[9];//3199086;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(2)){
																    	        			basla=sinir5[10];//3430025;
																    	        		}
																    	        		if(mutasyon.get(onsekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(onsekiz).charAt(1)==siralikarakter.charAt(3)){
																    	        			basla=sinir5[11];//3706632;
																    	        			if(mutasyon.get(onsekiz).charAt(2)==siralikarakter.charAt(3))
																    	        				basla=ttt_sayisi;
																    	        			if(mutasyon.get(onsekiz).charAt(2)==siralikarakter.charAt(2))
																    	        				basla=ttg_sayisi;
																    	        			if(mutasyon.get(onsekiz).charAt(2)==siralikarakter.charAt(1))
																    	        				basla=ttc_sayisi;
																    	        		}
																              			 for(int i=basla;i<index.length;i++){
																         	             	int esit_karakter_sayisi=0;
																         	             	if(birlestir.length()-index[i]>=mutasyon.get(onsekiz).length())
																         	             	for(int j=0;j<mutasyon.get(onsekiz).length();j++){
																         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(onsekiz).charAt(j)){
																         	             		esit_karakter_sayisi++;
																         	             	}
																         	             	}
																         	             	if(esit_karakter_sayisi==mutasyon.get(onsekiz).length()){
																         	             		// System.out.println(index[i]);
																         	             		 break;
																         	             	}
																         	             	if(esit_karakter_sayisi==mutasyon.get(onsekiz).length()-1&&(index[i]==random_index[onsekiz])){
																	       	             		 System.out.println(index[i]);
																	       	             		 break;
																	         	             		}
																         	             }
																              		}
																              		*/
																              	}
																              };
																              Thread t19=new Thread(){
																	              	public void run(){
																	              		
																	              	karnel ( 18, mutasyon, index, random_index, sinir3, sinir4, sinir5,7200,7600);

																	              		/*
																	              		for(ondokuz=7200;ondokuz<7600;ondokuz++){
																	              		
																	    	        		int basla=0;
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(0)){
																	    	        			basla=sinir4[0];
																	    	        			if(mutasyon.get(ondokuz).charAt(2)==siralikarakter.charAt(0))
																	    	        				basla=sinir3[0];
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(1)){
																	    	        			basla=sinir5[0];//292209;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(2)){
																	    	        			basla=sinir5[1];//515147;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(3)){
																	    	        			basla=sinir5[2];//718797;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(0)){
																	    	        			basla=sinir4[1]; //986854;
																	    	        			if(mutasyon.get(ondokuz).charAt(2)==siralikarakter.charAt(0))
																	    	        				basla=sinir3[1];
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(1)){
																	    	        			basla=sinir5[3];//1269418;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(2)){
																	    	        			basla=sinir5[4];//1505613;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(3)){
																	    	        			basla=sinir5[5];//1803549;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(0)){
																	    	        			basla=sinir4[2];//2007501;
																	    	        			if(mutasyon.get(ondokuz).charAt(2)==siralikarakter.charAt(0))
																	    	        				basla=sinir3[2];
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(1)){
																	    	        			basla=sinir5[6];//2236352;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(2)){
																	    	        			basla=sinir5[7];//2566927;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(3)){
																	    	        			basla=sinir5[8];//2797091;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(0)){
																	    	        			basla=sinir4[3];//3015857;
																	    	        			if(mutasyon.get(ondokuz).charAt(2)==siralikarakter.charAt(0))
																	    	        				basla=sinir3[3];
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(1)){
																	    	        			basla=sinir5[9];//3199086;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(2)){
																	    	        			basla=sinir5[10];//3430025;
																	    	        		}
																	    	        		if(mutasyon.get(ondokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(ondokuz).charAt(1)==siralikarakter.charAt(3)){
																	    	        			basla=sinir5[11];//3706632;
																	    	        			if(mutasyon.get(ondokuz).charAt(2)==siralikarakter.charAt(3))
																	    	        				basla=ttt_sayisi;
																	    	        			if(mutasyon.get(ondokuz).charAt(2)==siralikarakter.charAt(2))
																	    	        				basla=ttg_sayisi;
																	    	        			if(mutasyon.get(ondokuz).charAt(2)==siralikarakter.charAt(1))
																	    	        				basla=ttc_sayisi;
																	    	        		}
																	              			 for(int i=basla;i<index.length;i++){
																	         	             	int esit_karakter_sayisi=0;
																	         	             	if(birlestir.length()-index[i]>=mutasyon.get(ondokuz).length())
																	         	             	for(int j=0;j<mutasyon.get(ondokuz).length();j++){
																	         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(ondokuz).charAt(j)){
																	         	             		esit_karakter_sayisi++;
																	         	             	}
																	         	             	}
																	         	             	if(esit_karakter_sayisi==mutasyon.get(ondokuz).length()){
																	         	             		// System.out.println(index[i]);
																	         	             		 break;
																	         	             	}
																	         	             	if(esit_karakter_sayisi==mutasyon.get(ondokuz).length()-1&&(index[i]==random_index[ondokuz])){
																		       	             		 System.out.println(index[i]);
																		       	             		 break;
																		         	             		}
																	         	             }
																	              		}
																	              		*/
																	              	}
																	              };
																	              Thread t20=new Thread(){
																		              	public void run(){
																		              		
																		              		karnel ( 19, mutasyon, index, random_index, sinir3, sinir4, sinir5,7600,8000);

																		              		/*
																		              		for(yirmi=7600;yirmi<8000;yirmi++){
																		              			
																		    	        		int basla=0;
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(0)){
																		    	        			basla=sinir4[0];
																		    	        			if(mutasyon.get(yirmi).charAt(2)==siralikarakter.charAt(0))
																		    	        				basla=sinir3[0];
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(1)){
																		    	        			basla=sinir5[0];//292209;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(2)){
																		    	        			basla=sinir5[1];//515147;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(3)){
																		    	        			basla=sinir5[2];//718797;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(0)){
																		    	        			basla=sinir4[1]; //986854;
																		    	        			if(mutasyon.get(yirmi).charAt(2)==siralikarakter.charAt(0))
																		    	        				basla=sinir3[1];
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(1)){
																		    	        			basla=sinir5[3];//1269418;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(2)){
																		    	        			basla=sinir5[4];//1505613;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(3)){
																		    	        			basla=sinir5[5];//1803549;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(0)){
																		    	        			basla=sinir4[2];//2007501;
																		    	        			if(mutasyon.get(yirmi).charAt(2)==siralikarakter.charAt(0))
																		    	        				basla=sinir3[2];
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(1)){
																		    	        			basla=sinir5[6];//2236352;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(2)){
																		    	        			basla=sinir5[7];//2566927;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(3)){
																		    	        			basla=sinir5[8];//2797091;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(0)){
																		    	        			basla=sinir4[3];//3015857;
																		    	        			if(mutasyon.get(yirmi).charAt(2)==siralikarakter.charAt(0))
																		    	        				basla=sinir3[3];
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(1)){
																		    	        			basla=sinir5[9];//3199086;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(2)){
																		    	        			basla=sinir5[10];//3430025;
																		    	        		}
																		    	        		if(mutasyon.get(yirmi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmi).charAt(1)==siralikarakter.charAt(3)){
																		    	        			basla=sinir5[11];//3706632;
																		    	        			if(mutasyon.get(yirmi).charAt(2)==siralikarakter.charAt(3))
																		    	        				basla=ttt_sayisi;
																		    	        			if(mutasyon.get(yirmi).charAt(2)==siralikarakter.charAt(2))
																		    	        				basla=ttg_sayisi;
																		    	        			if(mutasyon.get(yirmi).charAt(2)==siralikarakter.charAt(1))
																		    	        				basla=ttc_sayisi;
																		    	        		}
																		              			 for(int i=basla;i<index.length;i++){
																		         	             	int esit_karakter_sayisi=0;
																		         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmi).length())
																		         	             	for(int j=0;j<mutasyon.get(yirmi).length();j++){
																		         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmi).charAt(j)){
																		         	             		esit_karakter_sayisi++;
																		         	             	}
																		         	             	}
																		         	             	if(esit_karakter_sayisi==mutasyon.get(yirmi).length()){
																		         	             		// System.out.println(index[i]);
																		         	             		 break;
																		         	             	}
																		         	             	if(esit_karakter_sayisi==mutasyon.get(yirmi).length()-1&&(index[i]==random_index[yirmi])){
																			       	             		 System.out.println(index[i]);
																			       	             		 break;
																			         	             		}
																		         	             }
																		              		}
																		              		*/
																		              	}
																		              };
																		              
																		              Thread t21=new Thread(){
																			              	public void run(){
																			              		
																			              	karnel ( 20, mutasyon, index, random_index, sinir3, sinir4, sinir5,8000,8400);

																			              		/*for(yirmibir=8000;yirmibir<8400;yirmibir++){
																			              			
																			    	        		int basla=0;
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(0)){
																			    	        			basla=sinir4[0];
																			    	        			if(mutasyon.get(yirmibir).charAt(2)==siralikarakter.charAt(0))
																			    	        				basla=sinir3[0];
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(1)){
																			    	        			basla=sinir5[0];//292209;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(2)){
																			    	        			basla=sinir5[1];//515147;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(3)){
																			    	        			basla=sinir5[2];//718797;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(0)){
																			    	        			basla=sinir4[1]; //986854;
																			    	        			if(mutasyon.get(yirmibir).charAt(2)==siralikarakter.charAt(0))
																			    	        				basla=sinir3[1];
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(1)){
																			    	        			basla=sinir5[3];//1269418;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(2)){
																			    	        			basla=sinir5[4];//1505613;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(3)){
																			    	        			basla=sinir5[5];//1803549;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(0)){
																			    	        			basla=sinir4[2];//2007501;
																			    	        			if(mutasyon.get(yirmibir).charAt(2)==siralikarakter.charAt(0))
																			    	        				basla=sinir3[2];
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(1)){
																			    	        			basla=sinir5[6];//2236352;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(2)){
																			    	        			basla=sinir5[7];//2566927;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(3)){
																			    	        			basla=sinir5[8];//2797091;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(0)){
																			    	        			basla=sinir4[3];//3015857;
																			    	        			if(mutasyon.get(yirmibir).charAt(2)==siralikarakter.charAt(0))
																			    	        				basla=sinir3[3];
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(1)){
																			    	        			basla=sinir5[9];//3199086;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(2)){
																			    	        			basla=sinir5[10];//3430025;
																			    	        		}
																			    	        		if(mutasyon.get(yirmibir).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibir).charAt(1)==siralikarakter.charAt(3)){
																			    	        			basla=sinir5[11];//3706632;
																			    	        			if(mutasyon.get(yirmibir).charAt(2)==siralikarakter.charAt(3))
																			    	        				basla=ttt_sayisi;
																			    	        			if(mutasyon.get(yirmibir).charAt(2)==siralikarakter.charAt(2))
																			    	        				basla=ttg_sayisi;
																			    	        			if(mutasyon.get(yirmibir).charAt(2)==siralikarakter.charAt(1))
																			    	        				basla=ttc_sayisi;
																			    	        		}
																			              			 for(int i=basla;i<index.length;i++){
																			         	             	int esit_karakter_sayisi=0;
																			         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmibir).length())
																			         	             	for(int j=0;j<mutasyon.get(yirmibir).length();j++){
																			         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmibir).charAt(j)){
																			         	             		esit_karakter_sayisi++;
																			         	             	}
																			         	             	}
																			         	             	if(esit_karakter_sayisi==mutasyon.get(yirmibir).length()){
																			         	             		// System.out.println(index[i]);
																			         	             		 break;
																			         	             	}
																			         	             	if(esit_karakter_sayisi==mutasyon.get(yirmibir).length()-1&&(index[i]==random_index[yirmibir])){
																				       	             		 System.out.println(index[i]);
																				       	             		 break;
																				         	             		}
																			         	             }
																			              		}
																			              		*/
																			              	}
																			              };
																			              Thread t22=new Thread(){
																				              	public void run(){
																				              		
																				              		karnel ( 21, mutasyon, index, random_index, sinir3, sinir4, sinir5,8400,8800);

																				              		/*
																				              		for(yirmiiki=8400;yirmiiki<8800;yirmiiki++){
																				              			
																				    	        		int basla=0;
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(0)){
																				    	        			basla=sinir4[0];
																				    	        			if(mutasyon.get(yirmiiki).charAt(2)==siralikarakter.charAt(0))
																				    	        				basla=sinir3[0];
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(1)){
																				    	        			basla=sinir5[0];//292209;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(2)){
																				    	        			basla=sinir5[1];//515147;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(3)){
																				    	        			basla=sinir5[2];//718797;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(0)){
																				    	        			basla=sinir4[1]; //986854;
																				    	        			if(mutasyon.get(yirmiiki).charAt(2)==siralikarakter.charAt(0))
																				    	        				basla=sinir3[1];
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(1)){
																				    	        			basla=sinir5[3];//1269418;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(2)){
																				    	        			basla=sinir5[4];//1505613;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(3)){
																				    	        			basla=sinir5[5];//1803549;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(0)){
																				    	        			basla=sinir4[2];//2007501;
																				    	        			if(mutasyon.get(yirmiiki).charAt(2)==siralikarakter.charAt(0))
																				    	        				basla=sinir3[2];
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(1)){
																				    	        			basla=sinir5[6];//2236352;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(2)){
																				    	        			basla=sinir5[7];//2566927;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(3)){
																				    	        			basla=sinir5[8];//2797091;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(0)){
																				    	        			basla=sinir4[3];//3015857;
																				    	        			if(mutasyon.get(yirmiiki).charAt(2)==siralikarakter.charAt(0))
																				    	        				basla=sinir3[3];
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(1)){
																				    	        			basla=sinir5[9];//3199086;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(2)){
																				    	        			basla=sinir5[10];//3430025;
																				    	        		}
																				    	        		if(mutasyon.get(yirmiiki).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiiki).charAt(1)==siralikarakter.charAt(3)){
																				    	        			basla=sinir5[11];//3706632;
																				    	        			if(mutasyon.get(yirmiiki).charAt(2)==siralikarakter.charAt(3))
																				    	        				basla=ttt_sayisi;
																				    	        			if(mutasyon.get(yirmiiki).charAt(2)==siralikarakter.charAt(2))
																				    	        				basla=ttg_sayisi;
																				    	        			if(mutasyon.get(yirmiiki).charAt(2)==siralikarakter.charAt(1))
																				    	        				basla=ttc_sayisi;
																				    	        		}
																				              			 for(int i=basla;i<index.length;i++){
																				         	             	int esit_karakter_sayisi=0;
																				         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmiiki).length())
																				         	             	for(int j=0;j<mutasyon.get(yirmiiki).length();j++){
																				         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmiiki).charAt(j)){
																				         	             		esit_karakter_sayisi++;
																				         	             	}
																				         	             	}
																				         	             	if(esit_karakter_sayisi==mutasyon.get(yirmiiki).length()){
																				         	             		// System.out.println(index[i]);
																				         	             		 break;
																				         	             	}
																				         	             	if(esit_karakter_sayisi==mutasyon.get(yirmiiki).length()-1&&(index[i]==random_index[yirmiiki])){
																					       	             		 System.out.println(index[i]);
																					       	             		 break;
																					         	             		}
																				         	             }
																				              		}
																				              		*/
																				              	}
																				              };
																				              Thread t23=new Thread(){
																					              	public void run(){
																					              		
																					              	karnel ( 22, mutasyon, index, random_index, sinir3, sinir4, sinir5,8800,9200);
																					              		
																					              		/*
																					              		for(yirmiuc=8800;yirmiuc<9200;yirmiuc++){
																					              			
																					    	        		int basla=0;
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(0)){
																					    	        			basla=sinir4[0];
																					    	        			if(mutasyon.get(yirmiuc).charAt(2)==siralikarakter.charAt(0))
																					    	        				basla=sinir3[0];
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(1)){
																					    	        			basla=sinir5[0];//292209;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(2)){
																					    	        			basla=sinir5[1];//515147;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(3)){
																					    	        			basla=sinir5[2];//718797;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(0)){
																					    	        			basla=sinir4[1]; //986854;
																					    	        			if(mutasyon.get(yirmiuc).charAt(2)==siralikarakter.charAt(0))
																					    	        				basla=sinir3[1];
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(1)){
																					    	        			basla=sinir5[3];//1269418;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(2)){
																					    	        			basla=sinir5[4];//1505613;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(3)){
																					    	        			basla=sinir5[5];//1803549;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(0)){
																					    	        			basla=sinir4[2];//2007501;
																					    	        			if(mutasyon.get(yirmiuc).charAt(2)==siralikarakter.charAt(0))
																					    	        				basla=sinir3[2];
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(1)){
																					    	        			basla=sinir5[6];//2236352;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(2)){
																					    	        			basla=sinir5[7];//2566927;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(3)){
																					    	        			basla=sinir5[8];//2797091;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(0)){
																					    	        			basla=sinir4[3];//3015857;
																					    	        			if(mutasyon.get(yirmiuc).charAt(2)==siralikarakter.charAt(0))
																					    	        				basla=sinir3[3];
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(1)){
																					    	        			basla=sinir5[9];//3199086;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(2)){
																					    	        			basla=sinir5[10];//3430025;
																					    	        		}
																					    	        		if(mutasyon.get(yirmiuc).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiuc).charAt(1)==siralikarakter.charAt(3)){
																					    	        			basla=sinir5[11];//3706632;
																					    	        			if(mutasyon.get(yirmiuc).charAt(2)==siralikarakter.charAt(3))
																					    	        				basla=ttt_sayisi;
																					    	        			if(mutasyon.get(yirmiuc).charAt(2)==siralikarakter.charAt(2))
																					    	        				basla=ttg_sayisi;
																					    	        			if(mutasyon.get(yirmiuc).charAt(2)==siralikarakter.charAt(1))
																					    	        				basla=ttc_sayisi;
																					    	        		}
																					              			 for(int i=basla;i<index.length;i++){
																					         	             	int esit_karakter_sayisi=0;
																					         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmiuc).length())
																					         	             	for(int j=0;j<mutasyon.get(yirmiuc).length();j++){
																					         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmiuc).charAt(j)){
																					         	             		esit_karakter_sayisi++;
																					         	             	}
																					         	             	}
																					         	             	if(esit_karakter_sayisi==mutasyon.get(yirmiuc).length()){
																					         	             		// System.out.println(index[i]);
																					         	             		 break;
																					         	             	}
																					         	             	if(esit_karakter_sayisi==mutasyon.get(yirmiuc).length()-1&&(index[i]==random_index[yirmiuc])){
																						       	             		 System.out.println(index[i]);
																						       	             		 break;
																						         	             		}
																					         	             }
																					              		}
																					              		*/
																					              	}
																					              };
																					              Thread t24=new Thread(){
																						              	public void run(){
																						              	karnel ( 23, mutasyon, index, random_index, sinir3, sinir4, sinir5,9200,9600);
																						              		/*
																						              		for(yirmidort=9200;yirmidort<9600;yirmidort++){
																						              		
																						    	        		int basla=0;
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(0)){
																						    	        			basla=sinir4[0];
																						    	        			if(mutasyon.get(yirmidort).charAt(2)==siralikarakter.charAt(0))
																						    	        				basla=sinir3[0];
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(1)){
																						    	        			basla=sinir5[0];//292209;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(2)){
																						    	        			basla=sinir5[1];//515147;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(3)){
																						    	        			basla=sinir5[2];//718797;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(0)){
																						    	        			basla=sinir4[1]; //986854;
																						    	        			if(mutasyon.get(yirmidort).charAt(2)==siralikarakter.charAt(0))
																						    	        				basla=sinir3[1];
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(1)){
																						    	        			basla=sinir5[3];//1269418;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(2)){
																						    	        			basla=sinir5[4];//1505613;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(3)){
																						    	        			basla=sinir5[5];//1803549;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(0)){
																						    	        			basla=sinir4[2];//2007501;
																						    	        			if(mutasyon.get(yirmidort).charAt(2)==siralikarakter.charAt(0))
																						    	        				basla=sinir3[2];
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(1)){
																						    	        			basla=sinir5[6];//2236352;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(2)){
																						    	        			basla=sinir5[7];//2566927;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(3)){
																						    	        			basla=sinir5[8];//2797091;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(0)){
																						    	        			basla=sinir4[3];//3015857;
																						    	        			if(mutasyon.get(yirmidort).charAt(2)==siralikarakter.charAt(0))
																						    	        				basla=sinir3[3];
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(1)){
																						    	        			basla=sinir5[9];//3199086;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(2)){
																						    	        			basla=sinir5[10];//3430025;
																						    	        		}
																						    	        		if(mutasyon.get(yirmidort).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidort).charAt(1)==siralikarakter.charAt(3)){
																						    	        			basla=sinir5[11];//3706632;
																						    	        			if(mutasyon.get(yirmidort).charAt(2)==siralikarakter.charAt(3))
																						    	        				basla=ttt_sayisi;
																						    	        			if(mutasyon.get(yirmidort).charAt(2)==siralikarakter.charAt(2))
																						    	        				basla=ttg_sayisi;
																						    	        			if(mutasyon.get(yirmidort).charAt(2)==siralikarakter.charAt(1))
																						    	        				basla=ttc_sayisi;
																						    	        		}
																						              			 for(int i=basla;i<index.length;i++){
																						         	             	int esit_karakter_sayisi=0;
																						         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmidort).length())
																						         	             	for(int j=0;j<mutasyon.get(yirmidort).length();j++){
																						         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmidort).charAt(j)){
																						         	             		esit_karakter_sayisi++;
																						         	             	}
																						         	             	}
																						         	             	if(esit_karakter_sayisi==mutasyon.get(yirmidort).length()){
																						         	             		// System.out.println(index[i]);
																						         	             		 break;
																						         	             	}
																						         	             	if(esit_karakter_sayisi==mutasyon.get(yirmidort).length()-1&&(index[i]==random_index[yirmidort])){
																							       	             		 System.out.println(index[i]);
																							       	             		 break;
																							         	             		}
																						         	             }
																						              		}
																						              		*/
																						              	}
																						              };
																						              Thread t25=new Thread(){
																							              	public void run(){
																							              	karnel ( 24, mutasyon, index, random_index, sinir3, sinir4, sinir5,9600,10000);
																							              		/*
																							              		for(yirmibes=9600;yirmibes<10000;yirmibes++){
																							              			
																							    	        		int basla=0;
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(0)){
																							    	        			basla=sinir4[0];
																							    	        			if(mutasyon.get(yirmibes).charAt(2)==siralikarakter.charAt(0))
																							    	        				basla=sinir3[0];
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(1)){
																							    	        			basla=sinir5[0];//292209;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(2)){
																							    	        			basla=sinir5[1];//515147;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(3)){
																							    	        			basla=sinir5[2];//718797;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(0)){
																							    	        			basla=sinir4[1]; //986854;
																							    	        			if(mutasyon.get(yirmibes).charAt(2)==siralikarakter.charAt(0))
																							    	        				basla=sinir3[1];
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(1)){
																							    	        			basla=sinir5[3];//1269418;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(2)){
																							    	        			basla=sinir5[4];//1505613;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(3)){
																							    	        			basla=sinir5[5];//1803549;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(0)){
																							    	        			basla=sinir4[2];//2007501;
																							    	        			if(mutasyon.get(yirmibes).charAt(2)==siralikarakter.charAt(0))
																							    	        				basla=sinir3[2];
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(1)){
																							    	        			basla=sinir5[6];//2236352;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(2)){
																							    	        			basla=sinir5[7];//2566927;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(3)){
																							    	        			basla=sinir5[8];//2797091;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(0)){
																							    	        			basla=sinir4[3];//3015857;
																							    	        			if(mutasyon.get(yirmibes).charAt(2)==siralikarakter.charAt(0))
																							    	        				basla=sinir3[3];
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(1)){
																							    	        			basla=sinir5[9];//3199086;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(2)){
																							    	        			basla=sinir5[10];//3430025;
																							    	        		}
																							    	        		if(mutasyon.get(yirmibes).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmibes).charAt(1)==siralikarakter.charAt(3)){
																							    	        			basla=sinir5[11];//3706632;
																							    	        			if(mutasyon.get(yirmibes).charAt(2)==siralikarakter.charAt(3))
																							    	        				basla=ttt_sayisi;
																							    	        			if(mutasyon.get(yirmibes).charAt(2)==siralikarakter.charAt(2))
																							    	        				basla=ttg_sayisi;
																							    	        			if(mutasyon.get(yirmibes).charAt(2)==siralikarakter.charAt(1))
																							    	        				basla=ttc_sayisi;
																							    	        		}
																							              			 for(int i=basla;i<index.length;i++){
																							         	             	int esit_karakter_sayisi=0;
																							         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmibes).length())
																							         	             	for(int j=0;j<mutasyon.get(yirmibes).length();j++){
																							         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmibes).charAt(j)){
																							         	             		esit_karakter_sayisi++;
																							         	             	}
																							         	             	}
																							         	             	if(esit_karakter_sayisi==mutasyon.get(yirmibes).length()){
																							         	             		// System.out.println(index[i]);
																							         	             		 break;
																							         	             	}
																							         	             	if(esit_karakter_sayisi==mutasyon.get(yirmibes).length()-1&&(index[i]==random_index[yirmibes])){
																								       	             		 System.out.println(index[i]);
																								       	             		 break;
																								         	             		}
																							         	             }
																							              		}
																							              		*/
																							              	}
																							              };
																							              Thread t26=new Thread(){
																								              	public void run(){
																								              	karnel ( 25, mutasyon, index, random_index, sinir3, sinir4, sinir5,10000,10400);

																								              		/*
																								              		for(yirmialti=10000;yirmialti<10400;yirmialti++){
																								              			
																								    	        		int basla=0;
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(0)){
																								    	        			basla=sinir4[0];
																								    	        			if(mutasyon.get(yirmialti).charAt(2)==siralikarakter.charAt(0))
																								    	        				basla=sinir3[0];
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(1)){
																								    	        			basla=sinir5[0];//292209;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(2)){
																								    	        			basla=sinir5[1];//515147;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(3)){
																								    	        			basla=sinir5[2];//718797;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(0)){
																								    	        			basla=sinir4[1]; //986854;
																								    	        			if(mutasyon.get(yirmialti).charAt(2)==siralikarakter.charAt(0))
																								    	        				basla=sinir3[1];
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(1)){
																								    	        			basla=sinir5[3];//1269418;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(2)){
																								    	        			basla=sinir5[4];//1505613;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(3)){
																								    	        			basla=sinir5[5];//1803549;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(0)){
																								    	        			basla=sinir4[2];//2007501;
																								    	        			if(mutasyon.get(yirmialti).charAt(2)==siralikarakter.charAt(0))
																								    	        				basla=sinir3[2];
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(1)){
																								    	        			basla=sinir5[6];//2236352;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(2)){
																								    	        			basla=sinir5[7];//2566927;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(3)){
																								    	        			basla=sinir5[8];//2797091;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(0)){
																								    	        			basla=sinir4[3];//3015857;
																								    	        			if(mutasyon.get(yirmialti).charAt(2)==siralikarakter.charAt(0))
																								    	        				basla=sinir3[3];
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(1)){
																								    	        			basla=sinir5[9];//3199086;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(2)){
																								    	        			basla=sinir5[10];//3430025;
																								    	        		}
																								    	        		if(mutasyon.get(yirmialti).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmialti).charAt(1)==siralikarakter.charAt(3)){
																								    	        			basla=sinir5[11];//3706632;
																								    	        			if(mutasyon.get(yirmialti).charAt(2)==siralikarakter.charAt(3))
																								    	        				basla=ttt_sayisi;
																								    	        			if(mutasyon.get(yirmialti).charAt(2)==siralikarakter.charAt(2))
																								    	        				basla=ttg_sayisi;
																								    	        			if(mutasyon.get(yirmialti).charAt(2)==siralikarakter.charAt(1))
																								    	        				basla=ttc_sayisi;
																								    	        		}
																								              			 for(int i=basla;i<index.length;i++){
																								         	             	int esit_karakter_sayisi=0;
																								         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmialti).length())
																								         	             	for(int j=0;j<mutasyon.get(yirmialti).length();j++){
																								         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmialti).charAt(j)){
																								         	             		esit_karakter_sayisi++;
																								         	             	}
																								         	             	}
																								         	             	if(esit_karakter_sayisi==mutasyon.get(yirmialti).length()){
																								         	             		// System.out.println(index[i]);
																								         	             		 break;
																								         	             	}
																								         	             	if(esit_karakter_sayisi==mutasyon.get(yirmialti).length()-1&&(index[i]==random_index[yirmialti])){
																									       	             		 System.out.println(index[i]);
																									       	             		 break;
																									         	             		}
																								         	             }
																								              		}
																								              		*/
																								              	}
																								              };
																								              Thread t27=new Thread(){
																									              	public void run(){
																									              	karnel ( 26, mutasyon, index, random_index, sinir3, sinir4, sinir5,10400,10800);
																									              		/*
																									              		for(yirmiyedi=10400;yirmiyedi<10800;yirmiyedi++){
																									              			
																									    	        		int basla=0;
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(0)){
																									    	        			basla=sinir4[0];
																									    	        			if(mutasyon.get(yirmiyedi).charAt(2)==siralikarakter.charAt(0))
																									    	        				basla=sinir3[0];
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(1)){
																									    	        			basla=sinir5[0];//292209;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(2)){
																									    	        			basla=sinir5[1];//515147;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(3)){
																									    	        			basla=sinir5[2];//718797;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(0)){
																									    	        			basla=sinir4[1]; //986854;
																									    	        			if(mutasyon.get(yirmiyedi).charAt(2)==siralikarakter.charAt(0))
																									    	        				basla=sinir3[1];
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(1)){
																									    	        			basla=sinir5[3];//1269418;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(2)){
																									    	        			basla=sinir5[4];//1505613;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(3)){
																									    	        			basla=sinir5[5];//1803549;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(0)){
																									    	        			basla=sinir4[2];//2007501;
																									    	        			if(mutasyon.get(yirmiyedi).charAt(2)==siralikarakter.charAt(0))
																									    	        				basla=sinir3[2];
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(1)){
																									    	        			basla=sinir5[6];//2236352;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(2)){
																									    	        			basla=sinir5[7];//2566927;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(3)){
																									    	        			basla=sinir5[8];//2797091;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(0)){
																									    	        			basla=sinir4[3];//3015857;
																									    	        			if(mutasyon.get(yirmiyedi).charAt(2)==siralikarakter.charAt(0))
																									    	        				basla=sinir3[3];
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(1)){
																									    	        			basla=sinir5[9];//3199086;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(2)){
																									    	        			basla=sinir5[10];//3430025;
																									    	        		}
																									    	        		if(mutasyon.get(yirmiyedi).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmiyedi).charAt(1)==siralikarakter.charAt(3)){
																									    	        			basla=sinir5[11];//3706632;
																									    	        			if(mutasyon.get(yirmiyedi).charAt(2)==siralikarakter.charAt(3))
																									    	        				basla=ttt_sayisi;
																									    	        			if(mutasyon.get(yirmiyedi).charAt(2)==siralikarakter.charAt(2))
																									    	        				basla=ttg_sayisi;
																									    	        			if(mutasyon.get(yirmiyedi).charAt(2)==siralikarakter.charAt(1))
																									    	        				basla=ttc_sayisi;
																									    	        		}
																									              			 for(int i=basla;i<index.length;i++){
																									         	             	int esit_karakter_sayisi=0;
																									         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmiyedi).length())
																									         	             	for(int j=0;j<mutasyon.get(yirmiyedi).length();j++){
																									         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmiyedi).charAt(j)){
																									         	             		esit_karakter_sayisi++;
																									         	             	}
																									         	             	}
																									         	             	if(esit_karakter_sayisi==mutasyon.get(yirmiyedi).length()){
																									         	             		// System.out.println(index[i]);
																									         	             		 break;
																									         	             	}
																									         	             	if(esit_karakter_sayisi==mutasyon.get(yirmiyedi).length()-1&&(index[i]==random_index[yirmiyedi])){
																										       	             		 System.out.println(index[i]);
																										       	             		 break;
																										         	             		}
																									         	             }
																									              		}
																									              		*/
																									              	}
																									              };
																									              Thread t28=new Thread(){
																										              	public void run(){
																										              	karnel ( 27, mutasyon, index, random_index, sinir3, sinir4, sinir5,10800,11200);

																										              		/*
																										              		for(yirmisekiz=10800;yirmisekiz<11200;yirmisekiz++){
																										              			
																										    	        		int basla=0;
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(0)){
																										    	        			basla=sinir4[0];
																										    	        			if(mutasyon.get(yirmisekiz).charAt(2)==siralikarakter.charAt(0))
																										    	        				basla=sinir3[0];
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(1)){
																										    	        			basla=sinir5[0];//292209;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(2)){
																										    	        			basla=sinir5[1];//515147;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(3)){
																										    	        			basla=sinir5[2];//718797;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(0)){
																										    	        			basla=sinir4[1]; //986854;
																										    	        			if(mutasyon.get(yirmisekiz).charAt(2)==siralikarakter.charAt(0))
																										    	        				basla=sinir3[1];
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(1)){
																										    	        			basla=sinir5[3];//1269418;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(2)){
																										    	        			basla=sinir5[4];//1505613;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(3)){
																										    	        			basla=sinir5[5];//1803549;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(0)){
																										    	        			basla=sinir4[2];//2007501;
																										    	        			if(mutasyon.get(yirmisekiz).charAt(2)==siralikarakter.charAt(0))
																										    	        				basla=sinir3[2];
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(1)){
																										    	        			basla=sinir5[6];//2236352;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(2)){
																										    	        			basla=sinir5[7];//2566927;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(3)){
																										    	        			basla=sinir5[8];//2797091;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(0)){
																										    	        			basla=sinir4[3];//3015857;
																										    	        			if(mutasyon.get(yirmisekiz).charAt(2)==siralikarakter.charAt(0))
																										    	        				basla=sinir3[3];
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(1)){
																										    	        			basla=sinir5[9];//3199086;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(2)){
																										    	        			basla=sinir5[10];//3430025;
																										    	        		}
																										    	        		if(mutasyon.get(yirmisekiz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmisekiz).charAt(1)==siralikarakter.charAt(3)){
																										    	        			basla=sinir5[11];//3706632;
																										    	        			if(mutasyon.get(yirmisekiz).charAt(2)==siralikarakter.charAt(3))
																										    	        				basla=ttt_sayisi;
																										    	        			if(mutasyon.get(yirmisekiz).charAt(2)==siralikarakter.charAt(2))
																										    	        				basla=ttg_sayisi;
																										    	        			if(mutasyon.get(yirmisekiz).charAt(2)==siralikarakter.charAt(1))
																										    	        				basla=ttc_sayisi;
																										    	        		}
																										              			 for(int i=basla;i<index.length;i++){
																										         	             	int esit_karakter_sayisi=0;
																										         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmisekiz).length())
																										         	             	for(int j=0;j<mutasyon.get(yirmisekiz).length();j++){
																										         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmisekiz).charAt(j)){
																										         	             		esit_karakter_sayisi++;
																										         	             	}
																										         	             	}
																										         	             	if(esit_karakter_sayisi==mutasyon.get(yirmisekiz).length()){
																										         	             		// System.out.println(index[i]);
																										         	             		 break;
																										         	             	}
																										         	             	if(esit_karakter_sayisi==mutasyon.get(yirmisekiz).length()-1&&(index[i]==random_index[yirmisekiz])){
																											       	             		 System.out.println(index[i]);
																											       	             		 break;
																											         	             		}
																										         	             }
																										              		}
																										              		*/
																										              	}
																										              };
																										              Thread t29=new Thread(){
																											              	public void run(){
																											              		
																											              	karnel ( 28, mutasyon, index, random_index, sinir3, sinir4, sinir5,11200,11600);
																											              		
																											              		/*
																											              		for(yirmidokuz=11200;yirmidokuz<11600;yirmidokuz++){
																											              			
																											    	        		int basla=0;
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(0)){
																											    	        			basla=sinir4[0];
																											    	        			if(mutasyon.get(yirmidokuz).charAt(2)==siralikarakter.charAt(0))
																											    	        				basla=sinir3[0];
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(1)){
																											    	        			basla=sinir5[0];//292209;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(2)){
																											    	        			basla=sinir5[1];//515147;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(3)){
																											    	        			basla=sinir5[2];//718797;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(0)){
																											    	        			basla=sinir4[1]; //986854;
																											    	        			if(mutasyon.get(yirmidokuz).charAt(2)==siralikarakter.charAt(0))
																											    	        				basla=sinir3[1];
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(1)){
																											    	        			basla=sinir5[3];//1269418;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(2)){
																											    	        			basla=sinir5[4];//1505613;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(3)){
																											    	        			basla=sinir5[5];//1803549;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(0)){
																											    	        			basla=sinir4[2];//2007501;
																											    	        			if(mutasyon.get(yirmidokuz).charAt(2)==siralikarakter.charAt(0))
																											    	        				basla=sinir3[2];
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(1)){
																											    	        			basla=sinir5[6];//2236352;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(2)){
																											    	        			basla=sinir5[7];//2566927;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(3)){
																											    	        			basla=sinir5[8];//2797091;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(0)){
																											    	        			basla=sinir4[3];//3015857;
																											    	        			if(mutasyon.get(yirmidokuz).charAt(2)==siralikarakter.charAt(0))
																											    	        				basla=sinir3[3];
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(1)){
																											    	        			basla=sinir5[9];//3199086;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(2)){
																											    	        			basla=sinir5[10];//3430025;
																											    	        		}
																											    	        		if(mutasyon.get(yirmidokuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(yirmidokuz).charAt(1)==siralikarakter.charAt(3)){
																											    	        			basla=sinir5[11];//3706632;
																											    	        			if(mutasyon.get(yirmidokuz).charAt(2)==siralikarakter.charAt(3))
																											    	        				basla=ttt_sayisi;
																											    	        			if(mutasyon.get(yirmidokuz).charAt(2)==siralikarakter.charAt(2))
																											    	        				basla=ttg_sayisi;
																											    	        			if(mutasyon.get(yirmidokuz).charAt(2)==siralikarakter.charAt(1))
																											    	        				basla=ttc_sayisi;
																											    	        		}
																											              			 for(int i=basla;i<index.length;i++){
																											         	             	int esit_karakter_sayisi=0;
																											         	             	if(birlestir.length()-index[i]>=mutasyon.get(yirmidokuz).length())
																											         	             	for(int j=0;j<mutasyon.get(yirmidokuz).length();j++){
																											         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(yirmidokuz).charAt(j)){
																											         	             		esit_karakter_sayisi++;
																											         	             	}
																											         	             	}
																											         	             	if(esit_karakter_sayisi==mutasyon.get(yirmidokuz).length()){
																											         	             		// System.out.println(index[i]);
																											         	             		 break;
																											         	             	}
																											         	             	if(esit_karakter_sayisi==mutasyon.get(yirmidokuz).length()-1&&(index[i]==random_index[yirmidokuz])){
																												       	             		 System.out.println(index[i]);
																												       	             		 break;
																												         	             		}
																											         	             }
																											              		}
																											              		*/
																											              	}
																											              };
																											              Thread t30=new Thread(){
																												              	public void run(){
																												              	karnel ( 29, mutasyon, index, random_index, sinir3, sinir4, sinir5,11600,12000);

																												              		/*
																												              		for(otuz=11600;otuz<12000;otuz++){
																												              			
																												    	        		int basla=0;
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(0)){
																												    	        			basla=sinir4[0];
																												    	        			if(mutasyon.get(otuz).charAt(2)==siralikarakter.charAt(0))
																												    	        				basla=sinir3[0];
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(1)){
																												    	        			basla=sinir5[0];//292209;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(2)){
																												    	        			basla=sinir5[1];//515147;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(3)){
																												    	        			basla=sinir5[2];//718797;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(0)){
																												    	        			basla=sinir4[1]; //986854;
																												    	        			if(mutasyon.get(otuz).charAt(2)==siralikarakter.charAt(0))
																												    	        				basla=sinir3[1];
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(1)){
																												    	        			basla=sinir5[3];//1269418;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(2)){
																												    	        			basla=sinir5[4];//1505613;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(3)){
																												    	        			basla=sinir5[5];//1803549;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(0)){
																												    	        			basla=sinir4[2];//2007501;
																												    	        			if(mutasyon.get(otuz).charAt(2)==siralikarakter.charAt(0))
																												    	        				basla=sinir3[2];
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(1)){
																												    	        			basla=sinir5[6];//2236352;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(2)){
																												    	        			basla=sinir5[7];//2566927;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(3)){
																												    	        			basla=sinir5[8];//2797091;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(0)){
																												    	        			basla=sinir4[3];//3015857;
																												    	        			if(mutasyon.get(otuz).charAt(2)==siralikarakter.charAt(0))
																												    	        				basla=sinir3[3];
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(1)){
																												    	        			basla=sinir5[9];//3199086;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(2)){
																												    	        			basla=sinir5[10];//3430025;
																												    	        		}
																												    	        		if(mutasyon.get(otuz).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(otuz).charAt(1)==siralikarakter.charAt(3)){
																												    	        			basla=sinir5[11];//3706632;
																												    	        			if(mutasyon.get(otuz).charAt(2)==siralikarakter.charAt(3))
																												    	        				basla=ttt_sayisi;
																												    	        			if(mutasyon.get(otuz).charAt(2)==siralikarakter.charAt(2))
																												    	        				basla=ttg_sayisi;
																												    	        			if(mutasyon.get(otuz).charAt(2)==siralikarakter.charAt(1))
																												    	        				basla=ttc_sayisi;
																												    	        		}
																												              			 for(int i=basla;i<index.length;i++){
																												         	             	int esit_karakter_sayisi=0;
																												         	             	if(birlestir.length()-index[i]>=mutasyon.get(otuz).length())
																												         	             	for(int j=0;j<mutasyon.get(otuz).length();j++){
																												         	             	if(birlestir.charAt(index[i]+j)==mutasyon.get(otuz).charAt(j)){
																												         	             		esit_karakter_sayisi++;
																												         	             	}
																												         	             	}
																												         	             	if(esit_karakter_sayisi==mutasyon.get(otuz).length()){
																												         	             		// System.out.println(index[i]);
																												         	             		 break;
																												         	             	}
																												         	             	if(esit_karakter_sayisi==mutasyon.get(otuz).length()-1&&(index[i]==random_index[otuz])){
																													       	             		 System.out.println(index[i]);
																													       	             		 break;
																													         	             		}
																												         	             }
																												              		}
																												              		*/
																												              	}
																												              };
	                  t1.start();
	                  t2.start();
	                  t3.start();
	                  t4.start();
	                  t5.start();
	                  t6.start();
	                  t7.start();
	                  t8.start();
	                  t9.start();
	                  t10.start();
	                  t11.start();
	                  t12.start();
	                  t13.start();
	                  t14.start();
	                  t15.start();
	                  t16.start();
	                  t17.start();
	                  t18.start();
	                  t19.start();
	                  t20.start();
	                  t21.start();
	                  t22.start();
	                  t23.start();
	                  t24.start();
	                  t25.start();
	                  t26.start();
	                  t27.start();
	                  t28.start();
	                  t29.start();
	                  t30.start();
	             
	              
	            
	        	
	        	
	        	
	        	
	        	//MUTASYON BUL SON
	        /*
	        int temp;
	        boolean bool = false;    
	        while(bool==false){
	     	   bool=true;
	         for(int i=0;i<birlestir.length()-1;i++){
	         	if(birlestir.substring(index[i], birlestir.length()).charAt(0)>birlestir.substring(index[i+1], birlestir.length()).charAt(0)){
	         		temp=index[i+1];
	         		index[i+1]=index[i];
	         		index[i]=temp;
	         		bool=false;
	         	}
	         	}
	         }
		*/
	//	ArrayList<String> suffix= new ArrayList<String>();
	//	for(int i=0;i<birlestir.length();i++){
	//		suffix.add(birlestir.substring(i, birlestir.length()));	
			//System.out.println(suffix.get(i));
		//		}
		
	
	
	}
	
	
	
	public static void karnel(int thredd ,ArrayList<String> mutasyon,int index[],int random_index[],int sinir3[],int sinir4[],int sinir5[],int bas,int bit ){
		for(int thred=thredd;thred<200000;thred+=30){      //for(int thred=bas;thred<bit;thred++){
    		int basla=0;
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(0)){
    			basla=sinir4[0];
    			if(mutasyon.get(thred).charAt(2)==siralikarakter.charAt(0))
    				basla=sinir3[0];
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(1)){
    			basla=sinir5[0];//292209;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(2)){
    			basla=sinir5[1];//515147;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(0)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(3)){
    			basla=sinir5[2];//718797;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(0)){
    			basla=sinir4[1]; //986854;
    			if(mutasyon.get(thred).charAt(2)==siralikarakter.charAt(0))
    				basla=sinir3[1];
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(1)){
    			basla=sinir5[3];//1269418;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(2)){
    			basla=sinir5[4];//1505613;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(1)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(3)){
    			basla=sinir5[5];//1803549;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(0)){
    			basla=sinir4[2];//2007501;
    			if(mutasyon.get(thred).charAt(2)==siralikarakter.charAt(0))
    				basla=sinir3[2];
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(1)){
    			basla=sinir5[6];//2236352;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(2)){
    			basla=sinir5[7];//2566927;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(2)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(3)){
    			basla=sinir5[8];//2797091;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(0)){
    			basla=sinir4[3];//3015857;
    			if(mutasyon.get(thred).charAt(2)==siralikarakter.charAt(0))
    				basla=sinir3[3];
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(1)){
    			basla=sinir5[9];//3199086;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(2)){
    			basla=sinir5[10];//3430025;
    		}
    		if(mutasyon.get(thred).charAt(0)==siralikarakter.charAt(3)&&mutasyon.get(thred).charAt(1)==siralikarakter.charAt(3)){
    			basla=sinir5[11];//3706632;
    			if(mutasyon.get(thred).charAt(2)==siralikarakter.charAt(3))
    				basla=ttt_sayisi;
    			if(mutasyon.get(thred).charAt(2)==siralikarakter.charAt(2))
    				basla=ttg_sayisi;
    			if(mutasyon.get(thred).charAt(2)==siralikarakter.charAt(1))
    				basla=ttc_sayisi;
    		}	    	            	        		    	        			    	        		
    		 int sayi=0;
         	 for(int i=basla;i<index.length;i++){
             	int esit_karakter_sayisi=0;
             	if(birlestir.length()-index[i]>=mutasyon.get(thred).length())
             	for(int j=0;j<mutasyon.get(thred).length();j++){
             	if(birlestir.charAt(index[i]+j)==mutasyon.get(thred).charAt(j)){
             		esit_karakter_sayisi++;
             	}
             	}
             	if(esit_karakter_sayisi==mutasyon.get(thred).length()){
             		// System.out.println(index[i]);
             		sayi++;
             		 break;
             	}
             	if((esit_karakter_sayisi>=mutasyon.get(thred).length()-3)&&(index[i]==random_index[thred])){  //
             		 System.out.println(index[i]);
             		 int konum=0;
             		 for(int m=0;m<200;m++){
             			 if(mutasyon.get(thred).charAt(m)!=birlestir.charAt(index[i]+m)){
             				konum=m;	             	
             				break;
             			 }
             		 }
             		 System.out.println("-"+ mutasyon.get(thred).substring(konum,konum+30)+"   mutasyonlu");	             		 
             		 System.out.println("*"+birlestir.substring(index[i]+konum,index[i]+konum+30)+"      "+ (index[i]/200+3)+".satýr"+"   "+((index[i]/200+1))+".sekens");
             		 
             		 sayi++;	         
             		 break;
             	}	             		             	             	
         	 }
         	if(sayi==0){
         		int konum=0;
        		 for(int m=0;m<200;m++){
        			 if(mutasyon.get(thred).charAt(m)!=birlestir.charAt(random_index[thred]+m)){
        				konum=m;	             	
        				break;
        			 }
        		 }
         		 System.out.println("cerceve kaymasý var");
         		 System.out.println("-"+ mutasyon.get(thred).substring(konum,konum+30)+"   mutasyonlu");
        		 System.out.println("*"+birlestir.substring(random_index[thred]+konum,random_index[thred]+konum+30)+"      "+ (random_index[thred]/200+3)+".satýr"+"   "+((random_index[thred]/200+1))+".sekens");	    	            		 	    		         			    		         	
         
         	}	              			              			              			 	              			 	              		
  		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Mutasyon bulma
		//////////////////////////////////////////////////////////////
		//MUTASYON RASTGELE ÜRET
			//////////////////////////////////////////////////////////////////////
			// PARÇA 1 NORMAL SUFFÝX ÇIKAR
		
		/*
		SuffixArray  b = null;
		
		
		int sayi=0;
					  //normal.size()
		for(int n=5;n<6;n++){
				 b = new SuffixArray(normal.get(n));
			  	 b.createSuffixArray();	
		for (int s=0;s<200;s++)
			if(b.suffix[s].length()>39)
		for(int i=0;i<mutasyon.size();i++){
			for(int j=0;j<mutasyon.get(i).length()-b.suffix[s].length();j++){
				sayi=0;
				int l=0;
				for(int k=j;k<j+b.suffix[s].length();k++){
					
				if(mutasyon.get(i).charAt(k)==b.suffix[s].charAt(l)){
					sayi++;				
				}
				l++;
				//System.out.print(parca1.get(i).charAt(k)); 
				}
				
			//	System.out.println("-");
				for(int y=b.suffix[s].length();y<=b.suffix[s].length();y++)
				if(sayi == y){
				//	System.out.println(i);
				//	System.out.println(j);
				//	System.out.println(dene);
					System.out.println(b.suffix[s]);
					System.out.println(sayi);
					

				//	System.out.println("-----------------------------------------");
				break;
				}
			
			if(sayi==b.suffix[s].length())
				break;
			}
			if(sayi==b.suffix[s].length())
				break;
		}
	}
			
	}
	*/

	/*
	for(int i=0;i<mutasyon.size();i++){
		for(int j=0;j<mutasyon.get(i).length()-dene.length();j++){
			int sayi=0;
			int l=0;
			for(int k=j;k<j+dene.length();k++){
				
			if(mutasyon.get(i).charAt(k)==dene.charAt(l)){
				sayi++;				
			}
			l++;
			//System.out.print(parca1.get(i).charAt(k));
			}
			
		//	System.out.println("-");
			for(int y=30;y<=50;y++)
			if(sayi == y){
			//	System.out.println(i);
			//	System.out.println(j);
				System.out.println(dene);
				System.out.println(sayi);
				System.out.println("-----------------------------------------");
			break;
			}
		}
		
	}
	
	*/
	/////////////////////////////////////////////////////////////////////////////////////////////////
	//mutasyon bulma son
	
	//-----------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	public static int satirgetir(){
		int sayac=0;
		String str="";
		try{
			FileInputStream fStream = new FileInputStream("4M.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader  bReader = new BufferedReader(new InputStreamReader(dStream));
			
			while((str=bReader.readLine()) != null ){
				if(!(str.isEmpty())  && str.charAt(0)!='>'){
					sayac++;
					
				}
				
				
			}
			dStream.close();
		}catch(Exception e){
			System.err.println("Hata :  " + e.getMessage());
		}
		
		return sayac;
	}
	
	public static void arraylist(){
	
		
		
			String str="";
			String birlestir="";
			String birlestir2="";
		//	String normal="bedirhan";
		//	String mutasyon="bedirhen";
		//	String dene="TGGTAAGCCGAAAGAAATCG";

	
			
			int sec1_index[] = new int[200000];  // burasý hesaplanýp yazýlacak
			int sec2_index[] = new int[200000];
			int random_sayi;
			Random randomNum = new Random();
			int ss=satirgetir();
			//System.out.println(ss);
			
			ArrayList<String> sec1= new ArrayList<String>();  //RAstgele sekanslar
			ArrayList<String> sec2= new ArrayList<String>();

			ArrayList<String> parca1= new ArrayList<String>();
			String []dataArray;
			dataArray = new String[ss]; 
			ArrayList<String> parca2= new ArrayList<String>();
			String []dataArra;
			dataArra = new String[ss];      // 200.000 tane sekans var
			int sayac=0;
			try{
				FileInputStream fStream = new FileInputStream("4M.txt");
				DataInputStream dStream = new DataInputStream(fStream);
				BufferedReader  bReader = new BufferedReader(new InputStreamReader(dStream));
				while((str=bReader.readLine()) != null){
					
					if(!(str.isEmpty())  && str.charAt(0)!='>'){
					
						switch(sayac){
						case 1 :
							parca1.add(str.trim());
							break;
						case 2 :
							
							parca2.add(str.trim());
							break;
						}
						}
						else if(str.charAt(0)=='>'){
							sayac++;
						}
				}
				
				dStream.close();
			}catch(Exception e){
				System.err.println("Hata :  " + e.getMessage());
			}
			
	
			for(int i=0;i<parca1.size();i+=20){
				
				if(i+20>parca1.size()){
					
					for( int j=i;j<parca1.size();j++){
						birlestir+=parca1.get(j);
					//	System.out.println(j);
					}
					break;
				}
				//System.out.println(i);
				
				birlestir+=parca1.get(i).concat(parca1.get(i+1)).concat(parca1.get(i+2)).concat(parca1.get(i+3)).concat(parca1.get(i+4)).concat(parca1.get(i+5)).concat(parca1.get(i+6)).concat(parca1.get(i+7)).concat(parca1.get(i+8)).concat(parca1.get(i+9)).concat(parca1.get(i+10)).concat(parca1.get(i+11)).concat(parca1.get(i+12)).concat(parca1.get(i+13)).concat(parca1.get(i+14)).concat(parca1.get(i+15)).concat(parca1.get(i+16)).concat(parca1.get(i+17)).concat(parca1.get(i+18)).concat(parca1.get(i+19));
				
				
			}
			
			
			
			
				for(int i=0;i<parca2.size();i+=20){
				
				if(i+20>parca2.size()){
					
					for( int j=i;j<parca2.size();j++){
						birlestir2+=parca2.get(j);
					//	System.out.println(j);
					}
					break;
				}
				//System.out.println(i);
				
				birlestir2+=parca2.get(i).concat(parca2.get(i+1)).concat(parca2.get(i+2)).concat(parca2.get(i+3)).concat(parca2.get(i+4)).concat(parca2.get(i+5)).concat(parca2.get(i+6)).concat(parca2.get(i+7)).concat(parca2.get(i+8)).concat(parca2.get(i+9)).concat(parca2.get(i+10)).concat(parca2.get(i+11)).concat(parca2.get(i+12)).concat(parca2.get(i+13)).concat(parca2.get(i+14)).concat(parca2.get(i+15)).concat(parca2.get(i+16)).concat(parca2.get(i+17)).concat(parca2.get(i+18)).concat(parca2.get(i+19));
				
				
			}
			
			
		//	System.out.println(birlestir2.length());
		//	System.out.println(birlestir2.charAt(800)+""+birlestir2.charAt(801)+""+birlestir2.charAt(802));
			
			for(int i=0; i<birlestir.length(); i+=200){
				//random_sayi=randomNum.nextInt((birlestir.length()-200));
			//	System.out.println(random_sayi + "--" + i);
			//sec1_index[i]=random_sayi;
				sec1.add(birlestir.substring(i,(i+200)));
				
			}
		//	File file = new File ("C:\\Users\\balboa\\Desktop\\index.TXT");
		//	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			System.out.println(sec1.get(2)+" "+sec1.size());
			int random_index[]=new int[200000];
			for(int i=0; i<200000; i++){
				random_sayi=randomNum.nextInt((birlestir2.length()-200));
			//	System.out.println(random_sayi + "--" + i);
				random_index[i]=random_sayi;
				sec2_index[i]=random_sayi;
				sec2.add(birlestir2.substring(random_sayi,(random_sayi+200)));
				//System.out.println(sec2.get(i) );
			}
			
			File f = new File ("veri.TXT");
			try {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
				writer.write(">Normal"); 
				writer.newLine();
				for(int i=0;i<sec1.size();i++){
					writer.write(sec1.get(i)); 
					writer.newLine();
				}
				writer.write(">mutasyon"); 
				writer.newLine();
				for(int i=0;i<sec2.size();i++){
					writer.write(sec2.get(i)); 
					writer.newLine();
				}
				writer.close();
			}catch(Exception e){
				System.err.println("Hata :  " + e.getMessage());
			}
			
		
			File file = new File ("index.TXT");
			try {
				BufferedWriter writerr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				//writer.write(">Normal"); 
				for(int i=0;i<random_index.length;i++){
					writerr.write(String.valueOf(random_index[i])); 
					writerr.newLine();
				}
				
				writerr.close();
			}catch(Exception e){
				System.err.println("Hata :  " + e.getMessage());
			}
		
			
			
			
	}

	
	// mutasyonun üzerinde gezip benzerlik çýkarma
	/*		
	for(int i=0;i<parca1.size();i++){
		for(int j=0;j<parca1.get(i).length()-dene.length();j++){
			int sayi=0;
			int l=0;
			for(int k=j;k<j+dene.length();k++){
				
			if(parca1.get(i).charAt(k)==dene.charAt(l)){
				sayi++;				
			}
			l++;
			//System.out.print(parca1.get(i).charAt(k));
			}
			
		//	System.out.println("-");
			for(int y=13;y<21;y++)
			if(sayi == y){
				System.out.println(i);
				System.out.println(j);
				System.out.println(dene);
				System.out.println(sayi);
				System.out.println("-----------------------------------------");
			break;
			}
		}
		
	}
		
		
	*/	
	
}

