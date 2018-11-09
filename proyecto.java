import java.util.Scanner;

class conversion{
    
    public static String toRoman(int number,boolean mil,boolean mill){
        
        StringBuilder br = new StringBuilder("");
        
        while(number!=0)
        {   
            while(number>=1000)
            {
                br.append("M");
                number-=1000;   
            }
            while(number>=900)
            {
                br.append("CM");
                number-=900;    
            }
            while(number>=500)
            {
                br.append("D");
                number-=500;    
            }
            while(number>=400)
            {
                br.append("CD");
                number-=400;    
            }
            while(number>=100)
            {
                br.append("C");
                number-=100;    
            }
            while(number>=90)
            {
                br.append("XC");
                number-=90; 
            }
            while(number>=50)
            {
                br.append("L");
                number-=50; 
            }
            while(number>=40)
            {
                br.append("XL");
                number-=40; 
            }
            while(number>=10)
            {
                br.append("X");
                number-=10; 
            }
            while(number>=9)
            {
                br.append("IX");
                number-=9;  
            }
            while(number>=5)
            {
                br.append("V");
                number-=5;  
            }
            while(number>=4)
            {
                br.append("IV");
                number-=4;  
            }
            while(number>=1)
            {
                br.append("I");
                number-=1;  
            }
        }
        if(mil == true){
            br.append("'");
        }
        else if(mill == true){
            br.append("''");
        }
        
        return br.toString();
    }

    public static void main(String [] args){   
        Scanner reader = new Scanner(System.in); 
        System.out.println("Ingrese un Entero:");
        int n = reader.nextInt();
        reader.close();

        //parte mil
        if(n >3999 && n <1000000){
            int dez = Math.round((n/1000));

            String y = (toRoman(dez,true,false)); 
            dez = dez*1000;
            int number = n-dez;
            String x =(toRoman(number,false,false));
            StringBuilder cadena = new StringBuilder("");
            cadena.append(y);
            cadena.append(x);
            System.out.println(cadena);

        }
        //parte del millon
        else if (n>=1000000) {

            int dez = Math.round((n/1000000));
            //parte millon
            String mill = (toRoman(dez, false, true));
            //System.out.println(mill);
            
            //separacion parte mil
            int number = n-(dez*1000000);
            //int number = n-dez;
            //number contiene 100,000
            if(number>=0){
                int xx = Math.round((number/1000));
                String y = (toRoman(xx,true,false)); 
                //parte centenas
               // System.out.println("estos miles a :"+xx);
                //System.out.println(mill+y);
                //parte decenas
                int cin = number-xx*1000;
                String z = (toRoman(cin,false,false));
                if(xx == 0){
                    System.out.println(mill+z);
                }else{
                    System.out.println(mill+y+z);
                }       
            } 
        } 
        else{
            System.out.println(toRoman(n, false,false));
        }
    }
}