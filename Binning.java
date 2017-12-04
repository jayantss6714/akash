import java.util.*;
public class Binning 
{
	public static void main(String []arg)
	{
    
    Scanner sc;
    ArrayList<Integer> list;
    ArrayList bins[];

    int size, width, binCnt;
        list=new ArrayList<>();
        sc = new Scanner(System.in);
    
		System.out.println("Enter count of numbers :");
        size = sc.nextInt();
        System.out.println("Enter width of bin :");
        width = sc.nextInt();         
        System.out.println("Enter "+size+" numbers :");
        for(int i=0;i<size;i++)
            list.add(sc.nextInt());
        binCnt = (size%width==0)?(size/width):(size/width+1);
        Collections.sort(list);           
    
	
	//-------------------------------------------Equi width-----------------
	    
		System.out.println("\nEqui Width Binning :");
    
		bins = null;
        bins = new ArrayList[binCnt];
        int cnt=0;
        for(int i=0;i<binCnt;i++){
            bins[i]=new ArrayList<>();
            for(int j=0;j<width && cnt<list.size();j++){
                bins[i].add(list.get(cnt));
                cnt++;
    }
    }
	
	
	    for(int i=0;i<binCnt;i++){
            for(int j=0;j<bins[i].size();j++){
                System.out.print(bins[i].get(j)+" ");
            }
            System.out.println();
        }
    
	
	//-------------------------------------------Bin Boundaries-----------------
	
	System.out.println("\nBin Boundaries :");
        
	
	int left, right, near;
        for(int i=0;i<binCnt;i++){
            left =(int) bins[i].get(0);
            right =(int)bins[i].get((bins[i].size()-1));
            for(int j=1;j<bins[i].size()-1;j++){
                int no = (int)bins[i].get(j);
                near = (no-left<=right-no)?left:right;
                bins[i].set(j, near);
            }
        }
    
	    for(int i=0;i<binCnt;i++){
            for(int j=0;j<bins[i].size();j++){
                System.out.print(bins[i].get(j)+" ");
            }
            System.out.println();
        }
    
	
	//-------------------------------------------Bin Mean-----------------
	
	System.out.println("\nBin Mean :");
        
	bins = null;
        bins = new ArrayList[binCnt];
        cnt=0;
        for(int i=0;i<binCnt;i++){
            bins[i]=new ArrayList<>();
            for(int j=0;j<width && cnt<list.size();j++){
                bins[i].add(list.get(cnt));
                cnt++;
    }
    }
        for(int i=0;i<binCnt;i++){
            int a=0;
	    double mean;
            for(int k=0;k<bins[i].size();k++)
                a +=(int) bins[i].get(k);
            mean = (double)a/bins[i].size();
            for(int j=0;j<bins[i].size();j++){
                bins[i].set(j, mean);
            }
        }
		
		for(int i=0;i<binCnt;i++){
            for(int j=0;j<bins[i].size();j++){
                System.out.print(bins[i].get(j)+" ");
            }
            System.out.println();
        }
    }   
}