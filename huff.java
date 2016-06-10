import java.io.*;
import java.util.*;
public class huff
{
    static String s ="";
    static String path;
    public static String code[] = new String[65536];
    static int pos = 0;
    static String ans = "";
    static int r = 0;
    static int a;
    static int len;
    static String f;
    static String de_file;
    static treenode min(treenode first)
    {
        treenode temp = first;
        int m1 = first.sum;
        while(temp != null && temp.id != -1)
        {
            temp = temp.next;
        }
        m1 = temp.sum;
        treenode min1 = temp;
        temp = first;
        while(temp != null)
        {
            if(temp.id == -1)
            {
                if(m1 > temp.sum)
                {
                    m1 = temp.sum;
                    min1 = temp;
                }
            }
            temp = temp.next;
        }
        return min1;
    }

    static void path(treenode start,String p)
    {
        if(start.left != null)
        {
            path(start.left, p+"0");
        }
        if(start.right != null)
        {
            path(start.right, p+"1");
        }
        if(start.left == null && start.right == null)
        {
            char m = start.ch;
            code[(int)m] = p;
        }
    }

    static void sort(treenode head)
    {
        treenode temp = head;
        while(temp != null)
        {
            treenode t = temp.next;
            int min = temp.sum;
            treenode add = temp;
            while(t != null)
            {
                if(t.sum < min)
                {
                    min = t.sum;
                    add = t;
                }
                t = t.next;
            }
            int x = temp.sum;
            temp.sum = add.sum;
            add.sum = x;
            char c = temp.ch;
            temp.ch = add.ch;
            add.ch = c;
            temp = temp.next;
        }
    }

    static void decompress()throws IOException
    {
        StringTokenizer st = new StringTokenizer(ans);
        String de = "";
        FileWriter ob0;
        for(int i=0;i<len;i++)
        {
            String s = st.nextToken();
            for(int j=0;j<65536;j++)
            {
                if(s.equals(code[j]))
                {
                    de = de + (char)j;
                    break;
                }
            }
        }
        if(s.endsWith(".java"))
        {    de_file = f.substring(0,f.length()-5)+"_decompressed.java";
        }   
        else if(s.endsWith(".sh")) 
        {    de_file = f.substring(0,f.length()-3)+"_decompressed.sh";
           
        }    
        else if(s.endsWith(".py"))
        {    de_file = f.substring(0,f.length()-3)+"_decompressed.py";
           
        }
        else 
        {    de_file = f.substring(0,f.length()-4)+"_decompressed.txt";
             
        }     
        ob0 = new FileWriter(de_file);
        BufferedWriter ob1 = new BufferedWriter(ob0);
        PrintWriter o = new PrintWriter(ob1);
        o.write(de);
        o.close();
        ob1.close();
        ob0.close();
        s= "";f="";
    }

    static String compress()throws IOException
    {
        String strperc = "";
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new  BufferedReader(read);
        f = s;
        if(s.endsWith(".txt") || s.endsWith(".sh") || s.endsWith(".py") || s.endsWith(".java") || s.endsWith(".c"))
        {
            FileReader o1=new FileReader(path);
            BufferedReader o2=new BufferedReader(o1);
            String line;
            treenode start = null;
            treenode last = null;
            treenode temp = start;
            String input = "";
            char c;
            while((line=o2.readLine()) != null)
            {
                input = input+ line + "\n"; 
            }
            input = input.substring(0,input.length()-1);
            for(int i=0; i< input.length();i++)
            {
                c = input.charAt(i);
                temp = start;
                while(temp != null)
                {
                    if(temp.ch == c)
                    {
                        temp.sum++;
                        break;
                    }
                    temp = temp.next;
                }
                if(temp == null)
                {
                    treenode n = new treenode(c,0,r++);
                    if(i==0)
                        start = n;
                    else 
                        last.next = n;
                    last = n;
                    n.sum++;
                }
            }
            sort(start);
            temp = start;
            while(temp.next != null)
            {
                treenode arr[] = new treenode[2];
                arr[0] = min(start);
                arr[0].id = 1;
                arr[1] = min(start);
                arr[1].id = 1;
                int min = Math.min(arr[0].posn,arr[1].posn);
                treenode n1 = new treenode(' ',arr[0].sum+arr[1].sum,min);
                if(arr[0].posn == min)
                {
                    n1.left = arr[0];
                    n1.right = arr[1];
                } 
                else
                {
                    n1.right = arr[0];
                    n1.left = arr[1];
                }
                n1.next = start;
                start = n1;
                temp = temp.next;
            }
            path(start,"");
            len = input.length();
            for (int i = 0; i < len; i++)
            {
                c = input.charAt(i);
                ans += code[(int)c]+" ";
                
            }
            a = ans.length()-len;
            double percentagec = (a*1.0/(len*8))*100;
            String percans = Double.toString(percentagec);
            int point = percans.indexOf(".");
            percans = percans.substring(0,point)+"."+ percans.substring(point + 1, point + 3);
            strperc = "Size of input: " +len + "\n" + "Number of bits required to represent input prior to compression : " +len*8 +  "\n" + "Number of  bits required to represent input after compression : " +a + "\n"+ "Percentage compression achieved : " + percans + "%";
        }
        else
            strperc = "Type not supported";
        return strperc;
    }
}