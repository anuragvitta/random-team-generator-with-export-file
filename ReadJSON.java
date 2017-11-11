

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        System.out.println("enter json file path");
        Scanner s= new Scanner(System.in);
        String path=s.nextLine();

        try {
        

            JSONArray array =(JSONArray) parser.parse(new FileReader(path));
            int asize=array.size();
            PrintWriter writer = new PrintWriter("team.txt", "UTF-8");
            ArrayList<Integer> list = new ArrayList<Integer>(asize);
            for(int q=0; q<asize; q++) {
	            list.add(q);
	        }  
           Collections.shuffle(list);

            if(asize==0)
            {
            	System.out.println("file is empty");System.exit(0);
            }
            System.out.println("enter team size");
       	
    	 
            int tsize = s.nextInt();
            s.close();
            if(tsize>asize)
            {
            System.out.println("team size cannot be more than total member size");
            System.exit(0);
            }
            if(tsize==0|tsize<0)
            {
            	System.out.println("team size cant be zero or lesser");System.exit(0);
            }
            int rem=asize%tsize;
            int initnum=asize/tsize;
            int addnum=asize-(initnum*tsize),tnum=0;
            if(rem==0)
            {
            	System.out.println("creating-"+initnum+" number of team with size-"+tsize);
            	writer.println("created-"+initnum+"number of team with size-"+tsize);
             tnum=initnum;
            }
            else
            {
            	System.out.println("creating-"+initnum+" number of team with size-"+tsize+"  and one team with size-"+addnum);
               	writer.println("created-"+initnum+" number of team with size-"+tsize+"  and one team with size-"+addnum);
            	tnum=initnum+1;
            }
            
           int h=0,temp=tsize;
	        for(int p=1;p<=tnum;p++)
           {
	        	System.out.println("------------------------------------");
	        	writer.println("------------------------------------");
        	System.out.println("team-"+p);
        	System.out.println("--------");
        	writer.println("Team"+p+"\n");
        	writer.println("----------");
        	while(h<temp)
        	{
        		if(h>=asize)
        		{
        			break;
        		}
        		int za=list.get(h);
        		JSONObject person = (JSONObject) array.get(za);
        		System.out.println("team member");
        		System.out.println("-------------");
        		writer.println("Team member\n");
        		writer.println("-------------");
        		System.out.println("name is- "+person.get("name"));
        		writer.println("name is-"+person.get("name"));
        		System.out.println("branch is- "+person.get("branch"));
        		writer.println("branch is-"+person.get("branch"));
        		System.out.println("favourite language  is- "+person.get("favlanguage"));
        		writer.println("favourite language is-"+person.get("favlanguage"));
        		
        		
        		h++;
        		}temp=temp+tsize;
           }System.out.println("-------------");
           writer.println("----------------");
	        System.out.println("end of teams");
           writer.println("End of Teams");writer.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
