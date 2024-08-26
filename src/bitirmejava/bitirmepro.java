package bitirmejava;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class bitirmepro {
    static int bir, iki, uc, dort, bes, alti, yedi, sekiz, dokuz, on, onbir, oniki, onuc, ondort, onbes, onalti, onyedi, onsekiz, ondokuz, yirmi, yirmibir, yirmiiki, yirmiuc, yirmidort, yirmibes, yirmialti, yirmiyedi, yirmisekiz, yirmidokuz, otuz;
    static String birlestir = "";
    static String siralikarakter = "";
    static int ttt_sayisi = 0;
    static int ttg_sayisi = 0;
    static int ttc_sayisi = 0;

    public static void main(String[] args) throws IOException {
        mutasyonbul();

        //arraylist();
	
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
	        	
        //--------------------------------------------------------------------------
        //ÝKÝLÝ SUFFÝX SON
	        	
        System.out.println("basla");

        Thread t1=new Thread(){
            public void run(){

                karnel ( 0 , mutasyon, index, random_index, sinir3, sinir4, sinir5,0,200);
	              		
            }
        };

        Thread t2=new Thread(){
            public void run(){
                karnel ( 1 , mutasyon, index, random_index, sinir3, sinir4, sinir5,200,400);
	              		
	              		
            }

        };
        Thread t3=new Thread(){
            public void run(){
                karnel ( 2 , mutasyon, index, random_index, sinir3, sinir4, sinir5,400,600);
		              		
            }
        };
        Thread t4=new Thread(){
            public void run(){

                karnel ( 3 , mutasyon, index, random_index, sinir3, sinir4, sinir5,600,800);
			              		
			              		
            }
        };
        Thread t5=new Thread(){
            public void run(){

                karnel ( 4 , mutasyon, index, random_index, sinir3, sinir4, sinir5,800,1000);
				              		
				              		
            }
        };
        Thread t6=new Thread(){
            public void run(){

                karnel ( 5 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1000,1200);

					              		
					              		
            }
        };
        Thread t7=new Thread(){
            public void run(){

                karnel ( 6 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1200,1400);
						              		
						              		
            }
        };
        Thread t8=new Thread(){
            public void run(){

                karnel ( 7 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1400,1600);
							              		
            }
        };
        Thread t9=new Thread(){
            public void run(){

                karnel ( 8 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1600,1800);

								              		
            }
        };
        Thread t10=new Thread(){
            public void run(){

                karnel ( 9 , mutasyon, index, random_index, sinir3, sinir4, sinir5,1800,2000);

									              		
            }
        };
        Thread t11=new Thread(){
            public void run(){
                karnel ( 10 , mutasyon, index, random_index, sinir3, sinir4, sinir5,4000,4400);
										              		
            }
        };

        Thread t12=new Thread(){
            public void run(){

                karnel ( 11 , mutasyon, index, random_index, sinir3, sinir4, sinir5,4400,4800);

										              		
            }
        };
        Thread t13=new Thread(){
            public void run(){

                karnel ( 12 , mutasyon, index, random_index, sinir3, sinir4, sinir5,4800,5200);
											              		
											              		
            }
        };
        Thread t14=new Thread(){
            public void run(){

                karnel ( 13 , mutasyon, index, random_index, sinir3, sinir4, sinir5,5200,5600);


												              		
            }
        };
        Thread t15=new Thread(){
            public void run(){

                karnel ( 14 , mutasyon, index, random_index, sinir3, sinir4, sinir5,5600,6000);


													              		
            }
        };
        Thread t16=new Thread(){
            public void run(){

                karnel ( 15, mutasyon, index, random_index, sinir3, sinir4, sinir5,6000,6400);

														              		
            }
        };
        Thread t17=new Thread(){
            public void run(){

                karnel ( 16, mutasyon, index, random_index, sinir3, sinir4, sinir5,6400,6800);

															              		
            }
        };
        Thread t18=new Thread(){
            public void run(){
                karnel ( 17, mutasyon, index, random_index, sinir3, sinir4, sinir5,6800,7200);

																              		
            }
        };
        Thread t19=new Thread(){
            public void run(){

                karnel ( 18, mutasyon, index, random_index, sinir3, sinir4, sinir5,7200,7600);

																	              		
            }
        };
        Thread t20=new Thread(){
            public void run(){

                karnel ( 19, mutasyon, index, random_index, sinir3, sinir4, sinir5,7600,8000);

																		              		
            }
        };

        Thread t21=new Thread(){
            public void run(){

                karnel ( 20, mutasyon, index, random_index, sinir3, sinir4, sinir5,8000,8400);

																			              		
            }
        };
        Thread t22=new Thread(){
            public void run(){

                karnel ( 21, mutasyon, index, random_index, sinir3, sinir4, sinir5,8400,8800);

																				              		
            }
        };
        Thread t23=new Thread(){
            public void run(){

                karnel ( 22, mutasyon, index, random_index, sinir3, sinir4, sinir5,8800,9200);
																					              		
																					              		
            }
        };
        Thread t24=new Thread(){
            public void run(){
                karnel ( 23, mutasyon, index, random_index, sinir3, sinir4, sinir5,9200,9600);
																						              		
            }
        };
        Thread t25=new Thread(){
            public void run(){
                karnel ( 24, mutasyon, index, random_index, sinir3, sinir4, sinir5,9600,10000);
																							              		
            }
        };
        Thread t26=new Thread(){
            public void run(){
                karnel ( 25, mutasyon, index, random_index, sinir3, sinir4, sinir5,10000,10400);

																								              		
            }
        };
        Thread t27=new Thread(){
            public void run(){
                karnel ( 26, mutasyon, index, random_index, sinir3, sinir4, sinir5,10400,10800);
																									              		
            }
        };
        Thread t28=new Thread(){
            public void run(){
                karnel ( 27, mutasyon, index, random_index, sinir3, sinir4, sinir5,10800,11200);

																										              		
            }
        };
        Thread t29=new Thread(){
            public void run(){

                karnel ( 28, mutasyon, index, random_index, sinir3, sinir4, sinir5,11200,11600);
																											              		
																											              		
            }
        };
        Thread t30=new Thread(){
            public void run(){
                karnel ( 29, mutasyon, index, random_index, sinir3, sinir4, sinir5,11600,12000);

																												              		
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
	

}
